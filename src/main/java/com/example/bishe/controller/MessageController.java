package com.example.bishe.controller;

import cn.dev33.satoken.util.SaResult;
import com.example.bishe.model.entity.Message;
import com.example.bishe.service.MessageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "工人消息模块", description = "工人消息")
@RestController
@RequestMapping("/message")
public class MessageController {
    @Resource
    private MessageService messageService;

    @GetMapping("/listByWorkerId")
    public SaResult getMessageListByWorkerId(Long workerId){
        List<Message> messageList = messageService.getMessageListByWorkerId(workerId);
        return SaResult.data(messageList);
    }

    @PostMapping("/read")
    public SaResult readMessage(Long messageId){
        int readed = messageService.readMessage(messageId);
        if(readed == 1) {
            return SaResult.ok().setMsg("通知已读");
        }
        return SaResult.error("通知已读失败");
    }
}
