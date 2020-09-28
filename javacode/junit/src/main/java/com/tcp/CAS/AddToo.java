package com.tcp.CAS;

public class AddToo {
    public static void main(String[] args) {

        String s = new String("a") + new String("b");//ab已经存在于常量池，s指向堆
        s.intern();
        String a = "ab";
//        System.out.println(ClassLayout.parseInstance(a).toPrintable());
        System.out.println(a == s);
        String x2 = new String("c") + new String("b");
        x2.intern();
        String x1 = "cd";
        System.out.println(x1 == x2);  //false  因为常量池中已经有了"cd"字符串，不会加载
        System.out.println(System.nanoTime());


    }
}
