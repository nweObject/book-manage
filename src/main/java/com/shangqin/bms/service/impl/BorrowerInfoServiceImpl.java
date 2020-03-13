package com.shangqin.bms.service.impl;

import com.shangqin.bms.mapper.BorrowerInfoMapper;
import com.shangqin.bms.pojo.BorrowerInfo;
import com.shangqin.bms.service.BorrowerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @description：TODO
 * @projectName：book-manage
 * @packageName：com.shangqin.bms.service.impl
 * @className：BorrowerInfoServiceImpl
 * @createAuthor：zhouyang
 * @createTime：2020/3/13 18:32
 * @version：
 * @Copyright：重庆商勤科技有限公司
 */
@Service
public class BorrowerInfoServiceImpl implements BorrowerInfoService {
    @Autowired
    BorrowerInfoMapper borrowerInfoMapper;
    //通过bookid查找借阅人信息
    @Override
    public List<BorrowerInfo> selectBorrowerByBookId(Integer bookId) {
        Example example = new Example(BorrowerInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("bookId", bookId);
        List<BorrowerInfo> borrowerInfos = borrowerInfoMapper.selectByExample(example);
        return borrowerInfos;
    }
}
