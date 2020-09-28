package threads.线程通信.wait方法;

/**
 * 进入记时等待
 * 1，使用sleep（time）
 * 2,wait(time),自动唤醒
 */
public class Demo2WaitandNotify {
    public static void main(String[] args) {
        //创建锁对象
        Object obj=new Object();

        //创建一个消费者
        new Thread(){
            @Override
            public void run(){
                while(true){
                    synchronized (obj){
                        System.out.println("顾客1告诉需求");
                        try{
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("顾客1吃+*****************");
                        System.out.println("****************");
                    }
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run(){
                while(true){
                    synchronized (obj){
                        System.out.println("顾客2告诉需求");
                        try{
                            obj.wait(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("顾客2吃+*****************");
                        System.out.println("****************");
                    }
                }
            }
        }.start();

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
//                        obj.notify();随机唤醒一个
                        obj.notifyAll();//唤醒所有

                       try{
                           Thread.sleep(1000);
                       }
                       catch (Exception e){
                           e.printStackTrace();
                       }
                    }
                }
            }
        }.start();

    }
}
