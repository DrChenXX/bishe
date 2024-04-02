package com.example.bishe.handler;

import com.example.bishe.exception.BusinessException;
import com.example.bishe.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: 全局异常处理类
 * @Author: talhar
 */

@ControllerAdvice
public class GlobalExceptionHandler {
 
    /**
     * 使用ExceptionHandler注解声明处理Exception异常
     *
     * @param e e
     * @return {@link Result}
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Result exception(Exception e) {
        // 控制台打印异常
        e.printStackTrace();
        // 返回错误格式信息
        return Result.error();
    }

    /**
     * 使用ExceptionHandler注解声明处理TestException异常
     *
     * @param e e
     * @return {@link Result}
     */
    @ResponseBody
    @ExceptionHandler(BusinessException.class)
    public Result exception(BusinessException e) {
        // 控制台打印异常
        e.printStackTrace();
        // 返回错误格式信息
        return Result.error().message(e.getMessage()).code(e.getCode());
    }
 
}