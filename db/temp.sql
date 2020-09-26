/*
Navicat MySQL Data Transfer

Source Server         : TEXT
Source Server Version : 50540
Source Host           : 127.0.0.1:3306
Source Database       : temp

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2020-05-06 11:23:10
*/

SET FOREIGN_KEY_CHECKS=0;

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
) ENGINE=InnoDB AUTO_INCREMENT=148 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

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
) ENGINE=InnoDB AUTO_INCREMENT=137 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

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
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='返利信息记录表';

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

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
) ENGINE=InnoDB AUTO_INCREMENT=126 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

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
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8 COMMENT='用户表';

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
) ENGINE=InnoDB AUTO_INCREMENT=142 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

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
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

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
) ENGINE=InnoDB AUTO_INCREMENT=285 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for sm_order_goods_property
-- ----------------------------
DROP TABLE IF EXISTS `sm_order_goods_property`;
CREATE TABLE `sm_order_goods_property` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_property_id` int(11) DEFAULT NULL COMMENT '商品属性ID',
  `order_goods_id` int(11) DEFAULT NULL COMMENT '商品id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

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
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

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
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for sm_shopping_property
-- ----------------------------
DROP TABLE IF EXISTS `sm_shopping_property`;
CREATE TABLE `sm_shopping_property` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL COMMENT '商品属性id',
  `sid` int(11) DEFAULT NULL COMMENT '购物车商品id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

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
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for sm_sys_messge
-- ----------------------------
DROP TABLE IF EXISTS `sm_sys_messge`;
CREATE TABLE `sm_sys_messge` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系方式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='平台信息';

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
) ENGINE=InnoDB AUTO_INCREMENT=635 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='角色权限关系表';

-- ----------------------------
-- Table structure for sm_sys_role_user
-- ----------------------------
DROP TABLE IF EXISTS `sm_sys_role_user`;
CREATE TABLE `sm_sys_role_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL COMMENT '用户id',
  `rid` int(11) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

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
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

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
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

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
-- Table structure for sys_auth_good
-- ----------------------------
DROP TABLE IF EXISTS `sys_auth_good`;
CREATE TABLE `sys_auth_good` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tab` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品标签',
  `alias` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品别名',
  `itemId` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品编号',
  `sys` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '所属平台',
  `upd_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

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
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
