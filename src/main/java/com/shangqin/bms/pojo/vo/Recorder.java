package com.shangqin.bms.pojo.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @description：TODO
 * @projectName：book-manage
 * @packageName：com.shangqin.bms.pojo.vo
 * @className：Recorder
 * @createAuthor：zhouyang
 * @createTime：2020/3/19 09:58
 * @version：
 * @Copyright：重庆商勤科技有限公司
 */
@Data
@Getter
@Setter
public class Recorder {
    private Integer userBookId;
    private Integer BookId;
    private Integer userId;
}
