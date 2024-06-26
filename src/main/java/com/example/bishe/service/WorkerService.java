package com.example.bishe.service;

import com.example.bishe.model.entity.Worker;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @description 针对表【worker】的数据库操作Service
* @createDate 2024-04-03 11:11:29
*/
public interface WorkerService extends IService<Worker> {
    List<Worker> getWorkerList();

    int addWorker(Worker worker);

    int deleteWorker(Long id);

    int updateWorker(Worker worker);

    Worker getWorkerById(Long id);

}
