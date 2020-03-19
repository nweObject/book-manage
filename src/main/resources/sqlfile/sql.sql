CREATE DATABASE bms;
USE bms;
##用户表
drop table user
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(11) DEFAULT NULL,
  `phone_num` VARCHAR(11) DEFAULT NULL COMMENT '手机号码',
  `psw` VARCHAR(22) DEFAULT NULL COMMENT '密码',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
	`identify` int(2) DEFAULT NULL COMMENT '身份：0-管理员，1-用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

##插入一条数据
INSERT INTO user(id,username, phone_num, psw,age,identify) VALUES(null,'周杨', '18182205762', '3667681051',24,1)
INSERT INTO user(id,username, phone_num, psw,age,identify) VALUES(null,'张三', '18983454817', '3667681051',30,0)
##管理员表
CREATE TABLE `admin_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(11) DEFAULT NULL,
  `phone_num` VARCHAR(11) DEFAULT NULL COMMENT '手机号码',
  `psw` VARCHAR(11) DEFAULT NULL COMMENT '密码',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


##用户信息表
DROP TABLE user_info
CREATE TABLE `user_info` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`user_id` int(11) DEFAULT NULL COMMENT '用户id',
	`phone_num` VARCHAR(11) DEFAULT NULL ,
	`username` VARCHAR(11) DEFAULT NULL,
	`age` int(4) DEFAULT NULL ,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

##插入2条用户信息


##用户借书表
CREATE TABLE `user_book_info` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`user_id` int(11) DEFAULT NULL ,
	`book_id` int(11) DEFAULT NULL,
	`book_name` VARCHAR(11) DEFAULT null,
	`book_img` VARCHAR(40) DEFAULT null COMMENT '书籍图片信息',
	`create_time` date DEFAULT NULL COMMENT '借书时间',
	`return_time` date DEFAULT NULL COMMENT '应当归还时间',
	`status` int(2) DEFAULT NULL COMMENT '0-正常状态，1-延期，2-过期未归还',
	`renewz_count` int(2) DEFAULT null COMMENT '延期归还次数不超过两次',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

##书籍信息表
CREATE TABLE `book_info` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`book_name` VARCHAR(11) DEFAULT NULL,
	`description` VARCHAR(255) DEFAULT NULL,
	`price` int(4) DEFAULT NULL,
	`book_img` VARCHAR(40) DEFAULT NULL,
	`create_time` date DEFAULT NULL comment '添加书籍日期',
	`status` int(2) DEFAULT NULL COMMENT '书籍状态：0-未借出，1-借出',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

##借书人信息表
CREATE TABLE `borrower_info` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`user_id` int(11) DEFAULT NULL COMMENT '借书人的id',
	`book_id` int(11) DEFAULT NULL COMMENT '被借书籍id',
	`username` VARCHAR(11) DEFAULT NULL,
	`age` int(2) DEFAULT NULL,
	`return_time` date DEFAULT null,
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

##遗失书籍记录
CREATE TABLE `lost_recorder` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`usr_id` int(11) DEFAULT NULL,
	`user_name` VARCHAR(11) DEFAULT NULL,
	`book_name` VARCHAR(11) DEFAULT NULL,
	`description` VARCHAR(255) DEFAULT NULL,
	`price` int(4) DEFAULT NULL,
	`recorder_time` date DEFAULT NULL comment '添加书籍日期',
	`status` int(2) DEFAULT NULL COMMENT '书籍状态：0-管理员未确认，1-管理员确认',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
