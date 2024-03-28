package com.example.bishe.dao;

import com.example.bishe.entity.SalaryEntity;

import java.util.List;

public interface SalaryDao {
    List<SalaryEntity> searchByCondition(SalaryEntity salary);

    boolean add(SalaryEntity salary);

    boolean update(SalaryEntity salary);

    boolean delete(long id);
}
