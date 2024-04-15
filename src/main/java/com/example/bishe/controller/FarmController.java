package com.example.bishe.controller;

import cn.dev33.satoken.util.SaResult;
import com.example.bishe.model.dto.AddUpdateFarmForm;
import com.example.bishe.model.entity.Farm;
import com.example.bishe.service.FarmService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "林场管理模块", description = "林场信息增删改查")
@RestController
@RequestMapping("/farm")
public class FarmController {

    @Resource
    private FarmService farmService;


    // 添加林场信息
    @PostMapping("/addFarm")
    public SaResult addFarm(@RequestBody AddUpdateFarmForm addUpdateFarmForm) {
        int added = farmService.addFarm(addUpdateFarmForm);
        if (added >= 1) {
            return SaResult.ok("添加成功");
        }else {
            return SaResult.error("添加失败");
        }

    }
    // 删除林场信息
    @DeleteMapping("/delete")
    public SaResult deleteFarm(Long farmId) {
        int deleted = farmService.deleteFarm(farmId);
        if (deleted >= 1) {
            return SaResult.ok("删除成功");
        }else {
            return SaResult.error("删除失败");
        }
    }
    // 修改林场信息
    @PostMapping("/update")
    public SaResult updateFarm(Long farmId,@RequestBody AddUpdateFarmForm addUpdateFarmForm) {
        int updated = farmService.updateFarm(farmId, addUpdateFarmForm);
        if (updated >= 1) {
            return SaResult.ok("修改成功");
        }else {
            return SaResult.error("修改失败");
        }

    }
    // 查询林场信息
    @GetMapping("/get")
    public SaResult getFarm(Long farmId) {
        Farm farm = farmService.getFarm(farmId);
        if (farm != null) {
            return SaResult.ok().setData(farm);
        }else {
            return SaResult.error("林场信息不存在");
        }

    }
    // 查询林场列表
    @GetMapping("/list")
    public SaResult getFarmList() {
        List<Farm> farmList = farmService.getFarmList();
        if (farmList != null) {
            return SaResult.ok().setData(farmList);
        }else {
            return SaResult.error("林场列表为空");
        }
    }

}
