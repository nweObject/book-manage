package com.shangqin.bms.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author zy
 * @creat 2019-12-{DAY}-{TIME}
 */
@Component
public class ConstantPropertiesUtil implements InitializingBean {
    @Value("${aliyun.oss.file.endpoint}")
    private String endpoint;
    @Value("${aliyun.oss.file.keyid}")
    private String keyid;
    @Value("${aliyun.oss.file.keysecret}")
    private String keysecret;
    @Value("${aliyun.oss.file.bucketname}")
    private String bucketname;
    @Value("${aliyun.oss.file.filehost}")
    private String filehost;

    public static String END_POINT;
    public static String ACCESS_KEY_ID;
    public static String ACCESS_KEY_SECRET;
    public static String BUCKET_NAME;
    public static String FILE_HOST ;

    @Override
    public void afterPropertiesSet() throws Exception {
        this.END_POINT = endpoint;
        this.ACCESS_KEY_ID = keyid;
        this.ACCESS_KEY_SECRET = keysecret;
        this.BUCKET_NAME = bucketname;
        this.FILE_HOST = filehost;
    }
}

