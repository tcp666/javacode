package com.itheima.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        //数据源：spring内置数据源

        DriverManagerDataSource ds=new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/facetoface_db?serverTimezone=UTC");
        ds.setUsername("root");
        ds.setPassword("tcp666");
        JdbcTemplate jt=new JdbcTemplate();
        jt.setDataSource(ds);
        jt.execute("insert  into account (name,money) values ('jdb',1000)");
    }
}
