package com.example.bishe.service;

import com.example.bishe.entity.TaskEntity;

import java.util.List;

public interface TaskService {
    //发布新的任务
    void publish(TaskEntity task);

    /*查看农场任务,带条件搜索
    0：无条件
    1：根据农场farm_id
    2：根据类型type
    3：根据工人worker_id
    4：根据完成状态state
     */
    List<TaskEntity> search(TaskEntity task);
}
