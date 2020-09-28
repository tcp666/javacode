package com.itheima.jdbctemplate;

import com.itheima.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcTemplateDemo3 {
    public static void main(String[] args) {

        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");

        JdbcTemplate jt=ac.getBean("jdbcTemplate",JdbcTemplate.class);

//        jt.execute("insert  into account (name,money) values ('zjh',1000)");
        List<Account> accounts=jt.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));

        for (Account account:accounts)
            System.out.println(account);


    
    }
}
