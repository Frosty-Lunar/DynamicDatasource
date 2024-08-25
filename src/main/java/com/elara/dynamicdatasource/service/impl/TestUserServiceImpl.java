package com.elara.dynamicdatasource.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elara.dynamicdatasource.entity.TestUser;
import com.elara.dynamicdatasource.mapper.TestUserMapper;
import com.elara.dynamicdatasource.service.TestUserService;
import org.springframework.stereotype.Service;

@Service
public class TestUserServiceImpl extends ServiceImpl<TestUserMapper,TestUser> implements TestUserService {

}
