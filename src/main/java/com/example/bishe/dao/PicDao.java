package com.example.bishe.dao;

import com.example.bishe.entity.PicEntity;

import java.util.List;

public interface PicDao {
    List<PicEntity> getAll();

    boolean add(PicEntity pic);

    boolean update(PicEntity pic);

    boolean delete(long id);
}
