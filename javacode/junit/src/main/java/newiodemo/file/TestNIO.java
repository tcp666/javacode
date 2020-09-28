package newiodemo.file;


import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestNIO {
    @Test
    public void test1() throws Exception{
        //1,创建输出流
        FileOutputStream fos=new FileOutputStream("basic.txt");
        //2. 从流中得到一个通道，
        FileChannel fc=fos.getChannel();
        //3提供缓冲区
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        //存入数据
        buffer.put("hello,NIO".getBytes());
      //让指针回到队头
        buffer.flip();
        //4把缓冲区写道通道中
        fc.write(buffer);
        //5关闭
        fos.close();
    }
    @Test//读
    public void Test2() throws Exception{
        //，创建输流
        File file=new File("basic.txt");
        FileInputStream fis=new FileInputStream(file);
        //获取通道
        FileChannel fc=fis.getChannel();
        //获取缓冲区
        ByteBuffer buffer=ByteBuffer.allocate((int)file.length());
        //读取到buffer中
        fc.read(buffer);
        System.out.println(new String(buffer.array()));
        fis.close();
    }

    @Test//niocopy
    public void test3() throws Exception{
        //,创建两个流
        FileInputStream fis=new FileInputStream("basic.txt");
        FileOutputStream fos=new FileOutputStream("basiccp.txt");
        //2个通道
       FileChannel src= fis.getChannel();
       FileChannel dest=fos.getChannel();
       //3复制
        dest.transferFrom(src,0,src.size());
//src.transferTo(0,src.size(),dest);
        fis.close();
        fos.close();
    }
}
