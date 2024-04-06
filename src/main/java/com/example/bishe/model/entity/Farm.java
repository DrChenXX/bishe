package com.example.bishe.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;
import java.util.Date;

/**
 *
 * @TableName farm
 */
@TableName(value ="farm")
@Data
public class Farm implements Serializable {
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 林场名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 林场地址
     */
    @TableField(value = "address")
    private String address;

    /**
     * 林场描述
     */
    @TableField(value = "descriptions")
    private String descriptions;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 是否删除(0-未删除，1-已删除)
     */
    @TableField(value = "deleted")
    @TableLogic
    private Integer deleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}