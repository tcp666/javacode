package com.tcp.socket.udpdemo;

import java.io.IOException;
import java.net.*;

public class SendDemo {

    public static void main(String[] args) {
        DatagramSocket socket;
        try {
           socket=new DatagramSocket();
                   byte[] bytes="hhhhhh".getBytes();
                   int length=bytes.length;
            InetAddress address=InetAddress.getLocalHost();
           int port=10086;
            DatagramPacket dp=new DatagramPacket(bytes,length,address,port);

            socket.send(dp);
            socket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
