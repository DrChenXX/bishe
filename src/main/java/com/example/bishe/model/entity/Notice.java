package com.example.bishe.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName notice
 */
@TableName(value ="notice")
@Data
public class Notice implements Serializable {
    /**
     * 主键ID
     */
    @TableField(value = "id")
    private Long id;

    /**
     * 通知类型
     */
    @TableField(value = "type")
    private String type;

    /**
     * 目标ID
     */
    @TableField(value = "target")
    private Long target;

    /**
     * 内容
     */
    @TableField(value = "content")
    private String content;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}