package com.example.bishe.service;

import com.example.bishe.model.dto.AddCutForm;
import com.example.bishe.model.dto.RejectCutForm;
import com.example.bishe.model.entity.SingleCut;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @description 针对表【single_cut】的数据库操作Service
* @createDate 2024-04-03 11:11:29
*/
public interface SingleCutService extends IService<SingleCut> {
    List<SingleCut> getSingleCutList();

    int addSingleCut(AddCutForm addCutForm);

    int comfirmSingleCut(Long id);

    int rejectSingleCut(RejectCutForm rejectCutForm);

    int deleteSingleCut(Long id);

    int updateSingleCut(SingleCut singleCut);

    SingleCut getSingleCutById(Long id);
}
