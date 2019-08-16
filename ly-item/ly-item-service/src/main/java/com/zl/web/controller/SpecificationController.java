package com.zl.web.controller;

import com.zl.pojo.SpecGroup;
import com.zl.pojo.SpecParam;
import com.zl.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Copyright (C)，XX
 * FileName: SpecificationController
 * Author: zl
 * Date: 2019/8/4  13:35
 * Description:
 **/
@RestController
@RequestMapping("spec")
public class SpecificationController {
    @Autowired
    SpecificationService specificationService;

    /**
     * 根据分类id 查询规格组
     *
     * @param cid
     * @return
     */
    @GetMapping("groups/{cid}")
    public ResponseEntity<List<SpecGroup>> queryGroupByCid(@PathVariable("cid") long cid) {

        return ResponseEntity.ok(specificationService.queryGroupByCid(cid));

    }
    /**
     * 删除分组
     * http://api.leyou.com/api/item/spec/group/1
     */
    @DeleteMapping("group/{id}")
    public ResponseEntity<Void> deleteGroupByGid(@PathVariable("id") long id) {
        specificationService.deleteGroupById(id);
        return ResponseEntity.status(HttpStatus.GONE).build();
    }

    /**
     * 根据组id查询参数
     *
     * @param gid
     * @return
     */
    @GetMapping("params")
    public ResponseEntity<List<SpecParam>> queryParamByGid(@PathParam("gid") long gid) {
        return ResponseEntity.ok(specificationService.queryParamByGid(gid));
    }

    /**
     * 删除商品规格参数
     * @param id
     * @return
     */
    // http://api.leyou.com/api/item/spec/param/2
    @DeleteMapping("param/{id}")
    public ResponseEntity<Void> deleteParamByGid(@PathVariable("id") long id) {
        specificationService.deleteParamByGid(id);
        return ResponseEntity.status(HttpStatus.GONE).build();
    }


}
