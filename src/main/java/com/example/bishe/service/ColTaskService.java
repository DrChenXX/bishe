package com.example.bishe.service;

import com.example.bishe.model.dto.AddUpdateColTaskForm;
import com.example.bishe.model.entity.ColTask;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @description 针对表【col_task】的数据库操作Service
* @createDate 2024-04-15 15:04:52
*/
public interface ColTaskService extends IService<ColTask> {
    List<ColTask> getAllColTasks();

    List<ColTask> getFreeColTasks();

    int addColTask(AddUpdateColTaskForm addUpdateColTaskForm);

    int deleteColTask(Long id);

    int updateColTask(Long taskId, AddUpdateColTaskForm addUpdateColTaskForm);

    ColTask getColTaskById(Long id);

    int publishColTask(Long id);
}
