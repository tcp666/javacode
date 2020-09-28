package com.tcp.CAS;

import org.openjdk.jol.info.ClassLayout;

class User {
    int id;
    String name;
}

/**
 * new - 偏向锁 -轻量级锁 （无锁，自旋锁，自适应锁）- 重量级锁
 * Object o=new Object();
 */
public class Test1 {
    public static void main(String[] args) {
        Object o = new Object();
        System.out.println("加锁前");
        o.hashCode();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        synchronized (o){
            System.out.println("加锁中");
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
        System.out.println("释放后");
        System.gc();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());


    }
}
