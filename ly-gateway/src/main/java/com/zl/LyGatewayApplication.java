package com.zl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Copyright (C)，XX
 * FileName: LyGatewayApplication
 * Author: zl
 * Date: 2019/7/26  16:39
 * Description: zuul的启动类
 **/

@EnableZuulProxy
@SpringBootApplication
public class LyGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(LyGatewayApplication.class);

    }
}
