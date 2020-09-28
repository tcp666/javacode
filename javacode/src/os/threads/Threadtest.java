package os.threads;

import java.util.Scanner;

public class Threadtest {

    static final Object obj=new Object();

    static   long maincounter = 0;
    public static class Threadwork implements Runnable{
        private  long counter;

        public Threadwork(long counter) {
            this.counter = counter;
        }

        public long getCounter() {
            return counter;
        }

        @Override
        public void run() {

             while (true){
synchronized (Threadtest.obj) {
    this.counter++;
    Threadtest.maincounter++;
}

}
        }
    }

    public static void main(String[] args) throws Exception{

        Threadwork work1= new Threadwork(0);
        Threadwork work2=new Threadwork(0);
        Threadwork work3=new Threadwork(0);
        Thread t1 = new Thread(work1);
        Thread t2 = new Thread(work2);
        Thread t3=new Thread(work3);

        t1.start();
        t2.start();
        t3.start();
        int kill=1;
        Scanner sc=new Scanner(System.in);
        while (kill!=0){
            int sum=0;

           synchronized (Threadtest.obj){
               System.out.print("t1:"+work1.getCounter()+"  ");
               System.out.print("t2:"+work2.getCounter()+"  ");
               System.out.print("t3:"+work3.getCounter()+"  ");
               sum += work1.getCounter();
               sum += work2.getCounter();
               sum+=work3.getCounter();
               System.out.print("maincounter:"+maincounter+"    ");
               System.out.print("sum:"+sum+"    ");
           }
     kill=sc.nextInt();

        }
    }
}
