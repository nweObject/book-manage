package com.shangqin.bms.service;

import com.shangqin.bms.pojo.BookInfo;

import java.util.List;

/**
 * @description：TODO
 * @projectName：book-manage
 * @packageName：com.shangqin.bms.service
 * @className：BookService
 * @createAuthor：zhouyang
 * @createTime：2020/3/13 16:53
 * @version：
 * @Copyright：重庆商勤科技有限公司
 */
public interface BookService {
    List<BookInfo> selectAllBooks();

    void addNewBook(BookInfo bookInfo);

    BookInfo getBookById(Integer bookId);

    List<BookInfo> selectBooksByKeyWords(String keywords);

    void deleteBookById(Integer bookId, Integer lostBookId);
}
