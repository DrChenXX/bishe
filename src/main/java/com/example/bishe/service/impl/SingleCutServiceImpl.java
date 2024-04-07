package com.example.bishe.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bishe.model.entity.SingleCut;
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

    @Override
    public List<SingleCut> getSingleCutList() {
        return this.list();
    }

    @Override
    public int addSingleCut(SingleCut singleCut) {
        return singleCutMapper.insert(singleCut);
    }

    @Override
    public int deleteSingleCut(Long id) {
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
}




