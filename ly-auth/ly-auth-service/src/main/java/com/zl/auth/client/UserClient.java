package com.zl.auth.client;

import com.zl.api.UserApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * Copyright (C)，XX
 * FileName: UserClient
 * Author: zl
 * Date: 2019/8/5  20:39
 * Description:
 **/
@FeignClient("user-service")
public interface UserClient extends UserApi {

}
