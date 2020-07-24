package com.heima.test;

import com.heima.dao.Account;
import com.heima.dao.AccountUser;
import com.heima.mapper.IAccountDao;
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

public class AccountTest {
    private SqlSessionFactory sql;
    private InputStream in;
    private IAccountDao accountDao;
    private SqlSession sqlSession;
    @Before
    public void init()throws IOException {
        //InputStream in = Test.class.getClassLoader().getResourceAsStream("sqlmap_config.xml");
        in = Resources.getResourceAsStream("sqlmap_config.xml");
        sql = new SqlSessionFactoryBuilder().build(in);
        sqlSession = sql.openSession();
        accountDao = sqlSession.getMapper(IAccountDao.class);

    }
    @After
    public void destroy() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }
    @Test
    public void testfindAll(){
        List<Account> accounts = accountDao.findAll();
        for (Account account:accounts){
            System.out.println("********每个账户信息*********");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }
    @Test
    public void testfindAllAccountUser(){
        List<AccountUser> au = accountDao.findAllAccount();
        for (AccountUser aus:au){
            System.out.println(aus);
        }
    }
}
