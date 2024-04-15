package com.example.bishe.controller;

import cn.dev33.satoken.util.SaResult;
import com.example.bishe.model.dto.AddTaskForm;
import com.example.bishe.model.entity.Task;
import com.example.bishe.service.TaskService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "任务管理模块", description = "任务信息增删改查")
@RestController
@RequestMapping("/task")
public class TaskController {
    @Resource
    private TaskService taskService;

    @GetMapping("/list")
    public SaResult getAllTask() {
        List<Task> taskList = taskService.getTasklist();
        return SaResult.data(taskList);
    }

    @GetMapping("/freetask")
    public SaResult getFreeTask() {
        List<Task> taskList = taskService.getFreeTaskList();
        return SaResult.data(taskList);
    }

    @PostMapping("/add")
    public SaResult addTask(@RequestBody AddTaskForm addTaskForm) {
        int added = taskService.addTask(addTaskForm);
        if (added >= 1) {
            return SaResult.ok().setMsg("任务添加成功");
        }
        return SaResult.error("添加任务失败");
    }

    @PostMapping("/update")
    public SaResult updateTask(@RequestBody Task task) {
        int updated = taskService.updateTask(task);
        if (updated >= 1) {
            return SaResult.ok().setMsg("任务更新成功");
        }
        return SaResult.error("任务更新失败");
    }

    @PostMapping("/getTaskById")
    public SaResult getTaskById(@RequestBody Long id) {
        Task task = taskService.getTaskById(id);
        return SaResult.data(task);
    }

    @DeleteMapping("/delete")
    public SaResult deleteUser(@RequestBody Long id) {
        int deleted = taskService.deleteTask(id);
        if (deleted >= 1) {
            return SaResult.ok().setMsg("删除任务成功");
        }else {
            return SaResult.error("删除任务失败");
        }
    }

    @PostMapping("/publish")
    public SaResult publishTask(Long id) {
        int published = taskService.publishTask(id);
        if (published >= 1) {
            return SaResult.ok().setMsg("发布任务成功");
        }
        return SaResult.error("发布任务失败");
    }
}
