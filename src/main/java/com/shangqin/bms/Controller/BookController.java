package com.shangqin.bms.Controller;

import com.shangqin.bms.pojo.BookInfo;
import com.shangqin.bms.pojo.BorrowerInfo;
import com.shangqin.bms.service.BookService;
import com.shangqin.bms.service.BorrowerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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
    @Autowired
    BorrowerInfoService borrowerInfoService;
    @GetMapping("all")
    public List<BookInfo> getAllBook() {
        List<BookInfo> bookInfos = bookService.selectAllBooks();
        return bookInfos;
    }
    //管理员添加图书
    @PostMapping("add")
    public String addBook(@RequestBody BookInfo bookInfo) {
        try {
            bookService.addNewBook(bookInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok";
    }
    //管理员查看书籍的借阅记录
    @GetMapping("info")
    public BookInfo getBookInfoById(@RequestParam("bookId") Integer bookId) {
        BookInfo bookInfo = bookService.getBookById(bookId);
        List<BorrowerInfo> borrowerInfos = borrowerInfoService.selectBorrowerByBookId(bookId);
        bookInfo.setBorrowerInfos(borrowerInfos);
        return bookInfo;
    }
    /**
     * 读者通过模糊查询来查找相关书籍
     * */
    @GetMapping("/find")
    public List<BookInfo> getBooksByKeyWords(String keywords) {
        List<BookInfo> bookInfos = bookService.selectBooksByKeyWords(keywords);
        return bookInfos;
    }

}
