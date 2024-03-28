package com.example.bishe.entity;

import lombok.Data;
import java.sql.Timestamp;

@Data
public class PicEntity {

    private long id;

    private String url;

    private long workerId;

    private Timestamp time;

    public PicEntity() {
        id = 0;
        url = null;
        workerId = 0;
        time = new Timestamp(System.currentTimeMillis());
    }
}
