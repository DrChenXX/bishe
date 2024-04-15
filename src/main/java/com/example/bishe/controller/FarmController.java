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


    /**
     * 添加林场信息
     * @param addUpdateFarmForm 添加林场信息实体
     * @return affected rows
     */
    @PostMapping("/addFarm")
    public SaResult addFarm(@RequestBody AddUpdateFarmForm addUpdateFarmForm) {
        int added = farmService.addFarm(addUpdateFarmForm);
        if (added >= 1) {
            return SaResult.ok("添加成功");
        }else {
            return SaResult.error("添加失败");
        }

    }

    /**
     * 删除林场信息
     * @param farmId 林场id
     * @return affected rows
     */
    @DeleteMapping("/delete")
    public SaResult deleteFarm(Long farmId) {
        int deleted = farmService.deleteFarm(farmId);
        if (deleted >= 1) {
            return SaResult.ok("删除成功");
        }else {
            return SaResult.error("删除失败");
        }
    }

    /**
     * 修改林场信息
     * @param farmId 林场id
     * @param addUpdateFarmForm 林场实体
     * @return affected rows
     */
    @PostMapping("/update")
    public SaResult updateFarm(Long farmId,@RequestBody AddUpdateFarmForm addUpdateFarmForm) {
        int updated = farmService.updateFarm(farmId, addUpdateFarmForm);
        if (updated >= 1) {
            return SaResult.ok("修改成功");
        }else {
            return SaResult.error("修改失败");
        }

    }

    /**
     * 根据id获取林场信息
     * @param farmId 林场id
     * @return 林场实体
     */
    @GetMapping("/get")
    public SaResult getFarm(Long farmId) {
        Farm farm = farmService.getFarmById(farmId);
        if (farm != null) {
            return SaResult.ok().setData(farm);
        }else {
            return SaResult.error("林场信息不存在");
        }

    }

    /**
     * 获取所有林场列表
     * @return 林场列表
     */
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
