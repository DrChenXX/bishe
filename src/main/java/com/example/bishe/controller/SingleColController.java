package com.example.bishe.controller;

import cn.dev33.satoken.util.SaResult;
import com.example.bishe.model.dto.AddUpdateColForm;
import com.example.bishe.model.dto.RejectColForm;
import com.example.bishe.model.entity.SingleCol;
import com.example.bishe.service.SingleColService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "单次采集信息模块", description = "工人单次采集管理")
@RestController
@RequestMapping("/singleCol")
public class SingleColController {
    @Resource
    private SingleColService singleColService;

    /**
     * 获取全部采集信息
     * @return 全部采集信息
     */
    @GetMapping("/list")
    public SaResult getSingleColList() {
        List<SingleCol> singleColList = singleColService.getSingleColList();
        return SaResult.data(singleColList);
    }

    @GetMapping("/unconfirmedList")
    public SaResult getUnconfirmedSingleColList() {
        List<SingleCol> singleColList = singleColService.getUncomfirmedSingleColList();
        return SaResult.data(singleColList);
    }

    @GetMapping("/listByWorkerId")
    public SaResult getSingleColListByWorkerId(Long workerId) {
        List<SingleCol> singleColList = singleColService.getSingleColListByWorkerId(workerId);
        return SaResult.data(singleColList);
    }

    @GetMapping("/getById")
    public SaResult getSingleColById(Long id) {
        SingleCol singleCol = singleColService.getSingleColById(id);
        return SaResult.data(singleCol);
    }

    @PostMapping("/add")
    public SaResult addSingleCol(@RequestBody AddUpdateColForm addUpdateColForm) {
        int added = singleColService.addSingleCol(addUpdateColForm);
        if (added >= 1) {
            return SaResult.ok().setMsg("添加成功");
        } else {
            return SaResult.error("添加失败");
        }
    }

    @PostMapping("/confirm")
    public SaResult confirmSingleCol(Long id) {
        int confirmed = singleColService.comfirmSingleCol(id);
        if (confirmed >= 1) {
            return SaResult.ok().setMsg("确认成功");
        } else {
            return SaResult.error("确认失败");
        }
    }


    @PostMapping("/fail")
    public SaResult failSingleCol(@RequestBody RejectColForm rejectColForm) {
        int failed = singleColService.rejectSingleCol(rejectColForm);
        if (failed >= 1) {
            return SaResult.ok().setMsg("拒绝成功");
        } else {
            return SaResult.error("拒绝失败");
        }
    }

    @PostMapping("/delete")
    public SaResult deleteSingleCol(Long id) {
        int deleted = singleColService.deleteSingleCol(id);
        if (deleted >= 1) {
            return SaResult.ok().setMsg("删除成功");
        } else {
            return SaResult.error("删除失败");
        }
    }
}
