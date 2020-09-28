package com.tcp.GCAndACTuning;

import java.awt.*;

public class GCDemo2 {
    static volatile int i = 0;
    public static void main(String[] args) {
        new Thread(() -> {
            while (true)
                i = i++;
        }).start();


         while (true) {

            if (i == 1) {
               while (true){
                   System.out.println(i);
              break;
               }
            }
        }

    }
}
