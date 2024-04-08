package com.example.bishe.model.dto;

import lombok.Data;

@Data
public class RejectAppealForm implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    private String reason;
}
