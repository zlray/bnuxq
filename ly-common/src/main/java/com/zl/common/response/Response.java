package com.zl.common.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.io.Serializable;

/**
 * Copyright (C)，XX
 * FileName: Response
 * Author: zl
 * Date: 2019/8/4  18:30
 * Description: 统一数据返回
 **/
@Data
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class Response<T> implements Serializable {

    //请求成功返回码为：0000
    private static final int successCode = 0000;

    //返回码
    private int code;

    //返回描述
    private String msg;

    //返回数据
    private T data;

    public Response() {
        this.code = successCode;
        this.msg = "请求成功";
    }

    public Response(int code, String msg) {
        this();
        this.code = code;
        this.msg = msg;
    }

    public Response(int code, String msg, T data) {
        this();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Response(T data) {
        this();
        this.data = data;
    }
}
