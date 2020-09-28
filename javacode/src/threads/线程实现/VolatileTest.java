package threads.线程实现;
class UThreadDemo1 extends Thread{
  private static boolean flag=true;
    @Override
    public void run() {
        System.out.println("子线程开始。。。。。。。。。。");
        while (flag){

        }
        System.out.println("子线程结束");
    }
    static void change(){
      flag=false;
    }
}
/**
 * Volatile:
 *  保证可见行但不保证原子性
 */
public class VolatileTest {
    public static void main(String[] args) {
        UThreadDemo1 ut1=new UThreadDemo1();
        ut1.start();
        ut1.change();
    }
}
