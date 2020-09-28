package threads.线程安全.Sychronized;



/**
 * 创建3个线程同时卖票
 *
 */
public class Demo01Ticket {
    public static void main(String[] args) {
        RunnableImp run1=new RunnableImp();

        Thread thread1=new Thread(run1);

        Thread thread2=new Thread(run1);

        Thread thread3=new Thread(run1);


        thread1.start();
        thread2.start();
        thread3.start();
    }
}
