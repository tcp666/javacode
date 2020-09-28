import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Date;

public class FileCopy {
    public void copyByFileIo(File src, File dest) {
        try {
            long start=System.currentTimeMillis();
            FileInputStream fileInputStream = new FileInputStream(src);
            FileOutputStream fileOutputStream = new FileOutputStream(dest);
            byte[] bytes = new byte[1024];
            int length = 0;
            while ((length = fileInputStream.read(bytes)) > 0) {
                fileOutputStream.write(bytes, 0, length);
            }
            System.out.println("costtime"+(System.currentTimeMillis()-start));
            fileOutputStream.flush();
            fileInputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void copyByBufferedIo(File src, File dest) {
        try {
            long start=System.currentTimeMillis();

            BufferedReader bufferedReader = new BufferedReader(new FileReader(src));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(dest));
            char[] buff = new char[1024];
            int length = 0;
            while ((length = bufferedReader.read(buff)) > 0) {
                bufferedWriter.write(buff, 0, length);
            }
            System.out.println("cost"+(System.currentTimeMillis()-start));
            bufferedReader.close();
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void copyByFileChannelAndByteBuffer(File src, File dest) {

        try {
            long start=System.currentTimeMillis();

            FileChannel inChannel = new FileInputStream(src).getChannel();
            FileChannel outChannel = new FileOutputStream(dest).getChannel();
            ByteBuffer bb = ByteBuffer.allocate(1024);
            while (inChannel.read(bb) != -1) {
                bb.flip();
                outChannel.write(bb);
                bb.clear();
            }
            System.out.println(System.currentTimeMillis()-start);
            inChannel.close();
            outChannel.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public void copyByChanTran(File src, File dest) {
        try {
            long start=System.currentTimeMillis();
            FileChannel srcChan = new FileInputStream(src).getChannel();

            FileChannel edstChan = new FileOutputStream(dest).getChannel();
            srcChan.transferTo(0, srcChan.size(), edstChan);

            System.out.println(System.currentTimeMillis()-start);

            srcChan.close();
            edstChan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void copyByMapperByteBuffer(File src, File dest){


        try { FileChannel source = new FileInputStream(src).getChannel();
            FileChannel destination = new FileOutputStream(dest).getChannel();
            MappedByteBuffer inBuffer = null;
            MappedByteBuffer outBuffer = null;

            long start = -1;

            inBuffer = source.map(FileChannel.MapMode.READ_ONLY,0,source.size());
            outBuffer = destination.map(FileChannel.MapMode.READ_WRITE,0,source.size());

            start = System.currentTimeMillis();

            byte[] bytes = new byte[inBuffer.limit()];
            inBuffer.get(bytes);
            outBuffer.put(bytes);

            System.out.println("costtime" + (System.currentTimeMillis() - start) );
            source.close();
            destination.close();
            inBuffer.clear();
            outBuffer.clear();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        File src=new File("src.avi");
        File dest=new File("dest.avi");
        FileCopy fc=new FileCopy();
        System.out.println("1.1 使用File IO 实现文件拷贝");
        fc.copyByFileIo(src,dest);
        System.out.println("1.2 使用Buffered IO实现文件拷贝");
        fc.copyByBufferedIo(src,dest);
        System.out.println("1.3 使用FileChannel + ByteBuffer实现文件拷贝，申请直接缓冲区和一般缓冲区的方法进行拷贝");
        fc.copyByFileChannelAndByteBuffer(src,dest);
        System.out.println( "1.4 使用使用FileChannel的transferFrom对文件拷贝");
        fc.copyByChanTran(src,dest);
        System.out.println("1.5 使用MapperByteBuffer，对文件进行虚拟内存映射的方式进行文件拷贝");
        fc.copyByMapperByteBuffer(src,dest);


    }


}
