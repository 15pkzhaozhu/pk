-- --------------------------------------------------------
-- 主机:                           
-- 服务器版本:                        5.6.21-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win32
-- HeidiSQL 版本:                  8.2.0.4675
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 softwareengine 的数据库结构
CREATE DATABASE IF NOT EXISTS `softwareengine` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `softwareengine`;


-- 导出  表 softwareengine.student 结构
CREATE TABLE IF NOT EXISTS `student` (
  `stuID` int(11) NOT NULL,
  `name` char(50) NOT NULL,
  `phonenum` char(50) NOT NULL,
  `apartment` int(11) NOT NULL,
  `dorminum` char(50) NOT NULL,
  PRIMARY KEY (`stuID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  softwareengine.student 的数据：~7 rows (大约)
DELETE FROM `student`;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`stuID`, `name`, `phonenum`, `apartment`, `dorminum`) VALUES
	(131110101, '曹海洋', '18463100723', 9, '131b'),
	(131110102, '丛琛原', '18463110759', 9, '131b'),
	(131110103, 'AAS', '18463112356', 9, '133'),
	(131110104, '高管群', '18463114568', 9, '132'),
	(131110109, '呵呵', '18466545522', 2, '132'),
	(131110134, '赵柱', '18463102713', 9, '131b'),
	(131120102, '楼上', '18463112266', 2, '110');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;


-- 导出  表 softwareengine.student-wash 结构
CREATE TABLE IF NOT EXISTS `student-wash` (
  `stuID` int(11) NOT NULL,
  `dannum` int(11) NOT NULL COMMENT '被单数量',
  `zhaonum` int(11) NOT NULL COMMENT '被罩数量',
  PRIMARY KEY (`stuID`),
  CONSTRAINT `FK_student-wash_student` FOREIGN KEY (`stuID`) REFERENCES `student` (`stuID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  softwareengine.student-wash 的数据：~0 rows (大约)
DELETE FROM `student-wash`;
/*!40000 ALTER TABLE `student-wash` DISABLE KEYS */;
/*!40000 ALTER TABLE `student-wash` ENABLE KEYS */;


-- 导出  表 softwareengine.washing 结构
CREATE TABLE IF NOT EXISTS `washing` (
  `name` char(50) NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  softwareengine.washing 的数据：~2 rows (大约)
DELETE FROM `washing`;
/*!40000 ALTER TABLE `washing` DISABLE KEYS */;
INSERT INTO `washing` (`name`, `price`) VALUES
	('被单', 2),
	('被罩', 6);
/*!40000 ALTER TABLE `washing` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
