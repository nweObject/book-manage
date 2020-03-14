package com.shangqin.bms.service.impl;

import com.shangqin.bms.mapper.BookInfoMapper;
import com.shangqin.bms.mapper.BorrowerInfoMapper;
import com.shangqin.bms.mapper.UserBookMapper;
import com.shangqin.bms.pojo.BookInfo;
import com.shangqin.bms.pojo.BorrowerInfo;
import com.shangqin.bms.pojo.UserBookInfo;
import com.shangqin.bms.service.UserBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @description：TODO
 * @projectName：book-manage
 * @packageName：com.shangqin.bms.service.impl
 * @className：UserBookServiceImpl
 * @createAuthor：zhouyang
 * @createTime：2020/3/14 10:07
 * @version：
 * @Copyright：重庆商勤科技有限公司
 */
@Service
public class UserBookServiceImpl implements UserBookService {
    @Autowired
    UserBookMapper userBookMapper;

    @Autowired
    BookInfoMapper bookInfoMapper;

    @Autowired
    BorrowerInfoMapper borrowerInfoMapper;
    /**
     * 通过booId查询出需要被借阅的书籍的信息
     * */
    @Override
    public void addUserBook(Integer bookId, Map userMap) {
        Integer userId = (Integer)userMap.get("userId");
        String username = (String) userMap.get("username");
        Integer age = (Integer) userMap.get("age");
        UserBookInfo userBookInfo = new UserBookInfo();
        BookInfo bookInfo = new BookInfo();
        bookInfo.setId(bookId);
        BookInfo bookInfo1 = bookInfoMapper.selectByPrimaryKey(bookInfo);
        //被借阅书籍的信息
        userBookInfo.setBookId(bookId);
        userBookInfo.setBookImg(bookInfo1.getBookImg());
        userBookInfo.setCreateTime(new Date());
        userBookInfo.setRenewzCount(0);
        userBookInfo.setUserId(userId);
        userBookInfo.setBookName(bookInfo1.getBookName());
        userBookInfo.setStatus(0);
        userBookInfo.setReturnTime(plusDay(13));
        int userBookId = userBookMapper.insertSelective(userBookInfo);

        //修改图书馆被借用书籍的状态
        bookInfo1.setStatus(1);
        bookInfoMapper.updateByPrimaryKey(bookInfo1);
        //添加图书借阅人信息
        BorrowerInfo borrowerInfo = new BorrowerInfo();
        borrowerInfo.setAge(age);
        borrowerInfo.setBookId(bookId);
        borrowerInfo.setUserId(userId);
        borrowerInfo.setUsername(username);
        borrowerInfo.setReturnTime(plusDay(13));
        borrowerInfoMapper.insert(borrowerInfo);
    }
    /**
     * 归还书籍 ： 删除UserBookInfo信息，修改图书库状态信息
     * */
    @Override
    public void deleteUserBookInfoById(Integer userBookId, Integer bookId) {
        UserBookInfo userBookInfo = new UserBookInfo();
        userBookInfo.setId(userBookId);
        userBookMapper.deleteByPrimaryKey(userBookInfo);
        //修改图书库该图书状态信息
        BookInfo bookInfo = new BookInfo();
        bookInfo.setId(bookId);
        bookInfo.setStatus(0);
        bookInfoMapper.updateByPrimaryKey(bookInfo);
    }
    /**
     * 延期归还书籍，修改userBookInfo的归还时间，修改借阅人的归还时间
     * */
    @Override
    public String updateReturnBookTime(Integer userBookId, Integer bookId,Integer userId) {
        UserBookInfo userBookInfo = new UserBookInfo();
        userBookInfo.setId(bookId);
        UserBookInfo userBookInfo1 = userBookMapper.selectByPrimaryKey(userBookInfo);
        if(userBookInfo1.getRenewzCount() <=2) {
            userBookInfo1.setRenewzCount(userBookInfo1.getRenewzCount()+1);
            userBookInfo1.setReturnTime(plusDay(13));
            userBookMapper.updateByPrimaryKey(userBookInfo1);
        }else {
            return "erro";
        }
        //修改借阅人归还书籍时间
        BorrowerInfo borrowerInfo = new BorrowerInfo();
        borrowerInfo.setReturnTime(plusDay(13));
        Example example = new Example(BorrowerInfo.class);
        example.createCriteria().andEqualTo("userId",userId).andEqualTo("bookId",bookId);
        borrowerInfoMapper.updateByExample(borrowerInfo,example);
        return "ok";
    }

    @Override
    public List<UserBookInfo> selectUserBookDetailsByUserId(Integer userId) {
        Example example = new Example(UserBookInfo.class);
        example.createCriteria().andEqualTo("userId", userId);
        List<UserBookInfo> userBookInfos = userBookMapper.selectByExample(example);
        return userBookInfos;
    }

    /**
     * 给当前时间加上一个指定的天数
     * */
    public String plusDay(int num){
        Date d = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currdate = format.format(d);
        System.out.println("现在的日期是：" + currdate);

        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.DATE, num);
        d = ca.getTime();
        String enddate = format.format(d);
        System.out.println("增加天数以后的日期：" + enddate);
        return enddate;
    }
}
