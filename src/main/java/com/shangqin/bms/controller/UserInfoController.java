package com.shangqin.bms.controller;

import com.shangqin.bms.pojo.UserInfo;
import com.shangqin.bms.service.UserInfoService;
import com.shangqin.bms.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    /**
     * 管理员查看用户信息接口
     */
    @GetMapping("userInfo")
    public Response getAllUserInfo() {
        List<UserInfo> userInfos = userInfoService.getAllUserInfo();
        List<Map> userList = new ArrayList<>();
        for (UserInfo userInfo : userInfos) {
            Map<String, Object> userMap = new HashMap();
            userMap.put("id", userInfo.getId());
            userMap.put("age", userInfo.getAge());
            userMap.put("phoneNum", userInfo.getPhoneNum());
            userMap.put("username", userInfo.getUsername());
            if(1 == userInfo.getIdentify()) {
                userMap.put("identify", "普通用户");
            }else {
                userMap.put("identify", "管理员");
            }
            userList.add(userMap);
        }
        return Response.newOkInstance(userList);
    }
}
