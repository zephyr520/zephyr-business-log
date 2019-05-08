-- --------------------------------------------------------
-- 主机:                           localhost
-- 服务器版本:                        8.0.11 - MySQL Community Server - GPL
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 zephyr-log 的数据库结构
CREATE DATABASE IF NOT EXISTS `zephyr-log` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `zephyr-log`;

-- 导出  表 zephyr-log.t_operate_log 结构
CREATE TABLE IF NOT EXISTS `t_operate_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '操作人',
  `modify_date` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '操作日期',
  `modify_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '操作名词',
  `modify_object` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '操作对象',
  `modify_content` varchar(3000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '操作内容',
  `modify_ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'ip',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 正在导出表  zephyr-log.t_operate_log 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `t_operate_log` DISABLE KEYS */;
INSERT INTO `t_operate_log` (`id`, `user_name`, `modify_date`, `modify_name`, `modify_object`, `modify_content`, `modify_ip`) VALUES
	(1, 'zhangsan', '2019-05-08 14:49:20', '修改', 'http://localhost:8081/staff/modify', '【定损员姓名】从【陈杰】改为了【张三】;\n', '127.0.0.1'),
	(2, 'zhangsan', '2019-05-08 14:57:50', '修改', 'http://localhost:8081/staff/modify', '', '127.0.0.1'),
	(3, 'zhangsan', '2019-05-08 14:59:11', '修改', 'http://localhost:8081/staff/modify', '【定损员手机号】从【13336175876】改为了【18078793391】;\n【定损员姓名】从【张三】改为了【李四】;\n', '127.0.0.1');
/*!40000 ALTER TABLE `t_operate_log` ENABLE KEYS */;

-- 导出  表 zephyr-log.t_staff 结构
CREATE TABLE IF NOT EXISTS `t_staff` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `staff_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '定损员手机号',
  `staff_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '定损员姓名',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`),
  UNIQUE KEY `staffPhone` (`staff_phone`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='定损员信息表';

-- 正在导出表  zephyr-log.t_staff 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `t_staff` DISABLE KEYS */;
INSERT INTO `t_staff` (`id`, `staff_phone`, `staff_name`, `remark`) VALUES
	(1, '18078793391', '李四', NULL);
/*!40000 ALTER TABLE `t_staff` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
