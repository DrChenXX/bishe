package com.example.bishe.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bishe.model.entity.Salary;
import com.example.bishe.service.SalaryService;
import com.example.bishe.mapper.SalaryMapper;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description 针对表【salary】的数据库操作Service实现
* @createDate 2024-04-03 11:11:29
*/
@Service
@RequiredArgsConstructor
public class SalaryServiceImpl extends ServiceImpl<SalaryMapper, Salary>
    implements SalaryService {

    @Resource
    private SalaryMapper salaryMapper;
    @Override
    public List<Salary> getSalryList() {
        return this.list();
    }

    @Override
    public int addSalary(Salary salary) {
        return salaryMapper.insert(salary);
    }

    @Override
    public int deleteSalary(Long id) {
        return salaryMapper.deleteById(id);
    }

    @Override
    public int updateSalary(Salary salary) {
        return salaryMapper.updateById(salary);
    }

    @Override
    public Salary getSalaryById(Long id) {
        return salaryMapper.selectById(id);
    }
}




