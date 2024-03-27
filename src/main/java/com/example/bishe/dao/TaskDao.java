package com.example.bishe.dao;

import com.example.bishe.entity.TaskEntity;

import java.util.List;

public interface TaskDao {
    List<TaskEntity> getAll();

    boolean add(TaskEntity task);

    boolean update(TaskEntity task);

    boolean delete(long id);
}
