package com.neuedu.entity;

import javax.xml.crypto.Data;
@lombok.Data
public class Subject {
    public Subject(){

    }

    public Subject(Integer id, String url, String company, String companyAddress, String type, String jobName, Integer userId, Integer level, Data upload_date, Data update_date, Integer status) {
        this.id = id;
        this.url=url;
        this.company = company;
        this.companyAddress = companyAddress;
        this.type = type;
        this.jobName = jobName;
        this.userId = userId;
        this.level = level;
        this.upload_date = upload_date;
        this.update_date = update_date;
        this.status = status;
    }

    private Integer id;
    private String url;
    private String company;
    private String companyAddress;
    private String type;
    private String jobName;
    private Integer userId;
    private Integer level;
    private Data upload_date;
    private Data update_date;
    private Integer status;
}
