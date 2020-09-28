package threads.同步方法;

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


        thread2.start();
        thread1.start();
        thread3.start();
    }
}
