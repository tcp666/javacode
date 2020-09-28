import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * @Description TODO
 * @Author gyhdx
 * @Date 2020/4/29 22:44
 */
public class Base64Test {

    public static void main(String[] args) throws IOException {
        BASE64Encoder encoder = new BASE64Encoder();
        BASE64Decoder decoder = new BASE64Decoder();

        String s = "hello world";
        byte[] bytes = s.getBytes();
        String encode = encoder.encode(bytes);
        System.out.println(encode);
        byte[] bytes1 = decoder.decodeBuffer(encode);
        System.out.println(new String(bytes1));
    }
}
