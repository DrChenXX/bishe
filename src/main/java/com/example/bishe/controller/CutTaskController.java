package com.example.bishe.controller;

import cn.dev33.satoken.util.SaResult;
import com.example.bishe.model.dto.AddTaskForm;
import com.example.bishe.model.entity.CutTask;
import com.example.bishe.service.CutTaskService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "任务管理模块", description = "任务信息增删改查")
@RestController
@RequestMapping("/cutTask")
public class CutTaskController {
    @Resource
    private CutTaskService cutTaskService;

    @GetMapping("/list")
    public SaResult getAllTask() {
        List<CutTask> cutTaskList = cutTaskService.getTasklist();
        return SaResult.data(cutTaskList);
    }

    @GetMapping("/freetask")
    public SaResult getFreeTask() {
        List<CutTask> cutTaskList = cutTaskService.getFreeTaskList();
        return SaResult.data(cutTaskList);
    }

    @PostMapping("/add")
    public SaResult addTask(@RequestBody AddTaskForm addTaskForm) {
        int added = cutTaskService.addTask(addTaskForm);
        if (added >= 1) {
            return SaResult.ok().setMsg("任务添加成功");
        }
        return SaResult.error("添加任务失败");
    }

    @PostMapping("/update")
    public SaResult updateTask(@RequestBody CutTask cutTask) {
        int updated = cutTaskService.updateTask(cutTask);
        if (updated >= 1) {
            return SaResult.ok().setMsg("任务更新成功");
        }
        return SaResult.error("任务更新失败");
    }

    @PostMapping("/getTaskById")
    public SaResult getTaskById(@RequestBody Long id) {
        CutTask cutTask = cutTaskService.getTaskById(id);
        return SaResult.data(cutTask);
    }

    @DeleteMapping("/delete")
    public SaResult deleteUser(@RequestBody Long id) {
        int deleted = cutTaskService.deleteTask(id);
        if (deleted >= 1) {
            return SaResult.ok().setMsg("删除任务成功");
        }else {
            return SaResult.error("删除任务失败");
        }
    }

    @PostMapping("/publish")
    public SaResult publishTask(Long id) {
        int published = cutTaskService.publishTask(id);
        if (published >= 1) {
            return SaResult.ok().setMsg("发布任务成功");
        }
        return SaResult.error("发布任务失败");
    }
}
