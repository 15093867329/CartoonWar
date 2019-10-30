package com.neuedu.test;

import com.neuedu.dao.UserDao;
import com.neuedu.entity.User;
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

public class TestDemo {

    SqlSessionFactory sqlSessionFactory = null;
    @Before
    public void before(){
        String resource = "SqlMapConifg.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void test(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //String String.class
        //public class String
        // public class Class
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> allUser = mapper.getAllUser();
        System.out.println(allUser);
    }

    @After
    public void after(){
        System.out.println("after");
    }
}
