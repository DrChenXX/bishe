package com.example.bishe.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bishe.mapper.TaskMapper;
import com.example.bishe.model.dto.AddWorkForm;
import com.example.bishe.model.entity.Task;
import com.example.bishe.model.entity.Work;
import com.example.bishe.service.WorkService;
import com.example.bishe.mapper.WorkMapper;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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
    private TaskMapper taskMapper;

    @Override
    public List<Work> getWorkListByWorkerId() {
        //todo 分页查询
        return this.list();
    }

    @Override
    public int addWork(AddWorkForm addWorkForm) {
        Work work = new Work();
        work.setWorkerId(Long.valueOf(addWorkForm.getWorkerId()));
        work.setTaskId(Long.valueOf(addWorkForm.getTaskId()));
        Task task = taskMapper.selectById(addWorkForm.getTaskId());
        String state = task.getState();
        if (!Objects.equals(state, "0")) {
            return 0;
        }
        task.setWorkerId(Long.valueOf(addWorkForm.getWorkerId()));
        task.setState("1");
        taskMapper.updateById(task);
        work.setType(task.getType());
        work.setNumber(task.getNumber());
        work.setNownum(0);
        work.setDeadline(task.getDeadline());
        work.setSubmit("0");
        return workMapper.insert(work);
    }

    @Override
    public int deleteWork(Long id) {
        Work work = workMapper.selectById(id);
        Task task = taskMapper.selectById(work.getTaskId());
        task.setState("0");
        task.setWorkerId(0L);
        taskMapper.updateById(task);
        return workMapper.deleteById(id);
        //todo 删除关联
    }

    @Override
    public int updateWork(Work work) {
        return workMapper.updateById(work);
    }

    @Override
    public Work getWorkById(Long id) {
        return workMapper.selectById(id);
    }
}




