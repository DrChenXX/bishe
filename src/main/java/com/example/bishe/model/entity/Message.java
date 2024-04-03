package com.example.bishe.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName message
 */
@TableName(value ="message")
@Data
public class Message implements Serializable {
    /**
     * 主键ID
     */
    @TableField(value = "id")
    private Long id;

    /**
     * 通知ID
     */
    @TableField(value = "notice_id")
    private Long noticeId;

    /**
     * 工人ID
     */
    @TableField(value = "worker_Id")
    private Long workerId;

    /**
     * 是否已读
     */
    @TableField(value = "read")
    private String read;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}