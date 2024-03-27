package com.example.bishe.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class UserEntity {
    private long id;

    private String password;

    private String type;

    private String phone;
}
