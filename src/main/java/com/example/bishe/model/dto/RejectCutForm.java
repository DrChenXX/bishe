package com.example.bishe.model.dto;

import lombok.Data;

@Data
public class RejectCutForm implements java.io.Serializable {
    private String singleCutId;

    private String reason;

    private static final long serialVersionUID = 1L;
}
