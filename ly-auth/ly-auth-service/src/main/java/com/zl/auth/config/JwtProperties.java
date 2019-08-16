package com.zl.auth.config;

import com.zl.utils.RsaUtils;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;
import java.io.File;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * Copyright (C)，XX
 * FileName: JwtProperties
 * Author: zl
 * Date: 2019/8/5  19:47
 * Description: jwt的属性配置类
 **/
@Data
@ConfigurationProperties(prefix = "ly.jwt")
public class JwtProperties {

    private String secret;
    private String pubKeyPath;
    private String priKeyPath;
    private int expire;
    private String cookieName;

    private PrivateKey privateKey;
    private PublicKey publicKey;

    @PostConstruct
    public void init(){
        try {
            //首先判断公钥私钥是否存在，不存在则先生成公钥私钥
            File pubKey = new File(pubKeyPath);
            File priKey = new File(priKeyPath);

            if (!pubKey.exists() || !priKey.exists()) {
                //创建公钥，私钥
                RsaUtils.generateKey(pubKeyPath, priKeyPath, secret);
            }
            //公钥私钥都存在
            this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
            this.privateKey = RsaUtils.getPrivateKey(priKeyPath);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

}
