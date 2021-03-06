package com.itheima.dao.imp;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AccountImpl extends JdbcDaoSuport implements IAccountDao {



    public Account findById(Integer accountId) {
    List<Account> accounts=super.getJdbcTemplate().query("select * from account where id = ?",new BeanPropertyRowMapper<Account>(Account.class),accountId);
    return accounts.isEmpty()?null:accounts.get(0);
    }

    public Account findByName(String accountName) {
        List<Account> accounts=super.getJdbcTemplate().query("select * from account where name = ?",new BeanPropertyRowMapper<Account>(Account.class),accountName);
        if (accounts.isEmpty())
            return null;
        if (accounts.size()>1)
            throw new RuntimeException("结果集不唯一");
        return accounts.get(0);
    }

    public void updateAccount(Account account) {
        super.getJdbcTemplate().update("update  set name = ? ,money=? where id= ?",account.getName(),account.getMoney(),account.getId());
    }
}
