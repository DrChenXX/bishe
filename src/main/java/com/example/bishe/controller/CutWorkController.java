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

@Tag(name = "工人任务模块", description = "工人任务管理")
@RestController
@RequestMapping("/work")
public class CutWorkController {
    @Resource
    private CutTaskService cutTaskService;

    @Resource
    private CutWorkService cutWorkService;

    /**
     * 获取未被领取任务列表
     * @return 未被领取任务列表
     */
    @GetMapping("/freeTaskList")
    public SaResult getFreeTask() {
        List<CutTask> cutTaskList = cutTaskService.getFreeTaskList();
        return SaResult.data(cutTaskList);
    }

    /**
     * 根据工人id获取所有任务列表
     * @return 任务列表
     */
    @GetMapping("/listByWorkerId")
    public SaResult getWorkListByWorkerId(Long workerId) {
        List<CutWork> cutWorkList = cutWorkService.getWorkListByWorkerId(workerId);
        return SaResult.data(cutWorkList);
    }

    /**
     * 根据id获取任务
     * @param id 任务id
     * @return 任务列表
     */
    @GetMapping("/getWorkById")
    public SaResult getWorkById(@RequestBody Long id) {
        CutWork cutWork = cutWorkService.getWorkById(id);
        return SaResult.data(cutWork);
    }

    /**
     * 申领任务
     * @param taskId 任务id
     * @return affected rows
     */
    @PostMapping("/add")
    public SaResult addWork(Long taskId) {
        int added = cutWorkService.addWork(taskId);
        if (added >= 1) {
            return SaResult.ok().setMsg("领取任务成功");
        }
        return SaResult.error("领取任务失败");
    }

    /**
     * 提交任务
     * @param workId 任务id
     * @return affected rows
     */
    @PostMapping("/finish")
    public SaResult finishWork(Long workId) {
        // TODO 照片提交方式
        int submit = cutWorkService.finishWork(workId);
        if (submit >= 1) {
            return SaResult.ok().setMsg("任务提交成功");
        }else {
            return SaResult.error("任务提交失败");
        }
    }

    /**
     * 审核通过
     * @param workId 任务id
     * @return affected rows
     */
    @PostMapping("/pass")
    public SaResult pass(Long workId) {
        cutWorkService.pass(workId);
        return SaResult.ok().setMsg("审核通过");
    }

    /**
     * 审核不通过
     * @param workId 任务id
     * @return affected rows
     */
    @PostMapping("/fail")
    public SaResult fail(Long workId) {
        cutWorkService.fail(workId);
        return SaResult.ok().setMsg("审核不通过");
    }

    /**
     * 取消任务
     * @param id 任务id
     * @return affected rows
     */
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
