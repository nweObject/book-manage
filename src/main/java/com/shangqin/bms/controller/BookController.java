package com.shangqin.bms.controller;

import com.shangqin.bms.pojo.BookInfo;
import com.shangqin.bms.pojo.BorrowerInfo;
import com.shangqin.bms.service.BookService;
import com.shangqin.bms.service.BorrowerInfoService;
import com.shangqin.bms.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Response getAllBook() {
        List<BookInfo> bookInfos = bookService.selectAllBooks();
        return Response.newOkInstance(bookInfos);
    }
    /**
     *   管理员添加图书
     */
    @PostMapping("add")
    public Response addBook(@RequestBody BookInfo bookInfo) {
        try {
            bookService.addNewBook(bookInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.newOkInstance("ok");
    }
    /**
     * 管理员查看书籍的借阅记录
     */
    @GetMapping("info")
    public Response getBookInfoById(@RequestParam("bookId") Integer bookId) {
        BookInfo bookInfo = bookService.getBookById(bookId);
        List<BorrowerInfo> borrowerInfos = borrowerInfoService.selectBorrowerByBookId(bookId);
        bookInfo.setBorrowerInfos(borrowerInfos);
        return Response.newOkInstance(bookInfo);
    }
    /**
     * 读者通过模糊查询来查找相关书籍
     * */
    @GetMapping("/find")
    public Response getBooksByKeyWords(String keywords) {
        List<BookInfo> bookInfos = bookService.selectBooksByKeyWords(keywords);
        return Response.newOkInstance(bookInfos);
    }
    /**
     * 下架书籍
     * */
    @DeleteMapping("delete")
    public Response deleteBook(@RequestParam("bookId") Integer bookId, @RequestParam("lostBookId") Integer lostBookId) {
        bookService.deleteBookById(bookId, lostBookId);
        return Response.newOkInstance("ok");
    }
}
