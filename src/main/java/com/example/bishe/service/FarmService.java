package com.example.bishe.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bishe.model.dto.AddUpdateFarmForm;
import com.example.bishe.model.entity.Farm;

import java.util.List;

/**
 * @author talha
 * @description 针对表【farm】的数据库操作Service
 * @createDate 2024-04-06 15:55:16
 */
public interface FarmService extends IService<Farm> {

    int addFarm(AddUpdateFarmForm addUpdateFarmForm);

    int deleteFarm(Long farmId);

    int updateFarm(Long farmId, AddUpdateFarmForm addUpdateFarmForm);

    Farm getFarm(Long farmId);

    List<Farm> getFarmList();
}

