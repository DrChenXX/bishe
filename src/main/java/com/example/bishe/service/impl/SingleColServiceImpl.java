package com.example.bishe.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bishe.mapper.ColWorkMapper;
import com.example.bishe.model.dto.AddColForm;
import com.example.bishe.model.dto.RejectColForm;
import com.example.bishe.model.entity.ColWork;
import com.example.bishe.model.entity.SingleCol;
import com.example.bishe.service.SingleColService;
import com.example.bishe.mapper.SingleColMapper;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description 针对表【single_col】的数据库操作Service实现
* @createDate 2024-04-03 11:11:29
*/
@Service
@RequiredArgsConstructor
public class SingleColServiceImpl extends ServiceImpl<SingleColMapper, SingleCol>
    implements SingleColService {

    @Resource
    private SingleColMapper singleColMapper;

    @Resource
    private ColWorkMapper colWorkMapper;

    @Override
    public List<SingleCol> getSingleColList() {
        return this.list();
    }

    @Override
    public int addSingleCol(AddColForm addColForm) {
        SingleCol singleCol = new SingleCol();
        singleCol.setWorkerId(Long.valueOf(addColForm.getWorkerId()));
        singleCol.setWorkId(Long.valueOf(addColForm.getWorkId()));
        singleCol.setPicId(Long.valueOf(addColForm.getPicId()));
        singleCol.setAge(Integer.valueOf(addColForm.getAge()));
        singleCol.setCircum(Integer.valueOf(addColForm.getCircum()));
        singleCol.setTowards(addColForm.getTowards());
        singleCol.setTime(addColForm.getTime());
        singleCol.setWeather(addColForm.getWeather());
        singleCol.setLocation(addColForm.getLocation());
        singleCol.setState("0");
        return singleColMapper.insert(singleCol);
    }

    @Override
    public int comfirmSingleCol(Long id) {
        SingleCol singleCol = singleColMapper.selectById(id);
        singleCol.setState("1");
        ColWork colWork = colWorkMapper.selectById(singleCol.getWorkId());
        colWork.setNumber(colWork.getNumber() + 1);
        colWorkMapper.updateById(colWork);
        return singleColMapper.updateById(singleCol);
    }

    @Override
    public int rejectSingleCol(RejectColForm rejectColForm) {
        SingleCol singleCol = singleColMapper.selectById(Long.valueOf(rejectColForm.getSingleColId()));
        singleCol.setState("2");
        singleCol.setNote(rejectColForm.getReason());
        return singleColMapper.updateById(singleCol);
    }


    @Override
    public int deleteSingleCol(Long id) {
        SingleCol singleCol = singleColMapper.selectById(id);
        if (singleCol.getState().equals("1")) {
            ColWork colWork = colWorkMapper.selectById(singleCol.getWorkId());
            colWork.setNumber(colWork.getNumber() - 1);
            colWorkMapper.updateById(colWork);
        }
        return singleColMapper.deleteById(id);
    }

    @Override
    public int updateSingleCol(SingleCol singleCol) {
        return singleColMapper.updateById(singleCol);
    }

    @Override
    public SingleCol getSingleColById(Long id) {
        return singleColMapper.selectById(id);
    }
}




