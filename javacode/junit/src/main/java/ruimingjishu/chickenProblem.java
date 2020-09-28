package ruimingjishu;

public class chickenProblem {

    public static int count = 0;

    public static void main(String args[]) {
        int i, j, k;//i为母鸡，j为公鸡，k为小鸡
        int L = 1;
        for (i = 1; i <= 33; i++) {
            for (j = 1; j <= 20; j++) {
                k = 100 - i - j;
                if (i * 3 + j * 5 + k * (1 / 3) == 100) {
                    System.out.println("方案" + L + ":" + "母鸡的数量为:" + i + "," + "公鸡的数量为：" + j + "," + "小鸡的数量为：" + k);
                    L++;
                }
            }
        }


    }



}