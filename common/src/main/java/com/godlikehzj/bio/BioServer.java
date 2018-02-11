package com.godlikehzj.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BioServer {
    public void start(int port) throws IOException{
        ExecutorService executor = Executors.newFixedThreadPool(3);

        ServerSocket serverSocket = new ServerSocket(port);
        while(!Thread.currentThread().isInterrupted()){//主线程死循环等待新连接到来
            Socket socket = serverSocket.accept();
            System.out.println("socket accepted");
            executor.submit(new ConnectIOnHandler(socket));//为新的连接创建新的线程
        }
    }

    class ConnectIOnHandler extends Thread{
        private Socket socket;
        public ConnectIOnHandler(Socket socket){
            this.socket = socket;
        }
        public void run(){

            while(!Thread.currentThread().isInterrupted()&&!socket.isClosed()){
                BufferedReader in = null;
                PrintWriter out = null;
                try{
                    socket.setKeepAlive(true);
                    socket.setSoTimeout(1000);
                    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    out = new PrintWriter(socket.getOutputStream(),true);
                    String expression;
                    while(true){
                        //通过BufferedReader读取一行
                        //如果已经读到输入流尾部，返回null,退出循环
                        //如果得到非空值，就尝试计算结果并返回
                        if((expression = in.readLine())==null) break;
                        System.out.println("server：" + expression);
                        out.println("get message --->" + expression);
                    }
                    System.out.println("one age over");
                    try {
                        socket.sendUrgentData(0xFF);
                    }catch (Exception e){
//                        e.printStackTrace();
                        socket.close();
                    }
                    Thread.sleep(1000);
                }catch(Exception e){
                    e.printStackTrace();
                }

            }
            System.out.println("client socket close");
        }
    }
}
