package com.tcp.chapter2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

public class ClassIniitTest {
    int x;
    private int y;
    protected int z;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        byte[] bytes={-27,-108,-112,-24,-76,-94,-27,-71,-77};
        System.out.println(new String(bytes));
    }
}
