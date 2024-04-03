package com.example.bishe.service;

import com.example.bishe.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author talha
* @description 针对表【user】的数据库操作Service
* @createDate 2024-04-03 11:11:29
*/
public interface UserService extends IService<User> {

    boolean addUser(User user);

    boolean updateUser(User user);
}
