package com.example.bishe.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bishe.mapper.SingleColMapper;
import com.example.bishe.mapper.SingleCutMapper;
import com.example.bishe.mapper.WorkMapper;
import com.example.bishe.model.dto.AddAppealForm;
import com.example.bishe.model.dto.GetAppealByConditionForm;
import com.example.bishe.model.dto.RejectAppealForm;
import com.example.bishe.model.entity.Appeal;
import com.example.bishe.model.entity.SingleCol;
import com.example.bishe.model.entity.SingleCut;
import com.example.bishe.model.entity.Work;
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

    @Resource
    private SingleCutMapper singleCutMapper;

    @Resource
    private WorkMapper workMapper;

    @Resource
    private SingleColMapper singleCulMapper;

    @Override
    public List<Appeal> getAppealList() {
        return this.list();
    }

    @Override
    public int addAppeal(AddAppealForm addAppealForm) {
        Appeal appeal = new Appeal();
        appeal.setType(addAppealForm.getType());
        appeal.setSingleId(Long.valueOf(addAppealForm.getId()));
        appeal.setReason(addAppealForm.getReason());
        appeal.setState("0");
        if (addAppealForm.getType().equals("1")) {
            SingleCut singleCut = singleCutMapper.selectById(Long.valueOf(addAppealForm.getId()));
            singleCut.setState("3");
            singleCutMapper.updateById(singleCut);
        }
        if (addAppealForm.getType().equals("2")) {
            SingleCol singleCol = singleCulMapper.selectById(Long.valueOf(addAppealForm.getId()));
            singleCol.setState("3");
            singleCulMapper.updateById(singleCol);
        }
        return appealMapper.insert(appeal);
    }

    @Override
    public int comfirmAppeal(Long id) {
        Appeal appeal = appealMapper.selectById(id);
        appeal.setState("1");
        if (appeal.getType().equals("1")) {
            SingleCut singleCut = singleCutMapper.selectById(appeal.getSingleId());
            singleCut.setState("4");
            singleCutMapper.updateById(singleCut);
            Work work = workMapper.selectById(singleCut.getWorkId());
            work.setNownum(work.getNownum() + singleCut.getNumber());
            workMapper.updateById(work);
        }
        if (appeal.getType().equals("2")) {
            SingleCol singleCol = singleCulMapper.selectById(appeal.getSingleId());
            singleCol.setState("4");
            singleCulMapper.updateById(singleCol);
            Work work = workMapper.selectById(singleCol.getWorkId());
            work.setNownum(work.getNownum() + 1);
            workMapper.updateById(work);
        }
        return appealMapper.updateById(appeal);
    }

    @Override
    public int rejecetAppeal(RejectAppealForm rejectAppealForm) {
        Appeal appeal = appealMapper.selectById(rejectAppealForm.getId());
        appeal.setState("2");
        appeal.setReason(rejectAppealForm.getReason());
        if (appeal.getType().equals("1")) {
            SingleCut singleCut = singleCutMapper.selectById(appeal.getSingleId());
            singleCut.setState("5");
            singleCutMapper.updateById(singleCut);
        }
        if (appeal.getType().equals("2")) {
            SingleCol singleCol = singleCulMapper.selectById(appeal.getSingleId());
            singleCol.setState("5");
            singleCulMapper.updateById(singleCol);
        }
        return appealMapper.updateById(appeal);
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




