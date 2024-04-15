package com.example.bishe.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bishe.model.entity.CutTask;
import com.example.bishe.model.entity.CutWork;
import com.example.bishe.service.CutTaskService;
import com.example.bishe.service.CutWorkService;
import com.example.bishe.mapper.WorkMapper;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description 针对表【work】的数据库操作Service实现
* @createDate 2024-04-03 11:11:29
*/
@Service
@RequiredArgsConstructor
public class CutWorkServiceImpl extends ServiceImpl<WorkMapper, CutWork>
    implements CutWorkService {

    @Resource
    private WorkMapper workMapper;
    @Resource
    private CutTaskService cutTaskService;

    @Override
    public List<CutWork> getWorkListByWorkerId() {
        //todo 分页查询
        return this.list();
    }

    @Override
    public int addWork(Long taskId ) {
        Long workerId = Long.valueOf(String.valueOf(StpUtil.getLoginId())).longValue();
        CutTask cutTask = cutTaskService.getTaskById(taskId);
        cutTask.setState(1);
        cutTask.setWorkerId(workerId);
        //更改任务状态为已领取,填充工人id
        cutTaskService.updateById(cutTask);
        //把任务信息添加到work表

        CutWork cutWork = new CutWork();
        cutWork.setWorkerId(workerId);
        cutWork.setTaskId(taskId);
        cutWork.setTaskNumber(cutTask.getTaskNumber());
        cutWork.setDeadline(cutTask.getDeadline());
        cutWork.setFarmName(cutTask.getFarmName());
        cutWork.setDescription(cutTask.getDescription());
        return workMapper.insert(cutWork);
    }

    @Override
    public int deleteWork(Long id) {
        CutWork cutWork = workMapper.selectById(id);
        CutTask cutTask = cutTaskService.getTaskById(cutWork.getTaskId());
        cutTask.setState(0);
        cutTask.setWorkerId(0L);
        cutTaskService.updateById(cutTask);
        return workMapper.deleteById(id);
        //todo 删除关联
    }


    @Override
    public CutWork getWorkById(Long id) {
        return workMapper.selectById(id);
    }

    @Override
    public int submit(Long workId) {
        CutWork cutWork = workMapper.selectById(workId);
        cutWork.setState(1);
        return workMapper.updateById(cutWork);
    }

    @Override
    public int pass(Long workId) {
        CutWork cutWork = workMapper.selectById(workId);
        cutWork.setState(2);
        return workMapper.updateById(cutWork);
    }

    @Override
    public int fail(Long workId) {
        CutWork cutWork = workMapper.selectById(workId);
        cutWork.setState(3);
        return workMapper.updateById(cutWork);
    }


}




