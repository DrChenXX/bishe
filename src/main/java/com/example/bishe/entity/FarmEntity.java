package com.example.bishe.entity;

import lombok.Data;

@Data
public class FarmEntity {
    private long id;

    private String name;

    private long adminId;

    public FarmEntity() {
        id = 0;
        name = null;
        adminId = 0;
    }
}
