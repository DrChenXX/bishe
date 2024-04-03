package com.example.bishe.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName farm
 */
@TableName(value ="farm")
@Data
public class Farm implements Serializable {
    /**
     * 主键ID
     */
    @TableField(value = "id")
    private Long id;

    /**
     * 林场名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 管理员ID
     */
    @TableField(value = "admin_id")
    private Long adminId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}