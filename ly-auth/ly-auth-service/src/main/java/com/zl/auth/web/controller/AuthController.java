package com.zl.auth.web.controller;

import com.zl.auth.config.JwtProperties;
import com.zl.auth.service.AuthService;
import com.zl.common.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Copyright (C)，XX
 * FileName: AuthController
 * Author:zl
 * Date: 2019/8/5  20:00
 * Description:
 **/
@RestController
public class AuthController {
    @Autowired
    AuthService authService;
    @Autowired
    JwtProperties jwtProperties;
    @PostMapping("login")
    public ResponseEntity<String> login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpServletRequest request,
            HttpServletResponse response){

        String token = authService.login(username,password);
        CookieUtils.newBuilder(response).httpOnly().request(request).build(jwtProperties.getCookieName(),token);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

}
