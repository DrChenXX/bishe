package com.example.bishe.service;

import com.example.bishe.model.dto.AddAppealForm;
import com.example.bishe.model.dto.GetAppealByConditionForm;
import com.example.bishe.model.dto.RejectAppealForm;
import com.example.bishe.model.entity.Appeal;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @description 针对表【appeal】的数据库操作Service
* @createDate 2024-04-03 11:11:29
*/
public interface AppealService extends IService<Appeal> {
    List<Appeal> getAppealList();

    int deleteAppeal(Long id);

    int updateAppeal(Appeal appeal);

    Appeal getAppealById(Long id);

    Appeal getAppealByCondition(GetAppealByConditionForm getAppealByConditionForm);
}
