package com.example.bishe.controller;

import cn.dev33.satoken.util.SaResult;
import com.example.bishe.model.entity.Salary;
import com.example.bishe.service.SalaryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Tag(name = "工资账单模块", description = "工资账单模块")
@RestController
@RequestMapping("/salary")
public class SalaryController {

    @Resource
    private SalaryService salaryService;

    // 工资账单列表
    @GetMapping("list")
    public SaResult getSalaryList() {
        List<Salary> salryList = salaryService.getSalryList();
        return SaResult.ok().setData(salryList);
    }

    @GetMapping("{id}")
    public SaResult getSalaryById(@PathVariable Long id) {
        Salary salaryById = salaryService.getSalaryById(id);
        return SaResult.ok().setData(salaryById);
    }

    // 工资账单生成
    @PostMapping("/generate")
    public SaResult generate(Long workId, BigDecimal money) {
        int added = salaryService.generate(workId, money);
        if (added >= 1) {
            return SaResult.ok().setMsg("生成账单成功");
        }else {
            return SaResult.error().setMsg("生成账单失败");
        }

    }

    //工人工资确认
    @GetMapping("confirm")
    public SaResult confirm(Long salaryId) {
        salaryService.confirm(salaryId);
        return SaResult.ok().setMsg("工资确认成功");
    }

    //转账
    @PostMapping("/trans")
    public SaResult trans(Long salaryId) {
        String msg = salaryService.trans(salaryId);
        if (msg == null) {
            return SaResult.ok().setMsg("工人还未确认，暂不支持转账");
        }
        return SaResult.ok().setMsg(msg);
    }


}
