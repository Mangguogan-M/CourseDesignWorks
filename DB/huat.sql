/*
Navicat MySQL Data Transfer

Source Server         : MySQL5
Source Server Version : 50557
Source Host           : 127.0.0.1:3306
Source Database       : huat

Target Server Type    : MYSQL
Target Server Version : 50557
File Encoding         : 65001

Date: 2020-04-10 14:37:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) DEFAULT NULL,
  `pwd` varchar(32) DEFAULT NULL,
  `nickname` varchar(32) DEFAULT NULL,
  `gendar` char(255) DEFAULT NULL,
  `age` int(2) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'wawa', '123', 'xiaowa', 'F', '23', '12121212121');
