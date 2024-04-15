package com.example.bishe.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bishe.mapper.WorkMapper;
import com.example.bishe.model.dto.AddCutForm;
import com.example.bishe.model.dto.RejectCutForm;
import com.example.bishe.model.entity.SingleCut;
import com.example.bishe.model.entity.Work;
import com.example.bishe.service.SingleCutService;
import com.example.bishe.mapper.SingleCutMapper;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description 针对表【single_cut】的数据库操作Service实现
* @createDate 2024-04-03 11:11:29
*/
@Service
@RequiredArgsConstructor
public class SingleCutServiceImpl extends ServiceImpl<SingleCutMapper, SingleCut>
    implements SingleCutService {

    @Resource
    private SingleCutMapper singleCutMapper;

    @Resource
    private WorkMapper workMapper;

    @Override
    public List<SingleCut> getSingleCutList() {
        return this.list();
    }

    @Override
    public int addSingleCut(AddCutForm addCutForm) {
        SingleCut singleCut = new SingleCut();
        singleCut.setWorkId(Long.valueOf(addCutForm.getWorkId()));
        singleCut.setWorkerId(Long.valueOf(addCutForm.getWorkerId()));
        singleCut.setPic1Id(Long.valueOf(addCutForm.getPic1_id()));
        singleCut.setPic2Id(Long.valueOf(addCutForm.getPic2_id()));
        singleCut.setPic3Id(Long.valueOf(addCutForm.getPic3_id()));
        singleCut.setNumber(Integer.valueOf(addCutForm.getNumber()));
        singleCut.setState("0");
        return singleCutMapper.insert(singleCut);
    }

    @Override
    public int comfirmSingleCut(Long id) {
        SingleCut singleCut = singleCutMapper.selectById(id);
        singleCut.setState("1");
        Work work = workMapper.selectById(singleCut.getWorkId());
        int nownum = work.getNownum();
        work.setNownum(nownum + singleCut.getNumber());
        workMapper.updateById(work);
        return singleCutMapper.updateById(singleCut);
    }

    @Override
    public int rejectSingleCut(RejectCutForm rejectCutForm) {
        SingleCut singleCut = singleCutMapper.selectById(rejectCutForm.getSingleCutId());
        singleCut.setState("2");
        singleCut.setNote(rejectCutForm.getReason());
        return singleCutMapper.updateById(singleCut);
    }

    @Override
    public int deleteSingleCut(Long id) {
        SingleCut singleCut = singleCutMapper.selectById(id);
        if (singleCut.getState().equals("1")) {
            Work work = workMapper.selectById(singleCut.getWorkId());
            int nownum = work.getNownum();
            work.setNownum(nownum - singleCut.getNumber());
            workMapper.updateById(work);
        }
        return singleCutMapper.deleteById(id);
    }

    @Override
    public int updateSingleCut(SingleCut singleCut) {
        return singleCutMapper.updateById(singleCut);
    }

    @Override
    public SingleCut getSingleCutById(Long id) {
        return singleCutMapper.selectById(id);
    }

    @Override
    public List<SingleCut> getUncomfirmedSingleCutList() {
        SingleCut singleCut = new SingleCut();
        singleCut.setState("0");
        return singleCutMapper.searchByCondition(singleCut);
    }

    @Override
    public List<SingleCut> getSingleCutByWorkerId(Long workerId) {
        SingleCut singleCut = new SingleCut();
        singleCut.setWorkerId(workerId);
        return singleCutMapper.searchByCondition(singleCut);
    }

    @Override
    public List<SingleCut> getSingleCutByWorkId(Long workId) {
        SingleCut singleCut = new SingleCut();
        singleCut.setWorkId(workId);
        return singleCutMapper.searchByCondition(singleCut);
    }

    @Override
    public List<SingleCut> getFailedSingleCutListByWorkerId(Long workerId) {
        SingleCut singleCut = new SingleCut();
        singleCut.setWorkerId(workerId);
        singleCut.setState("2");
        List<SingleCut> singleCutList = singleCutMapper.searchByCondition(singleCut);
        singleCut.setState("5");
        singleCutList.addAll(singleCutMapper.searchByCondition(singleCut));
        return singleCutMapper.searchByCondition(singleCut);
    }

}




