package com.itheima.factory;

import com.itheima.service.IAccountService;
import com.itheima.service.imp.AccountServiceImp;

public class StaticFactory {
    public static IAccountService getAccountservice(){
        return new AccountServiceImp();
    }
}
