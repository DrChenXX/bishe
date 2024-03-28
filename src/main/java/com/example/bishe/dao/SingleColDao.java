package com.example.bishe.dao;

import com.example.bishe.entity.SingleColEntity;

import java.util.List;

public interface SingleColDao {

    List<SingleColEntity> searchByCondition(SingleColEntity singleCol);

    boolean add(SingleColEntity singleCol);

    boolean update(SingleColEntity singleCol);

    boolean delete(long id);
}
