package threads.线程通信.通信;

public class ChiHuo extends Thread {

    private Baozi bz;

    public ChiHuo(Baozi bz){
        this.bz=bz;
    }


    @Override
    public void run() {

        while (true){
            synchronized (bz){
             if (bz.flag==false){
               try{
                   bz.wait();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }

             }

                System.out.println("吃货正在吃"+bz.pi+","+bz.xian+"的包子");
             bz.flag=false;
                bz.count++;

             bz.notify();
                System.out.println("吃货已经吃完了"+bz.pi+","+bz.xian+"的包子");

                System.out.println("-------------------------");
                if (bz.count==10)
                {
                    System.out.println("吃饱了，不吃了");
                    break;
                }


            }
        }
    }
}
