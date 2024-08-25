package com.elara.dynamicdatasource.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.elara.dynamicdatasource.entity.TestDbInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestDbInfoMapper extends BaseMapper<TestDbInfo> {
}