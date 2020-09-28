import com.sun.org.apache.xml.internal.dtm.ref.DTMDefaultBaseIterators;

class Supper{
    public int x;
  public   Supper(){
      System.out.println(this);
      System.out.println(this.getClass());
    }
    public int f(){
        return 2;
    }
}
class Son extends Supper{
    public Son(){
        super();
        this.x=100;
        super.x=200;
        System.out.println(this);
        System.out.println(x);
        System.out.println(this.x);
        System.out.println(super.x);
    }
    public int f(int x){
        System.out.println("super:"+super.getClass()+":"+"this:"+this.getClass());
        return 5;
    }
}
public class Example {
    public static void main(String[] args) {
         Son son=new Son();
        System.out.println(son.f(1));
    }
}
