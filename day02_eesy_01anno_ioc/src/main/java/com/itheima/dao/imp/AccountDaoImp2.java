package com.itheima.dao.imp;

import com.itheima.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * 账户持久层实现类
 *
 */
@Repository("accountDao2")
public class AccountDaoImp2 implements IAccountDao {
    int i=0;
    public void saveAccount() {
        System.out.println("222222222222222222222");
        System.out.println(i);
        i++;
    }
}
