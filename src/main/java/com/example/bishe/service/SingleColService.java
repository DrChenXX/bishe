package com.example.bishe.service;

import com.example.bishe.model.entity.SingleCol;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @description 针对表【single_col】的数据库操作Service
* @createDate 2024-04-03 11:11:29
*/
public interface SingleColService extends IService<SingleCol> {
    List<SingleCol> getSingleColList();

    int addSingleCol(SingleCol singleCol);

    int deleteSingleCol(Long id);

    int updateSingleCol(SingleCol singleCol);

    SingleCol getSingleColById(Long id);
}
