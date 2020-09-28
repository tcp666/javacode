package tcp.RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;


public class Client {

    public Calculator calculator;

     public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
         Client client = new Client();
         Scanner scanner = new Scanner(System.in);

         while (true){
             System.out.println("client:");
             System.out.println("请输入算式：");
             String str = scanner.nextLine();
             client.client(str);
         }

     }

    public void client(String str) throws MalformedURLException, RemoteException, NotBoundException {
        //在RMI注册表中查找指定对象
        calculator = (Calculator) Naming.lookup("rmi://localhost:8000/Cal");
        //调用远程对象方法

        String[] str1 = handler(str);
        if (str1 == null){
            return;
        }else if (str1.length == 3){
            if (str1[1].equals("!")){
                int result = calculator.fac(Integer.valueOf(str1[0]));
                System.out.println("结果为："+result);
                return;
            }else if (str1[1].equals("f")){
                Long result = calculator.facFibonacci(Integer.valueOf(str1[0]));
                System.out.println("结果为："+result);
                return;
            }else if (str1[2].equals("+")){
                int result = calculator.add(Integer.valueOf(str1[0]), Integer.valueOf(str1[1]));
                System.out.println("结果为："+result);
                return;
            }else if (str1[2].equals("-")){
                int result = calculator.sub(Integer.valueOf(str1[0]), Integer.valueOf(str1[1]));
                System.out.println("结果为："+result);
                return;
            }else if (str1[2].equals("*")){
                int result = calculator.mul(Integer.valueOf(str1[0]), Integer.valueOf(str1[1]));
                System.out.println("结果为："+result);
                return;
            }else if (str1[2].equals("/")){
                Double result = calculator.div(Integer.valueOf(str1[0]), Integer.valueOf(str1[1]));
                System.out.println("结果为："+result);
                return;
            }else if (str1[2].equals("^")){
                int result = calculator.pow(Integer.valueOf(str1[0]), Integer.valueOf(str1[1]));
                System.out.println("结果为："+result);
                return;
            }else {
                System.out.println("输入错误！请重新输入");
            }

        }



//        System.out.println(calculator.add(1,3));
//        System.out.println(calculator.sub(5,3));
//        System.out.println(calculator.mul(2,3));
//        System.out.println(calculator.div(9,3));
//        System.out.println(calculator.fac(3));
//        System.out.println(calculator.pow(3,2));
//        System.out.println(calculator.facFibonacci(3));
    }


    public String[] handler(String str) {
        String[] sb = new String[3];
        //+
        if (str.contains("+")) {

            String[] strings = str.split("\\+");
            if (strings[0] == null || strings[1] == null) {
                System.out.println("输入错误！重新输入");
            } else {
                sb[0] = strings[0].trim();
                sb[1] = strings[1].trim();
                sb[2] = "+";
            }
        }else if (str.contains("-")){
            String[] strings = str.split("\\-");
            if (strings[0] == null || strings[1] == null) {
                System.out.println("输入错误！重新输入");
            } else {
                sb[0] = strings[0].trim();
                sb[1] = strings[1].trim();
                sb[2] = "-";
            }
        }else if (str.contains("*")){
            String[] strings = str.split("\\*");
            if (strings[0] == null || strings[1] == null) {
                System.out.println("输入错误！重新输入");
            } else {
                sb[0] = strings[0].trim();
                sb[1] = strings[1].trim();
                sb[2] = "*";
            }
        }else if (str.contains("/")){
            String[] strings = str.split("\\/");
            if (strings[0] == null || strings[1] == null) {
                System.out.println("输入错误！重新输入");
            } else {
                sb[0] = strings[0].trim();
                sb[1] = strings[1].trim();
                sb[2] = "/";
            }
        }else if (str.contains("^")){
            String[] strings = str.split("\\^");
            if (strings[0] == null || strings[1] == null) {
                System.out.println("输入错误！重新输入");
            } else {
                sb[0] = strings[0].trim();
                sb[1] = strings[1].trim();
                sb[2] = "^";
            }
        }else if (str.contains("!")){
            String string = str.substring(0, str.indexOf("!"));
            if (string == null ) {
                System.out.println("输入错误！重新输入");
            } else {
                sb[0] = string.trim();
                sb[1] = "!";
            }
        }else if (str.contains("f")){
            String string = str.substring(str.indexOf("f")+1, str.length());
            if (string == null ) {
                System.out.println("输入错误！重新输入");
            } else {
                sb[0] = string.trim();
                sb[1] = "f";
            }
        }else {
            System.out.println("输入错误！请重新输入");
            return null;
        }
        return sb;
    }

}