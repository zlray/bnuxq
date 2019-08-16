package main.com.zl.web.controller;

import main.com.zl.service.UploadService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Copyright (C)，XX
 * FileName: UploadController
 * Author: zl
 * Date: 2019/7/31  9:47
 * Description: 上传的controller
 **/
@RestController
@RequestMapping("upload")
public class UploadController {

    @Autowired
    UploadService uploadService;

    /**
     * @param multipartFile
     * @return
     */
    @PostMapping("image")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile multipartFile) {

        String url = uploadService.uploadImage(multipartFile);
        if (StringUtils.isBlank(url)) {
            // url为空，证明上传失败
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        // 返回200，并且携带url路径
        return ResponseEntity.ok(url);
    }

}
