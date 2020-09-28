package com.itheima.dao;

import com.itheima.domain.Account;

import java.util.List;

/**
 * 账户的持久层接口
 */
public interface IAccountDao {


        /**
         * 查寻所有
         * @return
         */
        List<Account> findAllaccount();

        /**
         * 按id查找
         * @param accountId
         * @return
         */
        Account findAccountById(Integer accountId);

        /**
         * 保存
         * @param account
         */
        void saveAccount(Account account);

        /**
         * 更新
         * @param account
         */
        void updateAccount(Account account);

        /**
         * 删除
         * @param accountId
         */
        void deleteAccount(Integer accountId);


    }
