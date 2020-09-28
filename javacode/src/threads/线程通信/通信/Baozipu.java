package threads.线程通信.通信;

/**
 * 1,创建包子对象
 *
 */
public class Baozipu extends Thread{

    private Baozi bozi;

    public Baozipu(Baozi baozi){
        this.bozi=baozi;
    }


    /**
     * 生产包子
     */
    @Override
    public void run() {

       while(true){
           synchronized (bozi){
               if (bozi.flag==true)
                   try{
                       bozi.wait();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               //shengcha
               if (bozi.count%2==0){
                   bozi.pi="薄皮";
                   bozi.xian="三鲜";
               }
               else {
                   bozi.pi="冰皮";
                   bozi.xian="牛肉大虾";
               }

               System.out.println("包子铺正在生产"+bozi.pi+"皮，"+bozi.xian+"馅包子...");
               try{
                   Thread.sleep(300);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               bozi.flag=true;
               bozi.notify();
               System.out.println("包子铺已经生产好了"+bozi.pi+"皮，"+bozi.xian+"馅包子你可以吃了");
               bozi.count++;
               if (bozi.count==10)
               {
                   System.out.println("今天bu卖le");
                   break;
               }
           }
       }
    }
}
