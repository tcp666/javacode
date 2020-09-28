package tcp.mynoblocking;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author gyhdx
 * @Date 2020/5/7 9:14
 */
public class Test {
    private static Map<Integer,String> map = new HashMap<Integer, String>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/resources/english900.txt")));
        String read;
        while ((read = reader.readLine()) != null){
            String[] split = read.split("\\.");
            try {
                Integer integer = Integer.valueOf(split[0]);
                String msg = split[1];
                for (int i = 2; i < split.length; i++) {
                    msg += "."+split[i];
                }
                map.put(integer,msg);
            }catch (Exception e){

            }
        }
//        for (int i = 0; i < map.size(); i++) {
//            System.out.println(i + "  :  "+ map.get(i));
//        }
        String s = "ggggg:Hello.你好！";
        String[] split = s.split(":");
        System.out.println(split.length);
        for (String s1 : split) {
            System.out.println(s1);
        }
//        for (int i = 0; i < 10; i++) {
//            new Thread(()->{
//                System.out.println(Thread.currentThread().getName()+":"+s);
//            }).start();
//
//            }



    }
}
