package com.example.bishe.service;

import com.example.bishe.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author talha
* @description 针对表【user】的数据库操作Service
* @createDate 2024-04-03 11:11:29
*/
public interface UserService extends IService<User> {
    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return token
     */
    String login(String username, String password);

    /**
     * 判断用户是否已登录
     * @return true/false
     */
    Boolean isLogin();

    /**
     * 用户登出
     */
    void logout();
}
