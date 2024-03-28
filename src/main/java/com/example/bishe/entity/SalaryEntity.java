package com.example.bishe.entity;

import lombok.Data;
import java.sql.Date;

@Data
public class SalaryEntity {

    private long id;

    private long workerId;

    private Date time;

    private long number;

    private String note;

    public SalaryEntity() {
        id = 0;
        workerId = 0;
        time = new Date(System.currentTimeMillis());
        number = 0;
        note = null;
    }
}
