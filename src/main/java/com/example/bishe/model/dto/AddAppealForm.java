package com.example.bishe.model.dto;

import lombok.Data;

@Data
public class AddAppealForm implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String type;

    private String id;

    private String reason;
}
