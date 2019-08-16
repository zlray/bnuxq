package com.zl.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Copyright (C)，XX
 * FileName: ExceptionEnums
 * Author: zl
 * Date: 2019/7/28  15:19
 * Description: 异常的枚举类
 **/

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ExceptionEnums {
    INVALID_USERNAME_PASSWORD(400, "用户名密码无效"),
    INVALID_USER_DATA_TYP(400, "用户数据类型无效"),
    Network_error(9999,"网络错误"),
    SPEC_PARAM_DELETE_ERROR(500, "商品规格参数删除失败"),
    SPEC_PARAM_NOT_FOUND(404, "商品规格参数没查到"),
    SPEC_GROUP_NOT_FOUND(404, "商品规格组没查到"),
    FILE_UPLOAD_ERROR(500, "上传文件失败"),
    FILE_TYPE_NOT_MATCH(400, "上传无效的文件类型"),
    BRAND_SAVE_ERROR(500, "新增品牌失败"),
    CATEGORY_NOT_FOUND(404, "商品分类没查到"),
    BRAND_NOT_FOUND(404, "该品牌不存在没查到"),
    CATEGORY_BRAND_SAVE_ERROR(500, "新增品牌失败");
    private int code;
    private String msg;

}
