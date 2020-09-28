package niukehuawei;

import java.util.Date;
import java.util.Scanner;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str=str.toUpperCase();
        int r = str.length() - 1;
        int count = 0;
        while (r > -1) {
            if (!(str.charAt(r) >= 'a' && str.charAt(r) <= 'z' || str.charAt(r) >= 'A' && str.charAt(r) <= 'Z'))
                continue;
            else {
                count++;
            }
            r--;
            if (r==-1||str.charAt(r) == ' ') {
                System.out.println(count);
                return;
            }

        }
        System.out.println(count);
    }
}

class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String charStr = sc.nextLine();
        str=str.toUpperCase();
        int count=0;
        char t=charStr.charAt(0);
        if (t>='a'&&t<='z')
            t= (char) (t+'A'-'a');

        for(int i=0;i<str.length();i++)
            if (str.charAt(i)==t)
                count++;

        System.out.println(count);
    }
}


 class Main3 {
    public static void main(String[] args) {

        System.out.println(System.currentTimeMillis());
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] chars=str.toCharArray();
        int l=0;
        int r=str.length()-1;
        while(l<r){
            char temp=chars[l];
            chars[l]=chars[r];
            chars[r]=temp;
            l++;
            r--;
        }
        System.out.println(String.valueOf(chars));



    }
}