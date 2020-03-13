package com.shangqin.bms.Controller;

import com.shangqin.bms.pojo.BookInfo;
import com.shangqin.bms.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description：TODO
 * @projectName：book-manage
 * @packageName：com.shangqin.bms.Controller
 * @className：BookController
 * @createAuthor：zhouyang
 * @createTime：2020/3/13 16:50
 * @version：
 * @Copyright：重庆商勤科技有限公司
 */
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;
    @GetMapping("all")
    public List<BookInfo> getAllBook() {
        List<BookInfo> bookInfos = bookService.selectAllBooks();
        return bookInfos;
    }
}
