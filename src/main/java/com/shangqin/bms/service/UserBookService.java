package com.shangqin.bms.service;

import com.shangqin.bms.pojo.UserBookInfo;

import java.util.List;
import java.util.Map;

/**
 * @description：TODO
 * @projectName：book-manage
 * @packageName：com.shangqin.bms.service
 * @className：UserBookService
 * @createAuthor：zhouyang
 * @createTime：2020/3/14 10:06
 * @version：
 * @Copyright：重庆商勤科技有限公司
 */
public interface UserBookService {
    void addUserBook(Integer bookId, Map userMap);

    void deleteUserBookInfoById(Integer userBookId, Integer bookId);

    String updateReturnBookTime(Integer userBookId, Integer bookId, Integer userId);

    List<UserBookInfo> selectUserBookDetailsByUserId(Integer userId);

    String recorderBookInfo(Integer userBookId, Integer bookId, Integer userId);

    void updateUserBookInfo(Integer userBookId);
}
