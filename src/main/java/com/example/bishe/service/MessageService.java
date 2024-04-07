package com.example.bishe.service;

import com.example.bishe.model.entity.Message;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @description 针对表【message】的数据库操作Service
* @createDate 2024-04-03 11:11:29
*/
public interface MessageService extends IService<Message> {
    List<Message> getMessageList();

    int addMessage(Message message);

    int deleteMessage(Long id);

    int updateMessage(Message message);

    Message getMessageById(Long id);
}
