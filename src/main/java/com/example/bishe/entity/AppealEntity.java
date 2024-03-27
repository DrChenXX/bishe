package com.example.bishe.entity;

import lombok.Data;

@Data
public class AppealEntity {
    private long id;

    private String type;

    private long singleId;

    private String reason;

    private String state;
}
