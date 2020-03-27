package com.hj.dao;

/**
 * @author Love-hj
 * @date 2020/3/26 - 10:30
 */

import com.hj.domain.Account;

import java.util.List;

/**
 * 账户持久层接口
 */
public interface AccountDao {

    /**
     * 查询所有账户信息
     * @return
     */
    List<Account> findAll();

}
