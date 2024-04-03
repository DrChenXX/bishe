package com.example.bishe.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName salary
 */
@TableName(value ="salary")
@Data
public class Salary implements Serializable {
    /**
     * 主键ID
     */
    @TableField(value = "id")
    private Long id;

    /**
     * 工人ID
     */
    @TableField(value = "worker_id")
    private Long workerId;

    /**
     * 发送时间
     */
    @TableField(value = "time")
    private Date time;

    /**
     * 金额
     */
    @TableField(value = "number")
    private Long number;

    /**
     * 备注
     */
    @TableField(value = "note")
    private String note;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}