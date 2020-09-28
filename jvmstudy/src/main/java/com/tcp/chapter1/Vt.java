package com.tcp.chapter1;

public class Vt {

    static volatile boolean i=true;
    public static void m(){
        System.out.println("m:start");
        while (i){}
        System.out.println("m:end");
    }
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                m();
            }
        }.start();


        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        i=false;

    }
}
