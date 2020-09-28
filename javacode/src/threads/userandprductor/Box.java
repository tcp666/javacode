package threads.userandprductor;

public class Box  {
    private int milk;

//    定义成员变量表示状态
    private boolean state=false;
    public synchronized void put(int milk) {
//        有则消费

        if(state){
           try{
               wait();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
        }
//没有生产
        this.milk=milk;
        System.out.println("送奶到了Box中");
        state=true;
        notifyAll();
    }

    public synchronized void get(){
//        无责等待
        if (!state){
            try{
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//           有则消费
        System.out.println("用户拿到第"
                +this.milk+"瓶奶");
        state=false;
        notifyAll();
    }
}
