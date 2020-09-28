package weather.toolsclasses;

import java.io.Serializable;




 public class Rel implements Serializable {
    private String reason;
    private Result result;
    private int error_code;
    public Result getResult() {
        return result;
    }
    @Override
    public String toString() {
        return "Rel{" +
                "reason='" + reason + '\'' +
                ", result=" + result +
                ", error_code=" + error_code +
                '}';
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setResult(Result result) {
        this.result = result;
    }



    public String getReason() {
        return reason;
    }

}
