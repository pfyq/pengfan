/*
Navicat MySQL Data Transfer

Source Server         : TEXT
Source Server Version : 50540
Source Host           : 127.0.0.1:3306
Source Database       : toy

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2020-05-06 11:23:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cp36_evaluate_obj
-- ----------------------------
DROP TABLE IF EXISTS `cp36_evaluate_obj`;
CREATE TABLE `cp36_evaluate_obj` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) DEFAULT NULL COMMENT '测评对象id',
  `height` double DEFAULT NULL COMMENT '身高',
  `weight` double DEFAULT NULL COMMENT '体重',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for cp_child
-- ----------------------------
DROP TABLE IF EXISTS `cp_child`;
CREATE TABLE `cp_child` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '孩子姓名',
  `age` int(11) DEFAULT NULL COMMENT '孩子的年龄',
  `phone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '对应的手机号',
  `update_date` datetime DEFAULT NULL COMMENT '数据更新时间',
  `birth_date` datetime DEFAULT NULL COMMENT '出生日期',
  `openid` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信凭证',
  `sex` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '性别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for cp_member
-- ----------------------------
DROP TABLE IF EXISTS `cp_member`;
CREATE TABLE `cp_member` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `nickname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户名',
  `phone` varchar(20) DEFAULT NULL COMMENT '注册手机号',
  `created` datetime DEFAULT NULL COMMENT '创建时间',
  `headimgurl` varchar(255) DEFAULT NULL COMMENT '头像',
  `openid` varchar(255) DEFAULT NULL COMMENT '微信oppenid',
  `score` int(11) DEFAULT NULL COMMENT '签到分数',
  `balance` decimal(10,2) DEFAULT NULL COMMENT '余额',
  `fx_earning_price` decimal(10,2) DEFAULT NULL COMMENT '收入金额',
  `subscribe` int(11) DEFAULT NULL COMMENT '0 代表没关注  1 代表关注了',
  `union_id` varchar(255) DEFAULT NULL COMMENT '微信公众号唯一标志',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`nickname`) USING BTREE,
  UNIQUE KEY `phone` (`phone`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Table structure for cp_send_code
-- ----------------------------
DROP TABLE IF EXISTS `cp_send_code`;
CREATE TABLE `cp_send_code` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '验证码',
  `phone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  `sendDate` datetime DEFAULT NULL COMMENT '发送时间',
  `time` int(11) DEFAULT NULL COMMENT '有效时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=211 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for evaluate_data
-- ----------------------------
DROP TABLE IF EXISTS `evaluate_data`;
CREATE TABLE `evaluate_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '分类',
  `title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '题目',
  `month` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '月份',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=594 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for evaluate_hw
-- ----------------------------
DROP TABLE IF EXISTS `evaluate_hw`;
CREATE TABLE `evaluate_hw` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `height_min` double DEFAULT NULL COMMENT '最低身高',
  `height_max` double DEFAULT NULL COMMENT '最高身高',
  `weight_min` double DEFAULT NULL COMMENT '最低体重',
  `weight_max` double DEFAULT NULL COMMENT '最高身高',
  `head_min` double DEFAULT NULL COMMENT '最低头围',
  `head_max` double DEFAULT NULL COMMENT '最大头围',
  `chest_min` double DEFAULT NULL COMMENT '最小胸围',
  `chest_max` double DEFAULT NULL COMMENT '最大胸围',
  `sex` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '性别',
  `month` int(11) DEFAULT NULL COMMENT '月份',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for evaluate_obj
-- ----------------------------
DROP TABLE IF EXISTS `evaluate_obj`;
CREATE TABLE `evaluate_obj` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '宝宝姓名',
  `sex` varchar(11) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '性别',
  `birthdate` datetime DEFAULT NULL COMMENT '出生日期',
  `park` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '园区',
  `phone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  `obj` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '对象',
  `child_height` double DEFAULT NULL COMMENT '宝宝身高',
  `child_weight` double DEFAULT NULL COMMENT '宝宝重量',
  `score1` int(11) DEFAULT NULL COMMENT '大运动发展分数',
  `score2` int(11) DEFAULT NULL COMMENT '精细运动发展分数',
  `score3` int(11) DEFAULT NULL COMMENT '语言与沟通发展',
  `score4` int(11) DEFAULT NULL COMMENT '社会性行为发展',
  `score5` int(11) DEFAULT NULL COMMENT '认知发展',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `synth` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '综合能力状况',
  `extrude` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '较为突出的能力',
  `reach` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '已经达标的能力',
  `streng` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '需要加强的方面',
  `suggest` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '测评建议',
  `streng1` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '需要加强的方面1',
  `sid` int(11) DEFAULT NULL COMMENT '学生id',
  `centerId` int(11) DEFAULT '0' COMMENT '园区id  0 代表平台id',
  `hw_res` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '体重身高结果',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for member_center
-- ----------------------------
DROP TABLE IF EXISTS `member_center`;
CREATE TABLE `member_center` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `nickname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户名',
  `created` datetime DEFAULT NULL COMMENT '创建时间',
  `headimgurl` varchar(255) DEFAULT NULL COMMENT '头像',
  `openid` varchar(50) DEFAULT NULL COMMENT '微信oppenid',
  `subscribe` int(11) DEFAULT NULL COMMENT '0 代表没关注  1 代表关注了',
  `center_id` int(11) DEFAULT '0' COMMENT '园区id  0 代表属于平台',
  `union_id` varchar(255) DEFAULT NULL COMMENT '微信公众号唯一标志',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`nickname`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Table structure for pdp_evaluate_obj
-- ----------------------------
DROP TABLE IF EXISTS `pdp_evaluate_obj`;
CREATE TABLE `pdp_evaluate_obj` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  `sex` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '性别',
  `openid` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信凭证',
  `tiger_score` decimal(10,0) DEFAULT NULL COMMENT '老虎分数',
  `peacock_score` decimal(10,0) DEFAULT NULL COMMENT '孔雀分数',
  `koala_score` decimal(10,0) DEFAULT NULL COMMENT '考拉分数',
  `owl_score` decimal(10,0) DEFAULT NULL COMMENT '猫头鹰分数',
  `anole_score` decimal(10,0) DEFAULT NULL COMMENT '变色龙分数',
  `type_ch` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '结果类型',
  `msg` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '类型描述',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `head_url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '头像',
  `center_id` int(11) DEFAULT '0' COMMENT '园区绑定  0  表示非园区',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for pdp_title
-- ----------------------------
DROP TABLE IF EXISTS `pdp_title`;
CREATE TABLE `pdp_title` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '题名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for students
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parentId` varchar(30) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL COMMENT '学员姓名',
  `birthday` datetime DEFAULT NULL,
  `age` varchar(25) DEFAULT NULL COMMENT '学员年龄',
  `parent_name` varchar(25) DEFAULT NULL COMMENT '家长姓名',
  `phone` varchar(25) DEFAULT NULL COMMENT '联系电话',
  `home_address` varchar(50) DEFAULT NULL COMMENT '家庭住址',
  `centerId` varchar(30) DEFAULT NULL,
  `class_name` varchar(25) DEFAULT NULL,
  `update` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `del_flag` int(11) DEFAULT '0',
  `height` int(11) DEFAULT NULL,
  `weight` int(12) DEFAULT NULL COMMENT '体重',
  `sex` varchar(25) DEFAULT NULL,
  `relation` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for weixin_user
-- ----------------------------
DROP TABLE IF EXISTS `weixin_user`;
CREATE TABLE `weixin_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `openId` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_name` varchar(25) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户姓名',
  `sex` varchar(25) CHARACTER SET utf8 DEFAULT NULL,
  `phone` varchar(25) CHARACTER SET utf8 DEFAULT NULL COMMENT '电话号码',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` int(11) DEFAULT '0' COMMENT '删除标志',
  `baby_name` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `account` int(25) DEFAULT '0' COMMENT '余额',
  `baby_sex` varchar(10) CHARACTER SET utf8 DEFAULT NULL COMMENT '宝宝性别',
  `baby_birthday` varchar(25) CHARACTER SET utf8 DEFAULT NULL,
  `coupon` varchar(25) CHARACTER SET utf8 DEFAULT NULL COMMENT '优惠券',
  `points` int(25) DEFAULT '0' COMMENT '积分',
  `address` varchar(25) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;
