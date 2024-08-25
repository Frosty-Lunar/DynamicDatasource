package com.elara.dynamicdatasource.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.elara.dynamicdatasource.entity.TestUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestUserMapper extends BaseMapper<TestUser> {
}