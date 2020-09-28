import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @Description TODO
 * @Author gyhdx
 * @Date 2020/5/6 15:18
 */
public class TestNonBlocking {

    @Test
    public void client() throws IOException {

        // 获取通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8888));

        // 分配1024字节大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        Scanner scan = new Scanner(System.in);

        // 输入
        while (scan.hasNext()) {

            String str = scan.next();

            buffer.put((new Date().toString() + "--" + str).getBytes());

            // 切换回读模式，实质是令limit=position；position=0。
            buffer.flip();
            // 写入通道
            socketChannel.write(buffer);
            // 清空缓冲区
            buffer.clear();
        }
    }

    @Test
    public void server() throws IOException {
        // 获取服务器端通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        // 切换该通道为非阻塞模式
        serverSocketChannel.configureBlocking(false);

        // 绑定端口号
        serverSocketChannel.bind(new InetSocketAddress(8888));

        // 获取选择器
        Selector selector = Selector.open();

        // 将通道注册到选择器上，并指定监听的事件类型为“接收”
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        // 轮询式地获取选择器上已经准备就绪的事件
        //selector.select()方法是阻塞的
        while (selector.select() > 0) {

            // 获取当前选择器中所有已经注册的“选择键”，即已就绪的监听事件
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();

            while (it.hasNext()) {
                // 获取已经准备就绪的事件
                SelectionKey selectionKey = it.next();

                // 判断事件的类型
                // 接收类型
                if (selectionKey.isAcceptable()) {
                    // 接收客户端通道
                    SocketChannel socketChannel = serverSocketChannel.accept();

                    socketChannel.configureBlocking(false);

                    socketChannel.register(selector, selectionKey.OP_READ);
                } else if (selectionKey.isReadable()) {
                    // 获取当前选择器上“读就绪”状态的通道
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();

                    ByteBuffer buffer = ByteBuffer.allocate(1024);

                    int len;

                    while ((len = socketChannel.read(buffer)) > 0) {
                        buffer.flip();
                        System.out.println(new String(buffer.array(), 0, len));
                        buffer.clear();
                    }
                }
                // 取消选择键 SelectionKey
                it.remove();
            }

        }
    }
}

