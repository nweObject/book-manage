package com.shangqin.bms.service.impl;

import com.shangqin.bms.mapper.UserInfoMapper;
import com.shangqin.bms.pojo.UserInfo;
import com.shangqin.bms.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description：TODO
 * @projectName：book-manage
 * @packageName：com.shangqin.bms.service.impl
 * @className：UserInfoServiceImpl
 * @createAuthor：zhouyang
 * @createTime：2020/3/13 18:06
 * @version：
 * @Copyright：重庆商勤科技有限公司
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserInfoMapper userInfoMapper;
    //查询所有的用户信息
    @Override
    public List<UserInfo> getAllUserInfo() {
        return userInfoMapper.selectAll();
    }

}
