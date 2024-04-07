package com.example.bishe.service;

import com.example.bishe.model.dto.AddTaskForm;
import com.example.bishe.model.entity.Task;
import com.baomidou.mybatisplus.extension.service.IService;
import jakarta.annotation.Resource;

import java.util.List;

/**
* @description 针对表【task】的数据库操作Service
* @createDate 2024-04-03 11:11:29
*/
public interface TaskService extends IService<Task> {
    /**
     * 获取所有任务
     */
    List<Task> getTasklist();

    List<Task> getFreeTaskList();

    int addTask(AddTaskForm addTaskForm);

    /**
     * 删除任务
     */
    int deleteTask(Long id);

    /**
     * 更新任务
     * @param task
     * @return
     */
    int updateTask(Task task);

    /**
     * 根据任务ID查询任务
     * @param id
     * @return
     */
    Task getTaskById(Long id);

    /**
     * 发布任务
     * @param id
     * @return
     */
    int publishTask(Long id);
}
