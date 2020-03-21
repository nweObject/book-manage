/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50713
 Source Host           : localhost:3306
 Source Schema         : bms

 Target Server Type    : MySQL
 Target Server Version : 50713
 File Encoding         : 65001

 Date: 21/03/2020 10:37:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book_info
-- ----------------------------
DROP TABLE IF EXISTS `book_info`;
CREATE TABLE `book_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` int(4) NULL DEFAULT NULL,
  `book_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` date NULL DEFAULT NULL COMMENT '添加书籍日期',
  `status` int(2) NULL DEFAULT NULL COMMENT '书籍状态：0-未借出，1-借出',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book_info
-- ----------------------------
INSERT INTO `book_info` VALUES (20, '英语', '中学英文课本', 40, 'https://guli-0722-zhouyg.oss-cn-shenzhen.aliyuncs.com/avatar/2020/03/19/4c727d8a-3634-4c5a-a5df-ce2b565b5f17.jpg', '2020-03-19', 1);
INSERT INTO `book_info` VALUES (22, '一本不知名的书', '翻开可能召唤出神龙', 9, 'https://guli-0722-zhouyg.oss-cn-shenzhen.aliyuncs.com/avatar/2020/03/19/2151c388-8c45-476a-886d-ee19d8fb8bf0.jpg', '2020-03-19', 1);
INSERT INTO `book_info` VALUES (24, '书B', '看封面就知道是一本好书', 11, 'https://guli-0722-zhouyg.oss-cn-shenzhen.aliyuncs.com/avatar/2020/03/19/7981cc65-af5b-4799-804a-9e9a441e58b1.jpg', '2020-03-19', 1);
INSERT INTO `book_info` VALUES (25, '书', '一本书', 1, 'https://guli-0722-zhouyg.oss-cn-shenzhen.aliyuncs.com/avatar/2020/03/20/6671904a-e825-4585-8dc9-b92d1dc756df.jpg', '2020-03-20', 1);
INSERT INTO `book_info` VALUES (27, '书', '一本书', 1, 'https://guli-0722-zhouyg.oss-cn-shenzhen.aliyuncs.com/avatar/2020/03/20/fa2a7036-5562-48c5-88bf-d6f2ec7f022a.jpg', '2020-03-20', 1);

-- ----------------------------
-- Table structure for borrower_info
-- ----------------------------
DROP TABLE IF EXISTS `borrower_info`;
CREATE TABLE `borrower_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL COMMENT '借书人的id',
  `book_id` int(11) NULL DEFAULT NULL COMMENT '被借书籍id',
  `username` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(2) NULL DEFAULT NULL,
  `return_time` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of borrower_info
-- ----------------------------
INSERT INTO `borrower_info` VALUES (1, 2, 1, '周杨', 24, '2020-03-27');
INSERT INTO `borrower_info` VALUES (2, 2, 2, '周杨', 24, '2020-03-31');
INSERT INTO `borrower_info` VALUES (3, 2, 3, '周杨', 24, '2020-04-01');
INSERT INTO `borrower_info` VALUES (4, 2, 1, '周杨', 24, '2020-03-31');
INSERT INTO `borrower_info` VALUES (5, 2, 3, '周杨', 24, '2020-04-01');
INSERT INTO `borrower_info` VALUES (6, 2, 3, '周杨', 24, '2020-04-01');
INSERT INTO `borrower_info` VALUES (7, 2, 3, '周杨', 24, '2020-04-01');
INSERT INTO `borrower_info` VALUES (8, 2, 3, '周杨', 24, '2020-04-01');
INSERT INTO `borrower_info` VALUES (9, 2, 3, '周杨', 24, '2020-04-01');
INSERT INTO `borrower_info` VALUES (10, 2, 19, '周杨', 24, '2020-04-02');
INSERT INTO `borrower_info` VALUES (11, 2, 20, '周杨', 24, '2020-04-02');
INSERT INTO `borrower_info` VALUES (12, 2, 21, '周杨', 24, '2020-04-02');
INSERT INTO `borrower_info` VALUES (13, 1, 22, '张三', 30, '2020-04-01');
INSERT INTO `borrower_info` VALUES (14, 2, 24, '周杨', 24, '2020-04-01');
INSERT INTO `borrower_info` VALUES (15, 2, 24, '周杨', 24, '2020-04-01');
INSERT INTO `borrower_info` VALUES (16, 2, 19, '周杨', 24, '2020-04-02');
INSERT INTO `borrower_info` VALUES (17, 2, 20, '周杨', 24, '2020-04-02');
INSERT INTO `borrower_info` VALUES (18, 2, 19, '周杨', 24, '2020-04-02');
INSERT INTO `borrower_info` VALUES (19, 2, 20, '周杨', 24, '2020-04-02');
INSERT INTO `borrower_info` VALUES (20, 2, 23, '周杨', 24, '2020-04-02');
INSERT INTO `borrower_info` VALUES (21, 2, 24, '周杨', 24, '2020-04-02');
INSERT INTO `borrower_info` VALUES (22, 2, 27, '周杨', 24, '2020-04-02');
INSERT INTO `borrower_info` VALUES (23, 2, 25, '周杨', 24, '2020-04-02');
INSERT INTO `borrower_info` VALUES (24, 2, 26, '周杨', 24, '2020-04-02');
INSERT INTO `borrower_info` VALUES (25, 2, 26, '周杨', 24, '2020-04-02');
INSERT INTO `borrower_info` VALUES (26, 2, 26, '周杨', 24, '2020-04-02');
INSERT INTO `borrower_info` VALUES (27, 2, 26, '周杨', 24, '2020-04-02');
INSERT INTO `borrower_info` VALUES (28, 2, 19, '周杨', 24, '2020-04-02');
INSERT INTO `borrower_info` VALUES (29, 2, 20, '周杨', 24, '2020-04-02');
INSERT INTO `borrower_info` VALUES (30, 2, 19, '周杨', 24, '2020-04-02');
INSERT INTO `borrower_info` VALUES (31, 2, 20, '周杨', 24, '2020-04-02');
INSERT INTO `borrower_info` VALUES (32, 2, 21, '周杨', 24, '2020-04-02');
INSERT INTO `borrower_info` VALUES (33, 2, 22, '周杨', 24, '2020-04-02');
INSERT INTO `borrower_info` VALUES (34, 2, 23, '周杨', 24, '2020-04-03');
INSERT INTO `borrower_info` VALUES (35, 2, 26, '周杨', 24, '2020-04-03');
INSERT INTO `borrower_info` VALUES (36, 2, 19, '周杨', 24, '2020-04-03');
INSERT INTO `borrower_info` VALUES (37, 2, 22, '周杨', 24, '2020-04-03');
INSERT INTO `borrower_info` VALUES (38, 2, 20, '周杨', 24, '2020-04-03');

-- ----------------------------
-- Table structure for lost_recorder
-- ----------------------------
DROP TABLE IF EXISTS `lost_recorder`;
CREATE TABLE `lost_recorder`  (
  `user_id` int(11) NULL DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `book_name` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `recorder_time` date NULL DEFAULT NULL COMMENT '添加书籍日期',
  `status` int(2) NULL DEFAULT NULL COMMENT '书籍状态：0-管理员未确认，1-管理员确认',
  `book_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lost_recorder
-- ----------------------------
INSERT INTO `lost_recorder` VALUES (2, 1, '周杨', 'Java编程思想', '2020-03-19', 1, NULL);
INSERT INTO `lost_recorder` VALUES (2, 3, '周杨', '一本不知名的书', '2020-03-19', 1, NULL);
INSERT INTO `lost_recorder` VALUES (2, 4, '周杨', '茶经', '2020-03-19', 1, NULL);
INSERT INTO `lost_recorder` VALUES (2, 5, '周杨', '英语', '2020-03-19', 1, NULL);
INSERT INTO `lost_recorder` VALUES (2, 6, '周杨', '书A', '2020-03-20', 1, NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone_num` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `psw` varchar(22) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `identify` int(2) NULL DEFAULT NULL COMMENT '身份：0-管理员，1-用户',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '张三', '18983654817', '3667681051', 30, 0);
INSERT INTO `user` VALUES (2, '周杨', '18182205762', '3667681051', 24, 1);

-- ----------------------------
-- Table structure for user_book_info
-- ----------------------------
DROP TABLE IF EXISTS `user_book_info`;
CREATE TABLE `user_book_info`  (
  `user_id` int(11) NULL DEFAULT NULL,
  `book_id` int(11) NULL DEFAULT NULL,
  `book_name` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `book_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '书籍图片信息',
  `create_time` date NULL DEFAULT NULL COMMENT '借书时间',
  `return_time` date NULL DEFAULT NULL COMMENT '应当归还时间',
  `status` int(2) NULL DEFAULT NULL COMMENT '0-正常状态，1-延期，2-过期未归还',
  `renewz_count` int(2) NULL DEFAULT NULL COMMENT '延期归还次数不超过两次',
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status2` int(1) NULL DEFAULT NULL COMMENT '0-未赔偿 1-已赔偿',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_book_info
-- ----------------------------
INSERT INTO `user_book_info` VALUES (2, 3, 'Java编程思想', 'null', '2020-03-19', '2020-04-01', 2, 2, 9, 1);
INSERT INTO `user_book_info` VALUES (2, 21, '一本不知名的书', 'https://guli-0722-zhouyg.oss-cn-shenzhen.aliyuncs.com/avatar/2020/03/19/2151c388-8c45-476a-886d-ee19d8fb8bf0.jpg', '2020-03-19', '2020-04-01', 2, 1, 12, 1);
INSERT INTO `user_book_info` VALUES (1, 22, '一本不知名的书', 'https://guli-0722-zhouyg.oss-cn-shenzhen.aliyuncs.com/avatar/2020/03/19/2151c388-8c45-476a-886d-ee19d8fb8bf0.jpg', '2020-03-19', '2020-04-01', 0, 0, 13, 0);
INSERT INTO `user_book_info` VALUES (2, 19, '茶经', 'https://guli-0722-zhouyg.oss-cn-shenzhen.aliyuncs.com/avatar/2020/03/19/9500ceb0-42fd-4a8d-a6cf-fccbe6f0197b.jpg', '2020-03-19', '2020-04-01', 2, 2, 18, 1);
INSERT INTO `user_book_info` VALUES (2, 20, '英语', 'https://guli-0722-zhouyg.oss-cn-shenzhen.aliyuncs.com/avatar/2020/03/19/4c727d8a-3634-4c5a-a5df-ce2b565b5f17.jpg', '2020-03-19', '2020-04-01', 2, 2, 19, 1);
INSERT INTO `user_book_info` VALUES (2, 23, '书A', 'https://guli-0722-zhouyg.oss-cn-shenzhen.aliyuncs.com/avatar/2020/03/19/80a04abe-698b-4889-8509-96d1afa55357.jpg', '2020-03-20', '2020-04-02', 2, 2, 20, 1);
INSERT INTO `user_book_info` VALUES (2, 21, '一本不知名的书', 'https://guli-0722-zhouyg.oss-cn-shenzhen.aliyuncs.com/avatar/2020/03/19/2151c388-8c45-476a-886d-ee19d8fb8bf0.jpg', '2020-03-20', '2020-04-28', 2, 2, 29, 1);
INSERT INTO `user_book_info` VALUES (2, 23, '书A', 'https://guli-0722-zhouyg.oss-cn-shenzhen.aliyuncs.com/avatar/2020/03/19/80a04abe-698b-4889-8509-96d1afa55357.jpg', '2020-03-21', '2020-04-03', 2, 0, 31, 1);
INSERT INTO `user_book_info` VALUES (2, 26, '书', 'https://guli-0722-zhouyg.oss-cn-shenzhen.aliyuncs.com/avatar/2020/03/20/6671904a-e825-4585-8dc9-b92d1dc756df.jpg', '2020-03-21', '2020-04-03', 2, 0, 32, 1);
INSERT INTO `user_book_info` VALUES (2, 19, '茶经', 'https://guli-0722-zhouyg.oss-cn-shenzhen.aliyuncs.com/avatar/2020/03/19/9500ceb0-42fd-4a8d-a6cf-fccbe6f0197b.jpg', '2020-03-21', '2020-04-03', 2, 0, 33, 1);
INSERT INTO `user_book_info` VALUES (2, 22, '一本不知名的书', 'https://guli-0722-zhouyg.oss-cn-shenzhen.aliyuncs.com/avatar/2020/03/19/2151c388-8c45-476a-886d-ee19d8fb8bf0.jpg', '2020-03-21', '2020-04-03', 0, 0, 34, 0);
INSERT INTO `user_book_info` VALUES (2, 20, '英语', 'https://guli-0722-zhouyg.oss-cn-shenzhen.aliyuncs.com/avatar/2020/03/19/4c727d8a-3634-4c5a-a5df-ce2b565b5f17.jpg', '2020-03-21', '2020-04-03', 0, 0, 35, 0);

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `phone_num` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(4) NULL DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `identify` int(2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, '18983454817', '张三', 30, 1, 0);
INSERT INTO `user_info` VALUES (2, '18182205762', '周杨', 24, 2, 1);

SET FOREIGN_KEY_CHECKS = 1;
