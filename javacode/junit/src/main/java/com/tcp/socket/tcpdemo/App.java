package com.tcp.socket.tcpdemo;

public class App {
    public static void main(String[] args) {
        Thread server =new Thread(new Server());
        Thread client=new Thread(new Client());
        server.start();
        client.start();
    }
}
