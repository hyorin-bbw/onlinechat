package com.hyorin.onlinechat.onlinechat_serveside;

import com.hyorin.onlinechat.onlinechat_serveside.MessagePool;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

public class ServeWrite implements Runnable {
    Socket socket = null;

    public ServeWrite(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            String msg = null;
            if ((msg = getMsg(br)) != null) {
                try {
                    sendMsg(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 获取客户端发来的消息
     */
    public String getMsg(BufferedReader br) {
        String msg = null;
        try {
            msg = br.readLine();
            //msg = MessagePool.msgMap.get(socket).get(br)+":"+msg;
            msg = socket.getInetAddress() + ":" + msg;
            System.out.println(msg);
        } catch (SocketException e) {
            System.out.println(socket.getInetAddress() + "已断开连接！");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return msg;
    }

    /**
     * 遍历集合 将其中的内容发给每个客户端
     */
    public void sendMsg(String msg) throws IOException {
        for (Socket socket : MessagePool.msgMap.keySet()) {
            if (this.socket != socket) {
                BufferedWriter br = MessagePool.msgMap.get(socket);
                br.write(msg);
                br.newLine();
                br.flush();
            } else {
                BufferedWriter br = MessagePool.msgMap.get(socket);
                br.write("发送成功！");
                br.newLine();
                br.flush();
            }
        }
    }
}
