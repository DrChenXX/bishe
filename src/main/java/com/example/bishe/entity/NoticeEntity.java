package com.example.bishe.entity;

import lombok.Data;

@Data
public class NoticeEntity {
    private long id;

    private String type;

    private long target;

    private String content;

}
