package com.example.bishe.dao;

import com.example.bishe.entity.SingleColEntity;

import java.util.List;

public interface SingleColDao {

    List<SingleColEntity> getAll();

    boolean add(SingleColEntity singleCol);

    boolean update(SingleColEntity singleCol);

    boolean delete(long id);
}
