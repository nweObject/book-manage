package com.shangqin.bms.service.impl;

import com.shangqin.bms.mapper.BookInfoMapper;
import com.shangqin.bms.pojo.BookInfo;
import com.shangqin.bms.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Override
    public List<BookInfo> selectAllBooks() {
        return bookInfoMapper.selectAll();
    }

}
