package jian;

import java.util.Scanner;

/**
 *@ClassName Main
 *@Description TODO
 *@Author  TangCaiping
 *@Date 2020/9/25 15:41
 *@Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
            n = sc.nextInt();
            System.out.println(getTypes(n));

    }

    static int getTypes(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        int count = 1;
        for (int i = 0; i < n - 1; i++)
            count *= 2;
        return count;
    }
}