package com.example.bishe.dao;

import com.example.bishe.entity.NoticeEntity;

import java.util.List;

public interface NoticeDao {
    List<NoticeEntity> getAll();

    boolean add(NoticeEntity notice);

    boolean update(NoticeEntity notice);

    boolean delete(long id);
}
