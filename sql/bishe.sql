/*
 Navicat Premium Data Transfer

 Source Server         : my_db
 Source Server Type    : MySQL
 Source Server Version : 80032
 Source Host           : localhost:3306
 Source Schema         : bishe

 Target Server Type    : MySQL
 Target Server Version : 80032
 File Encoding         : 65001

 Date: 06/04/2024 16:58:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for appeal
-- ----------------------------
DROP TABLE IF EXISTS `appeal`;
CREATE TABLE `appeal`  (
                           `id` bigint(0) NOT NULL COMMENT '主键ID',
                           `type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '申诉任务类型',
                           `single_id` bigint(0) NOT NULL COMMENT '单次ID',
                           `reason` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '申诉原因',
                           `state` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '申诉状态'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of appeal
-- ----------------------------

-- ----------------------------
-- Table structure for farm
-- ----------------------------
DROP TABLE IF EXISTS `farm`;
CREATE TABLE `farm`  (
                         `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                         `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '林场名',
                         `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '林场地址',
                         `descriptions` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '林场描述',
                         `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
                         `deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除(0-未删除，1-已删除)',
                         PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of farm
-- ----------------------------
INSERT INTO `farm` VALUES (1, '长沙岳麓区林场', '长沙岳麓区', '新添加的林场信息', '2024-04-06 16:53:32', 0);

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
                            `id` bigint(0) NOT NULL COMMENT '主键ID',
                            `notice_id` bigint(0) NOT NULL COMMENT '通知ID',
                            `worker_Id` bigint(0) NOT NULL COMMENT '工人ID',
                            `read` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '是否已读'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
                           `id` bigint(0) NOT NULL DEFAULT 0 COMMENT '主键ID',
                           `type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '通知类型',
                           `target` bigint(0) NOT NULL DEFAULT 0 COMMENT '目标ID',
                           `content` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '内容'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notice
-- ----------------------------

-- ----------------------------
-- Table structure for pic
-- ----------------------------
DROP TABLE IF EXISTS `pic`;
CREATE TABLE `pic`  (
                        `id` bigint(0) NOT NULL COMMENT '主键ID',
                        `url` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '照片地址',
                        `worker_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '工人ID',
                        `time` datetime(0) NOT NULL DEFAULT 0 COMMENT '上传时间'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pic
-- ----------------------------

-- ----------------------------
-- Table structure for salary
-- ----------------------------
DROP TABLE IF EXISTS `salary`;
CREATE TABLE `salary`  (
                           `id` bigint(0) NOT NULL COMMENT '主键ID',
                           `worker_id` bigint(0) NOT NULL COMMENT '工人ID',
                           `time` date NOT NULL COMMENT '发送时间',
                           `number` bigint(0) NOT NULL COMMENT '金额',
                           `note` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '备注'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of salary
-- ----------------------------

-- ----------------------------
-- Table structure for single_col
-- ----------------------------
DROP TABLE IF EXISTS `single_col`;
CREATE TABLE `single_col`  (
                               `id` bigint(0) NOT NULL COMMENT '主键ID',
                               `worker_id` bigint(0) NOT NULL COMMENT '工人ID',
                               `pic_id` bigint(0) NOT NULL COMMENT '照片ID',
                               `age` int(0) NOT NULL COMMENT '竹龄',
                               `circum` int(0) NOT NULL COMMENT '竹围',
                               `towards` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '朝向',
                               `time` datetime(0) NOT NULL COMMENT '时间',
                               `weather` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '天气',
                               `location` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '地点',
                               `state` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '是否通过',
                               `note` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '备注'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of single_col
-- ----------------------------

-- ----------------------------
-- Table structure for single_cut
-- ----------------------------
DROP TABLE IF EXISTS `single_cut`;
CREATE TABLE `single_cut`  (
                               `id` bigint(0) NOT NULL COMMENT '主键ID',
                               `worker_id` bigint(0) NOT NULL COMMENT '工人ID',
                               `work_id` bigint(0) NOT NULL COMMENT '工人任务ID',
                               `pic1_id` bigint(0) NOT NULL COMMENT '采伐前照片',
                               `pic2_id` bigint(0) NOT NULL COMMENT '修改标记后照片',
                               `pic3_id` bigint(0) NOT NULL COMMENT '采伐后照片',
                               `number` int(0) NOT NULL COMMENT '单词数量',
                               `state` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '是否通过',
                               `note` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '备注'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of single_cut
-- ----------------------------

-- ----------------------------
-- Table structure for task
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task`  (
                         `id` bigint(0) NOT NULL COMMENT '主键ID',
                         `farm_id` bigint(0) NOT NULL COMMENT '所在林场ID',
                         `type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '任务类型',
                         `number` int(0) NOT NULL DEFAULT 0 COMMENT '需求数量',
                         `deadline` datetime(0) NOT NULL COMMENT '截止时间',
                         `pos` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '任务地点',
                         `pic_id` bigint(0) NOT NULL COMMENT '地点照片',
                         `gps` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'GPS定位',
                         `money` bigint(0) NOT NULL COMMENT '任务工资',
                         `state` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '任务状态',
                         `worker_id` bigint(0) NOT NULL COMMENT '领取ID',
                         `note` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '备注'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of task
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
                         `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '用户id',
                         `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名',
                         `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
                         `avatar_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像地址',
                         `phone` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电话',
                         `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱',
                         `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
                         `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
                         `status` tinyint(0) NOT NULL DEFAULT 1 COMMENT '账号是否可用，默认为1（可用）',
                         `deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除(0-未删除，1-已删除)',
                         PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'aaa', 'e10adc3949ba59abbe56e057f20f883e', '', '12345678945', '', '2024-04-06 01:53:04', '2024-04-06 01:53:04', 1, 0);

-- ----------------------------
-- Table structure for work
-- ----------------------------
DROP TABLE IF EXISTS `work`;
CREATE TABLE `work`  (
                         `id` bigint(0) NOT NULL DEFAULT 0 COMMENT '主键ID',
                         `worker_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '工人ID',
                         `task_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '任务ID',
                         `type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '任务类型',
                         `number` int(0) NOT NULL COMMENT '需求数量',
                         `nownum` int(0) NOT NULL COMMENT '当前数量',
                         `deadline` datetime(0) NOT NULL COMMENT '截止时间',
                         `submit` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '是否提交'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of work
-- ----------------------------

-- ----------------------------
-- Table structure for worker
-- ----------------------------
DROP TABLE IF EXISTS `worker`;
CREATE TABLE `worker`  (
                           `id` bigint(0) NOT NULL DEFAULT 0 COMMENT '主键ID',
                           `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '工人名',
                           `farm_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '属于林场ID',
                           `bank` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '银行卡号',
                           `self_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '身份证号'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of worker
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
