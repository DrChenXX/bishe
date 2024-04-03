package com.example.bishe.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bishe.model.entity.User;
import com.example.bishe.service.UserService;
import com.example.bishe.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
* @author talha
* @description 针对表【user】的数据库操作Service实现
* @createDate 2024-04-03 11:11:29
*/
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    private final UserMapper userMapper;
    @Override
    public boolean addUser(User user) {
        return this.save(user);
    }

    @Override
    public boolean updateUser(User user) {
        return this.updateById(user);
    }


}




