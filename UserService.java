package com.neuedu.service;

import com.neuedu.entity.User;


public interface UserService {
    User login(User user);

    // 注册用户
    boolean registerUser(User user);


}
