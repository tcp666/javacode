package wf.noblocking;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;

import java.net.*;
import java.nio.channels.*;
import java.nio.*;
import java.io.*;
import java.nio.charset.*;
import java.util.*;



public class EchoClient{
    private int a = 0;
    Log log = LogFactory.get();
    private Map<Integer,String> oldmap = new HashMap<>();
    private Map<Integer,String> newmap = new HashMap<>();
  private SocketChannel socketChannel = null;
  private ByteBuffer sendBuffer=ByteBuffer.allocate(1024*1024);
  private ByteBuffer receiveBuffer=ByteBuffer.allocate(1024*1024);
  private Charset charset=Charset.forName("utf-8");
  private Selector selector;

  public EchoClient()throws IOException{
      getResource();
    socketChannel = SocketChannel.open();
    InetAddress ia = InetAddress.getLocalHost();
    InetSocketAddress isa = new InetSocketAddress(ia,8000);
    socketChannel.connect(isa);
    socketChannel.configureBlocking(false);
    System.out.println("与服务器的连接建立成功");
    selector=Selector.open();
  }
  public static void main(String args[])throws IOException{
    final EchoClient client=new EchoClient();
    Thread receiver=new Thread(){
      public void run(){
        client.receiveFromUser();
      }
    };

    receiver.start();
    client.talk();
  }

  public void receiveFromUser(){
    try{
      BufferedReader localReader=new BufferedReader(new InputStreamReader(System.in));
      String msg=null;
      String newMsg = null;
      while((msg=localReader.readLine())!=null){
          newMsg = "";
          String[] split = msg.split(":");
          newMsg += split[0];
          if (split[0].equals("sentence")){
              newMsg += ":";
              String[] nums = split[1].split(",");
              for (String num : nums) {
                  Integer integer = Integer.valueOf(num);
                  if (oldmap.containsKey(integer)){
                      System.out.println(split[0] + ":" + integer + "." + oldmap.get(integer) + "-----from client");
                }else {
                      newMsg += num + ",";
                  }
              }
          }
          sendBuffer.put(encode(newMsg + "\r\n"));
        if(msg.equals("bye")){
            synchronized(sendBuffer){
                break;
            }
        }

      }
    }catch(IOException e){
       e.printStackTrace();
    }
  }

  public void talk()throws IOException {
     socketChannel.register(selector,
                          SelectionKey.OP_READ |
                          SelectionKey.OP_WRITE);
     while (selector.select() > 0 ){
       Set readyKeys = selector.selectedKeys();
       Iterator it = readyKeys.iterator();
       while (it.hasNext()){

         SelectionKey key=null;
         try{
             key = (SelectionKey) it.next();
             it.remove();

             if (key.isReadable()) {
//                 System.out.println("a ;;;=" + a++);
                 receive(key);
             }
             if (key.isWritable()) {
//                 System.out.println("a ;;;=" + a++);
                 send(key);
             }
         }catch(IOException e){
             System.out.println("服务端的被强制退出连接！！！");
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
    SocketChannel socketChannel=(SocketChannel)key.channel();
    synchronized(sendBuffer){
        sendBuffer.flip(); //把极限设为位置
        socketChannel.write(sendBuffer);
        sendBuffer.compact();
     }
  }
  public void receive(SelectionKey key)throws IOException{

      SocketChannel socketChannel=(SocketChannel)key.channel();
      String receiveData;
      socketChannel.read(receiveBuffer);
      receiveBuffer.flip();
      receiveData = decode(receiveBuffer);

      if(receiveData.indexOf("\n")==-1)return;
      System.out.println(receiveData);
      String outputData=receiveData;
      String finalOutputData = outputData;

      String receiveMsg = null;
      try {
          String[] split = finalOutputData.split(";;;");

          for (String s : split) {
              receiveMsg = "";
              String[] split1 = s.split(":::");
              newmap.put(Integer.valueOf(split1[1]),split1[2]);
              receiveMsg = receiveMsg + split1[0] + ":" + split1[1] + "." + split1[2];
              System.out.println(receiveMsg);
          }
      }catch (Exception e){

      }
        outputData=receiveData.substring(0,receiveData.indexOf("\n")+1);
//          System.out.println(newmap.size());
//          System.out.print(receiveMsg);
          if(outputData.equals("bye\r\n")){
              log.info("map size {}",newmap.size());
              setResources();
              key.cancel();
              socketChannel.close();
              System.out.println("关闭与服务器的连接");
              selector.close();
              System.exit(0);
          }

      ByteBuffer temp = encode(receiveData);
      receiveBuffer.position(temp.limit());
      receiveBuffer.compact();
//      }
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
            reader = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/resources/clientres.txt")));
            String read;
            while ((read = reader.readLine()) != null){
                String[] split = read.split("\\.");
                try {
                    Integer integer = Integer.valueOf(split[0]);
                    String msg = split[1];
                    for (int i = 2; i < split.length; i++) {
                        msg += "."+split[i];
                    }
                    oldmap.put(integer,msg);
                }catch (Exception e){

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        Set<Integer> integers = map.keySet();
//        for (Integer integer : integers) {
//            System.out.println(integer+" : "+map.get(integer));
//        }

    }

    public void setResources() throws IOException {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/main/resources/clientres.txt",true)));
            Set<Integer> integers = newmap.keySet();
            for (Integer integer : integers) {
//                System.out.println(integer + "." + newmap.get(integer)+"\n");
                writer.write(integer + "." + newmap.get(integer)+"\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            writer.close();
        }
    }
}

//sentence:1,34,6