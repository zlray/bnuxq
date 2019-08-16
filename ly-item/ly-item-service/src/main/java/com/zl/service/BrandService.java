package com.zl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zl.common.enums.ExceptionEnums;
import com.zl.common.exception.LyException;
import com.zl.common.vo.PageResult;
import com.zl.mapper.BrandMapper;
import com.zl.pojo.Brand;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestParam;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Copyright (C)，XX
 * FileName: BrandService
 * Author: zl
 * Date: 2019/7/30  14:54
 * Description: 品牌分类的service
 **/
@Service
public class BrandService {
    @Autowired
    BrandMapper brandMapper;

    public PageResult<Brand> queryBrandByPage(Integer page, Integer rows, String sortBy, Boolean desc, String search) {
        //分页
        PageHelper.startPage(page, rows);
        //过滤
        Example example = new Example(Brand.class);
        if (StringUtils.isNotBlank(search)) {
            example.createCriteria()
                    .orLike("name", "%" + search + "%")
                    .orEqualTo("letter", search.toUpperCase());
        }
        //排序
        if (StringUtils.isNotBlank(sortBy)) {
            String orderByClause = sortBy + " " + (desc ? "DESC" : "ASC");
            System.out.println(orderByClause + "...........");
            example.setOrderByClause(orderByClause);
        }
        //查询
        List<Brand> list = brandMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            throw new LyException(ExceptionEnums.BRAND_NOT_FOUND);
        }
        //解析分页结果
        PageInfo<Brand> info = new PageInfo<>(list);
        return new PageResult<>(info.getTotal(), list);
    }

    /**
     * 添加事务
     *
     * @param brand
     * @param cids
     */
    @Transactional
    public void saveBrand(Brand brand, @RequestParam("cids") List<Long> cids) {
        //新增完自动回显
        brand.setId(null);
        int count = brandMapper.insert(brand);
        if (count != 1) {
            throw new LyException(ExceptionEnums.BRAND_SAVE_ERROR);
        }

        //新增品牌和分类的中间表
        for (Long cid : cids) {
            count = brandMapper.insertCategoryBrand(cid, brand.getId());
            if (count != 1) {
                throw new LyException(ExceptionEnums.CATEGORY_BRAND_SAVE_ERROR);
            }
        }
    }

}
