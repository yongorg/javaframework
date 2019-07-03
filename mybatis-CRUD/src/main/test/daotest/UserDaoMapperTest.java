package daotest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.yong.dao.UserDao;
import org.yong.pojo.User;

import java.io.IOException;
import java.io.InputStream;

public class UserDaoMapperTest {
    private Logger logger = Logger.getLogger(UserDaoMapperTest.class);
    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
            SqlSessionFactory sf = sfb.build(is);
            sqlSession = sf.openSession();


            User user = User.builder().age(18).address("湖南").gender("男").id(2).email("143505654@163.com").qq("1565615616").build();
            // 5.2 使用getMapper方法查询
            int count = sqlSession.getMapper(UserDao.class).update(user);

            sqlSession.commit();
            System.out.println(count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
