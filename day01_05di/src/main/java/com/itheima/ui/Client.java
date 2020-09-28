package com.itheima.ui;


import com.itheima.service.IAccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {


    public static void main(String[] args) {

        ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
//        IAccountService as= (IAccountService) ac.getBean("accountService");
//
//        as.saveAccount();
//        IAccountService as= (IAccountService) ac.getBean("accountService2");
        IAccountService as= (IAccountService) ac.getBean("accountService3");
        as.saveAccount();



    }

}
