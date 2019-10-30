package com.neuedu.dao;

import com.neuedu.entity.User;

public interface UserDao {
    User queryUserIsExists(User user);

    // 添加用户
    boolean registerUser(User user);

    // 添加用户
    Integer register(User user);
}
