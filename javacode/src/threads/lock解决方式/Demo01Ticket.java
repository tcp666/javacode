package threads.lock解决方式;

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


        thread2.start();
        thread1.start();
        thread3.start();
    }
}
