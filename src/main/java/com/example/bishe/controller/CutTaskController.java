package com.example.bishe.controller;

import cn.dev33.satoken.util.SaResult;
import com.example.bishe.model.dto.AddUpdateCutTaskForm;
import com.example.bishe.model.entity.CutTask;
import com.example.bishe.service.CutTaskService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "砍伐任务管理模块", description = "任务信息增删改查")
@RestController
@RequestMapping("/cutTask")
public class CutTaskController {
    @Resource
    private CutTaskService cutTaskService;

    /**
     * 获取任务列表
     * @return 任务列表
     */
    @GetMapping("/list")
    public SaResult getAllTask() {
        List<CutTask> cutTaskList = cutTaskService.getTasklist();
        return SaResult.data(cutTaskList);
    }

    /**
     * 获取未被领取任务列表
     * @return 被领取任务列表
     */
    @GetMapping("/freeTaskList")
    public SaResult getFreeTaskList() {
        List<CutTask> freeTaskList = cutTaskService.getFreeTaskList();
        return SaResult.data(freeTaskList);
    }

    /**
     * 根据Id查询任务
     * @param id 任务Id
     * @return 任务信息
     */
    @PostMapping("/task")
    public SaResult getTaskById(@RequestBody Long id) {
        CutTask cutTask = cutTaskService.getTaskById(id);
        return SaResult.data(cutTask);
    }

    /**
     * 添加任务
     * @param addUpdateCutTaskForm 添加任务实体
     * @return  affected rows
     */
    @PostMapping("/add")
    public SaResult addTask(@RequestBody AddUpdateCutTaskForm addUpdateCutTaskForm) {
        int added = cutTaskService.addTask(addUpdateCutTaskForm);
        if (added >= 1) {
            return SaResult.ok().setMsg("任务添加成功");
        }
        return SaResult.error("添加任务失败");
    }

    /**
     * 更新任务信息(前提是任务未被领取)
     * @param taskId 任务Id
     * @param addUpdateCutTaskForm 更新任务实体
     * @return affected rows
     */
    @PostMapping("/update")
    public SaResult updateTask(Long taskId, @RequestBody AddUpdateCutTaskForm addUpdateCutTaskForm) {
        int updated = cutTaskService.updateTask(taskId, addUpdateCutTaskForm);
        if (updated >= 1) {
            return SaResult.ok().setMsg("任务更新成功");
        }
        return SaResult.error("任务更新失败");
    }

    /**
     * 删除任务信息(前提是任务未被领取)
     * @param id 任务id
     * @return affected rows
     */
    @DeleteMapping("/delete")
    public SaResult deleteTask(@RequestBody Long id) {
        int deleted = cutTaskService.deleteTask(id);
        if (deleted >= 1) {
            return SaResult.ok().setMsg("删除任务成功");
        }else {
            return SaResult.error("删除任务失败");
        }
    }

    /**
     * 发布任务
     * @param id 任务id
     * @return affected rows
     */
    @PostMapping("/publish")
    public SaResult publishTask(Long id) {
        int published = cutTaskService.publishTask(id);
        if (published >= 1) {
            return SaResult.ok().setMsg("发布任务成功");
        }
        return SaResult.error("发布任务失败");
    }
}
