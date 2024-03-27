package com.example.bishe.dao;

import com.example.bishe.entity.FarmEntity;

import java.util.List;

public interface FarmDao {
    List<FarmEntity> getAll();

    boolean add(FarmEntity farm);

    boolean update(FarmEntity farm);

    boolean delete(long id);
}
