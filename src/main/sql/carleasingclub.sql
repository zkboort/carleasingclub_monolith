/*
Navicat MySQL Data Transfer

Source Server         : 10.1.223.202
Source Server Version : 80028
Source Host           : localhost:3306
Source Database       : carleasingclub

Target Server Type    : MYSQL
Target Server Version : 80028
File Encoding         : 65001

Date: 2022-04-27 16:31:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for attribute_attrigroup_relation
-- ----------------------------
DROP TABLE IF EXISTS `attribute_attrigroup_relation`;
CREATE TABLE `attribute_attrigroup_relation` (
  `id` bigint NOT NULL COMMENT 'id',
  `attribute_id` bigint DEFAULT NULL COMMENT '属性id',
  `attribute_group_id` bigint DEFAULT NULL COMMENT '属性分组 id',
  `attribute_sort` int DEFAULT NULL COMMENT '属性排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Table structure for car_product_arribute
-- ----------------------------
DROP TABLE IF EXISTS `car_product_arribute`;
CREATE TABLE `car_product_arribute` (
  `attribute_id` int NOT NULL AUTO_INCREMENT COMMENT '商品属性id',
  `catelog_id` int DEFAULT NULL COMMENT '商品三级分类id',
  `attribute_name` varchar(255) DEFAULT NULL COMMENT '属性名称',
  `attribute_type` varchar(255) DEFAULT NULL COMMENT '属性类型',
  `search_type` varchar(255) DEFAULT NULL COMMENT '检索类型',
  PRIMARY KEY (`attribute_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Table structure for car_product_attribute_group
-- ----------------------------
DROP TABLE IF EXISTS `car_product_attribute_group`;
CREATE TABLE `car_product_attribute_group` (
  `attribute_group_id` bigint NOT NULL COMMENT '属性分组id',
  `attribute_group_name` varchar(255) DEFAULT NULL COMMENT '属性分组名称',
  `car_product_catelog_id` bigint DEFAULT NULL COMMENT '属性分组 所属的分类',
  `attribute_group_descript` varchar(255) DEFAULT NULL COMMENT '属性分组的描述信息',
  `attribute_group_sort` int DEFAULT NULL COMMENT '属性分组 排序',
  `attribute_group_icon` varchar(255) DEFAULT NULL COMMENT '属性分组的图标 url',
  PRIMARY KEY (`attribute_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Table structure for car_product_attribute_value
-- ----------------------------
DROP TABLE IF EXISTS `car_product_attribute_value`;
CREATE TABLE `car_product_attribute_value` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `spu_id` bigint DEFAULT NULL COMMENT '商品id',
  `car_product_attribute_id` bigint DEFAULT NULL COMMENT '商品属性ID',
  `car_product_attribute_name` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `car_product_attribute_value` varchar(255) DEFAULT NULL COMMENT '商品属性值',
  `car_product_attribute_sort` varchar(255) DEFAULT NULL COMMENT '属性排序',
  `quick_show` tinyint(1) DEFAULT NULL COMMENT '是否显示 0 不显示 1显示',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Table structure for car_product_brand
-- ----------------------------
DROP TABLE IF EXISTS `car_product_brand`;
CREATE TABLE `car_product_brand` (
  `brand_id` bigint NOT NULL AUTO_INCREMENT COMMENT '品牌id',
  `name` varchar(255) DEFAULT NULL COMMENT '品牌名称',
  `logo` varchar(2000) DEFAULT NULL COMMENT '品牌 logo地址',
  `descript` longtext COMMENT '介绍',
  `sort` int DEFAULT NULL COMMENT '排序',
  `first_letter` char(1) DEFAULT NULL COMMENT '检索首字母',
  `show_status` tinyint DEFAULT NULL COMMENT '显示状态 0 不显示 1 显示',
  PRIMARY KEY (`brand_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for car_product_category
-- ----------------------------
DROP TABLE IF EXISTS `car_product_category`;
CREATE TABLE `car_product_category` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '分类ID',
  `parent_id` bigint DEFAULT NULL COMMENT '父类id',
  `name` varchar(255) DEFAULT NULL COMMENT '分类名称',
  `level` int DEFAULT NULL COMMENT '分类级别',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标地址',
  `sort` int DEFAULT NULL,
  `product_count` int DEFAULT NULL,
  `product_unit` char(50) DEFAULT NULL COMMENT '计量单位',
  `show_status` tinyint DEFAULT NULL COMMENT '是否显示 0不显示 1显示',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for car_product_sku
-- ----------------------------
DROP TABLE IF EXISTS `car_product_sku`;
CREATE TABLE `car_product_sku` (
  `sku_id` bigint NOT NULL AUTO_INCREMENT,
  `catelog_id` bigint DEFAULT NULL COMMENT '所属三级分类',
  `brand_id` bigint DEFAULT NULL,
  `spu_id` bigint DEFAULT NULL COMMENT '商品id',
  `sku_name` varchar(255) DEFAULT NULL COMMENT 'sku名称',
  `sku_descript` varchar(255) DEFAULT NULL COMMENT 'sku描述',
  `sku_default_img` varchar(255) DEFAULT NULL COMMENT 'sku默认图片url',
  `sku_title` varchar(255) DEFAULT NULL COMMENT 'sku标题',
  `sku_subtitle` varchar(255) DEFAULT NULL COMMENT '副标题',
  `price` decimal(10,2) DEFAULT NULL COMMENT '价格',
  `sale_count` bigint DEFAULT NULL COMMENT '库存',
  PRIMARY KEY (`sku_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Table structure for car_product_sku_imges
-- ----------------------------
DROP TABLE IF EXISTS `car_product_sku_imges`;
CREATE TABLE `car_product_sku_imges` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `sku_id` bigint DEFAULT NULL COMMENT '销售属性id',
  `img_url` varchar(255) DEFAULT NULL COMMENT 'sku图片url',
  `img_sort` int DEFAULT NULL,
  `default_img` varchar(255) DEFAULT NULL COMMENT '默认图片路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Table structure for car_product_sku_sale_attribute_value
-- ----------------------------
DROP TABLE IF EXISTS `car_product_sku_sale_attribute_value`;
CREATE TABLE `car_product_sku_sale_attribute_value` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'sku销售属性值 id',
  `sku_id` bigint DEFAULT NULL,
  `spu_id` bigint DEFAULT NULL,
  `attribute_id` int DEFAULT NULL,
  `attribute_value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Table structure for car_product_spu
-- ----------------------------
DROP TABLE IF EXISTS `car_product_spu`;
CREATE TABLE `car_product_spu` (
  `spu_id` bigint NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `catelog_id` bigint DEFAULT NULL COMMENT '所属分类',
  `brand_id` bigint DEFAULT NULL COMMENT '所属品牌',
  `spu_name` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `spu_description` varchar(255) DEFAULT NULL COMMENT '商品描述',
  `weight` double DEFAULT NULL COMMENT '商品重量',
  `publish_status` varchar(255) DEFAULT NULL COMMENT '上架状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`spu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for custom_user
-- ----------------------------
DROP TABLE IF EXISTS `custom_user`;
CREATE TABLE `custom_user` (
  ` uid` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `real_name` varchar(40) DEFAULT NULL COMMENT '真实姓名',
  `birthday` int DEFAULT NULL COMMENT '生日',
  `card_id` varchar(20) DEFAULT NULL COMMENT '身份证号',
  `user_type` varchar(30) NOT NULL COMMENT '用户类型',
  `mark` varchar(255) DEFAULT NULL COMMENT '用户备注',
  `nick_name` varchar(100) DEFAULT NULL COMMENT '用户昵称',
  `head_portrait` varchar(255) DEFAULT NULL COMMENT '头像地址',
  `phone` varchar(15) DEFAULT NULL COMMENT '手机号',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '添加时间',
  `last_login_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次登录时间',
  `add_ip` varchar(150) DEFAULT NULL COMMENT '添加登录ip',
  `last_login_ip` varchar(150) DEFAULT NULL COMMENT '最后一次登录ip',
  `now_balance` decimal(9,2) NOT NULL COMMENT '余额',
  `integral` decimal(8,2) NOT NULL COMMENT '积分',
  `level` tinyint NOT NULL COMMENT '用户等级',
  `enabled` tinyint(1) NOT NULL COMMENT '用户状态 0 禁用 1启用',
  `addres` varchar(255) NOT NULL COMMENT '详细地址',
  `login_type` varchar(36) NOT NULL COMMENT '用户登录类型 微信 routine h5',
  `is_del` tinyint(1) DEFAULT NULL COMMENT '删除标记 0 删除 1未删除',
  PRIMARY KEY (` uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for picture
-- ----------------------------
DROP TABLE IF EXISTS `picture`;
CREATE TABLE `picture` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `create_time` datetime DEFAULT NULL COMMENT '上传时间',
  `delete_url` varchar(255) DEFAULT NULL COMMENT '删除的url',
  `picture_name` varchar(255) DEFAULT NULL COMMENT '图片名称',
  `height` varchar(255) DEFAULT NULL COMMENT '图片高度',
  `width` varchar(255) DEFAULT NULL COMMENT '图片宽度',
  `size` varchar(255) DEFAULT NULL COMMENT '图片大小',
  `url` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `username` varchar(255) DEFAULT NULL,
  `md5code` varchar(255) DEFAULT NULL COMMENT '文件的MD5值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '角色名称',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `data_scope` varchar(255) DEFAULT NULL COMMENT '数据权限呢',
  `level` varchar(255) DEFAULT NULL COMMENT '角色等级',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `promission` varchar(255) DEFAULT NULL COMMENT '功能权限',
  `is_del` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for system_user
-- ----------------------------
DROP TABLE IF EXISTS `system_user`;
CREATE TABLE `system_user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户表',
  `head_portrait` varchar(255) DEFAULT NULL COMMENT '头像地址',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `phone` varchar(255) DEFAULT NULL COMMENT '手机号',
  `nick_name` varchar(255) DEFAULT NULL COMMENT '昵称',
  `sex` varchar(20) DEFAULT NULL COMMENT '性别',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_password_reset_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次修改密码时间',
  `enabled` int DEFAULT NULL COMMENT '系统用户状态 0 禁用 1启用',
  ` is_del` tinyint(1) DEFAULT NULL COMMENT '删除标记  0 删除 1启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `is_frame` bit(1) DEFAULT NULL COMMENT '是否外链',
  `name` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `component` varchar(255) DEFAULT NULL,
  `component_name` varchar(20) DEFAULT NULL COMMENT '组件名称',
  `father_id` bigint NOT NULL COMMENT '父菜单id',
  `sort` bigint NOT NULL COMMENT '排序',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标',
  `path` varchar(255) DEFAULT NULL COMMENT '链接地址',
  `cache` bit(1) DEFAULT NULL COMMENT '是否缓存 布尔值',
  `hidden` bit(1) DEFAULT b'0' COMMENT '是否隐藏 布尔值',
  `permission` varchar(255) DEFAULT NULL COMMENT '权限',
  `type` int DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改日期',
  `is_del` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
