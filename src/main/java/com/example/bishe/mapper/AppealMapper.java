package com.example.bishe.mapper;

import com.example.bishe.model.entity.Appeal;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 30648
* @description 针对表【appeal】的数据库操作Mapper
* @createDate 2024-04-21 23:08:55
* @Entity com.example.bishe.model.entity.Appeal
*/
public interface AppealMapper extends BaseMapper<Appeal> {
    public Appeal selectAppealByCondition(Appeal appeal);
}




