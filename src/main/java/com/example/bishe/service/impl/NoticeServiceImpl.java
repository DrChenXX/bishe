package com.example.bishe.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bishe.mapper.MessageMapper;
import com.example.bishe.mapper.WorkerMapper;
import com.example.bishe.model.dto.AddUpdateNoticeForm;
import com.example.bishe.model.entity.Message;
import com.example.bishe.model.entity.Notice;
import com.example.bishe.model.entity.Worker;
import com.example.bishe.service.NoticeService;
import com.example.bishe.mapper.NoticeMapper;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description 针对表【notice】的数据库操作Service实现
* @createDate 2024-04-03 11:11:29
*/
@Service
@RequiredArgsConstructor
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice>
    implements NoticeService {

    @Resource
    private NoticeMapper noticeMapper;

    @Resource
    private MessageMapper messageMapper;

    @Resource
    private WorkerMapper workerMapper;

    @Override
    public List<Notice> getNoticeList() {
        return this.list();
    }

    @Override
    public int addNotice(AddUpdateNoticeForm addUpdateNoticeForm) {
        Notice notice = new Notice();
        notice.setType(addUpdateNoticeForm.getType());
        notice.setTarget(addUpdateNoticeForm.getTargetId());
        notice.setContent(addUpdateNoticeForm.getContent());
        return noticeMapper.insert(notice);
    }

    @Override
    public int deleteNotice(Long id) {
        messageMapper.deleteByNoticeId(String.valueOf(id));
        return noticeMapper.deleteById(id);
    }

    @Override
    public int updateNotice(Long id, AddUpdateNoticeForm addUpdateNoticeForm) {
        Notice notice = noticeMapper.selectById(id);
        if (notice.getType().equals("4")) {
            return 0;
        }
        notice.setType(addUpdateNoticeForm.getType());
        notice.setTarget(addUpdateNoticeForm.getTargetId());
        notice.setContent(addUpdateNoticeForm.getContent());
        return noticeMapper.updateById(notice);
    }

    @Override
    public Notice getNoticeById(Long id) {
        return noticeMapper.selectById(id);
    }

    @Override
    public int publishNotice(Long id) {
        Notice notice = noticeMapper.selectById(id);
        if (notice.getType().equals("1")) {
            List<Worker> workerList = workerMapper.searchAll();
            for (Worker worker : workerList) {
                Message message = new Message();
                message.setNoticeId(notice.getId());
                message.setWorkerId(worker.getId());
                message.setRead("0");
                messageMapper.insert(message);
            }
        }
        if (notice.getType().equals("2")) {
            Worker worker = new Worker();
            worker.setFarmId(notice.getTarget());
            List<Worker> workerList = workerMapper.searchByFarmId(worker);
            for (Worker worker1 : workerList) {
                Message message = new Message();
                message.setNoticeId(notice.getId());
                message.setWorkerId(worker1.getId());
                message.setRead("0");
                messageMapper.insert(message);
            }
        }
        if (notice.getType().equals("3")) {
            Worker worker = workerMapper.selectById(notice.getTarget());
            Message message = new Message();
            message.setNoticeId(notice.getId());
            message.setWorkerId(worker.getId());
            message.setRead("0");
            messageMapper.insert(message);
        }
        notice.setType("4");
        return noticeMapper.updateById(notice);
    }
}




