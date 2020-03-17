package com.shangqin.bms.controller;

import com.shangqin.bms.pojo.User;
import com.shangqin.bms.service.UserService;
import com.shangqin.bms.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @className：UserController
 * @createAuthor：zhouyang
 * @createTime：2020/3/14 10:19
 * @version：
 * @Copyright：重庆商勤科技有限公司
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/login")
    public Response login(@RequestParam("phoneNum") String phoneNum, @RequestParam("password") String password, HttpServletRequest request) {
        HttpSession session = request.getSession();
        List<User> users = userService.toLogin(phoneNum, password);
        if(users.size() != 0 && null != users.get(0)) {
            Integer userId = users.get(0).getId();
            String username = users.get(0).getUsername();
            Integer identify = users.get(0).getIdentify();
            Integer age = users.get(0).getAge();
            Map<String, Object> userMap = new HashMap<>();
            userMap.put("userId", userId);
            userMap.put("username", username);
            userMap.put("identify", identify);
            userMap.put("age",age);
            session.setAttribute("userMap", userMap);
            return Response.newOkInstance(userMap);
        }
        return Response.newErrorInstance("密码或账号错误");
    }
}
