package com.itheima.dao.imp;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 此类用于抽取重复代码
 */
public class JdbcDaoSuport {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
