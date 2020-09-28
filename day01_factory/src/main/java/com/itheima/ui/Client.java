package com.itheima.ui;

import com.itheima.factory.BeanFactory;
import com.itheima.service.IAccountService;

/**主动创建对象：
 *  IAccountService as=new AccountServiceImp();
 * 工厂模式创建对象：
 * IAccountService as= (IAccountService) BeanFactory.getBean("accountService");
 * 模拟表现
 * 多例对象
 * com.itheima.service.imp.AccountServiceImp@74a14482
 * com.itheima.service.imp.AccountServiceImp@1540e19d
 * com.itheima.service.imp.AccountServiceImp@677327b6
 * com.itheima.service.imp.AccountServiceImp@14ae5a5
 * com.itheima.service.imp.AccountServiceImp@7f31245a
 */
public class Client {
    public static void main(String[] args) {
//        IAccountService as=new AccountServiceImp();
//        IAccountService as= (IAccountService) BeanFactory.getBean("accountService");
        //as.saveAccount();
        for (int i=0;i<5;i++){
            IAccountService  as= (IAccountService) BeanFactory.getBean("accountService");
            System.out.println(as);
            as.saveAccount();
        }
    }

}
