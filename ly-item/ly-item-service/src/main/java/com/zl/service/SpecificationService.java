package com.zl.service;

import com.zl.common.enums.ExceptionEnums;
import com.zl.common.exception.LyException;
import com.zl.mapper.SpecGroupMapper;
import com.zl.mapper.SpecParamMapper;
import com.zl.pojo.SpecGroup;
import com.zl.pojo.SpecParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Copyright (C)，XX
 * FileName: SpecificationService
 * Author: zl
 * Date: 2019/8/4  13:35
 * Description:
 **/
@Service
public class SpecificationService {
    @Autowired
    SpecGroupMapper specGroupMapper;

    @Autowired
    SpecParamMapper specParamMapper;

    public List<SpecGroup> queryGroupByCid(long cid) {
        SpecGroup specGroup = new SpecGroup();
        specGroup.setCid(cid);

        List<SpecGroup> list = specGroupMapper.select(specGroup);
        if (CollectionUtils.isEmpty(list)) {
            throw new LyException(ExceptionEnums.SPEC_GROUP_NOT_FOUND);
        }
        return list;
    }

    //删除分组
    public void deleteGroupById(long id) {
        SpecGroup specGroup = new SpecGroup();
        specGroup.setId(id);
        int count = specGroupMapper.deleteByPrimaryKey(specGroup);
        if (count != 1) {
            throw new LyException(ExceptionEnums.BRAND_SAVE_ERROR);
        }
    }

    public List<SpecParam> queryParamByGid(long gid) {
        SpecParam specParam = new SpecParam();
        specParam.setGroupId(gid);
        List<SpecParam> list = specParamMapper.select(specParam);
        if (CollectionUtils.isEmpty(list)) {
            throw new LyException(ExceptionEnums.SPEC_PARAM_NOT_FOUND);
        }
        return list;
    }

    public void deleteParamByGid(long id) {
        SpecParam specParam = new SpecParam();
        specParam.setId(id);
        int count = specParamMapper.deleteByPrimaryKey(specParam);
        System.out.println(count + "  count ");
        if (count != 1) {
            throw new LyException(ExceptionEnums.BRAND_SAVE_ERROR);
        }
    }


}
