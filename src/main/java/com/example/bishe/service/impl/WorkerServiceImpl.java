package com.example.bishe.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bishe.model.entity.Worker;
import com.example.bishe.service.WorkerService;
import com.example.bishe.mapper.WorkerMapper;
import org.springframework.stereotype.Service;

/**
* @author talha
* @description 针对表【worker】的数据库操作Service实现
* @createDate 2024-04-03 11:11:29
*/
@Service
public class WorkerServiceImpl extends ServiceImpl<WorkerMapper, Worker>
    implements WorkerService{

}




