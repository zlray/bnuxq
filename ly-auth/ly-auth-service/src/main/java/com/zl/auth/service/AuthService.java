package com.zl.auth.service;

import com.zl.auth.client.UserClient;
import com.zl.auth.config.JwtProperties;
import com.zl.common.enums.ExceptionEnums;
import com.zl.common.exception.LyException;
import com.zl.entity.UserInfo;
import com.zl.pojo.User;
import com.zl.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Copyright (C)，XX
 * FileName: AuthService
 * Author: zl
 * Date: 2019/8/5  20:02
 * Description:
 **/
@Service
public class AuthService {

    @Autowired
    UserClient userClient;

    @Autowired
    private JwtProperties jwtProperties;

    public String login(String username, String password) {
        //校验用户名和密码

        User user = userClient.queryUserByUsernameAndPassword(username,password);
        //
        if (user==null){
            throw new LyException(ExceptionEnums.INVALID_USERNAME_PASSWORD);
        }
        String token = JwtUtils.generateToken(
                new UserInfo(user.getId(),username),
                jwtProperties.getPrivateKey(),jwtProperties.getExpire());

        return null;
    }
}
