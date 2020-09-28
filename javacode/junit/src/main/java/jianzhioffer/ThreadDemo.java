package jianzhioffer;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo {

    public static volatile int a = 0;

    public static void main(String[] args) throws IOException {
        Lock lock=new ReentrantLock();

        lock.lock();
    }


}
