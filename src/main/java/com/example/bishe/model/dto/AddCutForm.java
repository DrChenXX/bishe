package com.example.bishe.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddCutForm implements Serializable {
    private String workId;

    private String workerId;

    private String pic1_id;

    private String pic2_id;

    private String pic3_id;

    private String number;

    private static final long serialVersionUID = 1L;
}
