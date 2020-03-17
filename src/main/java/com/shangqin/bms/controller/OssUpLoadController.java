package com.shangqin.bms.controller;

import com.shangqin.bms.service.OssUpLoadService;
import com.shangqin.bms.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @description：TODO
 * @projectName：book-manage
 * @packageName：com.shangqin.bms.service.impl
 * @className：BookServieImpl
 * @createAuthor：zhouyang
 * @createTime：2020/3/13 17:02
 * @version：
 * @Copyright：重庆商勤科技有限公司
 */
@RestController
@CrossOrigin
@RequestMapping("oss/file")
public class OssUpLoadController {
    @Autowired
    OssUpLoadService ossUpLoadService;
    @PostMapping("upload")
    public Response upload(@RequestParam("file") MultipartFile file) {
        String url = ossUpLoadService.uploadFile(file);
        Map<String, String> urlMap = new HashMap<>();
        urlMap.put("url", url);
        return Response.newOkInstance(urlMap);
    }
}
