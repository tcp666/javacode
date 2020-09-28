package newiodemo.file;

import org.openjdk.jol.info.ClassLayout;


public class Test {
    public Test(){

    }
public static int i=0;
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        boolean flag=false;
        if (flag=true){
            System.out.println("true");
        }else System.out.println("false");


        Boolean flag1=false;
        if (flag1=true){
            System.out.println("true");
        }else
            System.out.println("false");


    }
    public static void f(int i) {
        i++;
        Test.i++;


    }
}
