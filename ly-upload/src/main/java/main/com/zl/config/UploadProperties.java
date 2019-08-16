package main.com.zl.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import java.util.List;

/**
 * Copyright (C)，XX
 * FileName: UploadProperties
 * Author: zl
 * Date: 2019/8/1  18:31
 * Description: 上传的属性
 **/
@Data
@ConfigurationProperties(prefix = "ly.upload")
public class UploadProperties {

    private String baseUrl;
    private List<String> allowTypes;
}
