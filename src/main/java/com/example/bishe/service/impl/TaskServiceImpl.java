package com.example.bishe.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bishe.model.dto.AddTaskForm;
import com.example.bishe.model.entity.Task;
import com.example.bishe.service.TaskService;
import com.example.bishe.mapper.TaskMapper;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
* @description 针对表【task】的数据库操作Service实现
* @createDate 2024-04-03 11:11:29
*/
@Service
@RequiredArgsConstructor
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task>
    implements TaskService{

    @Resource
    private TaskMapper taskMapper;

    /**
     * 获取所有任务
     * @return 所有任务
     */
    @Override
    public List<Task> getTasklist() {
        //TODO 分页查询
        return this.list();
    }

    @Override
    public List<Task> getFreeTaskList() {
        //todo 分页查询
        return this.list();
    }

    /**
     * 新添任务
     * @param addTaskForm
     * @return
     */
    @Override
    public int addTask(AddTaskForm addTaskForm) {
        Task task = new Task();
        task.setFarmId(Long.valueOf(addTaskForm.getFarmId()));
        task.setType(addTaskForm.getType());
        task.setNumber(Integer.valueOf(addTaskForm.getNumber()));
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = fmt.parse(addTaskForm.getDeadline());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        task.setDeadline(date);
        task.setPos(addTaskForm.getPos());
        task.setPicId(Long.valueOf(addTaskForm.getPicId()));
        task.setGps(addTaskForm.getGps());
        task.setMoney(Long.valueOf(addTaskForm.getMoney()));
        task.setState("0");
        task.setWorkerId(0L);
        if (addTaskForm.getNote() != null) {
            task.setNote(addTaskForm.getNote());
        }
        return taskMapper.insert(task);
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @Override
    public int deleteTask(Long id) {
        return taskMapper.deleteById(id);
        //todo 删除关联
    }

    /**
     * 更新任务
     * @param task
     * @return
     */
    @Override
    public int updateTask(Task task) {
        return taskMapper.updateById(task);
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Task getTaskById(Long id) {
        return taskMapper.selectById(id);
    }

    /**
     * 发布任务
     * @param id
     * @return
     */
    @Override
    public int publishTask(Long id) {
        Task task = taskMapper.selectById(id);
        task.setState("1");
        return taskMapper.updateById(task);
    }
}




