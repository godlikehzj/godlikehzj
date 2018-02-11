package com.godlikehzj.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class BioClient {
    //默认的端口号
    private static int DEFAULT_SERVER_PORT = 9999;
    private static String DEFAULT_SERVER_IP = "127.0.0.1";

    public  void send(String expression) throws IOException{
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        try{
            socket = new Socket();
            socket.setKeepAlive(true);
            socket.connect(new InetSocketAddress(DEFAULT_SERVER_PORT));
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),true);
            out.println(expression);
            System.out.println("client：" + in.readLine());
            socket.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
