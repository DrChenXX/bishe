package com.example.bishe.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName work
 */
@TableName(value ="work")
@Data
public class Work implements Serializable {
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
     * 任务ID
     */
    @TableField(value = "task_id")
    private Long taskId;

    /**
     * 任务类型
     */
    @TableField(value = "type")
    private String type;

    /**
     * 需求数量
     */
    @TableField(value = "number")
    private Integer number;

    /**
     * 当前数量
     */
    @TableField(value = "nownum")
    private Integer nownum;

    /**
     * 截止时间
     */
    @TableField(value = "deadline")
    private Date deadline;

    /**
     * 是否提交
     */
    @TableField(value = "submit")
    private String submit;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}