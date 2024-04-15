package com.example.bishe.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bishe.mapper.ColTaskMapper;
import com.example.bishe.model.entity.ColTask;
import com.example.bishe.model.entity.ColWork;
import com.example.bishe.service.ColTaskService;
import com.example.bishe.service.ColWorkService;
import com.example.bishe.mapper.ColWorkMapper;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description 针对表【col_work】的数据库操作Service实现
* @createDate 2024-04-15 15:15:47
*/
@Service
@RequiredArgsConstructor
public class ColWorkServiceImpl extends ServiceImpl<ColWorkMapper, ColWork>
    implements ColWorkService{

    @Resource
    private ColWorkMapper colWorkMapper;

    @Resource
    private ColTaskService colTaskService;

    @Override
    public List<ColWork> getColWorkListByWorkerId() {
        return this.list();
    }

    @Override
    public int addWork(Long taskId) {
        Long workerId = Long.valueOf(String.valueOf(StpUtil.getLoginId())).longValue();
        ColTask colTask = colTaskService.getColTaskById(taskId);
        colTask.setState(2);
        colTask.setWorker_id(workerId);
        colTaskService.updateById(colTask);

        ColWork colWork = new ColWork();
        colWork.setTask_id(taskId);
        colWork.setWorker_id(workerId);
        colWork.setTask_number(colTask.getTask_number());
        colWork.setDeadline(colTask.getDeadline());
        colWork.setState(0);
        colWork.setMoney(colTask.getMoney());
        if (colTask.getDescription() != null) {
            colWork.setDescription(colTask.getDescription());
        }
        colWork.setNumber(colTask.getNumber());
        return colWorkMapper.insert(colWork);
    }

    @Override
    public int deleteWork(Long Id) {
        ColWork colWork = colWorkMapper.selectById(Id);
        ColTask colTask = colTaskService.getColTaskById(colWork.getTask_id());
        colTask.setState(1);
        colTask.setWorker_id(0L);
        colTaskService.updateById(colTask);
        return colWorkMapper.deleteById(Id);
    }

    @Override
    public ColWork getColWorkById(Long Id) {
        return colWorkMapper.selectById(Id);
    }

    @Override
    public int submit(Long workId) {
        ColWork colWork = colWorkMapper.selectById(workId);
        colWork.setState(1);
        return colWorkMapper.updateById(colWork);
    }

    @Override
    public int pass(Long workId) {
        ColWork colWork = colWorkMapper.selectById(workId);
        colWork.setState(2);
        return colWorkMapper.updateById(colWork);
    }

    @Override
    public int fail(Long workId) {
        ColWork colWork = colWorkMapper.selectById(workId);
        colWork.setState(3);
        return colWorkMapper.updateById(colWork);
    }
}




