package com.example.bishe.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bishe.model.entity.Work;
import com.example.bishe.service.WorkService;
import com.example.bishe.mapper.WorkMapper;
import org.springframework.stereotype.Service;

/**
* @author talha
* @description 针对表【work】的数据库操作Service实现
* @createDate 2024-04-03 11:11:29
*/
@Service
public class WorkServiceImpl extends ServiceImpl<WorkMapper, Work>
    implements WorkService{

}




