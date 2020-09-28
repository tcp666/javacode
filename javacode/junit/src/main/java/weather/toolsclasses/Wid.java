package weather.toolsclasses;

import java.io.Serializable;

 public class Wid implements Serializable {
    private String day;
    private String night;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getNight() {
        return night;
    }

    public void setNight(String night) {
        this.night = night;
    }

    @Override
    public String toString() {
        return
                "\n\t\t白天:" + day  +
                "\n\t\t夜晚：" + night
                ;
    }
}
