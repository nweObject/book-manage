package com.shangqin.bms.config;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import lombok.Data;;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description：TODO
 * @projectName：book-manage
 * @packageName：com.shangqin.bms.config
 * @className：AliyunConfig
 * @createAuthor：zhouyang
 * @createTime：2020/3/14 16:18
 * @version：
 * @Copyright：重庆商勤科技有限公司
 */
@Configuration
@Data
public class AliyunConfig {

    // 地域节点
    @Value("${aliyun.oss.endpoint}")
    private String endpoint;
    @Value("${aliyun.accessKeyId}")
    private String accessKeyId;
    @Value("${aliyun.accessKeySecret}")
    private String accessKeySecret;

    @Value("${aliyun.oss.bucketName}")
    private String bucketName;
    @Value("${aliyun.oss.urlPrefix}")
    private String urlPrefix;

    @Bean
    public OSS ossClient() {
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        return ossClient;
    }
}
