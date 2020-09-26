/*
Navicat MySQL Data Transfer

Source Server         : TEXT
Source Server Version : 50540
Source Host           : 127.0.0.1:3306
Source Database       : khxt

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2020-05-06 11:24:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '标题',
  `content` text COLLATE utf8mb4_unicode_ci COMMENT '文章内容',
  `imgPath` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '图片地址',
  `state` int(11) DEFAULT NULL COMMENT '0代表有图,1代表没图',
  `info` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '文章简介',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=240 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for comments
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `UID` varchar(255) NOT NULL COMMENT '评论编号 前八位为视频编号 后面为该视频的评论',
  `CREATETIME` datetime NOT NULL COMMENT '发表时间',
  `CONTENT` text NOT NULL COMMENT '内容',
  `WONDERFUL_COUNT` int(11) NOT NULL COMMENT '点赞量',
  `IS_AUDIT` int(11) NOT NULL DEFAULT '0' COMMENT '是否审核 0 为 未审核 1 为 已审核',
  `USER_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`,`UID`),
  UNIQUE KEY `uid` (`UID`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type` int(11) DEFAULT NULL COMMENT '分类表主键',
  `author` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '作者',
  `kind` int(11) DEFAULT NULL COMMENT '课程类型:0 ,热门课程 .1,精品课程。2,公开课.3,推荐课程',
  `browseNum` bigint(20) DEFAULT NULL COMMENT '浏览量',
  `context` text COLLATE utf8mb4_unicode_ci COMMENT '文章简介',
  `imgPath` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '图片地址',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '标题',
  `lecturerId` int(11) DEFAULT NULL COMMENT '讲师id',
  `label` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '课程标签',
  `upload_path` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '课程下载路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=176 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for image
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '姓名',
  `img_path` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '图片地址',
  `url` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '轮播图路径',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for lecturer
-- ----------------------------
DROP TABLE IF EXISTS `lecturer`;
CREATE TABLE `lecturer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '姓名',
  `img_path` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '头像图片路径',
  `context` mediumtext COLLATE utf8mb4_unicode_ci COMMENT '简介',
  `level` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '讲师级别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `password` varchar(200) DEFAULT NULL COMMENT '密码加密存储',
  `phone` varchar(20) DEFAULT NULL COMMENT '注册手机号',
  `created` datetime DEFAULT NULL COMMENT '创建时间',
  `state` int(1) DEFAULT '0' COMMENT '状态',
  `file` varchar(255) DEFAULT NULL COMMENT '头像',
  `description` varchar(500) DEFAULT NULL COMMENT '描述',
  `oppenid` varchar(50) DEFAULT NULL COMMENT '微信oppenid',
  `QQ` varchar(50) DEFAULT NULL COMMENT 'qq',
  `zhifubao_id` varchar(50) DEFAULT NULL COMMENT '阿里id',
  `sex` varchar(255) DEFAULT NULL COMMENT '性别',
  `school` varchar(255) DEFAULT NULL COMMENT '学校',
  `info` varchar(500) DEFAULT NULL COMMENT '简介',
  `homePath` varchar(500) DEFAULT NULL,
  `score` int(11) DEFAULT NULL COMMENT '签到分数',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`) USING BTREE,
  UNIQUE KEY `phone` (`phone`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Table structure for member_course
-- ----------------------------
DROP TABLE IF EXISTS `member_course`;
CREATE TABLE `member_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mid` int(11) DEFAULT NULL COMMENT '会员id',
  `cid` int(11) DEFAULT NULL COMMENT '课程id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for project_library
-- ----------------------------
DROP TABLE IF EXISTS `project_library`;
CREATE TABLE `project_library` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '标题',
  `img_path` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '图片地址',
  `url` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '访问路径',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for search
-- ----------------------------
DROP TABLE IF EXISTS `search`;
CREATE TABLE `search` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `word` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '搜索词',
  `searchNum` int(11) DEFAULT NULL COMMENT '搜索次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for send_code
-- ----------------------------
DROP TABLE IF EXISTS `send_code`;
CREATE TABLE `send_code` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  `sendDate` datetime DEFAULT NULL COMMENT '发送时间',
  `code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '验证码',
  `type` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '0表示注册,1表示忘记密码',
  `time` int(11) DEFAULT NULL COMMENT '倒计时',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for sign
-- ----------------------------
DROP TABLE IF EXISTS `sign`;
CREATE TABLE `sign` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mid` int(11) DEFAULT NULL COMMENT '用户id',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `ID` int(65) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL COMMENT '用户姓名',
  `PASSWORD` varchar(255) DEFAULT NULL COMMENT '用户密码',
  `LEVEL` int(65) DEFAULT NULL COMMENT '账号权限',
  `REAL_NAME` varchar(255) DEFAULT NULL COMMENT '真实姓名',
  `PROVINCE_ID` int(65) DEFAULT NULL COMMENT '省市表ID',
  `CITY_ID` int(65) DEFAULT NULL COMMENT '市县表id',
  `PHONE` varchar(255) DEFAULT NULL COMMENT '手机号',
  `EMAIL` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `QQ` varchar(255) DEFAULT NULL COMMENT 'QQ',
  `BLOG` varchar(255) DEFAULT NULL COMMENT '微博',
  `SCHOOL_ID` int(65) DEFAULT NULL COMMENT '学校id',
  `GRADE_NAME` varchar(255) DEFAULT NULL COMMENT '班级',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户账号表';

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TYPE` int(255) DEFAULT NULL COMMENT '视频类型  对应video_sort中的id',
  `CHAPTER` varchar(255) DEFAULT NULL COMMENT '章节',
  `CONTENT` text COMMENT '视频简介',
  `VIDEO_PATH` varchar(255) DEFAULT NULL COMMENT '视频路径',
  `title` varchar(255) DEFAULT NULL COMMENT '视频标题',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `upload_path` varchar(500) DEFAULT NULL COMMENT '视频下载路径',
  `vip` int(11) DEFAULT NULL COMMENT '是否需要vip',
  `time` varchar(255) DEFAULT NULL COMMENT '播放时间',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2963 DEFAULT CHARSET=utf8 COMMENT='视频表\r\n';

-- ----------------------------
-- Table structure for video_sort
-- ----------------------------
DROP TABLE IF EXISTS `video_sort`;
CREATE TABLE `video_sort` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '类名',
  `parentId` int(11) DEFAULT NULL COMMENT '父节点id',
  `isRoot` int(11) DEFAULT NULL COMMENT '是否为根  0:代表根。1：代表子目录',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
