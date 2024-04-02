package com.example.bishe.result;

/**
 * @Description: 返回结果状态码
 * @Author: talhar
 */
public enum ResultCodeEnum {
 
    SUCCESS(true, 20000, "成功"),
 
    UNKNOWN_REASON(false, 20001, "未知错误"),
    //异常测试枚举
    TEST_NUMBER(false, 500, "计算错误");
 
    private final Boolean success;
 
    private final Integer code;
 
    private final String message;
 
    ResultCodeEnum(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
 
    public Boolean getSuccess() {
        return success;
    }
 
    public Integer getCode() {
        return code;
    }
 
    public String getMessage() {
        return message;
    }
 
    @Override
    public String toString() {
        return "ResultCodeEnum{" + "success=" + success + ", code=" + code + ", message='" + message + '\'' + '}';
    }
}