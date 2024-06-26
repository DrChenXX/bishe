package com.example.bishe.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bishe.model.entity.ColWork;

import java.util.List;

/**
* @description 针对表【col_work】的数据库操作Service
* @createDate 2024-04-15 15:15:47
*/
public interface ColWorkService extends IService<ColWork> {
    List<ColWork> getColWorkListByWorkerId(Long workerId);

    int addWork(Long taskId);

    int deleteWork(Long Id);

    int updateWork(ColWork colWork);

    int addOnePic(Long colWorkId);

    ColWork getColWorkById(Long Id);

    int submit(Long workId);

    int pass(Long workId);

    int fail(Long workId);
}
