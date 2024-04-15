package com.example.bishe.service;

import com.example.bishe.model.dto.AddUpdateCutTaskForm;
import com.example.bishe.model.entity.CutTask;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @description 针对表【task】的数据库操作Service
* @createDate 2024-04-03 11:11:29
*/
public interface CutTaskService extends IService<CutTask> {

    /**
     * 获取任务列表
     * @return 任务列表
     */
    List<CutTask> getTasklist();

    /**
     * 获取未被领取任务列表
     * @return 被领取任务列表
     */
    List<CutTask> getFreeTaskList();
    /**
     * 根据Id查询任务
     * @param id 任务Id
     * @return 任务信息
     */
    CutTask getTaskById(Long id);

    /**
     * 添加任务
     * @param addUpdateCutTaskForm 添加任务实体
     * @return  affected rows
     */
    int addTask(AddUpdateCutTaskForm addUpdateCutTaskForm);

    /**
     * 更新任务信息
     * @param taskId 任务Id
     * @param addUpdateCutTaskForm 更新任务实体
     * @return affected rows
     */
    int updateTask(Long taskId, AddUpdateCutTaskForm addUpdateCutTaskForm);

    /**
     * 删除任务信息
     * @param id 任务id
     * @return affected rows
     */
    int deleteTask(Long id);

    /**
     * 发布任务
     * @param id 任务id
     * @return affected rows
     */
    int publishTask(Long id);
}
