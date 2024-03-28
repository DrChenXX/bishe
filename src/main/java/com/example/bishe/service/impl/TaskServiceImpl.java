package com.example.bishe.service.impl;

import com.example.bishe.dao.TaskDao;
import com.example.bishe.entity.TaskEntity;
import com.example.bishe.service.TaskService;
import com.example.bishe.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    @Override
    public void publish(TaskEntity task) {
        task.setId(Instant.now().getEpochSecond());
        SqlSession session = null;
        try {
            session = MybatisUtil.getSqlSession();
            TaskDao taskDao = session.getMapper(TaskDao.class);
            taskDao.add(task);
            MybatisUtil.commit(session);
        }catch (Exception e){
            e.printStackTrace();
            MybatisUtil.rollBack(session);
        }
    }

    @Override
    public List<TaskEntity> search(TaskEntity task) {
        SqlSession session = MybatisUtil.getSqlSession();
        TaskDao taskDao = session.getMapper(TaskDao.class);
        List<TaskEntity> taskEntityList = taskDao.selectByCondition(task);
        MybatisUtil.close();
        return taskEntityList;
    }
}
