package com.itheima.dao.imp;

import com.itheima.dao.IAccountDao;

public class AccountDaoImp implements IAccountDao {
    int i=0;
    public void saveAccount() {
        System.out.println("保存了账户");
        System.out.println(i);
        i++;
    }
}
