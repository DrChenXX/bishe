package com.example.bishe.entity;

import lombok.Data;

@Data
public class SingleCutEntity {
    private long id;

    private long workerId;

    private long workId;

    private long pic1Id;

    private long pic2Id;

    private long pic3Id;

    private int number;

    private String state;

    private String note;

    public SingleCutEntity() {
        id = 0;
        workerId = 0;
        workId = 0;
        pic1Id = 0;
        pic2Id = 0;
        pic3Id = 0;
        number = 0;
        state = null;
        note = null;
    }
}
