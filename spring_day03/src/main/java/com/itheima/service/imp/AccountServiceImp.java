package com.itheima.service.imp;

import com.itheima.dao.IAccountDao;

import com.itheima.dao.imp.AccountDaoImp;
import com.itheima.service.IAccountService;

public class AccountServiceImp implements IAccountService {
//   private IAccountDao accountDao = new AccountDaoImp();

   public AccountServiceImp(){
       System.out.println("对象被创建了");
   }
    public void saveAccount() {

//        accountDao.saveAccount();
    }


}
