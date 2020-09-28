package jvmDemo.com.refernenceDemo;

import java.lang.ref.SoftReference;

public class SoftReferenceDemo1 {
    public static void main(String[] args) {
        SoftReference<byte[]>  softReference=new SoftReference<>(new byte[10*1024*1024]);

        System.out.println(softReference.get());

        System.gc();
        System.out.println(softReference.get());


     byte[] bytes=   new byte[10*1024*1024];
    }


    @Override
    protected void finalize() throws Throwable {
        System.out.println("垃圾回收");
    }
}
