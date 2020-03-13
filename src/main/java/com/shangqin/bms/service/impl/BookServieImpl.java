package com.shangqin.bms.service.impl;

import com.shangqin.bms.mapper.BookInfoMapper;
import com.shangqin.bms.pojo.BookInfo;
import com.shangqin.bms.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @description：TODO
 * @projectName：book-manage
 * @packageName：com.shangqin.bms.service.impl
 * @className：BookServieImpl
 * @createAuthor：zhouyang
 * @createTime：2020/3/13 17:02
 * @version：
 * @Copyright：重庆商勤科技有限公司
 */
@Service
public class BookServieImpl implements BookService {
    @Autowired
    BookInfoMapper bookInfoMapper;
    /**
     * 查询所有的书籍信息
     * */
    @Override
    public List<BookInfo> selectAllBooks() {
        return bookInfoMapper.selectAll();
    }
    /**
     * 管理员添加新的书籍
     * */
    @Override
    public void addNewBook(BookInfo bookInfo) {
        Date date = new Date();
//        DateFormat dft = new SimpleDateFormat("yyyy-MM-dd E a HH:mm:ss");
//        String format = dft.format(date);
        bookInfo.setCreateTime(date);
        bookInfoMapper.insert(bookInfo);
    }
    /**
     * 通过bookid查询书籍
     * */
    @Override
    public BookInfo getBookById(Integer bookId) {
        BookInfo bookInfo = new BookInfo();
        bookInfo.setId(bookId);
        BookInfo result = bookInfoMapper.selectByPrimaryKey(bookInfo);
        return result;
    }

    /**
     * 关键词查询书籍信息
     * */
    @Override
    public List<BookInfo> selectBooksByKeyWords(String keyword) {
        return bookInfoMapper.selectBookInfo(keyword);
    }

}
