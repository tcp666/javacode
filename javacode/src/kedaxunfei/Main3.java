package kedaxunfei;

import java.util.Scanner;

/**
 *@ClassName Main3
 *@Description TODO
 *@Author  TangCaiping
 *@Date 2020/9/26 19:43
 *@Version 1.0
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m;
        int n;
//        m=sc.nextInt();
//        n=sc.nextInt();

        String s=null;
         s=sc.nextLine();
         String[] ss=s.split(",");
         m=Integer.parseInt(ss[0]);
         n=Integer.parseInt(ss[1]);
        int[][] nums=new int[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                nums[i][j]=sc.nextInt();
            }
        }
        System.out.println(getMax(nums,m,n));
    }

    private static int getMax(int[][] nums, int m, int n) {
        if (m==0&&n==0)
            return 0;

        int[] temp=new int[n];

        for (int i=0;i<m;i++)
            for (int j=0;j<n;j++){
                int l=0;
                int up=0;
                if (i>0)
                    up=temp[j];
                if (j>0)
                    l=temp[j-1];
                temp[j]=Math.max(up,l)+nums[i][j];
            }
        return temp[n-1];
    }

}
