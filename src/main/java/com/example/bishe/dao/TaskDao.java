package com.example.bishe.dao;

import com.example.bishe.entity.TaskEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface TaskDao {
    List<TaskEntity> selectByCondition(TaskEntity task);

    boolean add(TaskEntity task);

    boolean update(TaskEntity task);

    boolean delete(long id);
}
