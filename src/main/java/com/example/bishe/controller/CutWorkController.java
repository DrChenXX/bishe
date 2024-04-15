package com.example.bishe.controller;

import cn.dev33.satoken.util.SaResult;
import com.example.bishe.model.entity.CutTask;
import com.example.bishe.model.entity.CutWork;
import com.example.bishe.service.CutTaskService;
import com.example.bishe.service.CutWorkService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "工人任务模块", description = "工人任务更改")
@RestController
@RequestMapping("/work")
public class CutWorkController {
    @Resource
    private CutTaskService cutTaskService;

    @Resource
    private CutWorkService cutWorkService;

    @GetMapping("/freetasklist")
    public SaResult getFreeTask() {
        List<CutTask> cutTaskList = cutTaskService.getFreeTaskList();
        return SaResult.ok().setData(cutTaskList);
    }

    @GetMapping("/worklist")
    public SaResult getAllWork() {
        List<CutWork> cutWorkList = cutWorkService.getWorkListByWorkerId();
        return SaResult.ok().setData(cutWorkList);
    }

    @PostMapping("/add")
    public SaResult addWork(Long taskId) {
        int added = cutWorkService.addWork(taskId);
        if (added >= 1) {
            return SaResult.ok().setMsg("领取任务成功");
        }
        return SaResult.error("领取任务失败");
    }

    @PostMapping("/submit")
    public SaResult submit(Long workId) {
        int submit = cutWorkService.submit(workId);
        if (submit >= 1) {
            return SaResult.ok().setMsg("提交任务成功");
        }else {
            return SaResult.error("提交任务失败");
        }
    }

    @PostMapping("/pass")
    public SaResult pass(Long workId) {
        cutWorkService.pass(workId);
        return SaResult.ok().setMsg("审核通过");
    }

    @PostMapping("/fail")
    public SaResult fail(Long workId) {
        cutWorkService.fail(workId);
        return SaResult.ok().setMsg("审核不通过");
    }

    @PostMapping("/finish")
    public SaResult finishWork(@RequestBody Long id) {
        int finished = workService.submitWork(id);
        if (finished >= 1) {
            return SaResult.ok().setMsg("完成任务成功");
        }
        return SaResult.error("完成任务失败");
    }


    @GetMapping("/getWorkById")
    public SaResult getWorkById(@RequestBody Long id) {
        CutWork cutWork = cutWorkService.getWorkById(id);
        return SaResult.data(cutWork);
    }

    @DeleteMapping("/delete")
    public SaResult deleteWork(@RequestBody Long id) {
        int deleted = cutWorkService.deleteWork(id);
        if (deleted >= 1) {
            return SaResult.ok().setMsg("取消任务成功");
        }else {
            return SaResult.error("取消任务失败");
        }
    }
}
