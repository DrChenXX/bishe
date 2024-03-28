package com.example.bishe.entity;

import lombok.Data;

@Data
public class NoticeEntity {
    private long id;

    private String type;

    private long target;

    private String content;

    public NoticeEntity() {
        id = 0;
        type = null;
        target = 0;
        content = null;
    }
}
