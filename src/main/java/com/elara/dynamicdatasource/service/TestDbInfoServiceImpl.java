package com.elara.dynamicdatasource.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elara.dynamicdatasource.entity.TestDbInfo;
import com.elara.dynamicdatasource.mapper.TestDbInfoMapper;
import com.elara.dynamicdatasource.service.impl.TestDbInfoService;
import org.springframework.stereotype.Service;
@Service
public class TestDbInfoServiceImpl extends ServiceImpl<TestDbInfoMapper,TestDbInfo> implements TestDbInfoService{

}
