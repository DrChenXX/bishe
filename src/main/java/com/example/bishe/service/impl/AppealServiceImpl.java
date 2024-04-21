package com.example.bishe.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bishe.model.dto.AddUpdateAppealForm;
import com.example.bishe.model.entity.Appeal;
import com.example.bishe.service.AppealService;
import com.example.bishe.mapper.AppealMapper;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 30648
* @description 针对表【appeal】的数据库操作Service实现
* @createDate 2024-04-21 23:08:55
*/
@Service
@RequiredArgsConstructor
public class AppealServiceImpl extends ServiceImpl<AppealMapper, Appeal>
    implements AppealService{

    @Resource
    private AppealMapper appealMapper;

    @Override
    public List<Appeal> getAppealList() {
        return this.list();
    }

    @Override
    public List<Appeal> getUnconfirmedAppealList() {
        LambdaQueryWrapper<Appeal> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Appeal::getState, '0');
        return appealMapper.selectList(queryWrapper);
    }

    @Override
    public Appeal getAppealBySingleId(AddUpdateAppealForm addUpdateAppealForm) {
        Appeal appeal = new Appeal();
        appeal.setType(addUpdateAppealForm.getType());
        appeal.setSingle_id(addUpdateAppealForm.getSingle_id());
        return appealMapper.selectAppealByCondition(appeal);
    }

    @Override
    public int addAppeal(AddUpdateAppealForm addUpdateAppealForm) {
        Appeal appeal = new Appeal();
        appeal.setType(addUpdateAppealForm.getType());
        appeal.setSingle_id(addUpdateAppealForm.getSingle_id());
        appeal.setReason(addUpdateAppealForm.getReason());
        appeal.setState("0");
        return appealMapper.insert(appeal);
    }

    @Override
    public int updateAppeal(AddUpdateAppealForm addUpdateAppealForm) {
        Appeal appeal = appealMapper.selectById(addUpdateAppealForm.getId());
        if (!appeal.getState().equals("0")) {
            return 0;
        }
        appeal.setType(addUpdateAppealForm.getType());
        appeal.setSingle_id(addUpdateAppealForm.getSingle_id());
        appeal.setReason(addUpdateAppealForm.getReason());
        return appealMapper.updateById(appeal);
    }

    @Override
    public int deleteAppeal(Long id) {
        return appealMapper.deleteById(id);
    }

    @Override
    public int confirmAppeal(Long id) {
        Appeal appeal = appealMapper.selectById(id);
        appeal.setState("1");
        return appealMapper.updateById(appeal);
    }

    @Override
    public int rejectAppeal(Long id) {
        Appeal appeal = appealMapper.selectById(id);
        appeal.setState("2");
        return appealMapper.updateById(appeal);
    }

    @Override
    public Appeal getAppealById(Long id) {
        return appealMapper.selectById(id);
    }
}




