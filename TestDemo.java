package com.neuedu.test;

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
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        User o = (User)sqlSession.selectOne("com.neuedu.mapper.select", 1);
//        System.out.println(o);
//        List<User> users = sqlSession.selectList("com.neuedu.mapper.selectAllUser");
//        System.out.println(users);


//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        List<Object> objects = sqlSession.selectList("com.neuedu.mapper.selectUserByName", "三");
//        System.out.println(objects);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User(null, "张四", "123456", "123456@qq.com", "123456", "你的家乡在哪", "在东北",  null, null);
        int num = sqlSession.insert("com.neuedu.mapper.addOneUser",user);
        System.out.println(num);

    }

    @After
    public void after(){
        System.out.println("after");

    }
}
