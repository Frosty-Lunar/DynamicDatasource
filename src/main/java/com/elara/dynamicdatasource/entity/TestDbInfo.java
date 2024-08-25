package com.elara.dynamicdatasource.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TestDbInfo {
    /**
    * 主键Id
    */
    private Integer id;

    /**
    * 数据库URL
    */
    private String url;

    /**
    * 用户名
    */
    private String username;

    /**
    * 密码
    */
    private String password;

    /**
    * 数据库驱动
    */
    private String driverClassName;

    /**
    * 数据库名称
    */
    private String name;
}