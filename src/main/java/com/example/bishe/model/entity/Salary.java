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
 * @TableName salary
 */
@TableName(value ="salary")
@Data
public class Salary implements Serializable {
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
     * 工人编号
     */
    @TableField(value = "worker_number")
    private String workerNumber;

    /**
     * 工人姓名
     */
    @TableField(value = "worker_name")
    private String workerName;

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
     * 状态（0：待工人确认，1工人已确认，2工资已发放）
     */
    @TableField(value = "state")
    private Integer state;

    /**
     * 砍伐或采集数量
     */
    @TableField(value = "number")
    private Integer number;

    /**
     * 工资
     */
    @TableField(value = "money")
    private BigDecimal money;

    /**
     * 支付宝转账订单号
     */
    @TableField(value = "order_id")
    private String orderId;

    /**
     * 支付宝支付资金流水号
     */
    @TableField(value = "pay_fund_order_id")
    private String payFundOrderId;

    /**
     * 订单支付时间
     */
    @TableField(value = "trans_date")
    private String transDate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}