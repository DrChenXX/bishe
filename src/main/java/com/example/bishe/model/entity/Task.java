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
 * @TableName task
 */
@TableName(value ="task")
@Data
public class Task implements Serializable {
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 任务编号
     */
    @TableField(value = "task_number")
    private String taskNumber;

    /**
     * 任务类型
     */
    @TableField(value = "type")
    private String type;

    /**
     * 任务地点（林场名）
     */
    @TableField(value = "farm_name")
    private String farmName;

    /**
     * 任务工资
     */
    @TableField(value = "money")
    private BigDecimal money;

    /**
     * 负责人姓名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 截止时间
     */
    @TableField(value = "deadline")
    private Date deadline;

    /**
     * 任务状态
     */
    @TableField(value = "state")
    private Integer state;

    /**
     * 描述
     */
    @TableField(value = "description")
    private String description;

    /**
     * 领取ID
     */
    @TableField(value = "worker_id")
    private Long workerId;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}