package com.example.bishe.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddTaskForm implements Serializable {
    private String farmId;

    private String type;

    private String number;

    private String deadline;

    private String pos;

    private String picId;

    private String gps;

    private String money;

    private String note;

    private static final long serialVersionUID = 1L;
}
