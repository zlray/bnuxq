package com.zl.common.advice;

import com.zl.common.enums.ExceptionEnums;
import com.zl.common.exception.LyException;
import com.zl.common.response.Response;
import com.zl.common.vo.ExceptionResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Copyright (C)，XX
 * FileName: CommonExceptionHandler
 * Author: zl
 * Date: 2019/7/28  15:08
 * Description: 通用的异常通知
 **/
@ControllerAdvice
public class CommonExceptionHandler  {

//    @ExceptionHandler(LyException.class)
//    public ResponseEntity<ExceptionResult> handlerException(LyException e) {
//
//        ExceptionEnums exceptionEnums = e.getExceptionEnums();
//
//        return ResponseEntity.status(exceptionEnums.getCode())
//
//                .body(new ExceptionResult(e.getExceptionEnums()));
//    }

    @ExceptionHandler(LyException.class)
    @ResponseBody
    public Response handleStudentException(HttpServletRequest request, LyException ex) {
        Response response;
        response = new Response(ex.getExceptionEnums().getCode(),ex.getExceptionEnums().getMsg());
        return response;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Response handleException(HttpServletRequest request, Exception ex) {
        Response response;
        response = new Response(ExceptionEnums.Network_error.getCode(),
                ExceptionEnums.Network_error.getMsg());
        return response;
    }

}