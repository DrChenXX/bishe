package com.example.bishe.service;

import com.example.bishe.model.dto.AddWorkForm;
import com.example.bishe.model.entity.Work;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @description 针对表【work】的数据库操作Service
* @createDate 2024-04-03 11:11:29
*/
public interface WorkService extends IService<Work> {
    List<Work> getWorkListByWorkerId();

    int addWork(AddWorkForm addWorkForm);

    int deleteWork(Long id);

    int updateWork(Work work);

    Work getWorkById(Long id);
}
