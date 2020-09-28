package com.itheima.service.imp;

import com.itheima.dao.IAccountDao;
import com.itheima.dao.imp.AccountDaoImp;
import com.itheima.factory.BeanFactory;
import com.itheima.service.IAccountService;

public class AccountServiceImp implements IAccountService {
//    private IAccountDao accountDao = new AccountDaoImp();
private IAccountDao accountDao=(IAccountDao) BeanFactory.getBean("accountDao");
    public void saveAccount() {

        accountDao.saveAccount();
    }


}
