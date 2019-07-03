package org.yong.dao;

import org.apache.ibatis.annotations.Param;
import org.yong.pojo.BankUser;

import java.util.List;

/**
 *
 * 银行用户类DAO接口
 * @author yongzi
 */
public interface BankUserDao {

    /**
     *  查询用户总数
     */
    public Integer count();

    /**
     * 查询所有信息
     * @return
     */
    public List<BankUser> getList();

    /**
     * 根据用户id查询用户信息
     */
    public BankUser getUserById(int uid);

    /**
     * 第一种：
     *      传递多个参数 将参数封装成对象传递
     * @param bankUser
     * @return
     */
//    public List<BankUser> getUserByName(BankUser bankUser);

    /**
     * 第二种：
     *      传递多个参数 将参数封装成对象传递
     */
    public List<BankUser> getUserByName(@Param("bankId") Integer bankid, @Param("name") String name);

    /**
     * 根据用户ID查询指定用户的所有银行卡类型
     */
    public BankUser getCardByUserId(int id);
}
