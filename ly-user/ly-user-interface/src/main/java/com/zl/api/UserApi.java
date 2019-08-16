package com.zl.api;

import com.zl.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Copyright (C)，XX
 * FileName: UserApi
 * Author: zl
 * Date: 2019/8/5  20:26
 * Description:
 **/
public interface UserApi {

    @GetMapping("/query")
    User queryUserByUsernameAndPassword(
            @RequestParam("username") String username,
            @RequestParam("password") String password);



}
