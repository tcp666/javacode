package newiodemo.socket;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Server程序
 */
public class NIOServer {
    public static void main(String[] args) throws Exception {
        //1,先得到ServerSocketChanel对象
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //得到selector对象
        Selector selector = Selector.open();
        //绑定一个端口
        serverSocketChannel.bind(new InetSocketAddress(9999));
        //设置非阻塞方式
        serverSocketChannel.configureBlocking(false);
        //把ServerSocketChanel注册给 selector
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        //6干活
        while (true) {
            //6.1监控客户端
            if (selector.select(2000) == 0) {//nio非阻塞式优势
                System.out.println("server:没有客户端搭理我，我就干点别的事");
                continue;
            }
            //6.2,得到得到SelectionKey,判断通道里的事件
            Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();
                if (key.isAcceptable()) {//客户端链接时间
                    System.out.println("P_ACCEPT");
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
//                    socketChannel.register(selector,SelectionKey.OP_WRITE,ByteBuffer.allocate(1024));
                }
                if (key.isReadable()) {//读取客户端数据事件
                    SocketChannel channel = (SocketChannel) key.channel();
                    ByteBuffer buffer = (ByteBuffer) key.attachment();
                    channel.read(buffer);
                    System.out.println("客户端发来数据："+new String(buffer.array()));
                }

                //6.3手动从集合中移除key
                keyIterator.remove();
            }
        }
    }
}
