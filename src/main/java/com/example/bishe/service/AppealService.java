package com.example.bishe.service;

import com.example.bishe.model.dto.AddUpdateAppealForm;
import com.example.bishe.model.entity.Appeal;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 30648
* @description 针对表【appeal】的数据库操作Service
* @createDate 2024-04-21 23:08:55
*/
public interface AppealService extends IService<Appeal> {
    List<Appeal> getAppealList();

    List<Appeal> getUnconfirmedAppealList();

    Appeal getAppealBySingleId(AddUpdateAppealForm addUpdateAppealForm);

    int addAppeal(AddUpdateAppealForm addUpdateAppealForm);

    int updateAppeal(AddUpdateAppealForm addUpdateAppealForm);

    int deleteAppeal(Long id);

    int confirmAppeal(Long id);

    int rejectAppeal(Long id);

    Appeal getAppealById(Long id);

}
