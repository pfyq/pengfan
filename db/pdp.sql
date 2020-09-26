/*
Navicat MySQL Data Transfer

Source Server         : TEXT
Source Server Version : 50540
Source Host           : 127.0.0.1:3306
Source Database       : pdp

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2020-05-06 11:23:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for pdp_member
-- ----------------------------
DROP TABLE IF EXISTS `pdp_member`;
CREATE TABLE `pdp_member` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `nickname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户名',
  `phone` varchar(20) DEFAULT NULL COMMENT '注册手机号',
  `created` datetime DEFAULT NULL COMMENT '创建时间',
  `headimgurl` varchar(255) DEFAULT NULL COMMENT '头像',
  `openid` varchar(50) DEFAULT NULL COMMENT '微信oppenid',
  `score` int(11) DEFAULT NULL COMMENT '签到分数',
  `balance` decimal(10,2) DEFAULT NULL COMMENT '余额',
  `fx_earning_price` decimal(10,2) DEFAULT NULL COMMENT '收入金额',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`nickname`) USING BTREE,
  UNIQUE KEY `phone` (`phone`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';
