package xiaomi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/**
 * @ClassName Main
 * @Description TODO
 * @Author TangCaiping
 * @Date 2020/9/15 19:36
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        String match;
        Scanner scanner = new Scanner(System.in);
        match = scanner.nextLine();
        if (match.length() <= 1) {
            System.out.println(false);
            return;
        }
        Stack<Character> stack = new Stack<>();

        for (int i = 0, lenght = match.length(); i < lenght; i++) {
            char t = match.charAt(i);
            if (t == '[' || t == '{' || t == '(') {
                stack.push(t);
                continue;
            }
            else {
                char s=stack.pop();
                if (t=='('&&s==')'||t=='{'&&s=='}'||t=='['||s==']'){
                    i++;
                }
                else {
                    stack.push(s);
                    stack.push(t);
                    i++;
                    continue;
                }
            }
        }

    }


}


//public class Main{
//    public static void main(String[] args) {
//        String str=new Scanner(System.in).nextLine();
//        Set<Character> set=new HashSet<>();
//        for (int i=0;i<str.length();i++){
//            set.add(str.charAt(i));
//        }
//        StringBuilder sb=new StringBuilder();
//        for (Character x:set){
//            sb.append(x);
//        }
//
//        System.out.println(sb.toString());
//
//    }
//}