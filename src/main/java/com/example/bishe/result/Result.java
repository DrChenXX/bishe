package com.example.bishe.result;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 统一API响应结果封装
 * @Author: talhar
 */
@Data
public class Result {
 
    /**
     * 是否成功
     */
    private Boolean success;
 
    /**
     * 状态码
     */
    private Integer code;
 
    /**
     * 返回的消息
     */
    private String message;
 
    /**
     * 放置响应的数据
     */
    private Map<String, Object> data = new HashMap<>();
 
    public Result() {}
 
    /** 以下是定义一些常用到的格式，调用了创建的枚举类 */
    
    public static Result ok() {
        Result r = new Result();
        r.setSuccess(ResultCodeEnum.SUCCESS.getSuccess());
        r.setCode(ResultCodeEnum.SUCCESS.getCode());
        r.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        return r;
    }
 
    public static Result error() {
        Result r = new Result();
        r.setSuccess(ResultCodeEnum.UNKNOWN_REASON.getSuccess());
        r.setCode(ResultCodeEnum.UNKNOWN_REASON.getCode());
        r.setMessage(ResultCodeEnum.UNKNOWN_REASON.getMessage());
        return r;
    }
 
    public static Result setResult(ResultCodeEnum resultCodeEnum) {
        Result r = new Result();
        r.setSuccess(resultCodeEnum.getSuccess());
        r.setCode(resultCodeEnum.getCode());
        r.setMessage(resultCodeEnum.getMessage());
        return r;
    }
 
    public Result success(Boolean success) {
        this.setSuccess(success);
        return this;
    }
 
    public Result message(String message) {
        this.setMessage(message);
        return this;
    }
 
    public Result code(Integer code) {
        this.setCode(code);
        return this;
    }
 
    public Result data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }
 
    public Result data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }

}