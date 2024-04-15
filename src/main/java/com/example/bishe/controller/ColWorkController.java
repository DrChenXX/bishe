package com.example.bishe.controller;

import cn.dev33.satoken.util.SaResult;
import com.example.bishe.model.entity.ColTask;
import com.example.bishe.model.entity.ColWork;
import com.example.bishe.service.ColTaskService;
import com.example.bishe.service.ColWorkService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "工人采集任务模块", description = "工人采集任务管理")
@RestController
@RequestMapping("/colWork")
public class ColWorkController {
    @Resource
    private ColWorkService colWorkService;

    @Resource
    private ColTaskService colTaskService;

    /**
     * 获取未被领取的工人采集任务列表
     * @return 未被领取的工人采集任务列表
     */
    @GetMapping("/freeColTaskList")
    public SaResult getFreeColTaskList() {
        List<ColTask> colTaskList = colTaskService.getFreeColTasks();
        return SaResult.data(colTaskList);
    }

    /**
     * 根据工人id获取该工人的采集任务列表
     * @param workerId 工人id
     * @return 该工人的采集任务列表
     */
    @GetMapping("/listByWorkerId")
    public SaResult getWorkListByWorkerId(Long workerId) {
        List<ColWork> colWorkList = colWorkService.getColWorkListByWorkerId(workerId);
        return SaResult.data(colWorkList);
    }

    /**
     * 根据ID获取任务详情
     * @param id 任务ID
     * @return 任务详情
     */
    @GetMapping("/getColWorkById")
    public SaResult getColWorkById(Long id) {
        ColWork colWork = colWorkService.getColWorkById(id);
        return SaResult.data(colWork);
    }

    /**
     * 领取任务
     * @param id 任务ID
     * @return 领取结果
     */
    @PostMapping("/add")
    public SaResult addWork(Long id) {
        int added = colWorkService.addWork(id);
        if (added >= 1) {
            return SaResult.ok().setMsg("领取任务成功");
        }
        return SaResult.error("领取任务失败");
    }

    /**
     * 提交任务
     * @param id 任务ID
     * @return 提交结果
     */
    @PostMapping("/finish")
    public SaResult finishWork(Long id) {
        int finished = colWorkService.submit(id);
        if (finished >= 1) {
            return SaResult.ok().setMsg("提交任务成功");
        }
        return SaResult.error("提交任务失败");
    }

    /**
     * 取消任务
     * @param id 任务ID
     * @return 取消结果
     */
    @DeleteMapping("/delete")
    public SaResult deleteWork(Long id) {
        int deleted = colWorkService.deleteWork(id);
        if (deleted >= 1) {
            return SaResult.ok().setMsg("取消任务成功");
        }
        return SaResult.error("取消任务失败");
    }
}
