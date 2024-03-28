package com.example.bishe.dao;

import com.example.bishe.entity.NoticeEntity;

import java.util.List;

public interface NoticeDao {
    List<NoticeEntity> searchByCondition(NoticeEntity notice);

    boolean add(NoticeEntity notice);

    boolean update(NoticeEntity notice);

    boolean delete(long id);
}
