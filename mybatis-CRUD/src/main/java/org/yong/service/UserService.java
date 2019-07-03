package org.yong.service;



import org.yong.pojo.PageBean;
import org.yong.pojo.User;

import java.util.List;

/**
 * 用户管理的业务接口
 */
public interface UserService {
    /**
     * 查询所有用户信息
     * @return
     */
     List<User> findAll();

    /**
     * 查询用户账号信息
     * @return
     */
    User find(String username, String password);

    Integer insert(User user);

    Integer deleteById(Integer id);

    User findById(String id);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    Integer update(User user);

    void delSelect(String[] ids);

    /**
     * 分页查询
     * @param currentPage
     * @param rows
     * @return
     */
    PageBean<User> findUserByPage(String currentPage, String rows);

}
