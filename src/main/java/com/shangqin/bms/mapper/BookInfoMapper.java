package com.shangqin.bms.mapper;

import com.shangqin.bms.pojo.BookInfo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @description：TODO
 * @projectName：book-manage
 * @packageName：com.shangqin.bms.mapper
 * @className：BookInfoMapper
 * @createAuthor：zhouyang
 * @createTime：2020/3/13 17:04
 * @version：
 * @Copyright：重庆商勤科技有限公司
 */
public interface BookInfoMapper extends Mapper<BookInfo> {
    List<BookInfo> selectBookInfo(@Param("keywords") String keywords);
}
