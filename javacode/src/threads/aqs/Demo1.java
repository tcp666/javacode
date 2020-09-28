package threads.aqs;

import java.io.*;
public class Demo1 {
    static int x=0,y=0;
    static int a=0,b=0;
    static void write(){
        a=1;
        y=b;
    }
    static void read(){
        b=1;
        x=a;
    }
    static int i=0;
    public static void resortI() throws InterruptedException {
        Thread t1=new Thread(){
            @Override
            public void run() {
                i++;
                a=1;
                y=b;
            }
        };
        Thread t2=new Thread(){
            @Override
            public void run() {
                i++;
                b=1;
                y=b;
            }
        };
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        if (x==0&&y==0){
            System.out.println(x+":"+y+":"+i);
        }
        x=0;y=0;a=0;b=0;
    }
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
   while (true){
       resortI();

   }
    }
}
