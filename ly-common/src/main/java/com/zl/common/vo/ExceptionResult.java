package com.zl.common.vo;

import com.zl.common.enums.ExceptionEnums;
import lombok.Data;

/**
 * Copyright (C)，XX
 * FileName: ExceptionResult
 * Author: zl
 * Date: 2019/7/28  15:40
 * Description: 异常的结果
 **/
@Data
public class ExceptionResult {
    private int status;
    private String msg;
    private long timestamp;

    public ExceptionResult(ExceptionEnums exceptionEnums) {
        this.status = exceptionEnums.getCode();
        this.msg = exceptionEnums.getMsg();
        this.timestamp = System.currentTimeMillis();
    }
}
