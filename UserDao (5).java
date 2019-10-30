package com.neuedu.dao;

public interface UserDao {
   // 查询用户名密码
    boolean queryUserByNameAndPsw(String username, String password);
}
