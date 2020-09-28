package com.tcp.blood;

public class Blood {

    private double emptyBloodSugar;
    private double workAfterBloodSugar;

    public Blood(double emptyBloodSugar, double workAfterBloodSugar) {
        this.emptyBloodSugar = emptyBloodSugar;
        this.workAfterBloodSugar = workAfterBloodSugar;
    }

    public String getResult(){
        if (emptyBloodSugar<=6.1 && workAfterBloodSugar<7.8)
            return "正常血糖( NGR)";
        else if (emptyBloodSugar>=6.1&&emptyBloodSugar<7.0 && workAfterBloodSugar<7.8)
            return "空腹血糖受损( IFG)";
        else if (emptyBloodSugar<7.0&&workAfterBloodSugar>=7.8&&workAfterBloodSugar<11.1)
            return "糖耐量减低(IGT)";
        else if (emptyBloodSugar>7.0&&workAfterBloodSugar>11.1)
            return "糖尿病( DM)";
        else return "数据异常";
    }

}
