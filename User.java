package com.neuedu.entity;


import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;
    private String phone;
    private String password;
    private String nickname;
    private String realName;
    private Integer role;
    private String iconurl;
    private Date regDate;
    private Date updateDate;
    public User(){

    }

    public User(Integer id, String phone, String password, String nickname, String realName, Integer role, String iconurl, Date regDate, Date updateDate) {
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
}
