/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : userman

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 30/01/2023 17:11:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱',
  `first_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓',
  `last_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名',
  `account_created` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `account_update` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `email`(`email`) USING BTREE COMMENT '索引'
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (9, '$2a$10$elVRYOuuXXbdkYO8XIgTR.50JDq6NVNeQY9XRAXK9qX84sNPmgE.C', '175@qq.com', '李', '白', '2023-01-29 21:34:32', '2023-01-29 21:34:32');
INSERT INTO `user` VALUES (11, '$2a$10$MimdODttMRr4TfPcLCtvt.2VKU15yUurD9zEiweKlIAsXVpj87pdS', 'qq.com', '李', '白', '2023-01-30 16:34:38', '2023-01-30 16:34:38');
INSERT INTO `user` VALUES (12, '$2a$10$U7nm8FwNYy13fNvqZ7LM3.ftZ6CbnkZtj7dB5pwsuKky1T.UFBKh6', '22@qq.com', '李', '白', '2023-01-30 16:37:28', '2023-01-30 16:37:28');

SET FOREIGN_KEY_CHECKS = 1;
