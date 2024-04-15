package com.example.bishe.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bishe.model.dto.AddUpdateFarmForm;
import com.example.bishe.model.entity.Farm;

import java.util.List;

/**
 * @description 针对表【farm】的数据库操作Service
 * @createDate 2024-04-06 15:55:16
 */
public interface FarmService extends IService<Farm> {

    /**
     * 添加林场信息
     * @param addUpdateFarmForm 添加林场信息实体
     * @return affected rows
     */
    int addFarm(AddUpdateFarmForm addUpdateFarmForm);

    /**
     * 删除林场信息
     * @param farmId 林场id
     * @return affected rows
     */
    int deleteFarm(Long farmId);

    /**
     * 修改林场信息
     * @param farmId 林场id
     * @param addUpdateFarmForm 林场实体
     * @return affected rows
     */
    int updateFarm(Long farmId, AddUpdateFarmForm addUpdateFarmForm);

    /**
     * 根据id获取林场信息
     * @param farmId 林场id
     * @return 林场实体
     */
    Farm getFarmById(Long farmId);

    /**
     * 获取所有林场列表
     * @return 林场列表
     */
    List<Farm> getFarmList();
}

