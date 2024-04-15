package com.example.bishe.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName col_work
 */
@TableName(value ="col_work")
@Data
public class ColWork implements Serializable {
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 工人ID
     */
    @TableField(value = "worker_id")
    private Long worker_id;

    /**
     * 任务ID
     */
    @TableField(value = "task_id")
    private Long task_id;

    /**
     * 任务编号
     */
    @TableField(value = "task_number")
    private String task_number;

    /**
     * 截止时间
     */
    @TableField(value = "deadline")
    private Date deadline;

    /**
     * 状态
     */
    @TableField(value = "state")
    private Integer state;

    /**
     * 任务工资
     */
    @TableField(value = "money")
    private BigDecimal money;

    /**
     * 任务描述
     */
    @TableField(value = "description")
    private String description;

    /**
     * 需求量
     */
    @TableField(value = "need")
    private Integer need;

    /**
     * 当前数量
     */
    @TableField(value = "number")
    private Integer number;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date create_time;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date update_time;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}