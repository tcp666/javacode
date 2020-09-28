package com.tcp.socket.tcpdemo;



import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server implements Runnable {
  public void run(){
        Scanner sc=new Scanner(System.in);
        ServerSocket serverSocket=null;
        Socket socket=null;
        try {
             serverSocket=new ServerSocket(8000);
            socket=serverSocket.accept();
            while(true){
                byte[] bytes=new byte[1024];
                System.out.println("请输入消息;");
                String message=sc.nextLine();
                socket.getOutputStream().write(("server:"+message).getBytes());
                socket.getInputStream().read(bytes);
                System.out.println(new String(bytes));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            sc.close();
            System.out.println("fhkjhdddddddddddd\n");
        }
    }
}
