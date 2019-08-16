package com.zl.web.controller;

import com.zl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright (C)，XX
 * FileName: UserController
 * Author:zl
 * Date: 2019/8/5  14:30
 * Description:
 **/
@RestController
public class UserController {
    @Autowired
    UserService userService;

    //    GET /check/{data}/{type}
    @GetMapping("/check/{data}/{type}")
    public ResponseEntity<Boolean> checkUser(
            @PathVariable("data") String data, @PathVariable("type") Integer type) {
        return ResponseEntity.ok(userService.checkUser(data,type));
    }
}
