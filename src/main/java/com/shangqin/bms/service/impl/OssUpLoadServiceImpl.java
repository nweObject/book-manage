package com.shangqin.bms.service.impl;

import com.aliyun.oss.OSSClient;

import com.shangqin.bms.service.OssUpLoadService;
import com.shangqin.bms.utils.ConstantPropertiesUtil;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author zy
 * @creat 2019-12-{DAY}-{TIME}
 */
@Service
public class OssUpLoadServiceImpl implements OssUpLoadService {
    @Override
    public String uploadFile(MultipartFile file) {
        if(file == null) {
            throw new RuntimeException();
        }
        int index = file.getOriginalFilename().indexOf(".");
        String suffixName = file.getOriginalFilename().substring(index);
        List<String> list = new ArrayList<>();
        list.add(".jpge");
        list.add(".jpg");
        list.add(".png");
        list.add(".bmp");
        Boolean flag = false;
        for (String sufn : list) {
            if(suffixName.equals(sufn)) {
                flag = true;
                break;
            }
        }
        if(!flag) {
            throw new RuntimeException("格式不正确");
        }
        try {
            //验证图片内容是否合法
            BufferedImage read = ImageIO.read(file.getInputStream());
            if(read == null) {
                System.out.println("图片内容不和法");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String newFileName = UUID.randomUUID().toString() + suffixName;
        String dataPath = new DateTime().toString("yyyy/MM/dd");
        String path = ConstantPropertiesUtil.FILE_HOST + "/" +dataPath + "/" + newFileName;
        String url = "";
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(ConstantPropertiesUtil.END_POINT, ConstantPropertiesUtil.ACCESS_KEY_ID,
                ConstantPropertiesUtil.ACCESS_KEY_SECRET);
        // 上传文件流。
        try {
            ossClient.putObject(ConstantPropertiesUtil.BUCKET_NAME, path,
                    file.getInputStream());
            url = "https://" + ConstantPropertiesUtil.BUCKET_NAME + "." + ConstantPropertiesUtil.END_POINT + "/" + path;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭OSSClient。
            ossClient.shutdown();
        }
        System.out.println(url);
        return url;
    }
}
