package com.example.bishe.service;

import com.example.bishe.model.entity.Salary;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bishe.model.entity.Work;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

/**
* @description 针对表【salary】的数据库操作Service
* @createDate 2024-04-03 11:11:29
*/
public interface SalaryService extends IService<Salary> {
    List<Salary> getSalryList();

    int generate(Long workId, BigDecimal money);

    int deleteSalary(Long id);

    int updateSalary(Salary salary);

    Salary getSalaryById(Long id);

    int confirm(Long salaryId);

    String trans(Long workId);
}
