package threads.同步方法;

/**
 * 实现卖票
 * <p>
 * 解决线程安全问题第一种方式
 * Sychronized（锁对象）{
 * 可能出现问题的对象
 * }
 * <p>
 * 1，锁对象可以是任意对象
 * 2，但是必须保证多个线程使用的是同一个对象
 * 3，吧同步代码块锁住，只让其中一个线程在同步代码块中执行
 */
public class RunnableImp implements Runnable {
    //    定义线程共享资源
    private  int ticket = 100;

//创建一个锁对象

    Object object = new Object();

    //    设置线程任务
    @Override
    public void run() {
      while(true){
          try{
              Thread.sleep(100);
              playticketstatic();
          }
          catch (Exception e){
              e.printStackTrace();
          }
          if (ticket==0)
          {
              System.out.println(Thread.currentThread().getName()+"买完了");
              break;
          }
      }
    }


    /**
     * 封装同步方法
     * 同步方法的锁对象
     * 就是实现类对象，this
     */
    public  synchronized void playticketstatic() {
        //        先判断

        try {
                   if (ticket > 0) {
                       System.out.println(Thread.currentThread().getName() + "正在卖第:" + ticket-- + "张票");
                   }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
