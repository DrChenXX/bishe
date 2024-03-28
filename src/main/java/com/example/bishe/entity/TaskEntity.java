package com.example.bishe.entity;
import lombok.Data;
import java.sql.Timestamp;

@Data
public class TaskEntity {
    private long id;

    private long farmId;

    private String type;

    private int number;

    private Timestamp deadline;

    private String pos;

    private long picId;

    private String gps;

    private long money;

    private String state;

    private long workerId;

    private String note;

    public TaskEntity() {
        id = 0;
        farmId = 0;
        type = null;
        number = 0;
        deadline = new Timestamp(System.currentTimeMillis());
        pos = null;
        picId = 0;
        gps = null;
        money = 0;
        state = null;
        workerId = 0;
        note = null;
    }
}
