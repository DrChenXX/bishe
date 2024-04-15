package com.example.bishe.controller;

import cn.dev33.satoken.util.SaResult;
import com.example.bishe.model.entity.SingleCut;
import com.example.bishe.service.SingleCutService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "单词砍伐模块", description = "单词砍伐模块的接口")
@RestController
@RequestMapping("/singleCut")
public class SingleCutController {
    @Resource
    private SingleCutService singleCutService;

    /**
     * 管理员查看未审核的单次砍伐列表
     */
    @GetMapping("/unconfirmedCutList")
    public SaResult unconfirmedCutList() {
        List<SingleCut> unconfirmedCutList = singleCutService.getUncomfirmedSingleCutList();
        return SaResult.data(unconfirmedCutList);
    }

    /**
     * 工人查看自己的单次砍伐列表
     */
    @GetMapping("/myCutList")
    public SaResult myCutList(@RequestBody Long workerId) {
        List<SingleCut> myCutList = singleCutService.getSingleCutByWorkerId(workerId);
        return SaResult.data(myCutList);
    }

    /**
     * 工人查看自己未通过的单次砍伐列表
     */
    @GetMapping("/myUnpassedCutList")
    public SaResult myUnpassedCutList(@RequestBody Long workerId) {
        List<SingleCut> myUnpassedCutList = singleCutService.getFailedSingleCutListByWorkerId(workerId);
        return SaResult.data(myUnpassedCutList);
    }

    /**
     * 通过某次任务查看所有砍伐记录
     */
    @GetMapping("/singleCutByWorkId")
    public SaResult singleCutByWorkId(@RequestBody Long workId) {
        List<SingleCut> singleCutByWorkId = singleCutService.getSingleCutByWorkId(workId);
        return SaResult.data(singleCutByWorkId);
    }

}
