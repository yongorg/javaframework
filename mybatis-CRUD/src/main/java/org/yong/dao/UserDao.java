package org.yong.dao;


import org.yong.pojo.User;

import java.util.List;

/**
 * 用户操作的dao
 */
public interface UserDao {

    List<User> findAll();

    /**
     * 根据用户名密码查询用户信息
     */
    User find(String username, String password);

    Integer insert(User user);

    Integer deleteById(Integer id);

    User findById(Integer id);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    Integer update(User user);

    /**
     * 查询总记录数
     * @return
     */
    int findTotalCount();

    /**
     * 分页查询
     * @param start
     * @param rows
     * @return
     */
    List<User> findByPage(int start, int rows);
}
