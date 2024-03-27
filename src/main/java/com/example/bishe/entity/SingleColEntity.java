package com.example.bishe.entity;

import lombok.Data;
import java.sql.Timestamp;

@Data
public class SingleColEntity {

    private long id;

    private long workerId;

    private long picId;

    private int age;

    private int circum;

    private String towards;

    private Timestamp time;

    private String weather;

    private String location;

    private String state;

    private String note;

}
