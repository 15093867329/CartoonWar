package com.neuedu.service;

import com.neuedu.dao.UserDao;
import com.neuedu.entity.User;
import com.neuedu.utils.SqlSessionFacUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserServiceImpl implements UserService {

private SqlSessionFactory sqlSessionFactory = SqlSessionFacUtil.createSqlSessionFactory();

@Override
public User login(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user1 = mapper.queryUserIsExists(user);
        sqlSession.close();
        return user1;
        }

@Override
public boolean registerUser(User user) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    UserDao mapper = sqlSession.getMapper(UserDao.class);
    boolean b = mapper.registerUser(user);
    sqlSession.commit();
    sqlSession.close();
    return b;
    }


}
