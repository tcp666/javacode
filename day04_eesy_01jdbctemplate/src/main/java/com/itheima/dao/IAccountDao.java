package com.itheima.dao;

import com.itheima.domain.Account;

/**
 * 账户的持久蹭接口
 */
public interface IAccountDao {
    /**
     * 根据Id查询
     * @param accountId
     * @return
     */
    Account findById(Integer accountId);

    /**
     * 根据名称差
     * @param accountName
     * @return
     */
    Account findByName(String accountName);

    /**
     * 更新账户
     * @param account
     */
    void updateAccount(Account account);
}
