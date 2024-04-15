package com.example.bishe.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bishe.model.dto.AddTaskForm;
import com.example.bishe.model.entity.Task;
import com.example.bishe.model.entity.User;
import com.example.bishe.service.TaskService;
import com.example.bishe.mapper.TaskMapper;
import com.example.bishe.service.UserService;
import com.example.bishe.util.SendSmsUtil;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
* @description 针对表【task】的数据库操作Service实现
* @createDate 2024-04-03 11:11:29
*/
@Service
@RequiredArgsConstructor
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task>
    implements TaskService{

    @Resource
    private TaskMapper taskMapper;

    @Resource
    private SendSmsUtil sendSmsUtil;

    @Resource
    private UserService userService;

    /**
     * 获取所有任务
     * @return 所有任务
     */
    @Override
    public List<Task> getTasklist() {
        //TODO 分页查询
        return this.list();
    }

    @Override
    public List<Task> getFreeTaskList() {
        //todo 分页查询
        return this.list();
    }

    /**
     * 新添任务
     * @param addTaskForm
     * @return
     */
    @Override
    public int addTask(AddTaskForm addTaskForm) {
        Task task = new Task();
        task.setType(addTaskForm.getType());
        task.setFarmName(addTaskForm.getFarmName());
        task.setMoney(addTaskForm.getMoney());
        task.setName(addTaskForm.getName());
        task.setDeadline(addTaskForm.getDeadline());
        if (addTaskForm.getDescription() != null) {
            task.setDescription(addTaskForm.getDescription());
        }
        task.setState(0);
        task.setWorkerId(0L);

        return taskMapper.insert(task);
    }

    /**
     * 删除任务
     * @param id
     * @return
     */
    @Override
    public int deleteTask(Long id) {
        Task task = taskMapper.selectById(id);
        if (task.getState() != 0) {
            //任务已发布，不支持修改或删除
            return 0;
        }
        return taskMapper.deleteById(id);
        //todo 删除关联
    }

    /**
     * 更新任务
     * @param task
     * @return
     */
    @Override
    public int updateTask(Task task) {
        Task task1 = taskMapper.selectById(task.getId());
        if (task1.getState() != 0) {
            //任务已发布，不支持修改或删除
            return 0;
        }
        return taskMapper.updateById(task);
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Task getTaskById(Long id) {
        return taskMapper.selectById(id);
    }

    /**
     * 发布任务
     * @param id
     * @return
     */
    @Override
    public int publishTask(Long id) {
        //根据当前时间和ID生成编号
        String todayDate = new SimpleDateFormat("yyyyMMdd")
                .format(new Date());
        String str = String.format("%04d", id);
        String taskNumber = todayDate + str;
        Task task = taskMapper.selectById(id);
        //1表述已发布
        task.setTaskNumber(taskNumber);
        task.setState(1);
        //发送短信
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
        return taskMapper.updateById(task);
    }
}




