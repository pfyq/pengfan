/*
Navicat MySQL Data Transfer

Source Server         : TEXT
Source Server Version : 50540
Source Host           : 127.0.0.1:3306
Source Database       : hdb

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2020-05-06 11:22:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for act
-- ----------------------------
DROP TABLE IF EXISTS `act`;
CREATE TABLE `act` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '活动名',
  `type` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '类型',
  `posterPath` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '海报',
  `startTime` datetime DEFAULT NULL COMMENT '开始时间',
  `endTime` datetime DEFAULT NULL COMMENT '结束时间',
  `province` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '省',
  `city` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '市',
  `district` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '区',
  `detailPath` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '详细地址',
  `content` text COLLATE utf8mb4_unicode_ci COMMENT '活动内容',
  `serverPhone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '服务电话',
  `contactPhone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系电话',
  `look_num` int(11) DEFAULT NULL COMMENT '浏览数',
  `forward_num` int(11) DEFAULT NULL COMMENT '转发数量',
  `join_num` int(11) DEFAULT NULL COMMENT '报名数',
  `tags` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '活动标签',
  `old_look` int(11) DEFAULT NULL COMMENT '历史浏览数',
  `old_forward` int(11) DEFAULT NULL COMMENT '历史转发数',
  `old_join` int(11) DEFAULT NULL COMMENT '历史参加人数',
  `old_income` decimal(10,2) DEFAULT NULL COMMENT '历史总收入',
  `user_id` int(11) DEFAULT NULL COMMENT '对象id',
  `state` int(11) DEFAULT NULL COMMENT '1 代表已删除',
  `income` decimal(10,2) DEFAULT NULL COMMENT '总收入',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for act_type
-- ----------------------------
DROP TABLE IF EXISTS `act_type`;
CREATE TABLE `act_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '活动类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for applyitems
-- ----------------------------
DROP TABLE IF EXISTS `applyitems`;
CREATE TABLE `applyitems` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '报名项名称',
  `necessityIs` int(11) DEFAULT NULL COMMENT '是否需要 0:没必要  1:必须',
  `actId` int(11) DEFAULT NULL COMMENT '活动id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=301 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for fx_draw_log
-- ----------------------------
DROP TABLE IF EXISTS `fx_draw_log`;
CREATE TABLE `fx_draw_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '提现编号',
  `price` decimal(10,2) DEFAULT NULL COMMENT '提现金额',
  `state` int(11) DEFAULT NULL COMMENT '提现状态  ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for fx_goods
-- ----------------------------
DROP TABLE IF EXISTS `fx_goods`;
CREATE TABLE `fx_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '活动链接',
  `poster_url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '海报链接',
  `title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '活动标题',
  `remark` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  `ass_title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '活动副标题',
  `type_id` int(11) DEFAULT NULL COMMENT '类型id',
  `end_date` datetime DEFAULT NULL COMMENT '截止时间',
  `head_url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '活动头图',
  `content` text COLLATE utf8mb4_unicode_ci COMMENT '详情',
  `price` decimal(10,2) DEFAULT NULL COMMENT '原价',
  `special_price` decimal(10,2) DEFAULT NULL COMMENT '特价',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `limitation` int(11) DEFAULT NULL COMMENT '限量',
  `limitation_type` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'on 表示需要  off 表示不需要',
  `sales_type` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'on 表示需要  off 表示不需要',
  `sales_but1` int(11) DEFAULT NULL COMMENT '1:显示  2:隐藏',
  `sales_but2` int(11) DEFAULT NULL COMMENT '1 未购买可分销  2 购买过可分销',
  `sales_award` int(11) DEFAULT NULL COMMENT '1 比例佣金奖励  2 固定佣金奖励',
  `sales_commission1` decimal(10,2) DEFAULT NULL COMMENT '分销佣金1',
  `sales_commission2` decimal(10,2) DEFAULT NULL COMMENT '分销佣金2',
  `placard_id` int(255) DEFAULT NULL COMMENT '分销海报路径',
  `sales_award_info` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '分销奖励r入账说明',
  `share_title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '分享标题',
  `share_info` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '分享描述',
  `share_url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '分享图片路径',
  `receiving_type` int(11) DEFAULT NULL COMMENT '1 不用填写  2  付费前填写  3   付费后填写',
  `but_left_type` int(11) DEFAULT NULL COMMENT '1 查看订单  2 添加微信群或个人号或其他公众号  3 文字说明  4  直接跳转',
  `left_word` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '左侧按钮文字',
  `left_des` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '左侧引导描述',
  `left_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '左侧二维码路径',
  `left_word_info` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '左侧文字说明',
  `left_url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '左侧跳转路径',
  `but_right_type` int(11) DEFAULT NULL COMMENT '1 添加微信群或个人号或其他公众号  2  文字说明  3  直接跳转',
  `right_word` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '右侧按钮文字',
  `right_des` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '右侧描述',
  `right_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '右侧二维码路径',
  `right_word_info` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '右侧文字说明',
  `right_url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '右侧跳转路径',
  `pay_logo` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '关注信息logo',
  `pay_title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '关注标题',
  `pay_title2` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '关注副标题',
  `serv_wechat` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '客服微信',
  `pay_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '关注二维码',
  `sales_type2` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否启动二级分销   on 表示需要  off 表示不需要',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `look_num` int(11) DEFAULT NULL COMMENT '浏览数',
  `forward_num` int(11) DEFAULT NULL COMMENT '转发分享邀请数',
  `buy_num` int(11) DEFAULT NULL COMMENT '购买数',
  `state` int(11) DEFAULT NULL COMMENT '1 代表已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for fx_invite
-- ----------------------------
DROP TABLE IF EXISTS `fx_invite`;
CREATE TABLE `fx_invite` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `from_openid` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邀请对象',
  `to_openid` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '被邀请对象',
  `gid` int(11) DEFAULT NULL COMMENT '商品id',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `lev_num` int(11) DEFAULT NULL COMMENT '分销等级',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for fx_market
-- ----------------------------
DROP TABLE IF EXISTS `fx_market`;
CREATE TABLE `fx_market` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `buy_openid` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '购买者openid',
  `gid` int(11) DEFAULT NULL COMMENT '商品id',
  `state` int(11) DEFAULT NULL COMMENT '1  代表购买了',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for fx_member
-- ----------------------------
DROP TABLE IF EXISTS `fx_member`;
CREATE TABLE `fx_member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `member_openid` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户openid',
  `recommend_openid` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '推荐者openid',
  `order_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单编号',
  `price` decimal(10,2) DEFAULT NULL COMMENT '支付金额',
  `ret_price` decimal(10,2) DEFAULT NULL COMMENT '返还金额',
  `lev_num` int(11) DEFAULT NULL COMMENT '几级分销',
  `gid` int(11) DEFAULT NULL COMMENT '商品id',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `state` int(11) DEFAULT NULL COMMENT '0 代表未付款  1  代表付款成功',
  `ret_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '返现编号',
  `ret_price2` decimal(10,2) DEFAULT NULL COMMENT '二次分销金额',
  `ret_code2` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '二次分销支付编号',
  `invite_per` int(11) DEFAULT NULL COMMENT '邀请的人数  某个商品下',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=155 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for fx_msg_member
-- ----------------------------
DROP TABLE IF EXISTS `fx_msg_member`;
CREATE TABLE `fx_msg_member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `openid` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `invite_per` int(11) DEFAULT NULL COMMENT '邀请的人数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for fx_order
-- ----------------------------
DROP TABLE IF EXISTS `fx_order`;
CREATE TABLE `fx_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '活动链接',
  `poster_url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '海报链接',
  `title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '活动标题',
  `remark` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  `ass_title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '活动副标题',
  `type_id` int(11) DEFAULT NULL COMMENT '类型id',
  `end_date` datetime DEFAULT NULL COMMENT '截止时间',
  `head_url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '活动头图',
  `content` text COLLATE utf8mb4_unicode_ci COMMENT '详情',
  `price` decimal(10,2) DEFAULT NULL COMMENT '原价',
  `special_price` decimal(10,2) DEFAULT NULL COMMENT '特价',
  `limitation` int(11) DEFAULT NULL COMMENT '限量',
  `limitation_type` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'on 表示需要  off 表示不需要',
  `sales_type` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'on 表示需要  off 表示不需要',
  `sales_but1` int(11) DEFAULT NULL COMMENT '1:显示  2:隐藏',
  `sales_but2` int(11) DEFAULT NULL COMMENT '1 未购买可分销  2 购买过可分销',
  `sales_award` int(11) DEFAULT NULL COMMENT '1 比例佣金奖励  2 固定佣金奖励',
  `sales_commission1` decimal(10,2) DEFAULT NULL COMMENT '分销佣金1',
  `sales_commission2` decimal(10,2) DEFAULT NULL COMMENT '分销佣金2',
  `placard_id` int(11) DEFAULT NULL COMMENT '分销海报路径id',
  `sales_award_info` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '分销奖励r入账说明',
  `share_title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '分享标题',
  `share_info` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '分享描述',
  `share_url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '分享图片路径',
  `receiving_type` int(11) DEFAULT NULL COMMENT '1 不用填写  2  付费前填写  3   付费后填写',
  `receiving_scene` int(11) DEFAULT NULL COMMENT '1  付费前填写 2 付费后填写',
  `receiving_example` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '表单示例',
  `but_left_type` int(11) DEFAULT NULL COMMENT '1 查看订单  2 添加微信群或个人号或其他公众号  3 文字说明  4  直接跳转',
  `left_word` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '左侧按钮文字',
  `left_des` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '左侧引导描述',
  `left_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '左侧二维码路径',
  `left_word_info` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '左侧文字说明',
  `left_url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '左侧跳转路径',
  `but_right_type` int(11) DEFAULT NULL COMMENT '1 添加微信群或个人号或其他公众号  2  文字说明  3  直接跳转',
  `right_word` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '右侧按钮文字',
  `right_des` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '右侧描述',
  `right_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '右侧二维码路径',
  `right_word_info` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '右侧文字说明',
  `right_url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '右侧跳转路径',
  `placard_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '海报名称',
  `placard_head_wrod` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '头像旁文字',
  `placard_font_color` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '字体颜色',
  `placard_rude_type` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'on 表示不加粗  off表示加粗',
  `placard_url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `head_type` int(11) DEFAULT NULL COMMENT '1 显示  2 不显示',
  `head_left` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '头部图片左边距离',
  `head_top` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '头部图片顶部距离',
  `head_width` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '头部图片宽度',
  `font_left` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '字体左边距离',
  `font_top` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '字体顶部距离',
  `font_width` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '字体宽度',
  `code_left` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '二维码左边距离',
  `code_top` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '二维码顶部距离',
  `code_width` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '二维码宽度',
  `order_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单编号',
  `buy_openid` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '购买者openid',
  `recommend_openid` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '推荐者微信编号',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `order_end_date` datetime DEFAULT NULL COMMENT '完成时间',
  `transaction_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '交易号',
  `order_kind` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `order_type` int(11) DEFAULT NULL COMMENT '订单状态  0 待付款  1  已付款  2  已发货  3  待使用  4  交易成功  5  申请退款  6 同意退款  7  商家收到退货   8  已退货  9  退款失败',
  `order_origin` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单来源',
  `ret_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '返现编号',
  `ret_price` decimal(10,2) DEFAULT NULL COMMENT '返现金额',
  `gid` int(11) DEFAULT NULL COMMENT '商品id',
  `order_price` decimal(10,2) DEFAULT NULL COMMENT '订单支付金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for fx_path
-- ----------------------------
DROP TABLE IF EXISTS `fx_path`;
CREATE TABLE `fx_path` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '收货人姓名',
  `phone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号码',
  `province` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '省',
  `city` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '市',
  `district` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '区',
  `detailPath` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '详细地址',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `openid` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信凭证',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for fx_placard
-- ----------------------------
DROP TABLE IF EXISTS `fx_placard`;
CREATE TABLE `fx_placard` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '海报名称',
  `head_wrod` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '头像旁文字',
  `font_color` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '字体颜色',
  `rude_type` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'on 表示不加粗  off表示加粗',
  `placard_url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `head_type` int(11) DEFAULT NULL COMMENT '1 显示  2 不显示',
  `head_left` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '头部图片左边距离',
  `head_top` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '头部图片顶部距离',
  `head_width` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '头部图片宽度',
  `font_left` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '字体左边距离',
  `font_top` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '字体顶部距离',
  `font_width` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '字体宽度',
  `code_left` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '二维码左边距离',
  `code_top` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '二维码顶部距离',
  `code_width` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '二维码宽度',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for fx_ret_msg
-- ----------------------------
DROP TABLE IF EXISTS `fx_ret_msg`;
CREATE TABLE `fx_ret_msg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ret_price` decimal(11,2) DEFAULT NULL COMMENT '返利金额',
  `ret_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '返利编号',
  `openid` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '直接推荐者',
  `gid` int(11) DEFAULT NULL COMMENT '商品id',
  `order_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单编号',
  `sour_openid` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '直接购买者',
  `earn_openid` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '获取返利对象',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `level` int(11) DEFAULT NULL COMMENT '分销层级',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='返利信息记录表';

-- ----------------------------
-- Table structure for fx_sys
-- ----------------------------
DROP TABLE IF EXISTS `fx_sys`;
CREATE TABLE `fx_sys` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `head_url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '公众号头像',
  `pay_title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '关注标题',
  `pay_title2` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '关注副标题',
  `serv_wechat` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '客服微信',
  `pay_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '关注公众号二维码',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for fx_welcome
-- ----------------------------
DROP TABLE IF EXISTS `fx_welcome`;
CREATE TABLE `fx_welcome` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `look_num` int(11) DEFAULT NULL COMMENT '浏览数',
  `forward_num` int(11) DEFAULT NULL COMMENT '分享数',
  `buy_num` int(11) DEFAULT NULL COMMENT '报名数',
  `gid` int(11) DEFAULT NULL COMMENT '活动id',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1284 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for hdb_bill
-- ----------------------------
DROP TABLE IF EXISTS `hdb_bill`;
CREATE TABLE `hdb_bill` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `state` int(11) DEFAULT NULL COMMENT '1  未结算  2  已结算',
  `type` int(11) DEFAULT NULL COMMENT '1 活动收入  2 活动退款  3 收入提现',
  `content` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '账单明细',
  `price` decimal(10,2) DEFAULT NULL COMMENT '金额',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `openid` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信凭证',
  `order_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单编号',
  `act_id` int(11) DEFAULT NULL COMMENT '活动id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=261 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for join_obj
-- ----------------------------
DROP TABLE IF EXISTS `join_obj`;
CREATE TABLE `join_obj` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '报名人姓名',
  `adult_num` int(11) DEFAULT NULL COMMENT '成年人数量',
  `child_num` int(11) DEFAULT NULL COMMENT '孩子的数量',
  `act_id` int(11) DEFAULT NULL COMMENT '活动id',
  `phone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号码',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `state` int(11) DEFAULT NULL COMMENT '0:待审核  1:审核通过  2:拒绝申请',
  `wechat` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信号',
  `path` varchar(400) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '地址信息',
  `openid` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信端id',
  `nickname` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信昵称',
  `headimgurl` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信头像',
  `tags` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '标签',
  `consume_price` decimal(10,2) DEFAULT NULL COMMENT '消费金额',
  `fx_earning_price` decimal(10,2) DEFAULT NULL COMMENT '收益金额 fx系统',
  `fx_invite_per` int(11) DEFAULT NULL COMMENT '邀请的人数  分销系统',
  `placard` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '海报地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=210 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '信息内容',
  `msg_num` int(11) DEFAULT NULL COMMENT '发送条数',
  `person_num` int(11) DEFAULT NULL COMMENT '发送人数',
  `create_date` datetime DEFAULT NULL COMMENT '发送时间',
  `state` int(11) DEFAULT NULL COMMENT '发送状态  1  成功  0  失败',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单编号',
  `act_title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '活动标题',
  `ticket_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '活动票名',
  `ticket_price` decimal(10,2) DEFAULT NULL COMMENT '票价格',
  `openid` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户的微信凭证',
  `state` int(11) DEFAULT NULL COMMENT '订单状态  0 待付款  1  待验证  2  已完成  3  已拒绝  4  待审核  5  已评价  6 已退款',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `origin` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单下单工具',
  `act_id` int(11) DEFAULT NULL COMMENT '活动id',
  `ticket_id` int(11) DEFAULT NULL COMMENT '票id',
  `verify_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '检验码',
  `verify_code_date` datetime DEFAULT NULL COMMENT '验票时间',
  `act_type` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '活动类型',
  `act_start_date` datetime DEFAULT NULL COMMENT '活动开始时间',
  `act_end_date` datetime DEFAULT NULL COMMENT '活动结束时间',
  `act_posterPath` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '活动海报',
  `evaluate_star` int(11) DEFAULT NULL COMMENT '几颗星',
  `evaluate_content` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '评价内容',
  `evaluate_date` datetime DEFAULT NULL COMMENT '评论时间',
  `act_province` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '活动省',
  `act_city` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '活动市',
  `act_district` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '活动区',
  `act_detailPath` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '活动具体地址',
  `pay_date` datetime DEFAULT NULL COMMENT '支付时间',
  `transaction_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商家编号',
  `out_refund_no` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '退款编号',
  `refund_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '退款id',
  `refund_date` datetime DEFAULT NULL COMMENT '退款时间',
  `adult_num` int(11) DEFAULT NULL COMMENT '大人数',
  `child_num` int(11) DEFAULT NULL COMMENT '孩子数',
  `phone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  `wechat` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户微信号',
  `path` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户地址',
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=247 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for send_code
-- ----------------------------
DROP TABLE IF EXISTS `send_code`;
CREATE TABLE `send_code` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '验证码',
  `phone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  `sendDate` datetime DEFAULT NULL COMMENT '发送时间',
  `time` int(11) DEFAULT NULL COMMENT '有效时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=190 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for sm_fx_member
-- ----------------------------
DROP TABLE IF EXISTS `sm_fx_member`;
CREATE TABLE `sm_fx_member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `member_openid` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户openid',
  `recommend_openid` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '推荐者openid',
  `order_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单编号',
  `price` decimal(10,2) DEFAULT NULL COMMENT '支付金额',
  `ret_price` decimal(10,2) DEFAULT NULL COMMENT '返还金额',
  `lev_num` int(11) DEFAULT NULL COMMENT '几级分销',
  `gid` int(11) DEFAULT NULL COMMENT '商品id',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `state` int(11) DEFAULT '0' COMMENT '0 代表未付款  1  代表付款成功',
  `ret_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '返现编号',
  `ret_price2` decimal(10,2) DEFAULT NULL COMMENT '二次分销金额',
  `ret_code2` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '二次分销支付编号',
  `invite_per` int(11) DEFAULT NULL COMMENT '邀请的人数  某个商品下',
  `sys` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '系统标记',
  `pid` int(11) DEFAULT NULL COMMENT '上级id  推荐者数据对应id',
  `ogid` int(11) DEFAULT NULL COMMENT '订单商品id',
  `ret_type` int(11) DEFAULT '1' COMMENT '1 代表未完成返利  2 代表已完成返利',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=154 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for sm_fx_param
-- ----------------------------
DROP TABLE IF EXISTS `sm_fx_param`;
CREATE TABLE `sm_fx_param` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `buy_type` int(11) DEFAULT '1' COMMENT '1 表示正常分销  2  购买可分销',
  `param` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '分销json型参数',
  `gid` int(11) DEFAULT NULL COMMENT '商品id',
  `num_type` int(11) DEFAULT '1' COMMENT '1 表示按百分比例  2  表示按倍数',
  `info` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '描述',
  `type` int(11) DEFAULT '1' COMMENT '1 非默认 2 默认',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for sm_fx_recommend_ret
-- ----------------------------
DROP TABLE IF EXISTS `sm_fx_recommend_ret`;
CREATE TABLE `sm_fx_recommend_ret` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `member_id` int(11) DEFAULT NULL COMMENT '购买者id',
  `recommend_id` int(11) DEFAULT NULL COMMENT '推荐者id',
  `order_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单编号',
  `price` decimal(10,2) DEFAULT NULL COMMENT '支付金额',
  `ret_price` decimal(10,2) DEFAULT NULL COMMENT '返还金额',
  `lev_num` int(11) DEFAULT NULL COMMENT '几级分销',
  `gid` int(11) DEFAULT NULL COMMENT '商品id',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `state` int(11) DEFAULT '0' COMMENT '0 代表未付款  1  代表付款成功',
  `ret_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '返现编号',
  `ret_price2` decimal(10,2) DEFAULT NULL COMMENT '二次分销金额',
  `ret_code2` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '二次分销支付编号',
  `invite_per` int(11) DEFAULT NULL COMMENT '邀请的人数  某个商品下',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for sm_fx_ret_msg
-- ----------------------------
DROP TABLE IF EXISTS `sm_fx_ret_msg`;
CREATE TABLE `sm_fx_ret_msg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ret_price` decimal(11,2) DEFAULT NULL COMMENT '返利金额',
  `ret_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '返利编号',
  `openid` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '直接推荐者',
  `gid` int(11) DEFAULT NULL COMMENT '商品id',
  `order_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单编号',
  `sour_openid` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '直接购买者',
  `earn_openid` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '获取返利对象',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `level` int(11) DEFAULT NULL COMMENT '分销层级',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='返利信息记录表';

-- ----------------------------
-- Table structure for sm_fx_template
-- ----------------------------
DROP TABLE IF EXISTS `sm_fx_template`;
CREATE TABLE `sm_fx_template` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '模板名',
  `ucode` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户编号',
  `param` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '分销比例参数',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `buy_type` int(255) DEFAULT '1' COMMENT '1 表示正常分销  2  购买可分销',
  `num_type` int(255) DEFAULT '1' COMMENT '1 表示按百分比例  2  表示按倍数',
  `info` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '描述',
  `type` int(255) DEFAULT '1' COMMENT '1 非默认 2 默认',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for sm_goods
-- ----------------------------
DROP TABLE IF EXISTS `sm_goods`;
CREATE TABLE `sm_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品名称',
  `price` decimal(10,2) DEFAULT NULL COMMENT '价格',
  `type` int(11) DEFAULT '0' COMMENT '商品类型',
  `createDate` datetime DEFAULT NULL COMMENT '商品创建时间',
  `shopId` int(11) DEFAULT NULL COMMENT '商家id',
  `num` int(11) DEFAULT NULL COMMENT '库存',
  `content` text COLLATE utf8mb4_unicode_ci COMMENT '商品详情',
  `repertory_type` int(11) DEFAULT '0' COMMENT '0:上架,1:下架',
  `temp_id` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '模板id',
  `ucode` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户编号',
  `head_url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '封面',
  `state` int(11) DEFAULT '0' COMMENT '1 代表删除状态',
  `belong` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '属于商品 还是 课程',
  `type_two` int(11) DEFAULT NULL COMMENT '二级分类',
  `content_two` text COLLATE utf8mb4_unicode_ci COMMENT '详情二',
  `file_path` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '文件路径',
  `pid` int(11) DEFAULT NULL COMMENT '所属分类',
  `look_num` int(11) DEFAULT '0' COMMENT '浏览量',
  `forward_num` int(11) DEFAULT '0' COMMENT '转发分享邀请数',
  `buy_num` int(11) DEFAULT '0' COMMENT '购买数',
  `special_price` decimal(10,2) DEFAULT '0.00' COMMENT '特价',
  `remain_num` int(11) DEFAULT NULL,
  `series_id` int(11) DEFAULT '0' COMMENT '系列id',
  `tab` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '商品标签',
  `fx_state` int(255) DEFAULT '1' COMMENT '1 表示不分销  2  表示可以分销',
  `series_state` int(255) DEFAULT '1' COMMENT '1 代表不是系列  2  代表是系列',
  `fx_template_id` int(11) DEFAULT '0' COMMENT '分销模板id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=129 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for sm_goods_evaluate
-- ----------------------------
DROP TABLE IF EXISTS `sm_goods_evaluate`;
CREATE TABLE `sm_goods_evaluate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gid` int(11) DEFAULT NULL COMMENT '商品id',
  `msg` text COLLATE utf8mb4_unicode_ci COMMENT '评价内容',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `openid` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户凭证',
  `file_paths` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '文件路径',
  `order_id` int(11) DEFAULT NULL COMMENT '订单id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for sm_member
-- ----------------------------
DROP TABLE IF EXISTS `sm_member`;
CREATE TABLE `sm_member` (
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
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Table structure for sm_menu
-- ----------------------------
DROP TABLE IF EXISTS `sm_menu`;
CREATE TABLE `sm_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `parent_id` int(11) DEFAULT NULL COMMENT '父id 为0时表示未一级目录',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `url` varchar(100) DEFAULT NULL COMMENT '访问的url',
  `is_parent` int(1) NOT NULL DEFAULT '0' COMMENT '是否有子节点0为无1为有',
  `icon` varchar(300) DEFAULT NULL COMMENT '图标头像',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=129 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='权限表';

-- ----------------------------
-- Table structure for sm_order
-- ----------------------------
DROP TABLE IF EXISTS `sm_order`;
CREATE TABLE `sm_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_code` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单编号',
  `openid` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信凭证',
  `bill` int(255) DEFAULT NULL,
  `pay_price` decimal(10,2) DEFAULT NULL COMMENT '订单下的商品总金额',
  `type` int(11) DEFAULT NULL COMMENT '订单类型|0:创建订单|1:待付款|2:待发货|3:待收货|4:待评价|5:售后|6:退款|7:退款中|8:退款成功',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `updDate` datetime DEFAULT NULL COMMENT '更新时间',
  `transaction_id` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信支付编号',
  `out_refund_no` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商户退款单号',
  `refund_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信退款单号',
  `state` int(11) DEFAULT '0' COMMENT '1 表示已删除',
  `num` int(11) DEFAULT NULL COMMENT '商品件数',
  `belong` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '属于商品 还是 课程',
  `temp_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '模板名字',
  `temp_price` decimal(10,2) DEFAULT NULL COMMENT '快递模板支付价格',
  `fx_type` int(255) DEFAULT '1' COMMENT '1 不分销  2  分销',
  `order_date` datetime DEFAULT NULL COMMENT '下单时间',
  `pay_date` datetime DEFAULT NULL COMMENT '支付时间',
  `way_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '运单号',
  `express_company` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '快递公司',
  `deliver_date` datetime DEFAULT NULL COMMENT '发货时间',
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '收货人姓名',
  `path` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '收货人地址',
  `phone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '收货人联系方式',
  `take_date` datetime DEFAULT NULL COMMENT '收货时间',
  `evaluate_date` datetime DEFAULT NULL COMMENT '评论时间',
  `ret_date` datetime DEFAULT NULL COMMENT '退货时间',
  `apply_ret_date` datetime DEFAULT NULL COMMENT '申请退款时间',
  `ret_price` decimal(10,2) DEFAULT NULL COMMENT '退款金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=175 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for sm_order_detail
-- ----------------------------
DROP TABLE IF EXISTS `sm_order_detail`;
CREATE TABLE `sm_order_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单编号',
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品名称',
  `price` decimal(10,2) DEFAULT NULL COMMENT '商品价格',
  `head_url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品封面',
  `g_type` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品类型',
  `sname` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品规格名称',
  `sprice` decimal(10,2) DEFAULT NULL COMMENT '商品规格价格',
  `create_date` datetime DEFAULT NULL,
  `temp_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单快递模板名',
  `temp_first` int(11) DEFAULT NULL COMMENT '快递首件',
  `price_first` decimal(10,2) DEFAULT NULL,
  `temp_extend` int(11) DEFAULT NULL,
  `price_extend` decimal(10,2) DEFAULT NULL,
  `order_good_id` int(11) DEFAULT NULL COMMENT '订单商品id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for sm_order_goods
-- ----------------------------
DROP TABLE IF EXISTS `sm_order_goods`;
CREATE TABLE `sm_order_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gid` int(11) DEFAULT NULL COMMENT '商品ID',
  `pay_price` decimal(10,2) DEFAULT NULL COMMENT '支付价格',
  `order_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '对应订单表订单号',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `updDate` datetime DEFAULT NULL COMMENT '更新时间',
  `type` int(255) DEFAULT NULL COMMENT '订单类型|0:待付款|1:申请退货|2:已退货|3:待发货|4:发货|5:取消发货',
  `pay_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '支付编号',
  `good_num` int(11) DEFAULT NULL COMMENT '商品数量',
  `buy_openid` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '购买者openid',
  `recommend_openid` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '推荐者微信编号',
  `fromId` int(11) DEFAULT NULL COMMENT '对应分销表上下文id',
  `belong` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品标记',
  `fx_type` int(11) DEFAULT '1' COMMENT '1 不分销  2  分销',
  `curObjId` int(11) DEFAULT NULL COMMENT '当前分销对象对应fx_member_id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=318 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for sm_order_goods_property
-- ----------------------------
DROP TABLE IF EXISTS `sm_order_goods_property`;
CREATE TABLE `sm_order_goods_property` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_property_id` int(11) DEFAULT NULL COMMENT '商品属性ID',
  `order_goods_id` int(11) DEFAULT NULL COMMENT '商品id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for sm_path
-- ----------------------------
DROP TABLE IF EXISTS `sm_path`;
CREATE TABLE `sm_path` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '收货人姓名',
  `phone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号码',
  `province` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '省',
  `city` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '市',
  `district` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '区',
  `detailPath` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '详细地址',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `openid` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信凭证',
  `type` int(11) DEFAULT NULL COMMENT '1 代表默认选择',
  `tab` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '标签',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for sm_role
-- ----------------------------
DROP TABLE IF EXISTS `sm_role`;
CREATE TABLE `sm_role` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for sm_shopping
-- ----------------------------
DROP TABLE IF EXISTS `sm_shopping`;
CREATE TABLE `sm_shopping` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gid` int(11) DEFAULT NULL COMMENT '商品id',
  `openid` varchar(300) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信凭证',
  `type` int(11) DEFAULT NULL COMMENT '状态码|0:加入购物车|1:加入订单|2:取消购物车|3:提交购物车',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `updDate` datetime DEFAULT NULL COMMENT '更新时间',
  `good_num` int(11) DEFAULT NULL COMMENT '商品数量',
  `promptly` int(11) DEFAULT NULL COMMENT '0:表示非立即购买,1:表示立即购买',
  `state` int(11) DEFAULT NULL COMMENT '1  代表已删除',
  `buy_openid` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '购买者openid',
  `recommend_openid` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '推荐者微信编号',
  `fx_type` int(11) DEFAULT '1' COMMENT '1 不分销  2  分销',
  `fromId` int(11) DEFAULT NULL COMMENT '分销用户的上下文id',
  `curObjId` int(11) DEFAULT NULL COMMENT '购买对象对应的分销上下文id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for sm_shopping_property
-- ----------------------------
DROP TABLE IF EXISTS `sm_shopping_property`;
CREATE TABLE `sm_shopping_property` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL COMMENT '商品属性id',
  `sid` int(11) DEFAULT NULL COMMENT '购物车商品id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for sm_spec
-- ----------------------------
DROP TABLE IF EXISTS `sm_spec`;
CREATE TABLE `sm_spec` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sname` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '规格名称',
  `sprice` decimal(10,2) DEFAULT NULL COMMENT '价格',
  `snum` int(11) DEFAULT NULL COMMENT '库存',
  `gid` int(11) DEFAULT NULL COMMENT '商品id',
  `remain_snum` int(11) DEFAULT NULL COMMENT '库存剩余',
  `state` int(11) DEFAULT NULL COMMENT '1 代表删除了',
  `create_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for sm_sys_messge
-- ----------------------------
DROP TABLE IF EXISTS `sm_sys_messge`;
CREATE TABLE `sm_sys_messge` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系方式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='平台信息';

-- ----------------------------
-- Table structure for sm_sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sm_sys_permission`;
CREATE TABLE `sm_sys_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `per` varchar(255) DEFAULT NULL COMMENT '权限列表',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='权限表';

-- ----------------------------
-- Table structure for sm_sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sm_sys_role_permission`;
CREATE TABLE `sm_sys_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `rid` int(11) NOT NULL COMMENT '角色id',
  `pid` int(11) NOT NULL COMMENT '权限id',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='角色权限关系表';

-- ----------------------------
-- Table structure for sm_sys_role_user
-- ----------------------------
DROP TABLE IF EXISTS `sm_sys_role_user`;
CREATE TABLE `sm_sys_role_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL COMMENT '用户id',
  `rid` int(11) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for sm_temp
-- ----------------------------
DROP TABLE IF EXISTS `sm_temp`;
CREATE TABLE `sm_temp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '模板名',
  `type` int(11) DEFAULT NULL COMMENT '1 自定义运费  2 全国包邮',
  `create_date` datetime DEFAULT NULL COMMENT '更新时间',
  `state` int(11) DEFAULT NULL COMMENT '1 代表已删除',
  `ucode` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '对象编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for sm_temp_freight
-- ----------------------------
DROP TABLE IF EXISTS `sm_temp_freight`;
CREATE TABLE `sm_temp_freight` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `district` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '地区',
  `first` int(11) DEFAULT NULL COMMENT '首件',
  `price_first` decimal(10,2) DEFAULT NULL COMMENT '运费',
  `extend` int(11) DEFAULT NULL COMMENT '续件',
  `price_extend` decimal(10,2) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL COMMENT '更新时间',
  `tid` int(11) DEFAULT NULL COMMENT '模板id',
  `state` int(11) DEFAULT NULL COMMENT '1 代表删除了',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for sm_type
-- ----------------------------
DROP TABLE IF EXISTS `sm_type`;
CREATE TABLE `sm_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '类型名',
  `pid` int(11) DEFAULT NULL COMMENT '上级分类',
  `create_date` datetime DEFAULT NULL COMMENT '更新时间',
  `belong` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '属于商品 还是 课程',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for sm_user
-- ----------------------------
DROP TABLE IF EXISTS `sm_user`;
CREATE TABLE `sm_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '账号',
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密码',
  `real_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '真实姓名',
  `phone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号码',
  `code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户编号',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for sysjobpo
-- ----------------------------
DROP TABLE IF EXISTS `sysjobpo`;
CREATE TABLE `sysjobpo` (
  `jobId` int(11) NOT NULL AUTO_INCREMENT COMMENT '任务id',
  `beanName` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'bean名称',
  `methodName` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '方法名称',
  `methodParams` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '方法参数',
  `cronExpression` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'cron表达式',
  `remark` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  `jobStatus` int(11) DEFAULT NULL COMMENT '状态（1正常 0暂停）',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`jobId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for tb_auth
-- ----------------------------
DROP TABLE IF EXISTS `tb_auth`;
CREATE TABLE `tb_auth` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '编号',
  `auth_path` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '授权地址',
  `gid` int(11) DEFAULT NULL COMMENT '商品id',
  `mark` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '系统标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for ticket
-- ----------------------------
DROP TABLE IF EXISTS `ticket`;
CREATE TABLE `ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ticketName` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '票名称',
  `price` decimal(10,2) DEFAULT NULL COMMENT '票价',
  `num` int(11) DEFAULT NULL COMMENT '数量',
  `limitBuy` int(11) DEFAULT NULL COMMENT '限购',
  `actId` int(11) DEFAULT NULL COMMENT '活动id',
  `remain_num` int(11) DEFAULT NULL COMMENT '剩余数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for welcome
-- ----------------------------
DROP TABLE IF EXISTS `welcome`;
CREATE TABLE `welcome` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `look_num` int(11) DEFAULT NULL COMMENT '浏览数',
  `forward_num` int(11) DEFAULT NULL COMMENT '分享数',
  `join_num` int(11) DEFAULT NULL COMMENT '报名数',
  `act_id` int(11) DEFAULT NULL COMMENT '活动id',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `income` decimal(10,2) DEFAULT NULL COMMENT '当天活动收入',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2849 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
