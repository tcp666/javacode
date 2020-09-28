package com.tcp.threadsconcurr;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class ConCurrentHashMap {
    public static void main(String[] args) {
        ConcurrentHashMap map=new ConcurrentHashMap();
        map.put("key","value");


    }
}
