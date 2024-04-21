package com.example.bishe.controller;

import cn.dev33.satoken.util.SaResult;
import com.example.bishe.model.dto.AddUpdateNoticeForm;
import com.example.bishe.model.entity.Notice;
import com.example.bishe.service.NoticeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "公告管理模块", description = "公告信息")
@RestController
@RequestMapping("/notice")
public class NoticeController {
    @Resource
    private NoticeService noticeService;

    @GetMapping("/list")
    public SaResult getAlllist() {
        List<Notice> notices = noticeService.getNoticeList();
        return SaResult.data(notices);
    }

    @PostMapping("/get")
    public SaResult getNoticeById(Long id) {
        Notice notice = noticeService.getNoticeById(id);
        return SaResult.data(notice);
    }

    @PostMapping("/add")
    public SaResult addNotice(@RequestBody AddUpdateNoticeForm addUpdateNoticeForm) {
        int added = noticeService.addNotice(addUpdateNoticeForm);
        if (added >= 1) {
            return SaResult.ok().setMsg("通知添加成功");
        }
        return SaResult.error("通知添加失败");
    }

    @PostMapping("/update")
    public SaResult updateNotice(Long id, @RequestBody AddUpdateNoticeForm addUpdateNoticeForm) {
        int updated = noticeService.updateNotice(id, addUpdateNoticeForm);
        if (updated >= 1) {
            return SaResult.ok().setMsg("通知更新成功");
        }
        return SaResult.error("通知更新失败");
    }

    @DeleteMapping("/delete")
    public SaResult deleteNotice(Long id) {
        int deleted = noticeService.deleteNotice(id);
        if (deleted >= 1) {
            return SaResult.ok().setMsg("通知删除成功");
        }
        return SaResult.error("通知删除失败");
    }

    @PostMapping("/publish")
    public SaResult publishNotice(Long id) {
        int published = noticeService.publishNotice(id);
        if (published >= 1) {
            return SaResult.ok().setMsg("通知发布成功");
        }
        return SaResult.error("通知发布失败");
    }
}
