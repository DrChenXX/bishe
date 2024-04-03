package com.example.bishe.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bishe.model.entity.Message;
import com.example.bishe.service.MessageService;
import com.example.bishe.mapper.MessageMapper;
import org.springframework.stereotype.Service;

/**
* @author talha
* @description 针对表【message】的数据库操作Service实现
* @createDate 2024-04-03 11:11:29
*/
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message>
    implements MessageService {

}




