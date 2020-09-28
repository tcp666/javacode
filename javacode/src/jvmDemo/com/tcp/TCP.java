package jvmDemo.com.tcp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;

public class TCP {
    ServerSocketChannel socketChannel;
    Selector selector;
    int port = 8778;
    String[] opsName = new String[17];

    public TCP() {
        opsName[SelectionKey.OP_ACCEPT] = "OP_ACCEPT";
        opsName[SelectionKey.OP_CONNECT] = "OP_CONNECT";
        opsName[SelectionKey.OP_READ] = "OP_READ";
        opsName[SelectionKey.OP_WRITE] = "OP_WRITE";
        try {
            socketChannel = ServerSocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.socket().setReuseAddress(true);
            socketChannel.socket().bind(new InetSocketAddress(port));
            selector = Selector.open();
            System.out.println(socketChannel.hashCode());
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            socketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (ClosedChannelException e1) {
// TODO Auto-generated catch block
            e1.printStackTrace();
        }
        System.out.println("server start port " + port);
        while (true) {
            int n;
            try {
                System.out.print("wait...");
                n = selector.select(60000);
                System.out.println(n);
                if (n <= 0) continue;
                Iterator it = selector.selectedKeys().iterator();
                while (it.hasNext()) {
                    SelectionKey key = (SelectionKey) it.next();
                    it.remove();
                    System.out.println("key:" + opsName[key.interestOps()] + "," + key.channel().hashCode());
                    if (key.isReadable()) {
                        System.out.println(key.hashCode() + " isReadable");
                        socketChannel.accept().register(selector, SelectionKey.OP_READ);
//问题2：socketChannel 与 (SocketChannel)socketChannel.accept() 这两个channel什么区别
                    } else if (key.isAcceptable()) {
//问题1：当一个客户端连接进来时,为什么这句话会一直重复地打印
                        System.out.println(key.hashCode() + " accepted");
                    }
                }
            } catch (IOException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TCP tcp = new TCP();
        tcp.start();
    }
} 