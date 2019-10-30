package com.neuedu.dao;

import com.neuedu.entity.Subject;
import com.neuedu.entity.User;

import java.util.List;

public interface SubDao {

    // 添加面试题
    Integer addOneSubject(Subject subject);
    // 查询面试题
    List<Subject> querySubjectByStatusAndUserId(User user);
    // 根据id 查询面试题
    Subject querySubjectById(Integer id);
    //根据id 修改面试题
    int updateSubjectById(Subject subject);
}
