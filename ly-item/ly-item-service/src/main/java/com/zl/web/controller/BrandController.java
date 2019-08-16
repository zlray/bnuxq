package com.zl.web.controller;

import com.zl.common.vo.PageResult;
import com.zl.pojo.Brand;
import com.zl.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Copyright (C)，XX
 * FileName: BrandController
 * Author: zl
 * Date: 2019/7/30  14:55
 * Description: 品牌的controller
 **/
@RestController
@RequestMapping("brand")
public class BrandController {

    @Autowired
    private BrandService brandService;


    @GetMapping("page")
    public ResponseEntity<PageResult<Brand>> queryBrandByPage(
            @RequestParam(value = "page",defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows,
            @RequestParam(value = "sortBy", required = false) String sortBy,
            @RequestParam(value = "desc", defaultValue = "false") Boolean desc,
            @RequestParam(value = "search", required = false) String search
            ){
       return ResponseEntity.ok(brandService.queryBrandByPage(page,rows,sortBy,desc,search));
    }

    /**
     * 新增品牌
     * @param brand
     * @param cids
     * @return
     */
    @PostMapping
    public ResponseEntity<Void> saveBrand(Brand brand, @RequestParam("cids")List<Long> cids){

        brandService.saveBrand(brand,cids);

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }
}
