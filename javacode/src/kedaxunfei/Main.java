package kedaxunfei;

import java.util.Arrays;
import java.util.Scanner;

/**
 *@ClassName Main
 *@Description TODO
 *@Author  TangCaiping
 *@Date 2020/9/26 19:04
 *@Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String test=null;
        while (true){
            test=sc.nextLine();
            System.out.println(getFixedString(test));
        }
    }

    private static String getFixedString(String test) {
        if (test==null)
            return null;
        int l=0;
        int r=test.length()-1;
        while (test.charAt(l)=='_')
        l++;
        while (test.charAt(r)=='_')
            r--;
     String check=   test.substring(l,r+1);
     char[] chars=new char[check.length()];
     int count=0;
     for (int i=0;i<check.length();i++){
         if(check.charAt(i)!='_')
             chars[count++]=check.charAt(i);
         else {
             chars[count++]=check.charAt(i);
             while (check.charAt(i)=='_'&&i<test.length())
                 i++;
             i--;
         }
     }
            return String.valueOf(chars,0,count);
    }
}
