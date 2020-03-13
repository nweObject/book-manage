package com.shangqin.bms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @description：TODO
 * @projectName：book-manage
 * @packageName：com.shangqin.bms
 * @className：BookManageApplication
 * @createAuthor：zhouyang
 * @createTime：2020/3/13 15:43
 * @version：
 * @Copyright：重庆商勤科技有限公司
 */
@MapperScan("com.shangqin.bms.mapper")
@SpringBootApplication
public class BookManageApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookManageApplication.class, args);
    }
}
