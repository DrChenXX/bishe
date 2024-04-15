package com.example.bishe.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.alipay.api.AlipayApiException;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bishe.mapper.TaskMapper;
import com.example.bishe.model.dto.AddWorkForm;
import com.example.bishe.model.entity.Salary;
import com.example.bishe.model.entity.Task;
import com.example.bishe.model.entity.Work;
import com.example.bishe.service.SalaryService;
import com.example.bishe.service.TaskService;
import com.example.bishe.service.UserService;
import com.example.bishe.service.WorkService;
import com.example.bishe.mapper.WorkMapper;
import com.example.bishe.util.AliPayUtil;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
* @description 针对表【work】的数据库操作Service实现
* @createDate 2024-04-03 11:11:29
*/
@Service
@RequiredArgsConstructor
public class WorkServiceImpl extends ServiceImpl<WorkMapper, Work>
    implements WorkService{

    @Resource
    private WorkMapper workMapper;
    @Resource
    private TaskService taskService;

    @Override
    public List<Work> getWorkListByWorkerId() {
        //todo 分页查询
        return this.list();
    }

    @Override
    public int addWork(Long taskId ) {
        Long workerId = Long.valueOf(String.valueOf(StpUtil.getLoginId())).longValue();
        Task task = taskService.getTaskById(taskId);
        task.setState(1);
        task.setWorkerId(workerId);
        //更改任务状态为已领取,填充工人id
        taskService.updateById(task);
        //把任务信息添加到work表

        Work work = new Work();
        work.setWorkerId(workerId);
        work.setTaskId(taskId);
        work.setTaskNumber(task.getTaskNumber());
        work.setType(task.getType());
        work.setDeadline(task.getDeadline());
        work.setFarmName(task.getFarmName());
        work.setDescription(task.getDescription());
        return workMapper.insert(work);
    }

    @Override
    public int deleteWork(Long id) {
        Work work = workMapper.selectById(id);
        Task task = taskService.getTaskById(work.getTaskId());
        task.setState(0);
        task.setWorkerId(0L);
        taskService.updateById(task);
        return workMapper.deleteById(id);
        //todo 删除关联
    }


    @Override
    public Work getWorkById(Long id) {
        return workMapper.selectById(id);
    }

    @Override
    public int submit(Long workId) {
        Work work = workMapper.selectById(workId);
        work.setState(1);
        return workMapper.updateById(work);
    }

    @Override
    public int pass(Long workId) {
        Work work = workMapper.selectById(workId);
        work.setState(2);
        return workMapper.updateById(work);
    }

    @Override
    public int fail(Long workId) {
        Work work = workMapper.selectById(workId);
        work.setState(3);
        return workMapper.updateById(work);
    }


}




