package com.example.bishe.service;

import com.example.bishe.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> search(UserEntity user);
}
