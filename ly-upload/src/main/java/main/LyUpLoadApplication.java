package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Copyright (C)，XX
 * FileName: LyUpLoad
 * Author: zl
 * Date: 2019/7/31  9:32
 * Description: 启动类
 **/
@EnableEurekaClient
@SpringBootApplication
public class LyUpLoadApplication {

    public static void main(String[] args) {
        SpringApplication.run(LyUpLoadApplication.class);
    }

}
