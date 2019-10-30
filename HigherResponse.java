package com.neuedu.common;

import lombok.Data;

@Data
public class HigherResponse<T> {

    private Integer status;
    private T data;
    private String msg;
    public HigherResponse(){

    }
    public HigherResponse(Integer status, T data){
        this.status=status;
        this.data=data;
    }
    public HigherResponse(Integer status, String msg){
        this.status=status;
        this.msg=msg;
    }
}
