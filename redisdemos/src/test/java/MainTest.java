public class MainTest {
    public void test(){

        int i=8;
        while ((i-=3)>0);
        System.out.println("i = "+"/");

    }

    public static void main(String[] args) {
        MainTest mainTest=new MainTest();
        for (int i=0;i<100000;i++){
            mainTest.test();
        }
    }
}
