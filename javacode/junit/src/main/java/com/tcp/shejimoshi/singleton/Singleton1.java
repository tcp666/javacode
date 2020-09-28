package com.tcp.shejimoshi.singleton;

/**
 * 饿汉式
 * <p>
 * 类加获到内存后，就实阿化一 一个单例，JVM保证线程安全
 * *简单实用，推荐实用!
 * .爱-缺点: 不管用到与态类装载时就完成实例化
 * * (话说你不用的， 你技我它F管)
 */
public class Singleton1 {
    private static final Singleton1 INSTANCE = new Singleton1();
    private Singleton1() {
    }
    public static Singleton1 getINSTANCE() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Singleton1 singleton1 = Singleton1.getINSTANCE();
        Singleton1 singleton12 = Singleton1.getINSTANCE();
        System.out.println(singleton1 == singleton12);
    }
}
