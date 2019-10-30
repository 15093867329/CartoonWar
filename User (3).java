package com.neuedu.entity;


import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Data
public class User {

    public User(){

    }

    public User(Integer id, String phone, String password, String nickname, String realName, String role, String iconurl, Integer regDate, Date updateDate) {
        this.id = id;
        this.phone = phone;
        this.password = password;
        this.nickname = nickname;
        this.realName = realName;
        this.role = role;
        this.iconurl = iconurl;
        this.regDate = regDate;
        this.updateDate = updateDate;
    }

    private Integer id;

    private String phone;

    private String password;

    private String nickname;

    private String realName;

    private String role;

    private String iconurl;

    private Integer regDate;

    private Date updateDate;

}