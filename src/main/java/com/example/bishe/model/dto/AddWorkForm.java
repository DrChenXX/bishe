package com.example.bishe.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddWorkForm implements Serializable {
    private String taskId;

    private String workerId;
}
