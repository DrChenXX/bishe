package com.example.bishe.dao;

import com.example.bishe.entity.WorkEntity;

import java.util.List;

public interface WorkDao {
    List<WorkEntity> getAll();

    boolean add(WorkEntity work);

    boolean update(WorkEntity work);

    boolean delete(long id);
}
