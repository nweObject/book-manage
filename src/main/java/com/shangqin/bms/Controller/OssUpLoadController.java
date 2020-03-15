package com.shangqin.bms.Controller;

import com.shangqin.bms.service.OssUpLoadService;
import com.shangqin.bms.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zy
 * @creat 2019-12-{DAY}-{TIME}
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
