package com.example.bishe.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bishe.model.entity.Message;
import com.example.bishe.service.MessageService;
import com.example.bishe.mapper.MessageMapper;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description 针对表【message】的数据库操作Service实现
* @createDate 2024-04-03 11:11:29
*/
@Service
@RequiredArgsConstructor
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message>
    implements MessageService {

    @Resource
    private MessageMapper messageMapper;

    @Override
    public List<Message> getMessageList() {
        return this.list();
    }

    @Override
    public List<Message> getMessageListByWorkerId(Long workerId) {
        LambdaQueryWrapper<Message> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Message::getWorkerId, workerId);
        return messageMapper.selectList(queryWrapper);
    }

    @Override
    public List<Message> getUnreadMessageList(Long workerId) {
        LambdaQueryWrapper<Message> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Message::getWorkerId, workerId);
        queryWrapper.eq(Message::getRead, "0");
        return messageMapper.selectList(queryWrapper);
    }

    @Override
    public int addMessage(Message message) {
        return messageMapper.insert(message);
    }

    @Override
    public int deleteMessage(Long id) {
        return messageMapper.deleteById(id);
    }

    @Override
    public int updateMessage(Message message) {
        return messageMapper.updateById(message);
    }

    @Override
    public int readMessage(Long id) {
        Message message = messageMapper.selectById(id);
        message.setRead("1");
        return messageMapper.updateById(message);
    }

    @Override
    public Message getMessageById(Long id) {
        return messageMapper.selectById(id);
    }
}




