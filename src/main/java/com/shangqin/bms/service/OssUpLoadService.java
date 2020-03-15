package com.shangqin.bms.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author zy
 * @creat 2019-12-{DAY}-{TIME}
 */
public interface OssUpLoadService {
    String uploadFile(MultipartFile file);
}
