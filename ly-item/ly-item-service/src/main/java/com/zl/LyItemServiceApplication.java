package com.zl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Copyright (C)，XX
 * FileName: LyItemServiceApplication
 * Author: zl
 * Date: 2019/7/26  17:04
 * Description: ly item service 的启动类
 **/
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.zl.mapper")
public class LyItemServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(LyItemServiceApplication.class,args);
    }
}
