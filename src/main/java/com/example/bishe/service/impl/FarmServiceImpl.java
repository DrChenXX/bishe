package com.example.bishe.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.bishe.mapper.FarmMapper;
import com.example.bishe.model.dto.AddUpdateFarmForm;
import com.example.bishe.model.entity.Farm;
import com.example.bishe.service.FarmService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description 针对表【farm】的数据库操作Service实现
 * @createDate 2024-04-06 15:55:16
 */
@Service
public class FarmServiceImpl extends ServiceImpl<FarmMapper, Farm>
        implements FarmService {

    @Resource
    private FarmMapper farmMapper;

    /**
     * 添加林场信息
     * @param addUpdateFarmForm 添加林场信息实体
     * @return affected rows
     */
    @Override
        public int addFarm(AddUpdateFarmForm addUpdateFarmForm) {
        Farm farm = new Farm();
        farm.setName(addUpdateFarmForm.getName());
        farm.setAddress(addUpdateFarmForm.getAddress());
        farm.setDescriptions(addUpdateFarmForm.getDescription());
        return farmMapper.insert(farm);
    }

    /**
     * 删除林场信息
     * @param farmId 林场id
     * @return affected rows
     */
    @Override
    public int deleteFarm(Long farmId) {
        return farmMapper.deleteById(farmId);
    }

    /**
     * 修改林场信息
     * @param farmId 林场id
     * @param addUpdateFarmForm 林场实体
     * @return affected rows
     */
    @Override
    public int updateFarm(Long farmId, AddUpdateFarmForm addUpdateFarmForm) {
        Farm farm = farmMapper.selectById(farmId);
        farm.setName(addUpdateFarmForm.getName());
        farm.setAddress(addUpdateFarmForm.getAddress());
        farm.setDescriptions(addUpdateFarmForm.getDescription());
        return farmMapper.updateById(farm);
    }

    /**
     * 根据id获取林场信息
     * @param farmId 林场id
     * @return 林场实体
     */
    @Override
    public Farm getFarmById(Long farmId) {
        return farmMapper.selectById(farmId);
    }

    /**
     * 获取所有林场列表
     * @return 林场列表
     */
    @Override
    public List<Farm> getFarmList() {
        //TODO 分页查询
        return this.list();
    }
}




