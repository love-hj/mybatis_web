package com.hj.dao;

import com.hj.domain.Role;

import java.util.List;

/**
 * @author Love-hj
 * @date 2020/3/26 - 15:52
 */
public interface RoleDao {

    /**
     * 查找所用角色
     * @return
     */
    List<Role> findAll();
}
