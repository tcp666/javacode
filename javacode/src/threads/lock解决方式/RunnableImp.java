package threads.lock解决方式;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 第三种解决方案
 * lock
 *
 * 1，在成员位置创建Lock对象
 * 2，在可能出现线程按全问题的代码前获取锁lock()
 * 3，在可能出现线程按全问题的代码后释放锁unlock()
 */
public class RunnableImp implements Runnable{
//    定义线程共享资源
    private int ticket=1000;
     Lock lock=new ReentrantLock();
//    设置线程任务
    @Override
    public void run(){
//        先判断
          while (true){
              lock.lock();
              if (ticket>0){
                  System.out.println(Thread.currentThread().getName()+"正在卖第:"+ticket--+"张票");
              }
              else{
                  System.out.println(Thread.currentThread().getName()+"票买完了"+"ticket:"+ticket);
                  lock.unlock();
                  break;
              }

                 lock.unlock();
    }
          }
      }


