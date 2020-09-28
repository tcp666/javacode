package threads.线程实现;

class UThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            try {
                Thread.sleep(200);
                System.out.println("user:"+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 一个进程：
 * 主线程，gc,用户线程
 * 守护线程：
 * 和main线程相关
 * gc线程
 * 有一个特征：和主线程一起销毁
 * <p>
 * 用户线程：
 * 主线程创建的线程
 * 非守护线程：和主线程无关
 */
public class ThreadDemo4 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new UThread(), "username");
        thread1.setDaemon(true);
        thread1.start();

        for (int i = 0; i < 10; i++)
        {
            System.out.println("main+"+i);
            try{
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("主线程结束了");
    }
}
