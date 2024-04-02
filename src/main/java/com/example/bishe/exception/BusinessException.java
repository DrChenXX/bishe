package com.example.bishe.exception;

import com.example.bishe.result.ResultCodeEnum;

public class BusinessException extends RuntimeException {
    private Integer code;
 
    public BusinessException(ResultCodeEnum resultCodeEnum) {
        // 调用父类的方法添加信息
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }
 
    public Integer getCode() {
        return code;
    }
}