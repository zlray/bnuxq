package com.zl.web.controller;

import com.zl.common.response.Response;
import com.zl.pojo.Category;
import com.zl.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Copyright (C)，XX
 * FileName: CategoryController
 * Author: zl
 * Date: 2019/7/29  18:11
 * Description: 商品分类的controller
 **/
@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("list")
    public ResponseEntity<List<Category>> queryCategoryListByPid(@RequestParam("pid") long pid) {

//        return new Response(categoryService.queryCategoryListByPid(pid));

        return ResponseEntity.ok(categoryService.queryCategoryListByPid(pid));
    }
}
