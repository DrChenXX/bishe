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

}
