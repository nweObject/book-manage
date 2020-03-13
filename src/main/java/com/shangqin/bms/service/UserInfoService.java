package com.shangqin.bms.service;

import com.shangqin.bms.pojo.UserInfo;

import java.util.List;

/**
 * @description：TODO
 * @projectName：book-manage
 * @packageName：com.shangqin.bms.service
 * @className：UserInfoService
 * @createAuthor：zhouyang
 * @createTime：2020/3/13 18:03
 * @version：
 * @Copyright：重庆商勤科技有限公司
 */
public interface UserInfoService {
    List<UserInfo> getAllUserInfo();
}
