package com.example.bishe.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bishe.model.entity.Notice;
import com.example.bishe.service.NoticeService;
import com.example.bishe.mapper.NoticeMapper;
import org.springframework.stereotype.Service;

/**
* @author talha
* @description 针对表【notice】的数据库操作Service实现
* @createDate 2024-04-03 11:11:29
*/
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice>
    implements NoticeService {

}




