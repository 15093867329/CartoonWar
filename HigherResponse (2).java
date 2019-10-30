package com.neuedu.common;


import lombok.Data;

/**
 * 一切响应的对象
 * */
@Data
public class HigherResponse<T> {

    public HigherResponse(){

    }

    public HigherResponse(Integer status,T data){
        this.data = data;
        this.status = status;
    }

    public HigherResponse(Integer status,String msg){
        this.status = status;
        this.msg = msg;
    }
    // 响应的状态码
    private Integer status;

    // 泛型
    private T data;

    // 返回信息
    private String msg;
}
