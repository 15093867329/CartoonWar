package com.neuedu.service;

import com.github.pagehelper.PageInfo;
import com.neuedu.entity.Subject;
import com.neuedu.entity.User;

import java.util.List;

public interface SubService {

    // 添加面试题
   Integer addOneSubject(Subject subject);

    // 查询面试题
    PageInfo querySubjectByPage(User user,Integer pageNum, Integer pageSize);

    // 根据id查询面试题
    Subject querySubjectById(Integer id);
    //根据id 修改面试题
    boolean updateSubjectById(Subject subject);
}
