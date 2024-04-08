package com.example.bishe.model.dto;

import lombok.Data;

@Data
public class RejectColForm implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String singleColId;

    private String reason;
}
