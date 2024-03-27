package com.example.bishe.dao;

import com.example.bishe.entity.UserEntity;

import java.util.List;

public interface UserDao {
    List<UserEntity> getAll();

    boolean add(UserEntity user);

    boolean update(UserEntity user);

    boolean delete(long id);
}
