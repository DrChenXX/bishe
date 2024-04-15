package com.example.bishe.model.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class AddUpdateUserForm implements Serializable {

    /**
     * 账号
     */
    private String userAccount;

    /**
     * 用户名称
     */
    private String username;

    /**
     * 电话
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 身份证号
     */
    private String idNumber;

    /**
     * 支付宝id
     */
    private String alipayId;

    /**
     * 支付宝账号名
     */
    private String alipayName;

    /**
     * 类型（工人或管理员）
     */
    private String type;

    private static final long serialVersionUID = 1L;
}
