package com.tcp.socket.tcpdemo;


import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client implements Runnable{
    /**
     * 4321:
     * @para
     */
 public void run() {
        Scanner sc=new Scanner(System.in);
        Socket socket =null;
        try {
            socket=new Socket("192.168.43.156",8000);
           while(true){
               byte[] bytes=new byte[1024];
               socket.getInputStream().read(bytes);
               System.out.println(new String(bytes));
               Socket finalSocket = socket;
               new Thread(){

                   @Override
                   public void run() {
                      try{
                          System.out.println("client:请输入消息;");
                          String message=sc.nextLine();
                          finalSocket.getOutputStream().write(("client:"+message).getBytes());
                      } catch (IOException e) {
                          e.printStackTrace();
                      }
                   }
               }.start();
           }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            sc.close();
            System.out.println("fhkjhdddddddddddd");
        }

    }
}
