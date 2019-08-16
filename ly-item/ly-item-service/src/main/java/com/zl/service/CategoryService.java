package com.zl.service;

import com.zl.common.enums.ExceptionEnums;
import com.zl.common.exception.LyException;
import com.zl.mapper.CategoryMapper;
import com.zl.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Copyright (C)，XX
 * FileName: CategoryService
 * Author: zl
 * Date: 2019/7/29  18:09
 * Description: 商品分离的实现类
 **/
@Service
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> queryCategoryListByPid(long pid){

        //作为查询条件，mapper会把对象中的非空属性作为查询条件
        Category category = new Category();
        category.setParentId(pid);
        //判断结果
        List<Category> list = categoryMapper.select(category);
        if (CollectionUtils.isEmpty(list)){
            throw new LyException(ExceptionEnums.CATEGORY_NOT_FOUND);
        }
        return list;
    }
}
