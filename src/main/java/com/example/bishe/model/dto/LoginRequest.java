package com.example.bishe.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginRequest implements Serializable {

    private String username;

    private String password;

    private static final long serialVersionUID = 1L;
}
