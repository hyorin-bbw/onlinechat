package com.hyorin.onlinechat.onlinechat_clientside;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class Client {

    public static void main(String[] args) {
        Scanner inputText = new Scanner(System.in);
        try {
            Socket socket = new Socket("127.0.0.1", 9099);
            OutputStream write = socket.getOutputStream();
            System.out.println("成功连接服务器，可以开始聊天了！");
            //发送消息给客户端
            while (true) {
                String text = inputText.nextLine();
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(write));
                bw.write(text);
                bw.newLine();
                bw.flush();
               /* //读取从服务器接收的消息
                BufferedReader br = new BufferedReader(new InputStreamReader(read));
                System.out.println(br.readLine());*/
               Thread read = new Thread(new ClientRead(socket));
               read.start();
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e){
            System.out.println("无法连接到服务器........");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
