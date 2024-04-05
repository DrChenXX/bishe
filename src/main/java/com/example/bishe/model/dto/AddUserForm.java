package com.example.bishe.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddUserForm implements Serializable {

    private String username;

    private String phone;

    private String email;

    private String userRole;

    private static final long serialVersionUID = 1L;
}
