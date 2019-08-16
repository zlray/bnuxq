package com.zl.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * Copyright (C)，XX
 * FileName: SpecParam
 * Author: zl
 * Date: 2019/8/4  15:27
 * Description:
 **/
@Data
@Table(name = "tb_spec_param")
public class SpecParam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cid;
    private Long groupId;
    private String name;
    @Column(name = "`numeric`")
    private Boolean numeric;
    private String unit;
    private Boolean generic;
    private Boolean searching;
    private String segments;
}
