package newiodemo.socket;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * 网络客户端程序
 */
public class NIOClient {

    public static void main(String[] args) throws Exception {
        //1,得到一个网络通道
        SocketChannel channel = SocketChannel.open();
        //2设置阻塞方式
        channel.configureBlocking(false);
        //3提供服务器端的ip地址和端口
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 9999);
        //4,链接服务器端
        if (!channel.connect(address)) {
            while (!channel.finishConnect()) {
                //nio作为非阻塞式的优势
                System.out.println("Client：链接服务器的同事我可以做其他事情。。。。。。。");
            }
        }
        //5，发送数据
        String msg = "hello,server";
        ByteBuffer writeBuf = ByteBuffer.wrap(msg.getBytes());
        //6,发送数据

        channel.write(writeBuf);
    System.in.read();
    }
}
