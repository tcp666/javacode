package bianlifeng;/**
 *@ClassName InterFaceTest
 *@Description TODO
 *@Author  TangCaiping
 *@Date 2020/9/22 12:28
 *@Version 1.0
 */

interface I1{
    void sleep();
}
interface  I2{
    void sleep();
    public void haha();

   static void fun(){

    };


}

abstract  class M{
    static void haha(){

    }
}
public class InterFaceTest implements I1,I2 {

    @Override
    public void sleep() {

    }

    @Override
    public void haha() {
        System.out.println("heloo");
    }

    public static void main(String[] args) {
        I1 i1=new InterFaceTest();
        i1.sleep();
        I2 i2=new InterFaceTest();
        i2.sleep();
        i2.haha();
    }
}
