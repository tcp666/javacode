package jvmDemo.com.refernenceDemo;

import jvmDemo.com.tcp.Demo;

import java.io.IOException;
import java.util.HashMap;

public class Demo1 {
    public static void main(String[] args) throws IOException {

        Demo1 demo1=new Demo1();
        demo1=null;
        System.gc();
        System.in.read();
        Object object=new Object();

        HashMap<String,String> hashMap=new HashMap<>();
    }
    @Override
    protected void finalize() throws Throwable {
        System.out.println("垃圾回收");
    }
}
