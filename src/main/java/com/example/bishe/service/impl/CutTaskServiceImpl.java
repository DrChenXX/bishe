package com.example.bishe.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bishe.model.dto.AddUpdateCutTaskForm;
import com.example.bishe.model.entity.CutTask;
import com.example.bishe.model.entity.User;
import com.example.bishe.service.CutTaskService;
import com.example.bishe.mapper.CutTaskMapper;
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
* @description 针对表【task】的数据库操作Service实现
* @createDate 2024-04-03 11:11:29
*/
@Service
@RequiredArgsConstructor
public class CutTaskServiceImpl extends ServiceImpl<CutTaskMapper, CutTask>
    implements CutTaskService {

    @Resource
    private CutTaskMapper cutTaskMapper;

    @Resource
    private SendSmsUtil sendSmsUtil;

    @Resource
    private UserService userService;

    /**
     * 获取任务列表
     * @return 任务列表
     */
    @Override
    public List<CutTask> getTasklist() {
        //TODO 分页查询
        return this.list();
    }

    /**
     * 获取未被领取任务列表
     * @return 被领取任务列表
     */
    @Override
    public List<CutTask> getFreeTaskList() {
        LambdaQueryWrapper<CutTask> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CutTask::getState, 1);
        return cutTaskMapper.selectList(queryWrapper);
    }

    /**
     * 根据Id查询任务
     * @param id 任务Id
     * @return 任务信息
     */
    @Override
    public CutTask getTaskById(Long id) {
        return cutTaskMapper.selectById(id);
    }

    /**
     * 添加任务
     * @param addUpdateCutTaskForm 添加任务实体
     * @return  affected rows
     */
    @Override
    public int addTask(AddUpdateCutTaskForm addUpdateCutTaskForm) {
        CutTask cutTask = new CutTask();
        cutTask.setFarmName(addUpdateCutTaskForm.getFarmName());
        cutTask.setMoney(addUpdateCutTaskForm.getMoney());
        cutTask.setName(addUpdateCutTaskForm.getName());
        cutTask.setDeadline(addUpdateCutTaskForm.getDeadline());
        cutTask.setDescription(addUpdateCutTaskForm.getDescription());
        cutTask.setWorkerId(0L);
        return cutTaskMapper.insert(cutTask);
    }

    /**
     * 更新任务信息
     * @param taskId 任务Id
     * @param addUpdateCutTaskForm 更新任务实体
     * @return affected rows
     */
    @Override
    public int updateTask(Long taskId, AddUpdateCutTaskForm addUpdateCutTaskForm) {
        CutTask cutTask = cutTaskMapper.selectById(taskId);
        if (cutTask.getState() != 1) {
            //任务已发布，不支持修改或删除
            return 0;
        } else {
            if (addUpdateCutTaskForm.getFarmName() != null) {
                cutTask.setFarmName(addUpdateCutTaskForm.getFarmName());
            }
            if (addUpdateCutTaskForm.getMoney() != null) {
                cutTask.setMoney(addUpdateCutTaskForm.getMoney());
            }
            if (addUpdateCutTaskForm.getName() != null) {
                cutTask.setName(addUpdateCutTaskForm.getName());
            }
            if (addUpdateCutTaskForm.getDeadline() != null) {
                cutTask.setDeadline(addUpdateCutTaskForm.getDeadline());
            }
            if (addUpdateCutTaskForm.getDescription() != null) {
                cutTask.setDescription(addUpdateCutTaskForm.getDescription());
            }
            return cutTaskMapper.updateById(cutTask);
        }
    }

    /**
     * 删除任务信息
     * @param id 任务id
     * @return affected rows
     */
    @Override
    public int deleteTask(Long id) {
        CutTask cutTask = cutTaskMapper.selectById(id);
        if (cutTask.getState() != 1) {
            //任务已发布，不支持修改或删除
            return 0;
        }
        return cutTaskMapper.deleteById(id);
    }

    /**
     * 发布任务
     * @param id 任务id
     * @return affected rows
     */
    @Override
    public int publishTask(Long id) {
        //根据当前时间和ID生成编号
        String todayDate = new SimpleDateFormat("yyyyMMdd")
                .format(new Date());
        String str = String.format("%04d", id);
        String taskNumber = todayDate + str;
        CutTask cutTask = cutTaskMapper.selectById(id);
        //1表述已发布
        cutTask.setTaskNumber(taskNumber);
        cutTask.setState(1);
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
        return cutTaskMapper.updateById(cutTask);
    }
}




