package com.example.bishe.controller;

import cn.dev33.satoken.util.SaResult;
import com.example.bishe.service.PicService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Tag(name = "照片管理模块", description = "照片上传和下载")
@RestController
@RequestMapping("/pic")
public class PicController {

    @Resource
    private PicService picService;


    @PostMapping("/upload")
    public SaResult Upload(@RequestPart("file") MultipartFile file){
        String fileUrl = picService.upload(file);

        return SaResult.ok("上传成功").setData(fileUrl);
    }

    @PostMapping("/uploadfile")
    public SaResult Upload(String filePath){
        String fileUrl = picService.uploadFile(filePath);

        return SaResult.ok("上传成功").setData(fileUrl);
    }
}
