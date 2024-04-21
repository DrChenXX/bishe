package com.example.bishe.model.dto;

import lombok.Data;

@Data
public class AddUpdateAppealForm implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String type;

    private Long single_id;

    private String reason;
}
