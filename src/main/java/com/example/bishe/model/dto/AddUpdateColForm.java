package com.example.bishe.model.dto;

import lombok.Data;

@Data
public class AddUpdateColForm implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String workerId;

    private String workId;

    private String picId;

    private String age;

    private String circum;

    private String towards;

    private String time;

    private String weather;

    private String location;
}
