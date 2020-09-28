package threads.线程通信.通信;

public class Demo {
    public static void main(String[] args) {

        Baozi bz=new Baozi();

       int x=10;
       while (x-->0){

           new Baozipu(bz).start();

           new ChiHuo(bz).start();
       }
    }
}
