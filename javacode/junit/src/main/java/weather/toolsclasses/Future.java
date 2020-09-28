package weather.toolsclasses;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

public class Future implements Serializable {
    private String date;
    private String temperature;
    private String weather;
    private Wid wid;
    private String direct;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public Wid getWid() {
        return wid;
    }

    public void setWid(Wid wid) {
        this.wid = wid;
    }

    public String getDirect() {
        return direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }

    @Override
    public String toString() {
        return
                "\n\t\t日期:" + date +
                "\n\t\t温度:" + temperature +
                "\n\t\t天气:" + weather +
                 wid +
                "\n\t\t风向:" + direct+"\n"
               ;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Future future=Future.class.getConstructor().newInstance();
        System.out.println(future);
    }
}
