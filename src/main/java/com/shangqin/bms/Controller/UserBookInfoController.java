package com.shangqin.bms.Controller;

import com.shangqin.bms.pojo.UserBookInfo;
import com.shangqin.bms.service.UserBookService;
import com.shangqin.bms.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    UserBookService userBookService;
    /**
     * 借书通过session 获取 userId 并通过bookid查询出BookInfo 封装到UserBookInfo中, 修改图书库中的状态信息，添加书籍借阅人信息
     * */
    @PostMapping("/book")
    public Response addUserBook(HttpServletRequest request, Integer bookId) {
        HttpSession session = request.getSession();

        Map userMap = (HashMap)session.getAttribute("userMap");

        userBookService.addUserBook(bookId,userMap);
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
    public Response updateReturnBookTime(HttpServletRequest request, @RequestParam("userBookId") Integer userBookId, @RequestParam("bookId") Integer bookId) {
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        String result = userBookService.updateReturnBookTime(userBookId, bookId, userId);
        if(request.equals("ok")) {

            return Response.newOkInstance("延期成功");
        }
        return Response.newErrorInstance("已达次数上线，修改失败");
    }

    /**
     * 读者查看借阅详情
     * */
    @GetMapping("/detail")
    public Response getDetailsByUserId(HttpServletRequest request) {
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        List<UserBookInfo> userBookInfoList = userBookService.selectUserBookDetailsByUserId(userId);
        return Response.newOkInstance(userBookInfoList);
    }
}
