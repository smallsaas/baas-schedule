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

 Date: 18/04/2022 15:08:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_schedule_job_record
-- ----------------------------
DROP TABLE IF EXISTS `t_schedule_job_record`;
CREATE TABLE `t_schedule_job_record`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `job_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '定时任务名字(英文大写)',
  `job_group_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '定时任务组名',
  `job_class` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任务',
  `cron` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时间设置',
  `delete_flag` tinyint(4) NULL DEFAULT 0 COMMENT '删除逻辑',
  `duplicate_task` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '子任务名字',
  `seq` int(4) NULL DEFAULT 1 COMMENT '子任务数',
  `allow_repeat` tinyint(4) NULL DEFAULT 0 COMMENT '是否可重复执行项，1可重复执行',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
