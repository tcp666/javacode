package com.tcp.chapter2;
class ClassInit{
    static {
    if (true){
        System.out.println(Thread.currentThread().getName()+"正在加载"+ClassInit.class);
        while (true){
            int i=1000;
            try {
                Thread.sleep(i--);
                if (i==0)
                    break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    }
}

public class Load {
    public static void main(String[] args) {
      Runnable r=() -> {
          System.out.println(Thread.currentThread().getName()+"开始");
          ClassInit classInit=new ClassInit();
          System.out.println(Thread.currentThread().getName()+"结束");
      };
      Thread t1=new Thread(r,"thread1");
      Thread t2=new Thread(r,"thread2");
      t1.start();
      t2.start();
    }
}
