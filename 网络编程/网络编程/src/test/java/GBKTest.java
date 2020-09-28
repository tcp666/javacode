import java.io.UnsupportedEncodingException;

/**
 * @Description TODO
 * @Author gyhdx
 * @Date 2020/4/29 23:14
 */
public class GBKTest {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "你好";
        String s1 = new String(s.getBytes("UTF-8"),"GBK");
        System.out.println(s1);
        String s2 = new String(s1.getBytes("GBK"),"UTF-8");
        System.out.println(new String(s2));
    }
}
