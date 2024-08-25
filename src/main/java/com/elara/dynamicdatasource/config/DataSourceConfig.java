package com.elara.dynamicdatasource.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * DateSourceConfig 是一个配置类，用于配置动态数据源。
 * 它使用 Druid 数据源构建器创建主数据源和从数据源，并配置一个动态数据源，
 * 该动态数据源可以根据当前上下文在主数据源和从数据源之间切换。
 */
@Configuration
public class DataSourceConfig {

    /**
     * 创建主数据源。
     *
     * @return 主数据源对象。
     */
    @Bean
    @ConfigurationProperties("spring.datasource.druid.master")
    public DataSource masterDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * 创建从数据源。
     *
     * @return 从数据源对象。
     */
    @Bean
    @ConfigurationProperties("spring.datasource.druid.slave")
    public DataSource slaveDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * 创建动态数据源。
     * 该方法为主方法，返回一个动态数据源对象，该对象包含主数据源和从数据源的映射。
     *
     * @return 动态数据源对象。
     */
    @Bean(name = "dynamicDataSource")
    @Primary
    public DynamicDataSource createDynamicDataSource() {
        Map<Object, Object> dataSourceMap = new HashMap<>();
        DataSource defaultDataSource = masterDataSource();
        dataSourceMap.put("master", defaultDataSource);
        dataSourceMap.put("slave", slaveDataSource());
        return new DynamicDataSource(defaultDataSource, dataSourceMap);
    }
}
