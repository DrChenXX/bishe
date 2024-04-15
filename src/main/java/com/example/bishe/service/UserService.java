package com.example.bishe.service;

import com.example.bishe.model.dto.AddUpdateUserForm;
import com.example.bishe.model.dto.UpdatePasswordRequest;
import com.example.bishe.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
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
     * 用户注销
     */
    void logout();

    /**
     * 获取所有用户
     */
    List<User> getUserList();

    /**
     * 添加用户
     * @param addUpdateUserForm 用户添加表单
     * @return true/false
     */
    int addUser(AddUpdateUserForm addUpdateUserForm);

    /**
     * 删除用户
     * @param id 用户ID
     */
    int deleteUser(Long id);

    /**
     * 更新用户
     * @param updateUserForm 用户更新实体
     */
    int updateUser(Long userId,  AddUpdateUserForm updateUserForm);

    /**
     * 根据用户ID查询用户
     * @param id 用户ID
     */
    User getUserById(Long id);

    /**
     * 重置密码
     * @param id 用户id
     */
    int resetPassword(Long id);

    /**
     * 修改密码
     * @param updatePasswordRequest 密码
     */
    int updatePassword(UpdatePasswordRequest updatePasswordRequest);
}
