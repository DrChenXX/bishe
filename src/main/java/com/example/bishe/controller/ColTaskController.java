package com.example.bishe.controller;

import cn.dev33.satoken.util.SaResult;
import com.example.bishe.model.dto.AddUpdateColTaskForm;
import com.example.bishe.model.entity.ColTask;
import com.example.bishe.service.ColTaskService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "采集任务管理模块", description = "采集任务信息")
@RestController
@RequestMapping("/coltask")
public class ColTaskController {
    @Resource
    private ColTaskService colTaskService;

    /**
     * 获取所有采集任务信息
     * @return
     */
    @GetMapping("/list")
    public SaResult getAllTask() {
        List<ColTask> colTasks = colTaskService.getAllColTasks();
        return SaResult.data(colTasks);
    }

    /**
     * 获取未被领取的采集任务列表
     * @return 未被领取任务列表
     */
    @GetMapping("/freeColTasklist")
    public SaResult getFreeColTasklist() {
        List<ColTask> colTasks = colTaskService.getFreeColTasks();
        return SaResult.data(colTasks);
    }

    /**
     * 根据ID查询采集任务
     */
    @PostMapping("/get")
    public SaResult getColTaskById(@RequestBody Long id) {
        ColTask colTask = colTaskService.getColTaskById(id);
        return SaResult.data(colTask);

    }

    /**
     * 新增采集任务
     */
    @PostMapping("/add")
    public SaResult addColTask(@RequestBody AddUpdateColTaskForm addUpdateColTaskForm) {
        int added = colTaskService.addColTask(addUpdateColTaskForm);
        if (added >= 1) {
            return SaResult.ok().setMsg("任务添加成功");
        }
        return SaResult.error("任务添加失败");
    }

    /**
     * 更新采集任务
     * @param taskId 采集任务ID
     * @param addUpdateColTaskForm 更新采集任务实体
     * @return 更新结果
     */
    @PostMapping("/update")
    public SaResult updateColTask(Long taskId, @RequestBody AddUpdateColTaskForm addUpdateColTaskForm) {
        int updated = colTaskService.updateColTask(taskId, addUpdateColTaskForm);
        if (updated >= 1) {
            return SaResult.ok().setMsg("任务更新成功");
        }
        return SaResult.error("任务更新失败");

    }

    /**
     * 删除采集任务
     * @param taskId 采集任务ID
     * @return 删除结果
     */
    @DeleteMapping("/delete")
    public SaResult deleteColTask(@RequestBody Long taskId) {
        int deleted = colTaskService.deleteColTask(taskId);
        if (deleted >= 1) {
            return SaResult.ok().setMsg("任务删除成功");
        } else {
            return SaResult.error("任务删除失败");
        }
    }

    /**
     * 发布采集任务
     * @param taskId 采集任务ID
     * @return 发布结果
     */
    @PostMapping("/publish")
    public SaResult publishColTask(@RequestBody Long taskId) {
        int published = colTaskService.publishColTask(taskId);
        if (published >= 1) {
            return SaResult.ok().setMsg("任务发布成功");
        } else {
            return SaResult.error("任务发布失败");
        }
    }
}
