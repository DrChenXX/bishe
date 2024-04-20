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
 * @TableName cut_work
 */
@TableName(value ="cut_work")
@Data
public class CutWork implements Serializable {
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
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
     * 任务编号
     */
    @TableField(value = "task_number")
    private String taskNumber;


    /**
     * 截止时间
     */
    @TableField(value = "deadline")
    private Date deadline;

    /**
     * 地址（林场名）
     */
    @TableField(value = "farm_name")
    private String farmName;

    /**
     * 状态（0：待完成，1已提交待审核，2审核通过，3审核未通过）
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
     * 砍伐或采集数量（提交时填写）
     */
    @TableField(value = "number")
    private Integer number;

    /**
     * 砍伐前照片地址
     */
    @TableField(value = "pic_ago_id")
    private Long picAgoId;

    /**
     * 砍伐后照片地址
     */
    @TableField(value = "pic_back_id")
    private Long picBackId;

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