package com.tcp.GCAndACTuning;

import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;

public class GCDemo {
    private static final int _512KB = 512 * 1024;
    private static final int _1MB = 1024 * 1024;
    private static final int _6MB = 6 * 1024 * 1024;
    private static final int _7MB = 7 * 1024 * 1024;
    private static final int _8MB = 8 * 1024 * 1024;

    public static void main(String[] args) {
        ArrayList<byte[]> list=new ArrayList<>();
//        list.add(new byte[_7MB]);
//        System.out.println(ClassLayout.parseInstance(list).toPrintable());
//        list.add(new byte[_512KB]);
//        list.add(new byte[_512KB]);
//        list.add(new byte[_6MB]);
//        list.add(new byte[_7MB]);
        list.add(new byte[_8MB]);//大对象直接晋升
        list.add(new byte[_8MB]);


    }
}
