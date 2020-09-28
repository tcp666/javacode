package com.tcp.datedemo;

import java.util.LinkedList;
import java.util.List;

public class DateTools1 {
    public String getNextDay(int year,int month,int day){
     if (month>12||month<1)
         return "月份输入有误";
     if ((month==2&&year%4==0&&year%400!=0)&day>29)
         return "今年二月只有29天！";

     if (year%4!=0||year%400==0){
         if (month==2&&day>28){
             return "今年二月只有28天！";
         }
     }
        int td=day;
        int ty=year;
        int tm=month;
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
      else if (month==2&&year%4==0&&year%400!=0){
        if (day==29){
            tm++;
            td=1;
        }
        else if (day<29){
            td++;
        }
    }
      else if (month==2&&year%4!=0||year%400==0){
          if (day==28){
              tm++;
              td=1;
          }
          else if (day<28){
              td++;
          }
      }

        return ty+":"+tm+":"+td;
    }


    public static void main(String[] args) {
        List<String> nextTestResult=new LinkedList<String>();
        nextTestResult.add(new DateTools1().getNextDay(1925,7,15));
        nextTestResult.add(new DateTools1().getNextDay(1925,6,15));
        nextTestResult.add(new DateTools1().getNextDay(1925,2,28));
        nextTestResult.add(new DateTools1().getNextDay(1925,7,14));
        nextTestResult.add(new DateTools1().getNextDay(1925,12,31));
        nextTestResult.add(new DateTools1().getNextDay(2000,2,28));
        nextTestResult.add(new DateTools1().getNextDay(2004,2,28));
        for (String x:nextTestResult){
            System.out.println(x);
        }
    }
}
