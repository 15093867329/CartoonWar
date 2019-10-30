package com.neuedu.dao;

import com.neuedu.entity.User;

import java.util.List;

public interface UserDao {

    //查询用户
    List<User> getAllUser();

    // 判断用户名和密码是否存在
    User queryUserIsExists(User user);


}