package com.example.bishe.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName appeal
 */
@TableName(value ="appeal")
@Data
public class Appeal implements Serializable {
    /**
     * 主键ID
     */
    @TableField(value = "id")
    private Long id;

    /**
     * 申诉任务类型
     */
    @TableField(value = "type")
    private String type;

    /**
     * 单次ID
     */
    @TableField(value = "single_id")
    private Long singleId;

    /**
     * 申诉原因
     */
    @TableField(value = "reason")
    private String reason;

    /**
     * 申诉状态
     */
    @TableField(value = "state")
    private String state;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}