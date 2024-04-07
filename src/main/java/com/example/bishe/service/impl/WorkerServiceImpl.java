package com.example.bishe.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bishe.model.entity.Worker;
import com.example.bishe.service.WorkerService;
import com.example.bishe.mapper.WorkerMapper;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description 针对表【worker】的数据库操作Service实现
* @createDate 2024-04-03 11:11:29
*/
@Service
@RequiredArgsConstructor
public class WorkerServiceImpl extends ServiceImpl<WorkerMapper, Worker>
    implements WorkerService{

    @Resource
    private WorkerMapper workerMapper;

    @Override
    public List<Worker> getWorkerList() {
        //TODO 分页查询

        return this.list();
    }

    @Override
    public int addWorker(Worker worker) {
        return workerMapper.insert(worker);
    }

    @Override
    public int deleteWorker(Long id) {
        return workerMapper.deleteById(id);
    }

    @Override
    public int updateWorker(Worker worker) {
        return workerMapper.updateById(worker);
    }

    @Override
    public Worker getWorkerById(Long id) {
        return workerMapper.selectById(id);
    }
}




