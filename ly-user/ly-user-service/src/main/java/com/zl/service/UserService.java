package com.zl.service;

import com.zl.common.enums.ExceptionEnums;
import com.zl.common.exception.LyException;
import com.zl.mapper.UserMapper;
import com.zl.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright (C)，XX
 * FileName: UserService
 * Author: zl
 * Date: 2019/8/5  14:29
 * Description:
 **/
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    //校验数据唯一
    public Boolean checkUser(String data, Integer type) {
        User record = new User();
        switch (type) {
            case 1:
                record.setUsername(data);
                break;
            case 2:
                record.setPhone(data);
                break;
            default:
                throw new LyException(ExceptionEnums.INVALID_USER_DATA_TYP);
        }
        return this.userMapper.selectCount(record) == 0;
    }
}
