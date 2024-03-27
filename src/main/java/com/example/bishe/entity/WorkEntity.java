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
}
