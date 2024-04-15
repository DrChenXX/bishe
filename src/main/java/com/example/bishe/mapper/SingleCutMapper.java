package com.example.bishe.mapper;

import com.example.bishe.model.entity.SingleCut;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @description 针对表【single_cut】的数据库操作Mapper
* @createDate 2024-04-03 11:11:29
* @Entity generator.domain.SingleCut
*/
public interface SingleCutMapper extends BaseMapper<SingleCut> {
    List<SingleCut> searchByCondition(SingleCut singleCut);
}




