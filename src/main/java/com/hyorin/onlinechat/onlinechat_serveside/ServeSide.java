package com.hyorin.onlinechat.onlinechat_serveside;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServeSide {

    static Socket socket = null;
    static ServerSocket serverSocket = null;
    static Map<String, String> msgMap = new HashMap<String, String>();

    public static void main(String[] args) throws IOException {
        serverSocket = new ServerSocket(9099);
        ExecutorService service = Executors.newFixedThreadPool(64);
        while (true) {
            System.out.println("服务器已启动，等待新的连接........");
            socket = serverSocket.accept();
            System.out.println(socket.getInetAddress() + "已连接到服务器！");
            String clientName = "客户端" + new Random().nextInt(10000);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            //  MessagePool.msgMap.put(bw,clientName);
            // MessagePool.socketMap.put(socket,msgMap);
            MessagePool.msgMap.put(socket, bw);
            ServeWrite serveWrite = new ServeWrite(socket);
            service.submit(serveWrite);
        }
    }
}
