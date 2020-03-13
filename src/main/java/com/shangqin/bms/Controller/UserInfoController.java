package com.shangqin.bms.Controller;

import com.shangqin.bms.pojo.UserInfo;
import com.shangqin.bms.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description：TODO
 * @projectName：book-manage
 * @packageName：com.shangqin.bms.Controller
 * @className：UserInfoController
 * @createAuthor：zhouyang
 * @createTime：2020/3/13 18:01
 * @version：
 * @Copyright：重庆商勤科技有限公司
 */
@RestController
@RequestMapping("/user")
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;
    //管理员查看用户信息接口
    public List<UserInfo> getAllUserInfo() {
        List<UserInfo> userInfos = userInfoService.getAllUserInfo();
        return userInfos;
    }
}
