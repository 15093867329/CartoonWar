package com.neuedu.server.entity;
/*
* 用户实体类
* */
public class User {

    public User(){

    }

    public User(String userid, Integer userage, String username, String userbir) {
        this.userid = userid;
        this.userage = userage;
        this.username = username;
        this.userbir = userbir;
    }


    @Override
    public String toString() {
        return "User{" +
                "userid='" + userid + '\'' +
                ", userage=" + userage +
                ", username='" + username + '\'' +
                ", userbir='" + userbir + '\'' +
                '}';
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Integer getUserage() {
        return userage;
    }

    public void setUserage(Integer userage) {
        this.userage = userage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserbir() {
        return userbir;
    }

    public void setUserbir(String userbir) {
        this.userbir = userbir;
    }

    private String userid;

    private Integer userage;

    private String username;

    private String userbir;

}
