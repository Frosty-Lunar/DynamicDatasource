package com.elara.dynamicdatasource.controller;

import com.elara.dynamicdatasource.aop.DS;
import com.elara.dynamicdatasource.config.DataSourceContextHolder;
import com.elara.dynamicdatasource.entity.TestUser;
import com.elara.dynamicdatasource.service.TestUserService;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * (test_user)表控制层
 */
@RestController
@RequestMapping("/druidDatasource")
public class TestUserController {

    @Autowired
    private TestUserService testUserService;

    /**
     * 通过名称设置数据源
     *
     * @param datasourceName 数据源名称
     * @return 数据源名称
     */
    @GetMapping("/getData/{datasourceName}")
    public String getDatasourceName(@PathVariable("datasourceName") String datasourceName) {
        DataSourceContextHolder.setDatasource(datasourceName);
        TestUser testUser = testUserService.query().eq("user_name", "slave").one();
        return testUser.getUserName();
    }

    /**
     * 通过注解设置数据源查询单条数据
     *
     * @return 数据源名称
     */
    @GetMapping
    @DS("slave")
    public String getDatasourceNameByDS() {
        TestUser testUser = testUserService.getOne(null);
        return testUser.getUserName();
    }
}
