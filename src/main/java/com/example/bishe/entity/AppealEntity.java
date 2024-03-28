package com.example.bishe.entity;

import lombok.Data;

@Data
public class AppealEntity {
    private long id;

    private String type;

    private long singleId;

    private String reason;

    private String state;

    public AppealEntity() {
        id = 0;
        type = null;
        singleId = 0;
        reason = null;
        state = null;
    }
}
