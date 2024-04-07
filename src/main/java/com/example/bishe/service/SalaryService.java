package com.example.bishe.service;

import com.example.bishe.model.entity.Salary;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @description 针对表【salary】的数据库操作Service
* @createDate 2024-04-03 11:11:29
*/
public interface SalaryService extends IService<Salary> {
    List<Salary> getSalryList();

    int addSalary(Salary salary);

    int deleteSalary(Long id);

    int updateSalary(Salary salary);

    Salary getSalaryById(Long id);
}
