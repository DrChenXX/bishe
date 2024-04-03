package com.example.bishe.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
    @TableField(value = "id")
    private Long id;

    /**
     * 所在林场ID
     */
    @TableField(value = "farm_id")
    private Long farmId;

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
     * 截止时间
     */
    @TableField(value = "deadline")
    private Date deadline;

    /**
     * 任务地点
     */
    @TableField(value = "pos")
    private String pos;

    /**
     * 地点照片
     */
    @TableField(value = "pic_id")
    private Long pic_id;

    /**
     * GPS定位
     */
    @TableField(value = "gps")
    private String gps;

    /**
     * 任务工资
     */
    @TableField(value = "money")
    private Long money;

    /**
     * 任务状态
     */
    @TableField(value = "state")
    private String state;

    /**
     * 领取ID
     */
    @TableField(value = "worker_id")
    private Long worker_id;

    /**
     * 备注
     */
    @TableField(value = "note")
    private String note;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}