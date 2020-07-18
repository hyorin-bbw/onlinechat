package com.hyorin.onlinechat.onlinechat_serveside;

import java.io.BufferedWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class MessagePool {

    public static Map<Socket, BufferedWriter> msgMap = new HashMap<Socket, BufferedWriter>(64);
     //public static Map<BufferedWriter,String> msgMap = new HashMap<>();
    // public static Map<Socket,Map> socketMap = new HashMap();
}
