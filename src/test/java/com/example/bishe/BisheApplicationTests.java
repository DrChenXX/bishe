package com.example.bishe;

import com.example.bishe.dao.FarmDao;
import com.example.bishe.dao.UserDao;
import com.example.bishe.entity.FarmEntity;
import com.example.bishe.entity.UserEntity;
import com.example.bishe.util.MybatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootTest
class BisheApplicationTests {

    @Test
    public void testUser(){
        SqlSession session = MybatisUtil.getSqlSession();
        UserDao userDao = session.getMapper(UserDao.class);
        List<UserEntity> userEntityList = userDao.getAll();
        userEntityList.forEach(userEntity -> System.out.println(userEntity.toString()));
        MybatisUtil.close();
    }

    @Test
    public void testUserAdd(){
        SqlSession session = null;
        try {
            session = MybatisUtil.getSqlSession();
            UserDao userDao = session.getMapper(UserDao.class);
            UserEntity user = new UserEntity();
            user.setId(6);
            user.setPassword("666");
            user.setType("工人");
            user.setPhone("66666666666");
            userDao.add(user);
            MybatisUtil.commit(session);
        }catch (Exception e){
            e.printStackTrace();
            MybatisUtil.rollBack(session);
        }
    }

    @Test
    public void testFarmAdd() {
        SqlSession session = null;
        try {
            session = MybatisUtil.getSqlSession();
            FarmDao farmDao = session.getMapper(FarmDao.class);
            FarmEntity farm = new FarmEntity();
            farm.setId(2);
            farm.setName("zzz");
            farm.setAdminId(1);
            farmDao.add(farm);
            MybatisUtil.commit(session);
        }catch (Exception e) {
            e.printStackTrace();
            MybatisUtil.rollBack(session);
        }
    }

    @Test
    public void testUserUpdate(){
        SqlSession session = null;
        try {
            session = MybatisUtil.getSqlSession();
            UserDao userDao = session.getMapper(UserDao.class);
            UserEntity user = new UserEntity();
            user.setId(6);
            user.setPassword("777");
            user.setType("工人");
            user.setPhone("77777777777");
            userDao.update(user);
            MybatisUtil.commit(session);
        }catch (Exception e){
            e.printStackTrace();
            MybatisUtil.rollBack(session);
        }
    }

    @Test
    public void testUserDelete() {
        SqlSession session = null;
        try {
            session = MybatisUtil.getSqlSession();
            UserDao userDao = session.getMapper(UserDao.class);
            userDao.delete(6);
            MybatisUtil.commit(session);
        }catch (Exception e){
            e.printStackTrace();
            MybatisUtil.rollBack(session);
        }
    }

    @Test
    public void testFarm(){
        SqlSession session = MybatisUtil.getSqlSession();
        FarmDao farmDao = session.getMapper(FarmDao.class);
        List<FarmEntity> farmEntityList = farmDao.getAll();
        farmEntityList.forEach(farmEntity -> System.out.println(farmEntity.toString()));
        MybatisUtil.close();
    }
}
