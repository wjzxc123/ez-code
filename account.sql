/*
Navicat MySQL Data Transfer

Source Server         : lin_dog
Source Server Version : 80027
Source Host           : 121.89.203.197:3306
Source Database       : ez_code

Target Server Type    : MYSQL
Target Server Version : 80027
File Encoding         : 65001

Date: 2021-12-08 01:56:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `ID` bigint NOT NULL,
  `USER_ID` int NOT NULL,
  `ACCOUNT_ID` int NOT NULL,
  `ACCOUNT_NUMBER` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `AVAILABLE` decimal(10,0) DEFAULT NULL,
  `DAILY_LIMIT` decimal(10,0) DEFAULT NULL,
  `CURRENCY` varchar(10) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `VERSION` int DEFAULT '1',
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `DELETED` int DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1468262800049713153', '1', '1', '123456', '7000', '1000', 'CNY', '4', '2021-12-08 00:55:05', '2021-12-08 01:32:53', '0');
INSERT INTO `account` VALUES ('1468263370026287106', '2', '2', '1234567', '13000', '1000', 'CNY', '4', '2021-12-08 00:57:21', '2021-12-08 01:32:56', '0');
