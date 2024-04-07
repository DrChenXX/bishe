package com.example.bishe.controller;

import cn.dev33.satoken.util.SaResult;
import com.example.bishe.model.dto.AddWorkForm;
import com.example.bishe.model.entity.Task;
import com.example.bishe.model.entity.Work;
import com.example.bishe.service.TaskService;
import com.example.bishe.service.WorkService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "工人任务模块", description = "工人任务更改")
@RestController
@RequestMapping("/work")
public class WorkController {
    @Resource
    private TaskService taskService;

    @Resource
    private WorkService workService;

    @GetMapping("/freetasklist")
    public SaResult getFreeTask() {
        List<Task> taskList = taskService.getFreeTaskList();
        return SaResult.data(taskList);
    }

    @GetMapping("/worklist")
    public SaResult getAllWork() {
        List<Work> workList = workService.getWorkListByWorkerId();
        return SaResult.data(workList);
    }

    @PostMapping("/add")
    public SaResult addWork(@RequestBody AddWorkForm addWorkForm) {
        int added = workService.addWork(addWorkForm);
        if (added >= 1) {
            return SaResult.ok().setMsg("领取任务成功");
        }
        return SaResult.error("领取任务失败");
    }

    @PostMapping("/update")
    public SaResult updateWork(@RequestBody Work work) {
        int updated = workService.updateWork(work);
        if (updated >= 1) {
            return SaResult.ok().setMsg("任务更新成功");
        }
        return SaResult.error("任务更新失败");
    }

    @GetMapping("/getWorkById")
    public SaResult getWorkById(@RequestBody Long id) {
        Work work = workService.getWorkById(id);
        return SaResult.data(work);
    }

    @DeleteMapping("/delete")
    public SaResult deleteWork(@RequestBody Long id) {
        int deleted = workService.deleteWork(id);
        if (deleted >= 1) {
            return SaResult.ok().setMsg("取消任务成功");
        }else {
            return SaResult.error("取消任务失败");
        }
    }
}
