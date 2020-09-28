package com.itheima.service.imp;

import com.itheima.service.IAccountService;

public class AccountServiceImp implements IAccountService {

    public AccountServiceImp() {
        System.out.println("对象被创建了");
    }

    public void saveAccount() {
        System.out.println("service中的saveAccount执行了");
    }

    public void init(){
        System.out.println("inti..........");
    }


    public void destroy(){
        System.out.println("destroy.........");
    }
}
