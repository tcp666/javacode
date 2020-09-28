package com.itheima.factory;

import com.itheima.service.IAccountService;
import com.itheima.service.imp.AccountServiceImp;

/**
 * 模拟工厂
 *
 */
public class InstanceFactory {
    public IAccountService getAccountservice(){
        return new AccountServiceImp();
    }
}
