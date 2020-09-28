package com.itheima.service.imp;

import com.itheima.service.IAccountService;

import java.util.Date;


public class AccountServiceImp2 implements IAccountService {


    //如果是经常变化的数据并不适用于注入的方式
    private String name;
    private Integer age;
    private Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void saveAccount() {
        System.out.println("service中的saveAccount执行了"
        +"name:"+name+"age:"+age+"birthady:"+birthday);
    }

}
