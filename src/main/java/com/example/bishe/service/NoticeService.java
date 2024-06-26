package com.example.bishe.service;

import com.example.bishe.model.dto.AddUpdateNoticeForm;
import com.example.bishe.model.entity.Notice;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @description 针对表【notice】的数据库操作Service
* @createDate 2024-04-03 11:11:29
*/
public interface NoticeService extends IService<Notice> {
    List<Notice> getNoticeList();

    int addNotice(AddUpdateNoticeForm addUpdateNoticeForm);

    int deleteNotice(Long id);

    int updateNotice(Long id, AddUpdateNoticeForm addUpdateNoticeForm);

    Notice getNoticeById(Long id);

    int publishNotice(Long id);
}
