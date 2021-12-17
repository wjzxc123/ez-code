/*
 Navicat Premium Data Transfer

 Source Server         : licon
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : localhost:3306
 Source Schema         : ez_code

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 17/12/2021 17:16:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `ID` bigint(20) NOT NULL,
  `USER_ID` int(11) NOT NULL,
  `ACCOUNT_ID` int(11) NOT NULL,
  `ACCOUNT_NUMBER` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `AVAILABLE` decimal(10, 0) DEFAULT NULL,
  `DAILY_LIMIT` decimal(10, 0) DEFAULT NULL,
  `CURRENCY` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `VERSION` int(11) DEFAULT 1,
  `CREATE_TIME` datetime(0) DEFAULT NULL,
  `UPDATE_TIME` datetime(0) DEFAULT NULL,
  `DELETED` int(11) DEFAULT 0,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (1468262800049713153, 1, 1, '123456', 9000, 1000, 'CNY', 8, '2021-12-08 00:55:05', '2021-12-08 01:32:53', 0);
INSERT INTO `account` VALUES (1468263370026287106, 2, 2, '1234567', 11000, 1000, 'CNY', 8, '2021-12-08 00:57:21', '2021-12-08 01:32:56', 0);

-- ----------------------------
-- Table structure for sys_authority
-- ----------------------------
DROP TABLE IF EXISTS `sys_authority`;
CREATE TABLE `sys_authority`  (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `AUTHORITY_CODE` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `AUTHORITY_NAME` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `CREATE_BY` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `UPDATE_BY` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `CREATE_TIME` datetime(0) DEFAULT NULL,
  `UPDATE_TIME` datetime(0) DEFAULT NULL,
  `VERSION` int(11) DEFAULT 0,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_authority
-- ----------------------------
INSERT INTO `sys_authority` VALUES (1, 'READ', '读', 'wjzxc123', 'wjzxc123', '2021-12-17 10:08:12', '2021-12-17 10:08:15', 0);
INSERT INTO `sys_authority` VALUES (2, 'WRITE', '写', 'wjzxc123', 'wjzxc123', '2021-12-17 10:08:12', '2021-12-17 10:08:15', 0);

-- ----------------------------
-- Table structure for sys_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource`  (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `RESOURCE_ID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `RESOURCE_PATH` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `RESOURCE_NAME` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `RESOURCE_VERSION` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `CREATE_BY` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `UPDATE_BY` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `CREATE_TIME` datetime(0) DEFAULT NULL,
  `UPDATE_TIME` datetime(0) DEFAULT NULL,
  `VERSION` int(11) DEFAULT 0,
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `INDEX_RESOURCE_ID`(`RESOURCE_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_resource
-- ----------------------------
INSERT INTO `sys_resource` VALUES (1, '692ed850f04443018ae2016b31248036', '/sys/accounts', '获取所有账户', 'V1', 'wjzxc123', 'wjzxc123', '2021-12-17 09:52:37', '2021-12-17 09:52:41', 0);

-- ----------------------------
-- Table structure for sys_resource_authority
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource_authority`;
CREATE TABLE `sys_resource_authority`  (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `RESOURCE_ID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `AUTHORITY_CODE` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `CREATE_BY` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `UPDATE_BY` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `CREATE_TIME` datetime(0) DEFAULT NULL,
  `UPDATE_TIME` datetime(0) DEFAULT NULL,
  `VERSION` int(11) DEFAULT 0,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_resource_authority
-- ----------------------------
INSERT INTO `sys_resource_authority` VALUES (1, 'bd308f553ab242cdac8ebe3efcff2184', 'READ', 'wjzxc123', 'wjzxc123', '2021-12-17 10:02:10', '2021-12-17 10:02:12', 0);
INSERT INTO `sys_resource_authority` VALUES (2, '5b89b5c71b9f4920a5a70384262e2e40', 'WRITE', 'wjzxc123', 'wjzxc123', '2021-12-17 10:02:44', '2021-12-17 10:02:47', 0);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `ID` bigint(11) NOT NULL AUTO_INCREMENT,
  `ROLE_CODE` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ROLE_NAME` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `P_CODE` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `CREATE_BY` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `UPDATE_BY` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `CREATE_TIME` datetime(0) DEFAULT NULL,
  `UPDATE_TIME` datetime(0) DEFAULT NULL,
  `VERSION` int(11) DEFAULT 0,
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `INDEX_ROLE_CDE`(`ROLE_CODE`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, 'A', 'A', NULL, 'ADMIN', 'ADMIN', '2021-12-17 10:14:11', '2021-12-17 10:14:11', 0);
INSERT INTO `sys_role` VALUES (2, 'B', 'B', 'A', 'ADMIN', 'ADMIN', '2021-12-17 10:14:11', '2021-12-17 10:14:11', 0);
INSERT INTO `sys_role` VALUES (3, 'C', 'C', 'B', 'ADMIN', 'ADMIN', '2021-12-17 10:14:11', '2021-12-17 10:14:11', 0);
INSERT INTO `sys_role` VALUES (4, 'D', 'D', 'A', 'ADMIN', 'ADMIN', '2021-12-17 10:14:11', '2021-12-17 10:14:11', 0);
INSERT INTO `sys_role` VALUES (5, 'E', 'E', 'C', 'ADMIN', 'ADMIN', '2021-12-17 10:14:11', '2021-12-17 10:14:11', 0);
INSERT INTO `sys_role` VALUES (6, 'F', 'F', 'B', 'ADMIN', 'ADMIN', '2021-12-17 10:14:11', '2021-12-17 10:14:11', 0);
INSERT INTO `sys_role` VALUES (7, 'G', 'G', 'A', 'ADMIN', 'ADMIN', '2021-12-17 10:14:11', '2021-12-17 10:14:11', 0);
INSERT INTO `sys_role` VALUES (8, 'H', 'H', 'G', 'ADMIN', 'ADMIN', '2021-12-17 10:14:11', '2021-12-17 10:14:11', 0);
INSERT INTO `sys_role` VALUES (9, 'I', 'I', 'G', 'ADMIN', 'ADMIN', '2021-12-17 10:14:11', '2021-12-17 10:14:11', 0);
INSERT INTO `sys_role` VALUES (10, 'J', 'J', 'E', 'ADMIN', 'ADMIN', '2021-12-17 10:14:11', '2021-12-17 10:14:11', 0);
INSERT INTO `sys_role` VALUES (11, 'K', 'K', 'F', 'ADMIN', 'ADMIN', '2021-12-17 10:14:11', '2021-12-17 10:14:11', 0);
INSERT INTO `sys_role` VALUES (12, 'L', 'L', NULL, 'ADMIN', 'ADMIN', '2021-12-17 10:14:11', '2021-12-17 10:14:11', 0);
INSERT INTO `sys_role` VALUES (13, 'M', 'M', 'L', 'ADMIN', 'ADMIN', '2021-12-17 10:14:11', '2021-12-17 10:14:11', 0);
INSERT INTO `sys_role` VALUES (14, 'N', 'N', 'M', 'ADMIN', 'ADMIN', '2021-12-17 10:14:11', '2021-12-17 10:14:11', 0);
INSERT INTO `sys_role` VALUES (15, 'AA', 'AA', 'A', 'ADMIN', 'ADMIN', '2021-12-17 10:14:11', '2021-12-17 10:14:11', 0);
INSERT INTO `sys_role` VALUES (16, 'AB', 'AB', 'A', 'ADMIN', 'ADMIN', '2021-12-17 10:14:11', '2021-12-17 10:14:11', 0);
INSERT INTO `sys_role` VALUES (17, 'AC', 'AC', 'A', 'ADMIN', 'ADMIN', '2021-12-17 10:14:11', '2021-12-17 10:14:11', 0);
INSERT INTO `sys_role` VALUES (18, 'BB', 'BB', 'B', 'ADMIN', 'ADMIN', '2021-12-17 10:14:11', '2021-12-17 10:14:11', 0);
INSERT INTO `sys_role` VALUES (19, 'BC', 'BC', 'B', 'ADMIN', 'ADMIN', '2021-12-17 10:14:11', '2021-12-17 10:14:11', 0);

-- ----------------------------
-- Table structure for sys_role_authority
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_authority`;
CREATE TABLE `sys_role_authority`  (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ROLE_CODE` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `AUTHORITY_CODE` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `CREATE_BY` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `UPDATE_BY` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `CREATE_TIME` datetime(0) DEFAULT NULL,
  `UPDATE_TIME` datetime(0) DEFAULT NULL,
  `VERSION` int(11) DEFAULT 0,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_authority
-- ----------------------------
INSERT INTO `sys_role_authority` VALUES (1, 'A', 'READ', 'ADMIN', 'ADMIN', '2021-12-17 10:10:20', '2021-12-17 10:10:23', 0);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USER_ID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ACCOUNT` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `PASSWORD` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `NAME` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `EMAIL` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `PHONE` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `GENDER` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `AGE` int(11) DEFAULT NULL,
  `DISABLE` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `CREATE_TIME` datetime(0) DEFAULT NULL,
  `UPDATE_TIME` datetime(0) DEFAULT NULL,
  `CREATE_BY` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `UPDATE_BY` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `VERSION` int(11) DEFAULT 0,
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `INDEX_USER_ID`(`USER_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, '7ef6c4f8ef67439484fd81c150e2a2af', 'wjzxc123', '123456', '张三', '1163760935@qq.com', '17393121300', '1', 26, '0', '2021-12-16 14:07:39', '2021-12-16 14:07:42', 'ADMIN', 'ADMIN', 0);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USER_ID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ROLE_CODE` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `CREATE_BY` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `UPDATE_BY` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `CREATE_TIME` datetime(0) DEFAULT NULL,
  `UPDATE_TIME` datetime(0) DEFAULT NULL,
  `VERSION` int(10) DEFAULT 0,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, '7ef6c4f8ef67439484fd81c150e2a2af', 'A', 'ADMIN', 'ADMIN', '2021-12-16 14:19:58', '2021-12-16 14:20:02', 0);

-- ----------------------------
-- Procedure structure for tree
-- ----------------------------
DROP PROCEDURE IF EXISTS `tree`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `tree`(IN `rootCode` int,IN `tableName` varchar(50))
BEGIN
	DECLARE Level int;
	
	set @deleteTable =  CONCAT('drop TABLE IF EXISTS ',tableName);
	PREPARE del FROM @deleteTable;
  EXECUTE del;
	
	set @createTable =  CONCAT('CREATE TABLE ' ,tableName,' (id int,nLevel int,sCort varchar(8000))');
	PREPARE crt FROM @createTable;
  EXECUTE crt;
	
	Set Level=0 ;
	
	set @ins =  CONCAT('INSERT into ',tableName,' SELECT id,',Level,',ID FROM sys_role WHERE P_CODE=',rootCode);
	PREPARE inst FROM @ins;
  EXECUTE inst;
	
	WHILE ROW_COUNT()>0 DO
		SET Level=Level+1 ;
		
		set @quyins =  CONCAT('INSERT into ',tableName,' SELECT A.ID,',Level,',concat(B.sCort,A.ID) FROM sys_role A,',tableName,' B WHERE A.P_CODE=B.ID AND B.nLevel=',Level-1);
		PREPARE quyinst FROM @quyins;
		EXECUTE quyinst;
	END WHILE;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
