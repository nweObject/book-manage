package com.shangqin.bms.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

/**
 * @description：TODO
 * @projectName：book-manage
 * @packageName：com.shangqin.bms.pojo
 * @className：User
 * @createAuthor：zhouyang
 * @createTime：2020/3/13 15:58
 * @version：
 * @Copyright：重庆商勤科技有限公司
 */

@Data
@Getter
@Setter
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;
    private String username;
    private String phoneNum;
    private String psw;
    private Integer age;
    private Integer identify;
    List<UserBookInfo> UserBookInfos;
}
