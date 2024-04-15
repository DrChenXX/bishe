package com.example.bishe.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName single_col
 */
@TableName(value ="single_col")
@Data
public class SingleCol implements Serializable {
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
    @TableField(value = "work_id")
    private Long workId;

    /**
     * 照片ID
     */
    @TableField(value = "pic_id")
    private Long picId;

    /**
     * 竹龄
     */
    @TableField(value = "age")
    private Integer age;

    /**
     * 竹围
     */
    @TableField(value = "circum")
    private Integer circum;

    /**
     * 朝向
     */
    @TableField(value = "towards")
    private String towards;

    /**
     * 时间
     */
    @TableField(value = "time")
    private String time;

    /**
     * 天气
     */
    @TableField(value = "weather")
    private String weather;

    /**
     * 地点
     */
    @TableField(value = "location")
    private String location;

    /**
     * 是否通过
     * 0:待审核
     * 1:通过
     * 2:未通过
     * 3：申诉中
     * 4：申诉成功
     * 5：申诉失败
     */
    @TableField(value = "state")
    private Integer state;

    /**
     * 备注
     */
    @TableField(value = "note")
    private String note;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}