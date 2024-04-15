package com.example.bishe.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bishe.model.entity.CutWork;

import java.util.List;

/**
* @description 针对表【work】的数据库操作Service
* @createDate 2024-04-03 11:11:29
*/
public interface CutWorkService extends IService<CutWork> {
    /**
     * 根据工人id获取所有任务列表
     * @return 任务列表
     */
    List<CutWork> getWorkListByWorkerId(Long workerId);

    /**
     * 根据id获取任务
     * @param id 任务id
     * @return 任务列表
     */
    CutWork getWorkById(Long id);

    /**
     * 申领任务
     * @param taskId 任务id
     * @return affected rows
     */
    int addWork(Long taskId);

    /**
     * 提交任务
     * @param workId 任务id
     * @return affected rows
     */
    int finishWork(Long workId);

    /**
     * 审核通过
     * @param workId 任务id
     * @return affected rows
     */
    int pass(Long workId);

    /**
     * 审核不通过
     * @param workId 任务id
     * @return affected rows
     */
    int fail(Long workId);

    /**
     * 取消任务
     * @param id 任务id
     * @return affected rows
     */
    int deleteWork(Long id);
}
