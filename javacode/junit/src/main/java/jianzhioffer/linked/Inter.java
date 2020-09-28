package jianzhioffer.linked;

/**
 * @InterfaceName Inter
 * @Description TODO
 * @Author Haining
 * @Date 2020/9/17 20:24
 * @Version 1.0
 */

public interface Inter {
    public int x = 10;
    static int u = 100;
    default public void f() {
    }
}
class  Fu{
    final public void hh(){
        System.out.println(78);
    }
}

 class AA extends  Fu {

     public static void main(String[] args) {
         AA aa=new AA();
         aa.hh();
     }
}