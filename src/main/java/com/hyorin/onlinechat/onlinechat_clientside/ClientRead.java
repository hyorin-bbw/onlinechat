package com.hyorin.onlinechat.onlinechat_clientside;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientRead implements Runnable{
    Socket socket = null;

    public ClientRead(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        BufferedReader br = null;
        while (true){
            try {
                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String msg = br.readLine();
                System.out.println(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
