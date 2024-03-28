package com.example.bishe.dao;

import com.example.bishe.entity.MessageEntity;

import java.util.List;

public interface MessageDao {
    List<MessageEntity> searchByCondition(MessageEntity message);

    boolean add(MessageEntity message);

    boolean update(MessageEntity message);

    boolean delete(long id);
}
