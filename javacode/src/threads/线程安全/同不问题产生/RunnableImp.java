package threads.线程安全.同不问题产生;

/**
 * 实现卖票
 */
public class RunnableImp implements Runnable{
//    定义线程共享资源
    private int ticket=100;


//    设置线程任务
    @Override
    public void run(){
//        先判断
      try{
          while (ticket>0){
              if (ticket>0){
                  Thread.sleep(100);
                  System.out.println(Thread.currentThread().getName()+"正在卖第:"+ticket--+"张票");
              }

          }
      } catch (InterruptedException e) {
          e.printStackTrace();
      }


    }
}
