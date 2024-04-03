package com.example.bishe.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName worker
 */
@TableName(value ="worker")
@Data
public class Worker implements Serializable {
    /**
     * 主键ID
     */
    @TableField(value = "id")
    private Long id;

    /**
     * 工人名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 属于林场ID
     */
    @TableField(value = "farm_id")
    private Long farmId;

    /**
     * 银行卡号
     */
    @TableField(value = "bank")
    private String bank;

    /**
     * 身份证号
     */
    @TableField(value = "self_id")
    private String selfId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}