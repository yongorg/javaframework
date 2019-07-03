package org.yong.service.impl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.yong.dao.UserDao;
import org.yong.pojo.PageBean;
import org.yong.pojo.User;
import org.yong.service.UserService;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserServiceImpl implements UserService {

    private static Logger logger = Logger.getLogger(UserServiceImpl.class);

    private static SqlSession sqlSession;

    static {
        // 1. 创建MyBatis核心配置文件到流中
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 2. 创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        // 3. 使用SqlSessionFactoryBuilder的build方法创建SqlSessionFactory
        SqlSessionFactory sf = sfb.build(is);
        // 4. 创建SqlSession对象，用于执行Sql语句
        sqlSession = sf.openSession();
    }

    public static SqlSession getSqlSession() {
        return sqlSession;
    }



    @Override
    public List<User> findAll() {
        List<User> list = getSqlSession().getMapper(UserDao.class).findAll();
        logger.info("UserService-->findAll-->msg："+list);
        return list;
    }

    @Override
    public User find(String username, String password) {
        return null;
    }

    @Override
    public Integer insert(User user) {
        Integer insert = sqlSession.getMapper(UserDao.class).insert(user);
        sqlSession.commit();
        return insert;
    }

    @Override
    public Integer deleteById(Integer id) {
        Integer insert = sqlSession.getMapper(UserDao.class).deleteById(id);

        sqlSession.commit();
        return insert;
    }

    @Override
    public User findById(String id) {
        return sqlSession.getMapper(UserDao.class).findById(Integer.parseInt(id));
    }

    @Override
    public Integer update(User user) {

        logger.info(user);

        Integer update = sqlSession.getMapper(UserDao.class).update(user);

        sqlSession.commit();
        return update;
    }

    @Override
    public void delSelect(String[] ids) {

    }

    @Override
    public PageBean<User> findUserByPage(String currentPage, String rows) {
        return null;
    }
}
