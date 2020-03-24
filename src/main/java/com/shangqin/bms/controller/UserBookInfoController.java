package com.shangqin.bms.controller;

import com.shangqin.bms.pojo.LostRecorder;
import com.shangqin.bms.pojo.UserBookInfo;
import com.shangqin.bms.pojo.vo.Recorder;
import com.shangqin.bms.pojo.vo.Review;
import com.shangqin.bms.pojo.vo.UpdateUserBook;
import com.shangqin.bms.service.UserBookService;
import com.shangqin.bms.utils.Response;
import com.shangqin.bms.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @description：TODO
 * @projectName：book-manage
 * @packageName：com.shangqin.bms.Controller
 * @className：UserBookInfoController
 * @createAuthor：zhouyang
 * @createTime：2020/3/14 10:02
 * @version：
 * @Copyright：重庆商勤科技有限公司
 */
@RestController
@RequestMapping("/borrower")
public class UserBookInfoController {
    private static final String FLAG = "ok";
    @Autowired
    UserBookService userBookService;

    /**
     * 借书通过session 获取 userId 并通过bookid查询出BookInfo 封装到UserBookInfo中, 修改图书库中的状态信息，添加书籍借阅人信息
     * */
    @GetMapping ("/book")
    public Response addUserBook(HttpServletRequest request, @RequestParam("bookId") Integer bookId) {
        HttpSession session = request.getSession();

        Map userMap = (HashMap)session.getAttribute("userMap");

        try {
            userBookService.addUserBook(bookId, userMap);
        } catch (Exception e) {
            return Response.newErrorInstance("该书籍已被借出");
        }
        return Response.newOkInstance("借书成功");
    }
    /**
     * 归还书籍 ： 删除UserBookInfo信息，修改图书库状态信息
     * */
    @DeleteMapping("/return")
    public Response returnBook(@RequestParam("userBookId") Integer userBookId, @RequestParam("bookId") Integer bookId) {
        userBookService.deleteUserBookInfoById(userBookId, bookId);
        return Response.newOkInstance("归还书籍成功");
    }
    /**
     * 延期归还书籍 ，修改书籍的延期次数，修改书籍的归还时间
     * */
    @PutMapping("/update")
    public Response updateReturnBookTime(@RequestBody UpdateUserBook updateUserBook, HttpServletRequest request) {
        Integer userBookId = updateUserBook.getUserbookId();
        Integer bookId = updateUserBook.getBookId();
        //工具类获取userId
        Integer userId = SessionUtil.getUserId(request);
        String result = userBookService.updateReturnBookTime(userBookId, bookId, userId);
        if(FLAG.equals(result)) {

            return Response.newOkInstance("延期成功");
        }
        return Response.newErrorInstance("已达次数上线，修改失败");
    }

    /**
     * 读者查看借阅详情
     * */
    @GetMapping("/detail")
    public Response getDetailsByUserId(HttpServletRequest request) {
        //工具类获取userId
        Integer userId = SessionUtil.getUserId(request);
        List<UserBookInfo> userBookInfoList = userBookService.selectUserBookDetailsByUserId(userId);
        return Response.newOkInstance(userBookInfoList);
    }
    /**
     * 遗失书籍登记  添加书籍遗失记录
     * */
    @PutMapping("/lost")
    public Response lostBook(@RequestBody Recorder recorder) {
        Integer userBookId = recorder.getUserBookId();
        userBookService.updateUserBookInfo(userBookId);
        return Response.newOkInstance("ok");
    }
    /**
     * 赔偿
     * */
    @PostMapping("compensation")
    public Response compensationBook(@RequestBody Recorder recorder) {
        Integer bookId = recorder.getBookId();
        Integer userBookId = recorder.getUserBookId();
        Integer userId = recorder.getUserId();
        String result = userBookService.recorderBookInfo(userBookId, bookId, userId);
        return Response.newOkInstance("ok");
    }
    /**
     * 查询所有遗失记录
     * */
    @GetMapping("lostBooks")
    public Response getLostReview() {
        List<LostRecorder> lostRecorders = userBookService.selectLostRecorder();
        return Response.newOkInstance(lostRecorders);
    }
    /**
     * 管理员审核已经赔偿过得书籍
     * */
    @PutMapping("/review")
    public Response reviewBook(@RequestBody Review review) {
        Integer lostBookId = review.getLostBookId();
        userBookService.reviewLostBookById(lostBookId);
        return Response.newOkInstance("ok");
    }
}
