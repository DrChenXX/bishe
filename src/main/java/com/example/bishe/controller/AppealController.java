package com.example.bishe.controller;

import cn.dev33.satoken.util.SaResult;
import com.example.bishe.model.dto.AddUpdateAppealForm;
import com.example.bishe.model.entity.Appeal;
import com.example.bishe.service.AppealService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "申诉模块", description = "处理用户的申诉")
@RestController
@RequestMapping("/appeal")
public class AppealController {
    @Resource
    private AppealService appealService;

    @GetMapping("/list")
    public SaResult getAppealList() {
        List<Appeal> appealList = appealService.getAppealList();
        return SaResult.data(appealList);
    }

    @GetMapping("/getById")
    public SaResult getAppealById(Long id) {
        Appeal appeal = appealService.getAppealById(id);
        return SaResult.data(appeal);
    }

    @GetMapping("/unconfirmedList")
    public SaResult getUnconfirmedAppealList() {
        List<Appeal> appealList = appealService.getUnconfirmedAppealList();
        return SaResult.data(appealList);
    }

    @GetMapping("/appealByWork")
    public SaResult getAppealByWork(@RequestBody AddUpdateAppealForm addUpdateAppealForm) {
        Appeal appeal = appealService.getAppealBySingleId(addUpdateAppealForm);
        return SaResult.data(appeal);
    }

    @GetMapping("/add")
    public SaResult addAppeal(@RequestBody AddUpdateAppealForm addUpdateAppealForm) {
        int added = appealService.addAppeal(addUpdateAppealForm);
        if (added >= 1) {
            return SaResult.ok().setMsg("添加申诉成功");
        }
        return SaResult.error("添加申诉失败");
    }

    @PostMapping("/confirm")
    public SaResult confirmAppeal(Long id) {
        int confirmed = appealService.confirmAppeal(id);
        if (confirmed >= 1) {
            return SaResult.ok().setMsg("确认申诉成功");
        }
        return SaResult.error("确认申诉失败");
    }

    @PostMapping("/reject")
    public SaResult rejectAppeal(Long id) {
        int rejected = appealService.rejectAppeal(id);
        if (rejected >= 1) {
            return SaResult.ok().setMsg("拒绝申诉成功");
        }
        return SaResult.error("拒绝申诉失败");
    }

    @PostMapping("/update")
    public SaResult updateAppeal(@RequestBody AddUpdateAppealForm addUpdateAppealForm) {
        int updated = appealService.updateAppeal(addUpdateAppealForm);
        if (updated >= 1) {
            return SaResult.ok().setMsg("更新申诉成功");
        }
        return SaResult.error("更新申诉失败");
    }

    @DeleteMapping("/delete")
    public SaResult deleteAppeal(Long id) {
        int deleted = appealService.deleteAppeal(id);
        if (deleted >= 1) {
            return SaResult.ok().setMsg("删除申诉成功");
        }
        return SaResult.error("删除申诉失败");
    }
}
