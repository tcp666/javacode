package threads.线程安全.同不问题产生;

/**
 * 创建3个线程同时卖票
 *
 */
public class Demo01Ticket {
    public static void main(String[] args) {
        RunnableImp run=new RunnableImp();

        Thread thread1=new Thread(run);

        Thread thread2=new Thread(run);

        Thread thread3=new Thread(run);


        thread1.start();
        thread2.start();
        thread3.start();
    }
}
