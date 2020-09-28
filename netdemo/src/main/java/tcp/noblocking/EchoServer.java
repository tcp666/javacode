package tcp.noblocking;
import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;
import java.net.*;
import java.util.*;

public class EchoServer{
    private int a = 0;
    private Map<Integer,String> map = new HashMap<Integer, String>();
  private Selector selector = null;
  private ServerSocketChannel serverSocketChannel = null;
  private int port = 8000;
  private Charset charset=Charset.forName("utf-8");

  public EchoServer()throws IOException{
      getResource();
    selector = Selector.open();
    serverSocketChannel= ServerSocketChannel.open();
    serverSocketChannel.socket().setReuseAddress(true);
    //使ServerSocketChannel工作于非阻塞模式
    serverSocketChannel.configureBlocking(false);
    //把服务器进程与一个本地端口绑定
    serverSocketChannel.socket().bind(new InetSocketAddress(port));
    System.out.println("服务器启动");
  }

  public void service() throws IOException{
    serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT );
    while (selector.select() > 0 ){
      Set readyKeys = selector.selectedKeys();
      //System.out.println("readykeys:"+ readyKeys);
      Iterator it = readyKeys.iterator();

      while (it.hasNext()){
         SelectionKey key=null;
         try{
            key = (SelectionKey) it.next();

             it.remove();

            if (key.isAcceptable()) {
    
             ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
             //ServerSocketChannel ssc = serverSocketChannel;
              System.out.println(ssc+"          -ServerSocketChannel");
              SocketChannel socketChannel = ssc.accept();
              System.out.println("接收到客户连接，来自:" +
                                 socketChannel.socket().getInetAddress() +
                                 ":" + socketChannel.socket().getPort());
              socketChannel.configureBlocking(false);
              ByteBuffer buffer = ByteBuffer.allocate(1024*1024);
              System.out.println("************acceptable*******");
              socketChannel.register(selector,
                                     SelectionKey.OP_READ |
                                     SelectionKey.OP_WRITE, buffer);
            }
            if (key.isReadable()) {
                //System.out.println("************Readable*******");
                receive(key);
            }
            if (key.isWritable()) {
                //System.out.println("************writable*******");
                send(key);
            }
        }catch(IOException e){
             System.out.println("客户端的被强制退出连接！！！");
           try{
               if(key!=null){
                   key.cancel();
                   key.channel().close();
               }
           }catch(Exception ex){e.printStackTrace();}
        }
      }//#while
    }//#while
  }

  public void send(SelectionKey key)throws IOException{
//      System.out.println("************writable*******" + a++);

      ByteBuffer buffer=(ByteBuffer)key.attachment();
    SocketChannel socketChannel=(SocketChannel)key.channel();
    buffer.flip();  //把极限设为位置，把位置设为0
    String data=decode(buffer);
    if(data.indexOf("\r\n")==-1)return;
    String outputData=data.substring(0,data.indexOf("\n")+1);
    String outputData2=data.substring(0,data.indexOf("\r\n"));
//    System.out.print(outputData);
      String sendMsg = "";
      String str = "";
    try{
        String[] split = outputData2.split(":");
        if (split[0].equals("sentence")){
            String[] nums = split[1].split(",");
            for (String num : nums) {
                Integer integer = Integer.valueOf(num);
                str = split[0] + ":::" + integer + ":::" + map.get(integer);
                sendMsg += str+";;;";
            }
        }


        System.out.println("sendMsg----:"+sendMsg);
    }catch (Exception e){
    }
//    synchronized (socketChannel){
      if (!sendMsg.equals("")){
          outputData2 = sendMsg;
      }
      System.out.println(outputData2);
        ByteBuffer outputBuffer=encode(outputData2+"\r\n");

        while(outputBuffer.hasRemaining()){
            socketChannel.write(outputBuffer);
        }
//    }


//    outputBuffer.compact();
    ByteBuffer temp=encode(outputData);
      buffer.position(temp.limit());
    buffer.compact();

    if(outputData.equals("bye\r\n")){
      key.cancel();
      socketChannel.close();
      System.out.println("关闭与客户的连接");
    }
  }

  public void receive(SelectionKey key)throws IOException{
    ByteBuffer buffer=(ByteBuffer)key.attachment();

    SocketChannel socketChannel=(SocketChannel)key.channel();
    ByteBuffer readBuff= ByteBuffer.allocate(32);
    socketChannel.read(readBuff);
    readBuff.flip();

    buffer.limit(buffer.capacity());
    buffer.put(readBuff);
  }

  public String decode(ByteBuffer buffer){  //解码
    CharBuffer charBuffer= charset.decode(buffer);
    return charBuffer.toString();
  }
  public ByteBuffer encode(String str){  //编码
    return charset.encode(str);
  }

    public void getResource(){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/resources/english900.txt")));
            String read;
            while ((read = reader.readLine()) != null){
                String[] split = read.split("\\.");
                try {
                    Integer integer = Integer.valueOf(split[0]);
                    String msg = split[1];
                    for (int i = 2; i < split.length; i++) {
                        msg += "."+split[i];
                    }
                    map.put(integer,msg);
                }catch (Exception e){

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

  public static void main(String args[])throws Exception{
    EchoServer server = new EchoServer();
    server.service();
  }
}

