package com.example.bishe.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bishe.mapper.SingleColMapper;
import com.example.bishe.mapper.WorkMapper;
import com.example.bishe.model.dto.AddAppealForm;
import com.example.bishe.model.dto.GetAppealByConditionForm;
import com.example.bishe.model.dto.RejectAppealForm;
import com.example.bishe.model.entity.Appeal;
import com.example.bishe.model.entity.CutWork;
import com.example.bishe.model.entity.SingleCol;
import com.example.bishe.service.AppealService;
import com.example.bishe.mapper.AppealMapper;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author talha
* @description 针对表【appeal】的数据库操作Service实现
* @createDate 2024-04-03 11:11:29
*/
@Service
@RequiredArgsConstructor
public class AppealServiceImpl extends ServiceImpl<AppealMapper, Appeal>
    implements AppealService {

    @Resource
    private AppealMapper appealMapper;

    @Override
    public List<Appeal> getAppealList() {
        return this.list();
    }

    @Override
    public int deleteAppeal(Long id) {
        return appealMapper.deleteById(id);
    }

    @Override
    public int updateAppeal(Appeal appeal) {
        return appealMapper.updateById(appeal);
    }

    @Override
    public Appeal getAppealById(Long id) {
        return appealMapper.selectById(id);
    }

    @Override
    public Appeal getAppealByCondition(GetAppealByConditionForm getAppealByConditionForm) {
        return appealMapper.searchByCondition(getAppealByConditionForm);
    }
}




