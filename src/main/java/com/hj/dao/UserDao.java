package com.hj.dao;

/**
 * @author Love-hj
 * @date 2020/3/24 - 9:53
 */

import com.hj.domain.QueryVo;
import com.hj.domain.User;

import java.util.List;

/**
 * 用户的持久层接口
 */
public interface UserDao {

    /**
     * 查询所有操作
     * @return
     */
    List<User> findAll();

    /**
     *  保存用户
     * @param user
     */
    void saveUser(User user);

    /**
     *  更新用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除用户操作
     * @param id
     */
    void deleteUser(Integer id);

    /**
     * 通过id查询单个数据
     * @param id
     */
    User selectSingleUser(Integer id);

    /**
     * 通过名称进行查询
     * @param name
     * @return
     */
    List<User> selectNameUser(String name);

    /**
     * 查找总的用户数
     * @return
     */
    int selectTotalUser();

    /**
     * 通过queryvo进行查找
     * @param vo
     * @return
     */
    List<User> selectQueryVoUser(QueryVo vo);

    /**
     * 通过queryvo进行查找
     * @param vo
     * @return
     */
    List<User> selectQueryVoIdUser(QueryVo vo);
}
