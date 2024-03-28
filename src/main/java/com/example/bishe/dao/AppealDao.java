package com.example.bishe.dao;

import com.example.bishe.entity.AppealEntity;

import java.util.List;

public interface AppealDao {
    List<AppealEntity> searchByCondition(AppealEntity appeal);

    boolean add(AppealEntity appeal);

    boolean update(AppealEntity appeal);

    boolean delete(long id);
}
