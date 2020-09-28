package weather.toolsclasses;

import java.io.Serializable;
import java.util.List;

public class Result implements Serializable {
    private String city;
    private RealTime realtime;
    private List<Future> future;

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "\n未来三天:" +
                "\ncity:" + city + '\'' +
                ", realtime=" + realtime +
                ", future=" + future +
                '}';
    }

    public void setCity(String city) {
        this.city = city;
    }

    public RealTime getRealtime() {
        return realtime;
    }

    public void setRealtime(RealTime realtime) {
        this.realtime = realtime;
    }

    public List<Future> getFuture() {
        return future;
    }

    public void setFuture(List<Future> future) {
        this.future = future;
    }
}

