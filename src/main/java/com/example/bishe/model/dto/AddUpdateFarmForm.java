package com.example.bishe.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddUpdateFarmForm implements Serializable {


    private static final long serialVersionUID = 1L;

    private String name;

    private String address;

    private String description;

}
