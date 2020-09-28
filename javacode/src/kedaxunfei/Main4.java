package kedaxunfei;

import java.util.Arrays;
import java.util.Scanner;

/**
 *@ClassName Main4
 *@Description TODO
 *@Author  TangCaiping
 *@Date 2020/9/26 20:13
 *@Version 1.0
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n;
        n=sc.nextInt();

        String  numStr=sc.next();
        int[]  arr=new int[n];
        String[] strings=numStr.split(",");
        int count=0;
        for (String nums:strings)
            arr[count++]=Integer.parseInt(nums);
        print(arr);
    }

    private static void print(int[] arr) {
        if (arr==null)
            return;
        int length=arr.length;
        for (int i=1;i<length;i++){
            int temp=arr[i];
            int j;
            for (j=i-1;j>-1;j--){
                if (temp<arr[j])
                    arr[j+1]=arr[j];
                else break;
            }
            arr[j+1]=temp;
            System.out.println(Arrays.toString(arr));;
        }
        System.out.println("**********************************88");
        for (int i=0;i<arr.length-1;i++){
            System.out.print(arr[i]+",");
        }
        System.out.print(arr[arr.length-1]);
    }
}
