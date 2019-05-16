/*
Navicat MySQL Data Transfer

Source Server         : mydb
Source Server Version : 50714
Source Host           : 127.0.0.1:3306
Source Database       : shiro

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2019-05-16 14:03:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_permission`
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
  `id` int(11) NOT NULL,
  `rid` int(11) DEFAULT NULL,
  `url` varchar(20) DEFAULT NULL,
  `role` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission` VALUES ('20', '10', 'home', '超级管理员');

-- ----------------------------
-- Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('10', 'admin', '超级管理员');
INSERT INTO `t_role` VALUES ('11', 'lisi', '仓库管理员');
INSERT INTO `t_role` VALUES ('12', 'zhangsan', '管理员');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', '123456');
INSERT INTO `t_user` VALUES ('2', 'zhangsan', '123456');
INSERT INTO `t_user` VALUES ('3', 'lisi', '123456');
