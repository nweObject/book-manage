package com.shangqin.bms.service;

import com.shangqin.bms.pojo.User;

import java.util.List;

/**
 * @description：TODO
 * @projectName：book-manage
 * @packageName：com.shangqin.bms.service
 * @className：UserService
 * @createAuthor：zhouyang
 * @createTime：2020/3/14 10:47
 * @version：
 * @Copyright：重庆商勤科技有限公司
 */
public interface UserService {
    List<User> toLogin(String phoneNum, String password);
}
