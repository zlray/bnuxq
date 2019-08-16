package main.com.zl.service;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.zl.common.enums.ExceptionEnums;
import com.zl.common.exception.LyException;
import main.com.zl.config.UploadProperties;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;

/**
 * Copyright (C)，XX
 * FileName: UploadService
 * Author: zl
 * Date: 2019/7/31  9:50
 * Description: 上传的service
 **/
@Service
@EnableConfigurationProperties(UploadProperties.class)
public class UploadService {
    @Autowired
    FastFileStorageClient storageClient;

    @Autowired
    private UploadProperties uploadProperties;

    //支持的文件类型

    private static final List<String> suffixes = Arrays.asList("image/png", "image/jpeg");


    public String uploadImage(MultipartFile multipartFile) {
        try {
            //校验文件类型
            String type = multipartFile.getContentType();
            if (!uploadProperties.getAllowTypes().contains(type)) {
                throw new LyException(ExceptionEnums.FILE_TYPE_NOT_MATCH);
            }
            //校验文件的内容
            BufferedImage image = ImageIO.read(multipartFile.getInputStream());
            if (image == null) {
                throw new LyException(ExceptionEnums.FILE_TYPE_NOT_MATCH);
            }

            //文件后缀名 如 png等
//            String extension = multipartFile.getOriginalFilename().substring(
//                    multipartFile.getOriginalFilename().lastIndexOf(".") + 1
//            );
            String extension = StringUtils.substringAfterLast(multipartFile.getOriginalFilename(),".");
            StorePath storePath = storageClient.uploadFile(multipartFile.getInputStream(), multipartFile.getSize(), extension, null);
            return uploadProperties.getBaseUrl() + storePath.getFullPath();

        } catch (Exception e) {
            //上传失败
            throw new LyException(ExceptionEnums.FILE_UPLOAD_ERROR);
        }
    }
}
