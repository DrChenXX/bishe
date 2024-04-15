package com.example.bishe.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class AddTaskForm implements Serializable {

    /**
     * 任务类型
     * 1:砍伐任务
     * 2:采集任务
     */
    private String type;

    /**
     * 任务地点(林场)
     */
    private String farmName;

    /**
     * 任务工资
     */
    private BigDecimal money;

    /**
     * 负责人姓名
     */
    private String name;

    /**
     * 截止时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date deadline;

    /**
     * 描述
     */
    private String description;

    private static final long serialVersionUID = 1L;
}
