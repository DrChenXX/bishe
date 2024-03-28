package com.example.bishe.dao;

import com.example.bishe.entity.SingleCutEntity;

import java.util.List;

public interface SingleCutDao {

    List<SingleCutEntity> searchByCondition(SingleCutEntity singleCut);

    boolean add(SingleCutEntity singleCut);

    boolean update(SingleCutEntity singleCut);

    boolean delete(long id);
}
