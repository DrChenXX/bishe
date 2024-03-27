package com.example.bishe.entity;

import lombok.Data;
import java.sql.Timestamp;

@Data
public class PicEntity {

    private long id;

    private String url;

    private long workerId;

    private Timestamp time;

}
