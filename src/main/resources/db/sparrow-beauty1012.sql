/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.6.44 : Database - sparrow-beauty
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sparrow-beauty` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `sparrow-beauty`;

/*Table structure for table `tb_activity` */

DROP TABLE IF EXISTS `tb_activity`;

CREATE TABLE `tb_activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `activity_name` varchar(32) DEFAULT NULL COMMENT '活动名称',
  `activity_type` varchar(2) DEFAULT NULL COMMENT '活动类型 0 全场折扣 1 限时活动',
  `start_date` date DEFAULT NULL COMMENT '开始日期',
  `end_date` date DEFAULT NULL COMMENT '结束日期',
  `start_hour` int(11) DEFAULT NULL COMMENT '开始时间',
  `end_hour` int(11) DEFAULT NULL COMMENT '结束时间',
  `activity_poster` varchar(256) DEFAULT NULL COMMENT '活动海报',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `activity_ratio` varchar(4) DEFAULT NULL COMMENT '活动折扣',
  `cms_user_id` int(11) DEFAULT NULL COMMENT '创建者',
  `cms_user_name` varchar(32) DEFAULT NULL COMMENT '创建人名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='活动定义表';

/*Data for the table `tb_activity` */

/*Table structure for table `tb_activity_goods` */

DROP TABLE IF EXISTS `tb_activity_goods`;

CREATE TABLE `tb_activity_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `activity_id` int(11) DEFAULT NULL COMMENT '活动id',
  `activity_name` varchar(32) DEFAULT NULL COMMENT '活动名称',
  `goods_id` int(11) DEFAULT NULL COMMENT '商品id',
  `goods_name` varchar(64) DEFAULT NULL COMMENT '商品名称',
  `price_type` int(2) DEFAULT NULL COMMENT '价格类型 0-指定价格 1-折扣价',
  `activit_price` varchar(16) DEFAULT NULL COMMENT '活动价格',
  `activity_ratio` varchar(4) DEFAULT NULL COMMENT '折扣比例',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `cms_user_id` int(11) DEFAULT NULL COMMENT '创建者',
  `cms_user_name` varchar(32) DEFAULT NULL COMMENT '创建者名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='活动商品关联表';

/*Data for the table `tb_activity_goods` */

/*Table structure for table `tb_api_user` */

DROP TABLE IF EXISTS `tb_api_user`;

CREATE TABLE `tb_api_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `nick_name` varchar(64) DEFAULT NULL COMMENT '微信昵称',
  `wechat_num` varchar(64) DEFAULT NULL COMMENT '微信号',
  `oppen_id` varchar(128) DEFAULT NULL COMMENT '微信唯一标识',
  `wechat_phone_num` varchar(16) DEFAULT NULL COMMENT '微信关联电话号码',
  `user_bind_phone_num` varchar(16) DEFAULT NULL COMMENT '用户绑定电话号码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `user_head_image` varchar(512) DEFAULT NULL COMMENT '用户头像',
  `referrer_oppen_id` varchar(128) DEFAULT NULL COMMENT '推荐人id',
  `gift_receive_status` int(2) DEFAULT '0' COMMENT '新人礼包领取状态 0 未领取 1已经领取',
  `is_dealer` int(2) DEFAULT '0' COMMENT '是否是经销商 0不是 1是',
  `dealer_level_id` int(11) DEFAULT NULL COMMENT '经销商等级id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='小程序用户表';

/*Data for the table `tb_api_user` */

/*Table structure for table `tb_carousel` */

DROP TABLE IF EXISTS `tb_carousel`;

CREATE TABLE `tb_carousel` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `image_url` varchar(256) DEFAULT NULL COMMENT '图片地址',
  `goto_url` varchar(256) DEFAULT NULL COMMENT '跳转地址',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='小程序轮播表';

/*Data for the table `tb_carousel` */

/*Table structure for table `tb_cart` */

DROP TABLE IF EXISTS `tb_cart`;

CREATE TABLE `tb_cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `oppen_id` varchar(128) DEFAULT NULL COMMENT '用户唯一标识',
  `goods_id` int(11) DEFAULT NULL COMMENT '商品id',
  `show_price` double(12,2) DEFAULT NULL COMMENT '购物车显示价格，商品价格+sku_detail价格',
  `sku_detail_ids` varchar(128) DEFAULT NULL COMMENT '用户选中的sku_detai_id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `goods_count` int(4) DEFAULT NULL COMMENT '商品数量',
  `sku_detail_desc` varchar(32) DEFAULT NULL COMMENT '商品规格描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='购物车表';

/*Data for the table `tb_cart` */

/*Table structure for table `tb_cms_user` */

DROP TABLE IF EXISTS `tb_cms_user`;

CREATE TABLE `tb_cms_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_name` varchar(32) DEFAULT NULL COMMENT '用户名称',
  `login_name` varchar(32) DEFAULT NULL COMMENT '登陆名称',
  `password` varchar(16) DEFAULT NULL COMMENT '登陆密码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='后台用户表';

/*Data for the table `tb_cms_user` */

/*Table structure for table `tb_commission_record` */

DROP TABLE IF EXISTS `tb_commission_record`;

CREATE TABLE `tb_commission_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `open_id` varchar(64) DEFAULT NULL COMMENT '用户id',
  `trading_id` varchar(64) DEFAULT NULL COMMENT '关联交易id 对应订单id',
  `trading_amount` varchar(16) DEFAULT NULL COMMENT '交易金额',
  `consumer_open_id` varchar(64) DEFAULT NULL COMMENT '消费者open_id',
  `commission_ratio` varchar(4) DEFAULT NULL COMMENT '佣金分配比例',
  `settlement_status` int(2) DEFAULT '0' COMMENT '结算状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `consumer_source` int(2) DEFAULT '0' COMMENT '佣金来源 0 一级分销佣金 1 二级分销佣金',
  `serial_no` varchar(64) DEFAULT NULL COMMENT '佣金业务id唯一表示',
  `api_user_id` int(11) DEFAULT NULL COMMENT '用户系统id',
  `commission_amount` varchar(8) DEFAULT NULL COMMENT '佣金金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='佣金记录表';

/*Data for the table `tb_commission_record` */

/*Table structure for table `tb_coupons` */

DROP TABLE IF EXISTS `tb_coupons`;

CREATE TABLE `tb_coupons` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `coupons_type` int(2) DEFAULT NULL COMMENT '1-折扣券 2-满减券 3-团购券',
  `coupons_name` varchar(32) DEFAULT NULL,
  `coupons_ratio` varchar(8) DEFAULT NULL,
  `consume_amount` int(4) DEFAULT '0',
  `reduce_amount` int(4) DEFAULT '0',
  `consume_count` int(4) DEFAULT '0',
  `give_count` int(4) DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `coupons_poster` varchar(128) DEFAULT NULL COMMENT '优惠券海报图片',
  `use_rules` varchar(128) DEFAULT NULL COMMENT '使用规则',
  `use_scope` varchar(128) DEFAULT NULL COMMENT '使用范围',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='优惠券定义表';

/*Data for the table `tb_coupons` */

/*Table structure for table `tb_dealer_level` */

DROP TABLE IF EXISTS `tb_dealer_level`;

CREATE TABLE `tb_dealer_level` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(32) DEFAULT NULL COMMENT '经销商等级名称',
  `share_count` int(8) DEFAULT NULL COMMENT '分享人数',
  `sell_amount` int(8) DEFAULT NULL COMMENT '分享销售金额',
  `logical_relation` int(2) DEFAULT '0' COMMENT '条件逻辑关系 0 两者同时满足 1 两者满足其一',
  `commission_ratio` varchar(4) DEFAULT NULL COMMENT '佣金分配比列',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `cms_user_id` int(11) DEFAULT NULL COMMENT '创建者id',
  `cms_user_name` varchar(32) DEFAULT NULL COMMENT '创建者姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='经销商等级定义表';

/*Data for the table `tb_dealer_level` */

/*Table structure for table `tb_goods` */

DROP TABLE IF EXISTS `tb_goods`;

CREATE TABLE `tb_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `goods_name` varchar(128) DEFAULT NULL COMMENT '商品名称',
  `selling point` varchar(128) DEFAULT NULL COMMENT '卖点介绍',
  `goods_price` varchar(128) DEFAULT NULL COMMENT '商品价格',
  `goods_inventory` varchar(128) DEFAULT NULL COMMENT '商品库存',
  `goods_status` int(2) DEFAULT NULL COMMENT '商品状态 0 下架 1 上架',
  `goods_poster` varchar(128) DEFAULT NULL COMMENT '商品首页海报',
  `goods_carousel_image` varchar(1024) DEFAULT NULL COMMENT '商品详情轮播图片',
  `goods_detail_images` varchar(1024) DEFAULT NULL COMMENT '商品详情图片',
  `is_trial` int(11) DEFAULT NULL COMMENT '是否是试用装 0 不是 1 是',
  `sku_type_ids` varchar(64) DEFAULT NULL COMMENT 'sku类型ids',
  `default_sku_detail_ids` varchar(64) DEFAULT NULL COMMENT 'sku明细ids',
  `simple_desc` varchar(512) DEFAULT NULL COMMENT '商品简单描述',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `cms_user_id` int(11) DEFAULT NULL COMMENT '创建者',
  `cms_user_name` varchar(64) DEFAULT NULL COMMENT '创建者名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';

/*Data for the table `tb_goods` */

/*Table structure for table `tb_integral_record` */

DROP TABLE IF EXISTS `tb_integral_record`;

CREATE TABLE `tb_integral_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `open_id` varchar(64) DEFAULT NULL COMMENT '用户唯一标识',
  `integral_source` int(2) DEFAULT NULL COMMENT '积分来源 0消费 1活动赠送',
  `trading_id` varchar(64) DEFAULT NULL COMMENT '交易编号，消费类型下的订单边号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  `integral_amount` int(8) DEFAULT NULL COMMENT '积分数量',
  `api_user_id` int(11) DEFAULT NULL COMMENT '用户系统id',
  `serial_no` varchar(64) DEFAULT NULL COMMENT '积分记录id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='积分记录表';

/*Data for the table `tb_integral_record` */

/*Table structure for table `tb_order` */

DROP TABLE IF EXISTS `tb_order`;

CREATE TABLE `tb_order` (
  `order_id` varchar(64) NOT NULL COMMENT '订单主键',
  `order_name` varchar(64) DEFAULT NULL COMMENT '订单名称',
  `order_amount` varchar(16) DEFAULT NULL COMMENT '订单总金额',
  `payment_amount` varchar(16) DEFAULT NULL COMMENT '支付金额',
  `payment_channel` int(2) DEFAULT '0' COMMENT '支付渠道 0 微信支付',
  `order_status` int(2) DEFAULT NULL COMMENT '订单状态 0 未支付 1支付成功，待发货 2已发货 3已经签收 4超时关闭 5 订单取消',
  `order_postage_amount` varchar(8) DEFAULT NULL COMMENT '订单邮费',
  `goods_amount` varchar(8) DEFAULT NULL COMMENT '商品金额',
  `coupons_reduce_amount` varchar(8) DEFAULT NULL COMMENT '优惠减免金额',
  `payment_time` datetime DEFAULT NULL COMMENT '支付时间',
  `delivery_time` datetime DEFAULT NULL COMMENT '发货时间',
  `logistics_name` varchar(64) DEFAULT NULL COMMENT '物流名称',
  `logistics_code` varchar(64) DEFAULT NULL COMMENT '物流编号',
  `api_user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `api_user_message` varchar(512) DEFAULT NULL COMMENT '买家留言',
  `api_user_nick` varchar(64) DEFAULT NULL COMMENT '买家昵称',
  `open_id` varchar(64) DEFAULT NULL COMMENT '用户open_id',
  `address` varchar(512) DEFAULT NULL COMMENT '收件地址',
  `phone_num` varchar(16) DEFAULT NULL COMMENT '电话号码',
  `poster_url` varchar(128) DEFAULT NULL COMMENT '海报图',
  `goods_total_count` varchar(4) DEFAULT NULL COMMENT '订单商品数量',
  `api_user_coupons_id` int(11) DEFAULT NULL COMMENT '用户优惠券id',
  `api_user_coupons_name` varchar(64) DEFAULT NULL COMMENT '优惠券名称',
  `api_user_address_id` int(11) DEFAULT NULL COMMENT '收件地址id',
  `is_first_order` int(2) DEFAULT '0' COMMENT '是否首单',
  `create_time` datetime DEFAULT NULL COMMENT '订单创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '订单更新时间',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

/*Data for the table `tb_order` */

/*Table structure for table `tb_order_detail` */

DROP TABLE IF EXISTS `tb_order_detail`;

CREATE TABLE `tb_order_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `order_id` varchar(64) DEFAULT NULL COMMENT '订单id',
  `goods_id` int(11) DEFAULT NULL COMMENT '商品id',
  `sku_type_ids` varchar(64) DEFAULT NULL COMMENT 'sku类型ids',
  `default_sku_detail_ids` varchar(64) DEFAULT NULL COMMENT 'sku明细ids',
  `goods_num` int(4) DEFAULT NULL COMMENT '商品数量',
  `goods_name` varchar(128) DEFAULT NULL COMMENT '商品名称',
  `goods_price` varchar(8) DEFAULT NULL COMMENT '商品价格  购物车价格',
  `goods_total_amount` varchar(8) DEFAULT NULL COMMENT '商品总金额',
  `sku_detail_desc` varchar(128) DEFAULT NULL COMMENT 'sku明细描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单明细表';

/*Data for the table `tb_order_detail` */

/*Table structure for table `tb_sku_detail` */

DROP TABLE IF EXISTS `tb_sku_detail`;

CREATE TABLE `tb_sku_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `sku_type_id` int(11) DEFAULT NULL COMMENT '类型id',
  `sku_detail_name` varchar(32) DEFAULT NULL COMMENT '名称',
  `sku_detail_price` varchar(8) DEFAULT NULL COMMENT '价格',
  `cms_view` varchar(32) DEFAULT NULL COMMENT 'cms显示名称',
  `remark` varchar(64) DEFAULT NULL COMMENT '描述',
  `cms_user_id` int(11) DEFAULT NULL COMMENT '创建者',
  `cms_user_name` varchar(32) DEFAULT NULL COMMENT '创建者名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='sku明细表';

/*Data for the table `tb_sku_detail` */

/*Table structure for table `tb_sku_type` */

DROP TABLE IF EXISTS `tb_sku_type`;

CREATE TABLE `tb_sku_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `sku_type_name` varchar(16) DEFAULT NULL COMMENT 'sku类型id',
  `remark` varchar(32) DEFAULT NULL COMMENT '描述',
  `cms_user_id` int(11) DEFAULT NULL COMMENT '创建者id',
  `cms_user_name` varchar(32) DEFAULT NULL COMMENT '创建名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='sku分类表';

/*Data for the table `tb_sku_type` */

/*Table structure for table `tb_suit` */

DROP TABLE IF EXISTS `tb_suit`;

CREATE TABLE `tb_suit` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `first_name` varchar(16) DEFAULT NULL COMMENT '一级名称',
  `second_name` varchar(64) DEFAULT NULL COMMENT '二级名称',
  `suit_price` varchar(16) DEFAULT NULL COMMENT '套餐价格',
  `sku_detail_ids` varchar(32) DEFAULT NULL COMMENT '套餐拥有sku_detail id',
  `sku_detail_descs` varchar(128) DEFAULT NULL COMMENT '套餐拥有sku_detail_desc，小程序显示',
  `suit_cover` varchar(64) DEFAULT NULL COMMENT '套装封面，商品列表页展示',
  `suit_detail_poster` varchar(1024) DEFAULT NULL COMMENT '套装明细海报，商品详情页显示 集合',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `cms_user_id` int(11) DEFAULT NULL COMMENT '创建者id',
  `cms_user_name` varchar(16) DEFAULT NULL COMMENT '创建者名称',
  `simple_desc` varchar(256) DEFAULT NULL COMMENT '套装简单描述',
  `second_desc` varchar(512) DEFAULT NULL COMMENT '套装二级描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='套餐表';

/*Data for the table `tb_suit` */

/*Table structure for table `tb_user_account` */

DROP TABLE IF EXISTS `tb_user_account`;

CREATE TABLE `tb_user_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `open_id` varchar(64) DEFAULT NULL COMMENT '用户oppen_id',
  `api_user_id` int(11) DEFAULT NULL COMMENT '用户系统id',
  `total_amount` varchar(16) DEFAULT NULL COMMENT '总金额',
  `remaining_amount` varchar(16) DEFAULT NULL COMMENT '可用金额',
  `withdrawaling_amount` varchar(8) DEFAULT NULL COMMENT '体现中金额',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `freeze_amount` varchar(16) DEFAULT NULL COMMENT '冻结中金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户账户表';

/*Data for the table `tb_user_account` */

/*Table structure for table `tb_user_account_change` */

DROP TABLE IF EXISTS `tb_user_account_change`;

CREATE TABLE `tb_user_account_change` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `open_id` varchar(64) DEFAULT NULL COMMENT '用户open_id',
  `api_user_id` int(11) DEFAULT NULL COMMENT '用户系统id',
  `cash_direction` int(2) DEFAULT '0' COMMENT '现金流向 0流出 1流入',
  `cash_amount` varchar(8) DEFAULT NULL COMMENT '现金金额',
  `trading_source` int(2) DEFAULT '0' COMMENT '交易来源 0 提现 1佣金结算',
  `trading_id` varchar(64) DEFAULT NULL COMMENT '交易来源id',
  `serial_no` varchar(64) DEFAULT NULL COMMENT '唯一序列号',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账户变动流水';

/*Data for the table `tb_user_account_change` */

/*Table structure for table `tb_user_coupons` */

DROP TABLE IF EXISTS `tb_user_coupons`;

CREATE TABLE `tb_user_coupons` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `open_id` varchar(128) DEFAULT NULL COMMENT '用户唯一表示',
  `coupons_id` int(11) DEFAULT NULL COMMENT '优惠券id',
  `coupons_name` varchar(32) DEFAULT NULL COMMENT '优惠券名称',
  `receive_date` int(8) DEFAULT NULL COMMENT '领取日期',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `status` int(2) DEFAULT NULL COMMENT '状态 0未使用 1锁定中 2已经使用',
  `coupons_poster` varchar(128) DEFAULT NULL COMMENT '优惠券海报',
  `expire_date` datetime DEFAULT NULL COMMENT '过期时间',
  `is_referrer` int(2) DEFAULT '0' COMMENT '是否是推荐券 0-不是 1-是',
  `coupons_ratio` varchar(8) DEFAULT NULL COMMENT '折扣比例',
  `coupons_type` int(2) DEFAULT NULL COMMENT '优惠券类型 1折扣券 2 满减券 3团购券 4 免费券 5 通用券 6 现金券',
  `use_rules` varchar(128) DEFAULT NULL COMMENT '使用规则',
  `use_scope` varchar(128) DEFAULT NULL COMMENT '使用范围',
  `coupons_source` int(2) DEFAULT NULL COMMENT '优惠券来源 0 幸运抽奖 1 分享专属 2 新人大礼包 3系统派发',
  `source_name` varchar(32) DEFAULT NULL COMMENT '来源名称 幸运抽奖 分享专属 新人大礼包 系统派发',
  `activity_id` int(11) DEFAULT NULL COMMENT '活动id',
  `use_way` int(2) DEFAULT '0' COMMENT '使用方式 0小程序专享 1门店专享',
  `expire_type` int(2) DEFAULT '0' COMMENT '失效类型 0过期时间过期 1 仅限当日有效 2永久有效',
  `cash_amount` varchar(16) DEFAULT '0' COMMENT '现金券 面值金额',
  `api_user_id` int(11) DEFAULT NULL COMMENT '用户系统id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='用户优惠券表';

/*Data for the table `tb_user_coupons` */

/*Table structure for table `tb_user_pay_record` */

DROP TABLE IF EXISTS `tb_user_pay_record`;

CREATE TABLE `tb_user_pay_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `api_user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `open_id` varchar(64) DEFAULT NULL COMMENT '用户open_id',
  `order_id` varchar(64) DEFAULT NULL COMMENT '订单id',
  `order_amount` varchar(8) DEFAULT NULL COMMENT '订单金额',
  `payment_amount` varchar(8) DEFAULT NULL COMMENT '支付金额',
  `nonce_str` varchar(64) DEFAULT NULL COMMENT '微信返回随机字符串',
  `prepay_id` varchar(64) DEFAULT NULL COMMENT '预支付id',
  `pay_status` int(64) DEFAULT NULL COMMENT '支付状态 0 新生成 1支付成功 2支付失败 3-超时关闭',
  `transaction_id` varchar(64) DEFAULT NULL COMMENT '微信支付事务id',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户支付记录表';

/*Data for the table `tb_user_pay_record` */

/*Table structure for table `tb_user_withdrawal_record` */

DROP TABLE IF EXISTS `tb_user_withdrawal_record`;

CREATE TABLE `tb_user_withdrawal_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `open_id` varchar(64) DEFAULT NULL COMMENT '用户open_id',
  `api_user_id` int(11) DEFAULT NULL COMMENT '用户系统id',
  `withdrawal_amount` varchar(8) DEFAULT NULL COMMENT '提现金额',
  `withdrawal_status` int(2) DEFAULT '0' COMMENT '提现状态 0提交 1审核通过 2 驳回 3 提现完成',
  `auditor_id` int(11) DEFAULT NULL COMMENT '审核者id',
  `auditor_name` varchar(16) DEFAULT NULL COMMENT '审核者名称',
  `audit_time` datetime DEFAULT NULL COMMENT '审核时间',
  `audit_remark` varchar(128) DEFAULT NULL COMMENT '审核描述',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `serial_no` varchar(64) DEFAULT NULL COMMENT '流水号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户提现申请表';

/*Data for the table `tb_user_withdrawal_record` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
