package com.tcp.datedemo;

import java.util.LinkedList;
import java.util.List;

public class DateTools {
    public String getNextDay(int year,int month,int day){
        int td=day;
        int ty=year;
        int tm=month;
        if (year%4==0&&year%400!=0){
            if (month==12){
                if (day==31){
                    tm=1;
                    td=1;
                    ty++;
                }
                else if (day<31){
                    td++;
                }
            }
           else if (month%2==1||month==8||month==10){
                if (day==31){
                    td=1;
                    tm++;
                }
                else if (day<31){
                    td++;
                }

            }
            else if (month%2==0&&month!=2){
                if (day==30){
                    tm++;
                    td=1;
                }
                else if (day<30){
                    td++;
                }
            }
            else if (month==2){
                if (day==29){
                    tm++;
                    td=1;
                }
                else if (day<29){
                    td++;
                }
            }
        }
        else if (year%4!=0||year%400==0){
            if (month==12){
                if (day==31){
                    tm=1;
                    td=1;
                    ty++;
                }
                else if (day<31){
                    td++;
                }
            }
            if (month%2==1||month==8||month==10){
                if (day==31){
                    td=1;
                    tm++;
                }
                else if (day<31){
                    td++;
                }

            }
            else if (month%2==0&&month!=2){
                if (day==30){
                    tm++;
                    td=1;
                }
                else if (day<30){
                    td++;
                }
            }
            else if (month==2){
                if (day==28){
                    tm++;
                    td=1;
                }
                else if (day<28){
                    td++;
                }
            }
        }
       return ty+":"+tm+":"+td;
    }



    public static void main(String[] args) {
        List<String>  nextTestResult=new LinkedList<String>();
        nextTestResult.add(new DateTools().getNextDay(1925,7,15));
        nextTestResult.add(new DateTools().getNextDay(1925,6,15));
        nextTestResult.add(new DateTools().getNextDay(1925,2,14));
        nextTestResult.add(new DateTools().getNextDay(1925,7,14));
        nextTestResult.add(new DateTools().getNextDay(1925,12,31));

        for (String x:nextTestResult){
            System.out.println(x);
        }
    }
}
