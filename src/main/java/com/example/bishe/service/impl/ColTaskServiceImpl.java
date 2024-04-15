package com.example.bishe.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bishe.model.dto.AddUpdateColTaskForm;
import com.example.bishe.model.entity.ColTask;
import com.example.bishe.model.entity.User;
import com.example.bishe.service.ColTaskService;
import com.example.bishe.mapper.ColTaskMapper;
import com.example.bishe.service.UserService;
import com.example.bishe.util.SendSmsUtil;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
* @description 针对表【col_task】的数据库操作Service实现
* @createDate 2024-04-15 15:04:52
*/
@Service
@RequiredArgsConstructor
public class ColTaskServiceImpl extends ServiceImpl<ColTaskMapper, ColTask>
    implements ColTaskService{

    @Resource
    private ColTaskMapper colTaskMapper;

    @Resource
    private SendSmsUtil sendSmsUtil;

    @Resource
    private UserService userService;

    @Override
    public List<ColTask> getAllColTasks() {
        return this.list();
    }

    @Override
    public List<ColTask> getFreeColTasks() {
        LambdaQueryWrapper<ColTask> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ColTask::getState, 1);
        return colTaskMapper.selectList(queryWrapper);
    }

    @Override
    public int addColTask(AddUpdateColTaskForm addUpdateColTaskForm) {
        ColTask colTask = new ColTask();
        colTask.setMoney(addUpdateColTaskForm.getMoney());
        colTask.setNumber(addUpdateColTaskForm.getNumber());
        colTask.setName(addUpdateColTaskForm.getName());
        colTask.setDeadline(addUpdateColTaskForm.getDeadline());
        if (addUpdateColTaskForm.getDescription() != null) {
            colTask.setDescription(addUpdateColTaskForm.getDescription());
        }
        colTask.setState(0);
        colTask.setWorker_id(0L);
        return colTaskMapper.insert(colTask);
    }

    @Override
    public int deleteColTask(Long id) {
        ColTask colTask = colTaskMapper.selectById(id);
        if (colTask.getState() != 0) {
            //任务已发布，不支持修改或删除
            return 0;
        }
        return colTaskMapper.deleteById(id);
    }

    @Override
    public int updateColTask(Long taskId, AddUpdateColTaskForm addUpdateColTaskForm) {
        ColTask colTask = colTaskMapper.selectById(taskId);
        if (colTask.getState() != 1) {
            //任务已发布，不支持修改或删除
            return 0;
        } else {
            colTask.setMoney(addUpdateColTaskForm.getMoney());
            colTask.setNumber(addUpdateColTaskForm.getNumber());
            colTask.setName(addUpdateColTaskForm.getName());
            colTask.setDeadline(addUpdateColTaskForm.getDeadline());
            if (addUpdateColTaskForm.getDescription() != null) {
                colTask.setDescription(addUpdateColTaskForm.getDescription());
            }
            return colTaskMapper.updateById(colTask);
        }
    }

    @Override
    public ColTask getColTaskById(Long id) {
        return colTaskMapper.selectById(id);
    }

    @Override
    public int publishColTask(Long id) {
        String todayDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String str = String.format("%04d", id);
        String taskNumber = todayDate + str;
        ColTask colTask = colTaskMapper.selectById(id);
        colTask.setTask_number(taskNumber);
        colTask.setState(1);
        ArrayList<String> phoneList = new ArrayList<>();
        List<User> userList = userService.getUserList();
        for (User user : userList) {
            phoneList.add(user.getPhone());
        }
        String phoneNumbers = StringUtils.join(phoneList, ",");
        try {
            sendSmsUtil.SendSms(phoneNumbers , taskNumber);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return colTaskMapper.updateById(colTask);
    }
}




