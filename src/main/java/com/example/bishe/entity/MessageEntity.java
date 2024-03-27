package com.example.bishe.entity;

import lombok.Data;

@Data
public class MessageEntity {
    private long id;

    private long noticeId;

    private long workerId;

    private String read;

}
