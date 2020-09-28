package threads.定时器;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class traditionalTimerTest {
    public static void main(String[] args) throws Exception{
        Timer timer=new Timer();


        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("bombing");
            }
        },1000,2000);
        while(true){
            System.out.println(new Date().getSeconds());
            Thread.sleep(1000);
        }
    }
}
