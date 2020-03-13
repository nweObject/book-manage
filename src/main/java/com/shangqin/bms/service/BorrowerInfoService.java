package com.shangqin.bms.service;

import com.shangqin.bms.pojo.BorrowerInfo;

import java.util.List;

/**
 * @description：TODO
 * @projectName：book-manage
 * @packageName：com.shangqin.bms.service
 * @className：BorrowerInfoService
 * @createAuthor：zhouyang
 * @createTime：2020/3/13 18:31
 * @version：
 * @Copyright：重庆商勤科技有限公司
 */
public interface BorrowerInfoService {
    List<BorrowerInfo> selectBorrowerByBookId(Integer bookId);
}
