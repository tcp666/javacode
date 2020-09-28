package threads.线程实现;

public class Demo01Sleep {
    public static void main(String[] args) {

     Runnable run=   new Runnable(){
            @Override
            public void run() {
                System.out.println("run"+Thread.currentThread().getName());
            }
        } ;


    }
}
