package com.example.bishe.mapper;

import com.example.bishe.model.dto.GetAppealByConditionForm;
import com.example.bishe.model.entity.Appeal;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author talha
* @description 针对表【appeal】的数据库操作Mapper
* @createDate 2024-04-03 11:11:29
* @Entity generator.domain.Appeal
*/
public interface AppealMapper extends BaseMapper<Appeal> {
    Appeal searchByCondition(GetAppealByConditionForm getAppealByConditionForm);
}




