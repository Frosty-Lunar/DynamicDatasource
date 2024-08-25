package com.elara.dynamicdatasource.component;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.elara.dynamicdatasource.config.DynamicDataSource;
import com.elara.dynamicdatasource.entity.TestDbInfo;
import com.elara.dynamicdatasource.service.impl.TestDbInfoService;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LoadDataSourceRunner implements CommandLineRunner {
    @Resource
    private DynamicDataSource dynamicDataSource;
    @Resource
    private TestDbInfoService testDbInfoService;

    @Override
    public void run(String... args) {
        List<TestDbInfo> testDbInfos = testDbInfoService.list();
        if (CollectionUtils.isNotEmpty(testDbInfos)) {
            List<TestDbInfo> ds = new ArrayList<>();
            for (TestDbInfo testDbInfo : testDbInfos) {
                TestDbInfo sourceEntity = new TestDbInfo();
                BeanUtils.copyProperties(testDbInfo, sourceEntity);
                sourceEntity.setName(testDbInfo.getName());
                ds.add(sourceEntity);
            }
            dynamicDataSource.createDataSource(ds);
        }
    }
}
