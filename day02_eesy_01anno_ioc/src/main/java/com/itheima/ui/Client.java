package com.itheima.ui;



import com.itheima.service.IAccountService;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as =(IAccountService)
                ac.getBean("accountService");
//
//        System.out.println(as);
//        IAccountDao adao= (AccountDaoImp)ac.getBean("accountDao",IAccountDao.class);
//        adao.saveAccount();
        IAccountService as1 =(IAccountService)
                ac.getBean("accountService");
        System.out.println(as==as1);
        as.saveAccount();
        ac.close();

    }

}
