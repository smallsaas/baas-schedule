/*
 Navicat Premium Data Transfer

 Source Server         : sh-cdb-q5vnc0iy.sql.tencentcdb.com
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : sh-cdb-q5vnc0iy.sql.tencentcdb.com:59449
 Source Schema         : nft

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 18/04/2022 14:42:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_schedule_record
-- ----------------------------
DROP TABLE IF EXISTS `t_schedule_record`;
CREATE TABLE `t_schedule_record`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NULL DEFAULT NULL COMMENT '运行时间',
  `end_time` datetime NULL DEFAULT NULL COMMENT '结束时间',
  `job_id` bigint(20) NULL DEFAULT NULL COMMENT '运行定时任务id',
  `use_time` bigint(20) NULL DEFAULT NULL COMMENT '运行时间(毫秒)',
  `use_player_id` bigint(20) NULL DEFAULT NULL COMMENT '运行人id',
  `session_id` bigint(20) NULL DEFAULT NULL COMMENT '场次id',
  `schedule_number` bigint(20) NULL DEFAULT NULL COMMENT '定时任务记录编号',
  `job_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '定时任务名',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `schedule_number`(`schedule_number`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 302457 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
