package com.example.bishe.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bishe.model.entity.Task;
import com.example.bishe.service.TaskService;
import com.example.bishe.mapper.TaskMapper;
import org.springframework.stereotype.Service;

/**
* @author talha
* @description 针对表【task】的数据库操作Service实现
* @createDate 2024-04-03 11:11:29
*/
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task>
    implements TaskService{

}




