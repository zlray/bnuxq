package com.zl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Copyright (C)，XX
 * FileName: LyRegistry
 * Author: zl
 * Date: 2019/7/26  16:20
 * Description: 启动类
 **/
@EnableEurekaServer
@SpringBootApplication
public class LyRegistryApplication {
    public static void main(String[] args) {
        SpringApplication.run(LyRegistryApplication.class);
    }
}
