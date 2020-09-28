import java.util.Date;
import java.util.Scanner;


public class TimeControl {

    //测试用例：
    /**
     * 输入10：预期输出：10ms过去了 实际输出：10ms过去了
     * 输入 5：预期输出：5ms过去了  实际输出  5ms过去了
     * 输入 2  预期输出： 2ms过去了 实习输出  死循环触发erro
     */
    public static void waiteSometime() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要暂停的毫秒数");
        int time = sc.nextInt();
        Date start = new Date();
        while (true) {
            if ((new Date().getTime() - start.getTime()) == time)
                break;
        }
        System.out.println(time + "ms过去了");
    }

    public static void main(String[] args) {

        waiteSometime();
    }
}
