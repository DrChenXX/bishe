package com.example.bishe.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

    @Override
    public List<SingleCol> getSingleColList() {
        return this.list();
    }

    @Override
    public int addSingleCol(SingleCol singleCol) {
        return singleColMapper.insert(singleCol);
    }

    @Override
    public int deleteSingleCol(Long id) {
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




