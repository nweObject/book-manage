package com.shangqin.bms.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @description：TODO
 * @projectName：book-manage
 * @packageName：com.shangqin.bms.pojo
 * @className：UserBookInfo
 * @createAuthor：zhouyang
 * @createTime：2020/3/13 16:07
 * @version：
 * @Copyright：重庆商勤科技有限公司
 */
@Data
@Getter
@Setter
@Table(name = "user_book_info")
public class UserBookInfo {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;
    private Integer userId;
    private Integer bookId;
    private String bookName;
    private String bookImg;
    private Date createTime;
    private String returnTime;
    private Integer status;
    private Integer renewzCount; //延期不能超过两次
    private Integer status2;
}
