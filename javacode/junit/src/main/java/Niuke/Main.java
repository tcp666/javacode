package Niuke;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] chars=input.toCharArray();

        if(chars[0]=='"'&&chars[chars.length-1]=='"'&&chars.length>1){
            for(int i=1;i<chars.length-1;i++){
                if (chars[i]=='"')
                {
                    if (chars[i-1]=='\\'&&chars[i]=='"')
                        continue;
                    System.out.println(false);
                    return;
                }
            }
            System.out.println(true);
        }

        else
            System.out.println(false);
    }



}