package com.example.bishe.service.impl;

import com.example.bishe.dao.UserDao;
import com.example.bishe.entity.UserEntity;
import com.example.bishe.service.UserService;
import com.example.bishe.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<UserEntity> search(UserEntity user) {
        SqlSession session = MybatisUtil.getSqlSession();
        UserDao userDao = session.getMapper(UserDao.class);
        List<UserEntity> userEntityList = userDao.searchByCondition(user);
        MybatisUtil.close();
        return userEntityList;
    }
}
