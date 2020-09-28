package weather.toolsclasses;

import java.io.Serializable;

public class RealTime implements Serializable {
    private int temperature;
    private int humidity;
    private String info;
    private String wid;
    private String direct;
    private String power;
    private String aqi;

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid;
    }

    public String getDirect() {
        return direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getAqi() {
        return aqi;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi;
    }

    @Override
    public String toString() {
        return
                "\t\t温度:" + temperature +
                "\n\t\t湿度:" + humidity +
                "\n\t\t天气:" + info+
                "\n\t\t风向:" + direct  +
                "\n\t\t级数:" + power +
                "\n\t\taqi:" + aqi ;
    }
}
