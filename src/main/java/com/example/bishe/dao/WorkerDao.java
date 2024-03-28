package com.example.bishe.dao;

import com.example.bishe.entity.WorkerEntity;

import java.util.List;

public interface WorkerDao {

    List<WorkerEntity> searchByCondition(WorkerEntity worker);

    boolean add(WorkerEntity worker);

    boolean update(WorkerEntity worker);

    boolean delete(long id);
}
