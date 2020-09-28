package com.tcp.CAS;

public class FinallyTest {
    public static void main(String[] args) {
        System.out.println(returnTest());
    }

    public static int returnTest() {
       int i=0;
       i=i++;
       return i;

    }
}
