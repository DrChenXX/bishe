package com.example.bishe.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName pic
 */
@TableName(value ="pic")
@Data
public class Pic implements Serializable {
    /**
     * 主键ID
     */
    @TableField(value = "id")
    private Long id;

    /**
     * 照片地址
     */
    @TableField(value = "url")
    private String url;

    /**
     * 工人ID
     */
    @TableField(value = "worker_id")
    private Long workerId;

    /**
     * 上传时间
     */
    @TableField(value = "time")
    private Date time;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}