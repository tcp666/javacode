package kedaxunfei;

import java.util.Scanner;

/**
 * @ClassName Main1
 * @Description TODO
 * @Author TangCaiping
 * @Date 2020/9/26 19:26
 * @Version 1.0
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        printf(n);
    }

    private static void printf(int n) {
        if (n == 0 || n == 1|n==2) {
            System.out.println(n);
        }
        StringBuilder sb = new StringBuilder();
        int i = 2;
        while (i <= n) {
            if (n % i == 0) {
                sb.append(i);
                sb.append('*');
                n=n/i;
                i=2;
            }else {
                i++;
            }
        }
        System.out.println(sb.toString().substring(0,sb.length()-1));
    }
}
