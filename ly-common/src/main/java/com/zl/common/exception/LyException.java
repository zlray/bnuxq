package com.zl.common.exception;

import com.zl.common.enums.ExceptionEnums;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Copyright (C)，XX
 * FileName: LyException
 * Author: zl
 * Date: 2019/7/28  15:25
 * Description: ly的异常
 **/
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LyException extends RuntimeException {

    private ExceptionEnums exceptionEnums;

}
