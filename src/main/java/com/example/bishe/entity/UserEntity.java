package com.example.bishe.entity;

import lombok.Data;

@Data
public class UserEntity {
    private long id;

    private String password;

    private String type;

    private String phone;
}
