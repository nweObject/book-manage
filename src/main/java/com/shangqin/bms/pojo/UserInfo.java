package com.shangqin.bms.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @description：TODO
 * @projectName：book-manage
 * @packageName：com.shangqin.bms.pojo
 * @className：UserInfo
 * @createAuthor：zhouyang
 * @createTime：2020/3/13 16:17
 * @version：
 * @Copyright：重庆商勤科技有限公司
 */
@Data
@Setter
@Getter
@Table(name = "user_info")
public class UserInfo {
//`id` int(11) NOT NULL AUTO_INCREMENT,
//	`user_id` int(11) DEFAULT NULL COMMENT '用户id',
//            `phone_num` VARCHAR(11) DEFAULT NULL ,
//	`username` VARCHAR(11) DEFAULT NULL,
//	`age` int(4) DEFAULT NULL ,
    @Id
    @GeneratedValue(generator = "JDBC")
    private int id;
    private String phoneNum;
    private String username;
    private int age;
}
