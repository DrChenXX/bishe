package com.example.bishe.entity;

import lombok.Data;
import java.sql.Timestamp;

@Data
public class WorkEntity {
    private long id;

    private long workerId;

    private long taskId;

    private String type;

    private int number;

    private int nownum;

    private Timestamp deadline;

    private String submit;

    public WorkEntity() {
        id = 0;
        workerId = 0;
        taskId = 0;
        type = null;
        number = 0;
        nownum = 0;
        deadline = new Timestamp(System.currentTimeMillis());
        submit = null;
    }
}
