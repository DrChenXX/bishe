package com.example.bishe.mapper;

import com.example.bishe.model.entity.Worker;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @description 针对表【worker】的数据库操作Mapper
* @createDate 2024-04-03 11:11:29
* @Entity generator.domain.Worker
*/
public interface WorkerMapper extends BaseMapper<Worker> {
    List<Worker> searchAll();
    List<Worker> searchByFarmId(Worker worker);
}




