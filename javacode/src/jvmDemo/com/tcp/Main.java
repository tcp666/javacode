package jvmDemo.com.tcp;

public class Main {

    public static void main(String[] args) {

        System.out.println(1);
        try {
            Thread.sleep(20000);

            byte[] bytes=new byte[1024*1024*10];

            Thread.sleep(20000);

            bytes=null;
            System.gc();;

            Thread.sleep(200000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
