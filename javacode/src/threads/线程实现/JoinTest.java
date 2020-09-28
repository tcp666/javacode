package threads.线程实现;

public class JoinTest {
    public static void main(String[] args) {
        Thread t1=new  Thread(new Runnable() {
            @Override
            public void run() {
              for (int i=0;i<10;i++)
                  System.out.println("t1+"+i);
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i=0;i<10;i++)
                    System.out.println("t2+"+i);
            }
        });
        Thread t3=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i=0;i<10;i++)
                    System.out.println("t3+"+i);
            }
        });

        t1.start();
        t2.start();

        t3.start();




    }
}
