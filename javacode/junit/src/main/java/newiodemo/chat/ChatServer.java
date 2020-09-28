package newiodemo.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

public class ChatServer {
    private static final int PORT = 9999;
    private ServerSocketChannel listenerChannel;//服务器端口: //监听通道老大
    private Selector selector;//选择器对象间谍

    public ChatServer() {
        try {
            // 1. 得到监听通道
            listenerChannel = ServerSocketChannel.open();
            //2.得到选择器间谍
            selector = Selector.open();
            // 3. 绑定端口
            listenerChannel.bind(new InetSocketAddress(PORT));
            // 4.设置为非阻塞模式
            listenerChannel.configureBlocking(false);
            // 5.将选择器绑定到监听通道并监听accept事件
            listenerChannel.register(selector, SelectionKey.OP_ACCEPT);
            printInfo("Chat Server is ready......");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printInfo(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat(" yyyy-MM-dd HH: mm:ss");
        System.out.println("[" + sdf.format(new Date() )+ "] ->" + str);

    }

    //6.干活儿
    public void start() {
        try {
            while (true) { //不停监控
                if (selector.select(2000) == 0) {
                    System.out.println("Server :没有客户端找我，我就干 别的事情");
                    continue;
                }
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    if (key.isAcceptable()) { //连接请求事件
                        SocketChannel sc = listenerChannel.accept();
                        sc.configureBlocking(false);
                        sc.register(selector, SelectionKey.OP_READ);
                        System.out.println(sc.getRemoteAddress().toString().substring(1) + "上线了");

                    }
                    if (key.isReadable()) { //读取数据事件
                        readMsg(key);
                    }

                    //一定要把当前key删掉，防止重复处理
                    iterator.remove();

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //读取客户端消息并广播
    private void readMsg(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int count = channel.read(buffer);
        if (count > 0) {
            String msg = new String(buffer.array());
            printInfo(msg);
            //发广播
            broadCast(channel, msg);
        }

    }

    //广播
    private void broadCast(SocketChannel channel, String msg) throws IOException {
        System.out.println("server发送了广播");
        for (SelectionKey key : selector.keys()) {

            SocketChannel targetChannel = (SocketChannel) key.channel();
            if (targetChannel instanceof SocketChannel && targetChannel != channel) {
                ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
                targetChannel.write(buffer);
            }
        }
    }

    public static void main(String[] args) {
        new ChatServer().start();
    }
}