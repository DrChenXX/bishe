package com.example.bishe.service;

import com.example.bishe.model.dto.AddTaskForm;
import com.example.bishe.model.entity.CutTask;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @description 针对表【task】的数据库操作Service
* @createDate 2024-04-03 11:11:29
*/
public interface CutTaskService extends IService<CutTask> {
    /**
     * 获取所有任务
     */
    List<CutTask> getTasklist();

    List<CutTask> getFreeTaskList();

    int addTask(AddTaskForm addTaskForm);

    /**
     * 删除任务
     */
    int deleteTask(Long id);

    /**
     * 更新任务
     * @param cutTask
     * @return
     */
    int updateTask(CutTask cutTask);

    /**
     * 根据任务ID查询任务
     * @param id
     * @return
     */
    CutTask getTaskById(Long id);

    /**
     * 发布任务
     * @param id
     * @return
     */
    int publishTask(Long id);
}
