package threads.线程实现;

import java.util.Date;

public class DemoThread1  {


    public static void main(String[] args) throws Exception{
       int[] arr=new int[10000000];



      Date  date1=new Date();
     new Thread(new Runnable() {
         @Override
         public void run() {
             for (int i=0;i<10000;i++)
                 arr[i]=i;
         }
     }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=10000;i<100000;i++)
                    arr[i]=i;
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=100000;i<10000000;i++)
                    arr[i]=i;

            }
        }).start();
        System.out.println(new Date().getTime()-date1.getTime());



    }


}
