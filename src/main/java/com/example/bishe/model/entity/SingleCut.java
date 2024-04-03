package com.example.bishe.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName single_cut
 */
@TableName(value ="single_cut")
@Data
public class SingleCut implements Serializable {
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
     * 工人任务ID
     */
    @TableField(value = "work_id")
    private Long workId;

    /**
     * 采伐前照片
     */
    @TableField(value = "pic1_id")
    private Long pic1Id;

    /**
     * 修改标记后照片
     */
    @TableField(value = "pic2_id")
    private Long pic2Id;

    /**
     * 采伐后照片
     */
    @TableField(value = "pic3_id")
    private Long pic3Id;

    /**
     * 单词数量
     */
    @TableField(value = "number")
    private Integer number;

    /**
     * 是否通过
     */
    @TableField(value = "state")
    private String state;

    /**
     * 备注
     */
    @TableField(value = "note")
    private String note;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}