package com.neuedu.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neuedu.dao.SubDao;
import com.neuedu.entity.Subject;
import com.neuedu.entity.User;
import com.neuedu.utils.SqlSessionFacUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class SubServiceImpl implements SubService {
    private SqlSessionFactory sqlSessionFactory = SqlSessionFacUtil.createSqlSessionFactory();

    @Override
    public Integer addOneSubject(Subject subject) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        SubDao mapper = sqlSession.getMapper(SubDao.class);
        Integer integer = mapper.addOneSubject(subject);
        sqlSession.commit();
        sqlSession.close();
        return integer;
    }

    @Override
    public PageInfo querySubjectByPage(User user, Integer pageNum, Integer pageSize) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        SubDao mapper = sqlSession.getMapper(SubDao.class);
        // 开始分页
        PageHelper.startPage(pageNum,pageSize);
        List<Subject> subjects = mapper.querySubjectByStatusAndUserId(user);
        PageInfo<Subject> subjectPageInfo = new PageInfo<>(subjects);
        sqlSession.commit();
        sqlSession.close();
        return subjectPageInfo;
    }

    @Override
    public Subject querySubjectById(Integer id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        SubDao mapper = sqlSession.getMapper(SubDao.class);
        Subject subject = mapper.querySubjectById(id);
        sqlSession.commit();
        sqlSession.close();
        return subject;
    }

    @Override
    public boolean updateSubjectById(Subject subject) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        SubDao mapper = sqlSession.getMapper(SubDao.class);
        int i = mapper.updateSubjectById(subject);
        System.out.println("ssssssssssssssss"+i);
        sqlSession.commit();
        sqlSession.close();
        if (i>0){
            return true;
        }
        return false;
    }


}
