package com.zl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Copyright (C)，XX
 * FileName: com.zl.LyUserApplication
 * Author: zl
 * Date: 2019/8/4  20:13
 * Description: user的启动类
 **/
@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.zl.mapper")
public class LyUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(LyUserApplication.class);
    }
}
