package com.example.bishe.model.dto;

import lombok.Data;

@Data
public class AddNoticeForm implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String type;

    private Long targetId;

    private String content;
}
