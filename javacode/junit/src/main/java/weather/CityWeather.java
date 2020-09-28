package weather;

import com.fasterxml.jackson.databind.ObjectMapper;
import weather.toolsclasses.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 *
 */
public class CityWeather {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入你要查询的城市：");
            String cityName = sc.nextLine();
            try {
                URL url = new URL("http://apis.juhe.cn/simpleWeather/query?city=" + cityName + "&key=c76e303ffdf48e7073d697528c6b9e38&key=c76e303ffdf48e7073d697528c6b9e38");
                URLConnection connection = url.openConnection();
                InputStream is = connection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
                char[] chars = new char[10000];
                bufferedReader.read(chars);
                String s = new String(chars);
                ObjectMapper mapper = new ObjectMapper();
                Rel rel = mapper.readValue(s, Rel.class);
                Result result = rel.getResult();
                RealTime realTime = result.getRealtime();
                String city = result.getCity();
                System.out.println("city:" + city);
                System.out.println("" +
                        "\t\t实时天气状况如下:\n" + realTime.toString());
//                System.out.println("未来三天:" + result.getFuture().toString().replace('[', ' ').replace(']', ' ').replace(',', ' '));


                if (rel.getResult().getRealtime().getInfo().contains("雨")){
                    System.out.println("记得带雨伞，今天有雨！");
                }

                if (realTime.getTemperature()>39){
                    System.out.println("注意防嗮！");
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
