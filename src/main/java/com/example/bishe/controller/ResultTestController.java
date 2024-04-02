package com.example.bishe.controller;

import com.example.bishe.exception.BusinessException;
import com.example.bishe.result.Result;
import com.example.bishe.result.ResultCodeEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("resultTest")
public class ResultTestController {

    @GetMapping("ok")
    public Result testOk() {
        //自定义异常测试
        try{
            int a = 1 / 0;
        }catch (Exception e){
            throw new BusinessException(ResultCodeEnum.TEST_NUMBER);
        }


        Map<String, Object> data = new HashMap<>();
        data.put("name", "李太白");
        return Result.ok().data(data);
    }
}