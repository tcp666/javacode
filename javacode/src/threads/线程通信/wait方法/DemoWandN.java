package threads.线程通信.wait方法;

/**
 * 创建一个消费者线程：
 * 创建生产者线程
 *
 * 顾客线程和老板线程只能有一个在执行同步
 *
 * 只有锁对象才能使用wait和notify方法
 */
public class DemoWandN {
    public static void main(String[] args) {
        //创建锁对象
        Object obj=new Object();

        //创建一个消费者
        new Thread(){
            @Override
            public void run(){
              while(true){
                  synchronized (obj){
                      System.out.println("告诉需求");
                      try{
                          obj.wait();
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                      System.out.println("zhengzaichi+*****************");
                  }
              }
            }
        }.start();


//        创建生产者

        new Thread(){
            @Override
            public void run(){
            while (true){
                try{
                    Thread.sleep(5000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj){
                    System.out.println("生产好了");
                    obj.notify();
                }
            }
            }
        }.start();
    }
}
