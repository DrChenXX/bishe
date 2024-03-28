package com.example.bishe.dao;

import com.example.bishe.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    List<UserEntity> searchByCondition(UserEntity user);

    boolean add(UserEntity user);

    boolean update(UserEntity user);

    boolean delete(long id);
}
