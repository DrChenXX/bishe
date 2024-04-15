package com.example.bishe.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bishe.model.entity.CutWork;

import java.util.List;

/**
* @description 针对表【work】的数据库操作Service
* @createDate 2024-04-03 11:11:29
*/
public interface CutWorkService extends IService<CutWork> {
    List<CutWork> getWorkListByWorkerId();

    int addWork(Long taskId);

    int deleteWork(Long id);
    

    CutWork getWorkById(Long id);

    int submit(Long workId);

    int pass(Long workId);

    int fail(Long workId);
}
