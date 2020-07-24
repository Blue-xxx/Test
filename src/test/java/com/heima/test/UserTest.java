package com.heima.test;

import com.heima.dao.Account;
import com.heima.dao.AccountUser;
import com.heima.dao.User;
import com.heima.mapper.IAccountDao;
import com.heima.mapper.UserDao;
import com.sun.org.apache.bcel.internal.generic.IADD;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserTest {
    private SqlSessionFactory sql;
    private InputStream in;
    private UserDao userDao;
    private SqlSession sqlSession;
    @Before
    public void init()throws IOException {
        //InputStream in = Test.class.getClassLoader().getResourceAsStream("sqlmap_config.xml");
        in = Resources.getResourceAsStream("sqlmap_config.xml");
        sql = new SqlSessionFactoryBuilder().build(in);
        sqlSession = sql.openSession();
        userDao = sqlSession.getMapper(UserDao.class);

    }
    @After
    public void destroy() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }
    @Test
    public void testseleceAll(){
        List<User> users =userDao.findAll();
        for (User user:users){
            System.out.println(user);
            System.out.println(user.getAccount());
        }

    }
}
