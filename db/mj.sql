/*
Navicat MySQL Data Transfer

Source Server         : TEXT
Source Server Version : 50540
Source Host           : 127.0.0.1:3306
Source Database       : mj

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2020-05-06 11:24:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bed
-- ----------------------------
DROP TABLE IF EXISTS `bed`;
CREATE TABLE `bed` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `price` decimal(10,2) DEFAULT NULL COMMENT '床位价格',
  `unit_price` decimal(10,2) DEFAULT NULL COMMENT '单价  每小时多少钱  单位元',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for bed_order
-- ----------------------------
DROP TABLE IF EXISTS `bed_order`;
CREATE TABLE `bed_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单编号',
  `oppenid` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信凭证',
  `pay_price` decimal(10,2) DEFAULT NULL COMMENT '支付金额',
  `code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '锁编号',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `updateDate` datetime DEFAULT NULL COMMENT '更新时间',
  `transaction_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信支付编号',
  `state` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单类型|0:待付款|1:已完成|2:退款成功',
  `out_refund_no` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商户退款单号',
  `refund_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信退款单号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for bluetooth
-- ----------------------------
DROP TABLE IF EXISTS `bluetooth`;
CREATE TABLE `bluetooth` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL COMMENT '编码',
  `mac` varchar(255) DEFAULT NULL COMMENT '蓝牙地址',
  `state` int(11) DEFAULT NULL COMMENT '0:关锁状态|1:开锁状态',
  `line_state` int(11) DEFAULT NULL COMMENT '0:断开状态|1:连接状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for bluetooth_trouble
-- ----------------------------
DROP TABLE IF EXISTS `bluetooth_trouble`;
CREATE TABLE `bluetooth_trouble` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '设备编号',
  `state` int(11) DEFAULT NULL COMMENT '0:无法开锁|1:无法关锁|2:结算异常',
  `msg` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '详细信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for bluetooth_use
-- ----------------------------
DROP TABLE IF EXISTS `bluetooth_use`;
CREATE TABLE `bluetooth_use` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '蓝牙对应编号',
  `state` int(11) DEFAULT NULL COMMENT '0:使用|1:使用完毕',
  `openid` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户微信凭证',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `updDate` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for business
-- ----------------------------
DROP TABLE IF EXISTS `business`;
CREATE TABLE `business` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '称呼',
  `phone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `license` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '营业执照',
  `path` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商铺完整路径',
  `lat` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `lng` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `remark_id` varchar(400) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '保存数据标记id   无标记为原数据',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '市名',
  `code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '编号',
  `state_id` int(11) DEFAULT NULL COMMENT '省id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `name` varchar(50) NOT NULL COMMENT '名称',
  `lon` double(9,6) NOT NULL COMMENT '经度',
  `lat` double(8,6) NOT NULL COMMENT '纬度',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='商户表';

-- ----------------------------
-- Table structure for evaluate
-- ----------------------------
DROP TABLE IF EXISTS `evaluate`;
CREATE TABLE `evaluate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gid` int(11) DEFAULT NULL COMMENT '商品id',
  `msg` text COLLATE utf8mb4_unicode_ci COMMENT '评价内容',
  `createDate` date DEFAULT NULL COMMENT '创建时间',
  `oppenid` varchar(225) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户凭证',
  `state` int(11) DEFAULT NULL COMMENT '0:待审核.1:好评.2:差评',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for facility
-- ----------------------------
DROP TABLE IF EXISTS `facility`;
CREATE TABLE `facility` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `facility_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '设备编号',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `mac` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '设备物理地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for facility_log
-- ----------------------------
DROP TABLE IF EXISTS `facility_log`;
CREATE TABLE `facility_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `facility_id` varchar(300) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '设备编号',
  `link_createDate` datetime DEFAULT NULL COMMENT '链接时间',
  `break_createDate` datetime DEFAULT NULL COMMENT '断开时间',
  `state` int(11) DEFAULT NULL COMMENT '锁状态:0.链接|1.关闭',
  `oppenid` varchar(300) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户凭证',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品名称',
  `price` decimal(10,2) DEFAULT NULL COMMENT '价格',
  `type` int(255) DEFAULT NULL COMMENT '商品类型',
  `createDate` datetime DEFAULT NULL COMMENT '商品创建时间',
  `shopId` int(11) DEFAULT NULL COMMENT '商家id',
  `recommend` int(11) DEFAULT NULL COMMENT '0:推荐。1:精品.2:新品',
  `context` text COLLATE utf8mb4_unicode_ci COMMENT '商品详情',
  `all_type_id` int(11) DEFAULT NULL COMMENT '商品总分类',
  `reduced_price` decimal(10,2) DEFAULT NULL COMMENT '优惠价',
  `repertory_type` int(11) DEFAULT '0' COMMENT '0:上架,1:下架,2:售罄',
  `remark_id` varchar(400) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '保存数据标记id   无标记为原数据',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for goods_all_type
-- ----------------------------
DROP TABLE IF EXISTS `goods_all_type`;
CREATE TABLE `goods_all_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品总分类名',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for goods_path
-- ----------------------------
DROP TABLE IF EXISTS `goods_path`;
CREATE TABLE `goods_path` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `oppenid` varchar(300) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户凭证信息',
  `path` varchar(300) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '收货地址',
  `path2` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '地址信息2',
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '收货人',
  `call` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系方式',
  `state` int(11) DEFAULT NULL COMMENT '0:非默认,1:默认',
  `path3` varchar(300) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '地址3',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for goods_property
-- ----------------------------
DROP TABLE IF EXISTS `goods_property`;
CREATE TABLE `goods_property` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '类型',
  `goods_id` int(11) DEFAULT NULL COMMENT '商品id',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `business_id` int(11) DEFAULT NULL COMMENT '商家id',
  `property_id` int(11) DEFAULT NULL COMMENT '属性id',
  `img_path` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '图片地址',
  `remark_id` varchar(400) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '保存数据标记id   无标记为原数据',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for goods_type
-- ----------------------------
DROP TABLE IF EXISTS `goods_type`;
CREATE TABLE `goods_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '名称',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `all_type_id` int(11) DEFAULT NULL COMMENT '总分类id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

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
-- Table structure for img
-- ----------------------------
DROP TABLE IF EXISTS `img`;
CREATE TABLE `img` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `img_path` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '图片地址',
  `gid` int(11) DEFAULT NULL COMMENT '商品id',
  `remark_id` varchar(400) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '保存数据标记id  无标记为原数据',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `phone` varchar(20) DEFAULT NULL COMMENT '注册手机号',
  `created` datetime DEFAULT NULL COMMENT '创建时间',
  `file` varchar(255) DEFAULT NULL COMMENT '头像',
  `oppenid` varchar(50) DEFAULT NULL COMMENT '微信oppenid',
  `score` int(11) DEFAULT NULL COMMENT '签到分数',
  `balance` decimal(10,2) DEFAULT NULL COMMENT '余额',
  `session_key` varchar(500) DEFAULT NULL COMMENT '微信参数加密数据',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_code` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单编号',
  `oppenid` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信凭证',
  `bill` int(255) DEFAULT NULL,
  `pay_price` decimal(10,2) DEFAULT NULL COMMENT '订单下的商品总金额',
  `state` int(11) DEFAULT NULL COMMENT '订单类型|0:待付款|1:待收货|2:待评价|3:已完成|4:退款失败|5:退款中|6:退款成功|7:处理中|8:发货中',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `updDate` datetime DEFAULT NULL COMMENT '更新时间',
  `transaction_id` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信支付编号',
  `out_refund_no` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商户退款单号',
  `refund_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信退款单号',
  `price_state` int(11) DEFAULT NULL COMMENT '0:正常订单 1:优惠订单',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for order_evaluate
-- ----------------------------
DROP TABLE IF EXISTS `order_evaluate`;
CREATE TABLE `order_evaluate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) DEFAULT NULL COMMENT '订单id',
  `msg` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '评价信息',
  `level1` int(11) DEFAULT NULL COMMENT '星级1',
  `level2` int(11) DEFAULT NULL COMMENT '星级2',
  `oppenid` varchar(225) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信凭证',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for order_goods
-- ----------------------------
DROP TABLE IF EXISTS `order_goods`;
CREATE TABLE `order_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gid` int(11) DEFAULT NULL COMMENT '商品ID',
  `pay_price` decimal(10,2) DEFAULT NULL COMMENT '支付价格',
  `business_id` int(11) DEFAULT NULL COMMENT '商家ID',
  `order_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '对应订单表订单号',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `updDate` datetime DEFAULT NULL COMMENT '更新时间',
  `type` int(255) DEFAULT NULL COMMENT '订单类型|0:待付款|1:申请退货|2:已退货|3:待发货|4:发货|5:取消发货',
  `pay_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '支付编号',
  `good_num` int(11) DEFAULT NULL COMMENT '商品数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=189 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for order_goods_property
-- ----------------------------
DROP TABLE IF EXISTS `order_goods_property`;
CREATE TABLE `order_goods_property` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_property_id` int(11) DEFAULT NULL COMMENT '商品属性ID',
  `order_goods_id` int(11) DEFAULT NULL COMMENT '商品id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for pay
-- ----------------------------
DROP TABLE IF EXISTS `pay`;
CREATE TABLE `pay` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pay_code` varchar(300) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '支付编号',
  `order_code` varchar(300) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单编号',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for property
-- ----------------------------
DROP TABLE IF EXISTS `property`;
CREATE TABLE `property` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '属性名',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `remark_id` varchar(400) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '保存数据标记id  无标记为原数据',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for refund_type
-- ----------------------------
DROP TABLE IF EXISTS `refund_type`;
CREATE TABLE `refund_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '类名',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for region
-- ----------------------------
DROP TABLE IF EXISTS `region`;
CREATE TABLE `region` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '区名',
  `code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '区编号',
  `city_id` int(11) DEFAULT NULL COMMENT '市id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for shopping
-- ----------------------------
DROP TABLE IF EXISTS `shopping`;
CREATE TABLE `shopping` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_id` int(11) DEFAULT NULL COMMENT '商品id',
  `oppenid` varchar(300) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信凭证',
  `state` int(11) DEFAULT NULL COMMENT '状态码|0:加入购物车|1:加入订单|2:取消购物车|3:提交购物车',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `pay_price` decimal(10,2) DEFAULT NULL COMMENT '支付金额',
  `business_id` int(11) DEFAULT NULL COMMENT '商家ID',
  `updDate` datetime DEFAULT NULL COMMENT '更新时间',
  `good_num` int(11) DEFAULT NULL COMMENT '商品数量',
  `promptly` int(11) DEFAULT NULL COMMENT '0:表示非立即购买,1:表示立即购买',
  `pay_reduced_price` decimal(10,2) DEFAULT NULL COMMENT '优惠总价',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for shopping_goods_property
-- ----------------------------
DROP TABLE IF EXISTS `shopping_goods_property`;
CREATE TABLE `shopping_goods_property` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_property_id` int(11) DEFAULT NULL COMMENT '商品属性id',
  `shopping_goods_id` int(11) DEFAULT NULL COMMENT '购物车商品id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for sign
-- ----------------------------
DROP TABLE IF EXISTS `sign`;
CREATE TABLE `sign` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mid` int(11) DEFAULT NULL COMMENT '用户id',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for sort
-- ----------------------------
DROP TABLE IF EXISTS `sort`;
CREATE TABLE `sort` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '类名',
  `parentId` int(11) DEFAULT NULL COMMENT '父节点id',
  `isRoot` int(11) DEFAULT NULL COMMENT '是否为根  0:代表根。1：代表子目录',
  `img_path` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '图片地址',
  `level` int(11) DEFAULT NULL COMMENT '级别',
  `use_obj` int(11) DEFAULT NULL COMMENT '分类作用对象id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for state
-- ----------------------------
DROP TABLE IF EXISTS `state`;
CREATE TABLE `state` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '城市',
  `code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for sys_messge
-- ----------------------------
DROP TABLE IF EXISTS `sys_messge`;
CREATE TABLE `sys_messge` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系方式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='平台信息';

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `parent_id` int(11) DEFAULT NULL COMMENT '父id 为0时表示未一级目录',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `purl` varchar(100) DEFAULT NULL COMMENT '访问的url',
  `is_parent` int(1) NOT NULL DEFAULT '0' COMMENT '是否有子节点0为无1为有',
  `icon` varchar(300) DEFAULT NULL COMMENT '图标头像',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=129 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='权限表';

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `rpid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `rid` int(11) NOT NULL COMMENT '角色id',
  `pid` int(11) NOT NULL COMMENT '权限id',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`rpid`)
) ENGINE=InnoDB AUTO_INCREMENT=634 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='角色权限关系表';

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
