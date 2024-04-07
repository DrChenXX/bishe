package com.example.bishe.service;

import com.example.bishe.model.entity.Pic;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

/**
* @author talha
* @description 针对表【pic】的数据库操作Service
* @createDate 2024-04-03 11:11:29
*/
public interface PicService extends IService<Pic> {

    /**
     * 上传文件
     * @param file 表单文件对象
     * @return 文件url
     */
    String uploadFile(MultipartFile file);

    /**
     * 删除文件
     *
     * @param filePath 文件完整URL
     * @return 删除结果
     */
    boolean deleteFile(String filePath);

}
