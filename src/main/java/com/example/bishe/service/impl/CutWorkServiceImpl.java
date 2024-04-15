package com.example.bishe.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bishe.model.entity.CutTask;
import com.example.bishe.model.entity.CutWork;
import com.example.bishe.service.CutTaskService;
import com.example.bishe.service.CutWorkService;
import com.example.bishe.mapper.CutWorkMapper;
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
public class CutWorkServiceImpl extends ServiceImpl<CutWorkMapper, CutWork>
    implements CutWorkService {

    @Resource
    private CutWorkMapper cutWorkMapper;
    @Resource
    private CutTaskService cutTaskService;

    /**
     * 根据工人id获取所有任务列表
     * @return 任务列表
     */
    @Override
    public List<CutWork> getWorkListByWorkerId(Long workerId) {
        LambdaQueryWrapper<CutWork> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CutWork::getWorkerId,workerId);
        return cutWorkMapper.selectList(queryWrapper);
        //todo 分页查询
    }

    /**
     * 根据id获取任务
     * @param id 任务id
     * @return 任务列表
     */
    @Override
    public CutWork getWorkById(Long id) {
        return cutWorkMapper.selectById(id);
    }

    /**
     * 申领任务
     * @param taskId 任务id
     * @return affected rows
     */
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
        return cutWorkMapper.insert(cutWork);
    }

    /**
     * 提交任务
     * @param workId 任务id
     * @return affected rows
     */
    @Override
    public int finishWork(Long workId) {
        CutWork cutWork = cutWorkMapper.selectById(workId);
        cutWork.setState(1);
        return cutWorkMapper.updateById(cutWork);
    }

    /**
     * 审核通过
     * @param workId 任务id
     * @return affected rows
     */
    @Override
    public int pass(Long workId) {
        CutWork cutWork = cutWorkMapper.selectById(workId);
        cutWork.setState(2);
        return cutWorkMapper.updateById(cutWork);
    }

    /**
     * 审核不通过
     * @param workId 任务id
     * @return affected rows
     */
    @Override
    public int fail(Long workId) {
        CutWork cutWork = cutWorkMapper.selectById(workId);
        cutWork.setState(3);
        return cutWorkMapper.updateById(cutWork);
    }

    /**
     * 取消任务
     * @param id 任务id
     * @return affected rows
     */
    @Override
    public int deleteWork(Long id) {
        CutWork cutWork = cutWorkMapper.selectById(id);
        CutTask cutTask = cutTaskService.getTaskById(cutWork.getTaskId());
        cutTask.setState(0);
        cutTask.setWorkerId(0L);
        cutTaskService.updateById(cutTask);
        return cutWorkMapper.deleteById(id);
    }

}




