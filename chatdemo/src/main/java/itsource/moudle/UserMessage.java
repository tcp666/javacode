package cn.itsource.moudle;

import java.io.Serializable;

public class UserMessage implements Serializable {
   String comname;
   String message;
   String toname;

    public String getMessage() {
        return message;
    }

    public String getToname() {
        return toname;
    }

    public void setComname(String comname) {
        this.comname = comname;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setToname(String toname) {
        this.toname = toname;
    }

    public String getComname() {
        return comname;
    }

    @Override
    public String toString() {
        return "UserMessage{" +
                "comname='" + comname + '\'' +
                ", message='" + message + '\'' +
                ", toname='" + toname + '\'' +
                '}';
    }
}
