package com.example.bishe.entity;

import lombok.Data;

@Data
public class WorkerEntity {
    private long id;

    private String name;

    private long farmId;

    private String bank;

    private String selfId;

    public WorkerEntity() {
        id = 0;
        name = null;
        farmId = 0;
        bank = null;
        selfId = null;
    }
}
