package com.shangqin.bms.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @description：TODO
 * @projectName：book-manage
 * @packageName：com.shangqin.bms.pojo
 * @className：LostBookInfo
 * @createAuthor：zhouyang
 * @createTime：2020/3/19 09:42
 * @version：
 * @Copyright：重庆商勤科技有限公司
 */
@Data
@Getter
@Setter
public class LostRecorder {
    private Integer id;
    private Integer userId;
    private Integer bookId;
    private String userName;
    private String bookName;
    private String recorderTime;
    private Integer status;
}
