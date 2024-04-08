package com.example.bishe.model.dto;

import lombok.Data;

@Data
public class GetAppealByConditionForm implements java.io.Serializable {
    public static final long serialVersionUID = 1L;
    private String type;
    private String id;
}
