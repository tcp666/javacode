package com.itheima.jdbctemplate;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateDemo4 {
    public static void main(String[] args) {

        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");

        IAccountDao accountDao=ac.getBean("accountDao",IAccountDao.class);

        System.out.println(  accountDao.findById(1));
        System.out.println(accountDao.findByName("aaa"));






    }
}
