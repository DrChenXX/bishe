package com.example.bishe.controller;

import cn.dev33.satoken.util.SaResult;
import com.alipay.api.AlipayApiException;
import com.example.bishe.model.dto.AddWorkForm;
import com.example.bishe.model.entity.Task;
import com.example.bishe.model.entity.Work;
import com.example.bishe.service.TaskService;
import com.example.bishe.service.WorkService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
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
        return SaResult.ok().setData(taskList);
    }

    @GetMapping("/worklist")
    public SaResult getAllWork() {
        List<Work> workList = workService.getWorkListByWorkerId();
        return SaResult.ok().setData(workList);
    }

    @PostMapping("/add")
    public SaResult addWork(Long taskId) {
        int added = workService.addWork(taskId);
        if (added >= 1) {
            return SaResult.ok().setMsg("领取任务成功");
        }
        return SaResult.error("领取任务失败");
    }

    @PostMapping("/submit")
    public SaResult submit(Long workId) {
        int submit = workService.submit(workId);
        if (submit >= 1) {
            return SaResult.ok().setMsg("提交任务成功");
        }else {
            return SaResult.error("提交任务失败");
        }
    }

    @PostMapping("/pass")
    public SaResult pass(Long workId) {
        workService.pass(workId);
        return SaResult.ok().setMsg("审核通过");
    }

    @PostMapping("/fail")
    public SaResult fail(Long workId) {
        workService.fail(workId);
        return SaResult.ok().setMsg("审核不通过");
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
