package com.shangqin.bms.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * @description：TODO
 * @projectName：book-manage
 * @packageName：com.shangqin.bms.pojo
 * @className：BookInfo
 * @createAuthor：zhouyang
 * @createTime：2020/3/13 16:21
 * @version：
 * @Copyright：重庆商勤科技有限公司
 */
@Data
@Getter
@Setter
@Table(name="book_info")
public class BookInfo {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;
    private String bookName;
    private String description;
    private Integer price;
    private String bookImg;
    private Date createTime;
    private Integer status;
    List<BorrowerInfo> borrowerInfos;
}
