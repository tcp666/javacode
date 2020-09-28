import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Description TODO
 * @Author gyhdx
 * @Date 2020/4/29 22:23
 */
public class URLConnBASE64Test {

    private static BASE64Decoder decoder = new BASE64Decoder();
    private static BASE64Encoder encoder = new BASE64Encoder();

    public static void main(String[] args) throws Exception {
//        String path = "http://www.baidu.com";
        String path = "https://qdcu02.baidupcs.com/file/fc50e9a50ffa6676d9bc7faafa10e9b1?bkt=en-9917cc7abd88e3cb564dd305344fd398dc01351dbeab8981b3e7a686f29da2967ddcfd0fe4d745de433b7477551016b22e94bd1e627225c3cb585f0d0a37df9b&fid=1926551080-250528-559915755579947&time=1588235389&sign=FDTAXUGERQlBHSKfW-DCb740ccc5511e5e8fedcff06b081203-v%2BSPm7Isj2yFh72C90QV%2FFZmA58%3D&to=66&size=323120&sta_dx=323120&sta_cs=0&sta_ft=txt&sta_ct=7&sta_mt=7&fm2=MH%2CYangquan%2CAnywhere%2C%2Cshanxi2%2Ccnc&ctime=1384567953&mtime=1549043890&resv0=-1&resv1=0&resv2=rlim&resv3=5&resv4=323120&vuk=1926551080&iv=2&htype=&randtype=&newver=1&newfm=1&secfm=1&flow_ver=3&pkey=en-d4e43f5a6b4045f31711fdf11426aedaf581bc27f53d7bc51c6f44c0eee13c188f2297edd893a67f8b18ecf5cdb5bf975b657a1d4b47099c305a5e1275657320&expires=8h&rt=pr&r=861568690&vbdid=1178127430&fin=%E5%93%91%E8%88%8D1.txt&fn=%E5%93%91%E8%88%8D1.txt&rtype=1&dp-logid=2799080708931876193&dp-callid=0.1&hps=1&tsl=0&csl=0&fsl=-1&csign=eDwlki8kWi%2FtdVtf42us%2FOFe9Hs%3D&so=0&ut=1&uter=4&serv=0&uc=1369580095&ti=34c17094e7d5a0c9c5c83674029a4abd49ad81799ab2ece1&adg=c_28fb39dc03630de29591c086381bbdf3&reqlabel=250528_f_729766cb4eeb4fb444fdb5a010335c78_-1_bfa54c88a34103c954fec7e35ac05da4&by=themis";
//        String path = "http://lib.csdn.net/base/aimachinelearning";
//        String path = "http://lib.csdn.net/base/aimachinelearning";
        url(path);

        //
//        System.out.println("解码：");
//        decode("F:/加密文件.txt");
    }

    public static void url(String path) throws Exception {
        URL url = new URL(path);
        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("F://雅舍.txt");
            int read;
            while ((read = inputStream.read()) != -1){
                outputStream.write(read);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            inputStream.close();

        }
        System.out.println("加密结束");
    }

    public static String encode(String str){
        if (str == null || str.length() < 1) {
            return "";
        }
        return encoder.encode(str.getBytes());
    }

    public static void decode(String path){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
            String read;
            while ((read = reader.readLine()) != null){
                byte[] bytes = decoder.decodeBuffer(read);
                System.out.println(new String(bytes));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
