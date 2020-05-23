/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1_3306_主
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : parrot

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 09/03/2020 17:50:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for clazz
-- ----------------------------
DROP TABLE IF EXISTS `clazz`;
CREATE TABLE `clazz`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '班级名',
  `version` decimal(10, 2) NOT NULL COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of clazz
-- ----------------------------
INSERT INTO `clazz` VALUES (1, '唐僧取经班', 1.00, '2020-01-14 17:19:37');

-- ----------------------------
-- Table structure for fruits
-- ----------------------------
DROP TABLE IF EXISTS `fruits`;
CREATE TABLE `fruits`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '水果表',
  `code` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '编码',
  `name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '水果名称',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '单价',
  `count` int(11) NULL DEFAULT NULL COMMENT '库存总量',
  `lock_count` int(11) NULL DEFAULT 0 COMMENT '锁定库存：未支付的',
  `surplus_count` int(11) NULL DEFAULT 0 COMMENT '剩余库存',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `code`(`code`) USING BTREE COMMENT '唯一索引'
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fruits
-- ----------------------------
INSERT INTO `fruits` VALUES (1, 'apple_001', '山东红富士苹果', 10.00, 10, 0, 0, '2020-03-09 10:46:17', '2020-03-09 10:46:17');
INSERT INTO `fruits` VALUES (2, 'apple_002', '山西老土苹果', 5.00, 10, 0, 0, '2020-03-09 10:47:22', '2020-03-09 10:47:22');
INSERT INTO `fruits` VALUES (3, 'apple_003', '河南老香苹果', 4.00, 2, 0, 0, '2020-03-09 10:48:06', '2020-03-09 10:48:06');

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence`  (
  `next_val` bigint(20) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'student主键',
  `num` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学号',
  `name` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `age` int(4) NULL DEFAULT NULL COMMENT '年龄',
  `sex` tinyint(2) NULL DEFAULT NULL COMMENT '1男2女',
  `clazz_id` int(11) NULL DEFAULT NULL COMMENT '班级id',
  `state` tinyint(2) NOT NULL DEFAULT 1 COMMENT '1入学，2已毕业，3休学，4开除，5肆业，6结业',
  `detele_status` tinyint(2) NOT NULL DEFAULT 1 COMMENT '数据状态：1未删除，2已删除',
  `version` decimal(10, 2) NOT NULL COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `num`(`num`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '20200114172101', '唐僧', 28, 1, 1, 1, 1, 1.00, '2020-01-14 18:21:58');
INSERT INTO `student` VALUES (2, '20200114172102', '孙悟空', 28, 1, 1, 1, 1, 1.00, '2020-01-14 18:21:58');
INSERT INTO `student` VALUES (3, '20200114172103', '猪八戒', 28, 1, 1, 1, 1, 1.00, '2020-01-14 18:21:58');
INSERT INTO `student` VALUES (4, '20200114172104', '沙和尚', 28, 1, 1, 1, 1, 1.00, '2020-01-14 18:21:58');
INSERT INTO `student` VALUES (5, '20200114172105', '白龙马', 28, 1, 1, 1, 1, 1.00, '2020-01-14 18:21:58');
INSERT INTO `student` VALUES (6, '20200114172106', '玉皇大帝', 28, 1, 1, 1, 1, 1.00, '2020-01-14 18:21:58');
INSERT INTO `student` VALUES (7, '20200114172107', '王母娘娘', 28, 2, 1, 1, 1, 1.00, '2020-01-14 18:21:58');
INSERT INTO `student` VALUES (8, '20200114172108', '太上老君', 28, 1, 1, 1, 1, 1.00, '2020-01-14 18:21:58');
INSERT INTO `student` VALUES (9, '20200114172109', '镇元子', 28, 1, 1, 1, 1, 1.00, '2020-01-14 18:21:58');
INSERT INTO `student` VALUES (10, '20200114172110', '如来佛主', 28, 1, 1, 1, 1, 1.00, '2020-01-14 18:21:58');
INSERT INTO `student` VALUES (11, '20200114172111', '观音菩萨', 28, 2, 1, 1, 1, 1.00, '2020-01-14 18:21:58');
INSERT INTO `student` VALUES (12, '20200114172112', '李世民', 28, 1, 1, 1, 1, 1.00, '2020-01-14 18:21:58');
INSERT INTO `student` VALUES (13, '20200114172113', '女儿国国王', 28, 2, 1, 1, 1, 1.00, '2020-01-14 18:21:58');
INSERT INTO `student` VALUES (14, '20200114172114', '黑熊精', 28, 1, 1, 1, 1, 1.00, '2020-01-14 18:21:58');
INSERT INTO `student` VALUES (15, '20200114172115', '琵琶精', 28, 2, 1, 1, 1, 1.00, '2020-01-14 18:21:58');

-- ----------------------------
-- Table structure for t_logger
-- ----------------------------
DROP TABLE IF EXISTS `t_logger`;
CREATE TABLE `t_logger`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `group_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `unit_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `tag` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `content` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `create_time` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `app_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单表',
  `order_number` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '订单编号',
  `status` bigint(1) NULL DEFAULT 1 COMMENT '1待支付2已支付3已退款4完成',
  `fruits_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '水果code',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '订单金额',
  `count` int(11) NULL DEFAULT 1 COMMENT '商品数量',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `order_number`(`order_number`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_tx_exception
-- ----------------------------
DROP TABLE IF EXISTS `t_tx_exception`;
CREATE TABLE `t_tx_exception`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `group_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `unit_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `mod_id` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `transaction_state` tinyint(4) NULL DEFAULT NULL,
  `registrar` tinyint(4) NULL DEFAULT NULL,
  `remark` varchar(4096) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `ex_state` tinyint(4) NULL DEFAULT NULL COMMENT '0 未解决 1已解决',
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for xy_kafka_in_msg
-- ----------------------------
DROP TABLE IF EXISTS `xy_kafka_in_msg`;
CREATE TABLE `xy_kafka_in_msg`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fw_bh` bigint(20) NOT NULL COMMENT '档案号',
  `message` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '信息',
  `status` int(1) NULL DEFAULT 1 COMMENT '1未消费，2已消费',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_update` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `fw_bh`(`fw_bh`) USING BTREE,
  INDEX `fwbh`(`fw_bh`) USING BTREE COMMENT '服务唯一标示'
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '消息消费成功表 幂等性' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for xy_kafka_out_msg
-- ----------------------------
DROP TABLE IF EXISTS `xy_kafka_out_msg`;
CREATE TABLE `xy_kafka_out_msg`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fw_bh` bigint(20) NOT NULL COMMENT '档案号',
  `message` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '消息',
  `deal_flag` tinyint(2) NOT NULL DEFAULT 0 COMMENT '处理标记 0 失败 1 成功',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_update` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `fw_bh`(`fw_bh`) USING BTREE,
  INDEX `fwbh`(`fw_bh`) USING BTREE COMMENT '服务唯一标示'
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '任务添加进kafka队列 幂等性' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
