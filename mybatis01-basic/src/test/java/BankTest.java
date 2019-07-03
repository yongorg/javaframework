import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.yong.dao.BankUserDao;
import org.yong.pojo.BankUser;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 非集成环境下的最佳实践：
 */
public class BankTest {
    private Logger logger = Logger.getLogger(BankTest.class);
    // 1. 创建MyBatis核心配置文件到流中
    private InputStream is;

    {
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 2. 创建SqlSessionFactoryBuilder对象
    private SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
    // 3. 使用SqlSessionFactoryBuilder的build方法创建SqlSessionFactory
    private SqlSessionFactory sf = sfb.build(is);
    // 4. 创建SqlSession对象，用于执行Sql语句
    private SqlSession sqlSession = sf.openSession();

    @Test
    public void test() {
        SqlSession sqlSession = null;
        try {
            // 1. 创建MyBatis核心配置文件到流中
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

            // 2. 创建SqlSessionFactoryBuilder对象
            // 用过即丢，其生命周期只存在于方法体内
            // 可重用其来创建多个SqlSessionFactory
            // 负责构建SqlSessionFactory，并提供多个build方法的重载
            SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();

            // 3. 使用SqlSessionFactoryBuilder的build方法创建SqlSessionFactory
            /*
                SqlSessionFactory是每个MyBatis应用的核心
                作用：创建SqlSession失恋了
                作用域：Application
                生命周期与应用的生命周期相同
                单例：
                    存在于整个应用运行时，并且同时只存在一个对象实例
             */
            SqlSessionFactory sf = sfb.build(is);

            // 4. 创建SqlSession对象，用于执行Sql语句
            /*
                SqlSession
                    包含了执行SQL所需的所有方法
                    对应一次数据库会话，会话结束必须关闭（后期Spring管理，不用自己手动关闭）
                    线程级别，不能共享
                获取方式
                使用方式两种：
                    1. 通过SQLsession实例执行运行映射的SQL语句
                    2. 基于Mapper接口方式
             */
            sqlSession = sf.openSession();

            // 5. 执行sql语句
            // 5.1 使用sqlSession的selectXX方法
            int count;
            count = sqlSession.selectOne("org.yong.dao.BankUserDao.count");
            logger.info("总人数为------" + count);
            // 5.2 使用getMapper方法查询
            count = sqlSession.getMapper(BankUserDao.class).count();
            logger.info("总人数为------" + count);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test02() {
        // 5. 执行sql语句
        List<BankUser> list = sqlSession.getMapper(BankUserDao.class).getList();
        logger.info("银行所有用户信息：" + list);


    }

    @Test
    public void test03() {
        // 5. 执行sql语句
        BankUser bankUser = sqlSession.getMapper(BankUserDao.class).getUserById(1);
        logger.info("银行所有用户信息：" + bankUser);
    }

    /**
     * 用对象传递多个参数
     */
    @Test
    public void test04() {
        // 第一种封装对象，传递多个参数
//        BankUser bk = BankUser.builder().bankId(1).name("罗").build();
//        List<BankUser> bks = sqlSession.getMapper(BankUserDao.class).getUserByName(bk);

        // 第二种注解配置，传递多个参数
        List<BankUser> bks = sqlSession.getMapper(BankUserDao.class).getUserByName(3,"罗");
        logger.info("银行所有用户信息：" + bks);
    }


    @Test
    public void test05() {

        BankUser bankUser = sqlSession.getMapper(BankUserDao.class).getCardByUserId(2);
        logger.info(bankUser);
    }

}
