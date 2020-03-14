package com.shangqin.bms.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Table;

/**
 * @description：TODO
 * @projectName：book-manage
 * @packageName：com.shangqin.bms.pojo
 * @className：BorrowerInfo
 * @createAuthor：zhouyang
 * @createTime：2020/3/13 16:26
 * @version：
 * @Copyright：重庆商勤科技有限公司
 */
@Data
@Getter
@Setter
@Table(name = "borrower_info")
public class BorrowerInfo {

    private Integer id;
    private Integer userId;
    private Integer bookId;
    private String username;
    private Integer age;
    private String returnTime;
}
