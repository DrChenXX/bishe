package com.example.bishe;

import com.example.bishe.dao.FarmDao;
import com.example.bishe.dao.UserDao;
import com.example.bishe.entity.FarmEntity;
import com.example.bishe.entity.TaskEntity;
import com.example.bishe.entity.UserEntity;
import com.example.bishe.service.TaskService;
import com.example.bishe.service.UserService;
import com.example.bishe.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BisheApplicationTests {

    @Autowired
    UserService userService;

    @Autowired
    TaskService taskService;

    @Test
    public void testUser(){
        UserEntity user = new UserEntity();
        user.setType("工人");
        List<UserEntity> userEntityList = userService.search(user);
        userEntityList.forEach(userEntity -> System.out.println(userEntity.toString()));
    }

    @Test
    public void testTask(){
        TaskEntity task = new TaskEntity();
        List<TaskEntity> taskEntityList = taskService.search(task);
        taskEntityList.forEach(taskEntity -> System.out.println(taskEntity.toString()));
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

}
