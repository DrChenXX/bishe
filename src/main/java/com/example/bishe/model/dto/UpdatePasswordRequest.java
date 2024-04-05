package com.example.bishe.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UpdatePasswordRequest implements Serializable {

    private String oldPassword;

    private String newPassword;

    private String confirmPassword;

    private static final long serialVersionUID = 1L;
}
