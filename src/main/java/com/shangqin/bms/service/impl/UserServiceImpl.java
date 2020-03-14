package com.shangqin.bms.service.impl;

import com.shangqin.bms.mapper.UserInfoMapper;
import com.shangqin.bms.mapper.UserMapper;
import com.shangqin.bms.pojo.User;
import com.shangqin.bms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @description：TODO
 * @projectName：book-manage
 * @packageName：com.shangqin.bms.service.impl
 * @className：UserServiceImpl
 * @createAuthor：zhouyang
 * @createTime：2020/3/14 10:47
 * @version：
 * @Copyright：重庆商勤科技有限公司
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> toLogin(String phoneNum, String password) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("phoneNum", phoneNum).andEqualTo("psw",password);
        return userMapper.selectByExample(example);
    }
}
