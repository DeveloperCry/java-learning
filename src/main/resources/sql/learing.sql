-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.3-m13-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.3.0.5045
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for blog
CREATE DATABASE IF NOT EXISTS `blog` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `blog`;

-- Dumping structure for table blog.author
CREATE TABLE IF NOT EXISTS `author` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(64) NOT NULL,
  `PASSWORD` varchar(64) NOT NULL,
  `BIO` varchar(64) DEFAULT NULL,
  `EMAIL` varchar(64) DEFAULT NULL,
  `FAVOURITE_SECTION` varchar(64) DEFAULT NULL,
  `CREATE_DATE` datetime(6) DEFAULT NULL,
  `EDIT_DATE` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table blog.author: ~0 rows (approximately)
DELETE FROM `author`;
/*!40000 ALTER TABLE `author` DISABLE KEYS */;
INSERT INTO `author` (`ID`, `USER_NAME`, `PASSWORD`, `BIO`, `EMAIL`, `FAVOURITE_SECTION`, `CREATE_DATE`, `EDIT_DATE`) VALUES
	(1, 'chris', '123456789', '112', 'test@test.cng.com', '1', '2017-04-17 14:40:32.000000', '2017-04-17 14:40:34.000000');
/*!40000 ALTER TABLE `author` ENABLE KEYS */;

-- Dumping structure for table blog.blog
CREATE TABLE IF NOT EXISTS `blog` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(64) NOT NULL,
  `CREATE_DATE` datetime(6) DEFAULT NULL,
  `CREATE_USER` int(11) DEFAULT NULL,
  `EDIT_DATE` datetime(6) DEFAULT NULL,
  `EDIT_USER` int(11) DEFAULT NULL,
  `CONTENT` varchar(1024) DEFAULT NULL,
  `TITLE` varchar(40) DEFAULT NULL,
  `AUTHOR_ID` int(11) DEFAULT NULL,
  `STATUS` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`),
  KEY `FK_BLOG_CREATE_USER_ID` (`CREATE_USER`),
  KEY `FK_BLOG_EDIT_USER_ID` (`EDIT_USER`),
  CONSTRAINT `FK_BLOG_CREATE_USER_ID` FOREIGN KEY (`CREATE_USER`) REFERENCES `user` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_BLOG_EDIT_USER_ID` FOREIGN KEY (`EDIT_USER`) REFERENCES `user` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Dumping data for table blog.blog: ~5 rows (approximately)
DELETE FROM `blog`;
/*!40000 ALTER TABLE `blog` DISABLE KEYS */;
INSERT INTO `blog` (`ID`, `NAME`, `CREATE_DATE`, `CREATE_USER`, `EDIT_DATE`, `EDIT_USER`, `CONTENT`, `TITLE`, `AUTHOR_ID`, `STATUS`) VALUES
	(1, 'GOOD JOB', '2017-04-06 13:51:22.000000', 1, '2017-04-06 13:51:22.000000', 2, 'xxxxxxxxxxxxxxxxxxxxxxx', 'java', 1, 'ACTIVE'),
	(2, 'GOOD JOB1', '2017-04-06 13:51:22.000000', 2, '2017-04-06 13:51:22.000000', 2, 'xxxxxxxxxxxxxxxxxxxxxxx', 'php', 2, 'ACTIVE'),
	(3, 'GOOD JOB2', '2017-04-06 13:51:22.000000', 1, '2017-04-06 13:51:22.000000', 2, 'xxxxxxxxxxxxxxxxxxxxxxx', 'c programmar', 1, 'ACTIVE'),
	(4, 'GOOD JOB3', '2017-04-06 13:51:22.000000', 2, '2017-04-06 13:51:22.000000', 2, 'xxxxxxxxxxxxxxxxxxxxxxx', 'scala', 1, 'INACTIVE'),
	(5, 'GOOD JOB4', '2017-04-06 13:51:22.000000', 1, '2017-04-06 13:51:22.000000', 2, 'xxxxxxxxxxxxxxxxxxxxxxx', 'yy', 1, 'INACTIVE');
/*!40000 ALTER TABLE `blog` ENABLE KEYS */;

-- Dumping structure for table blog.comments
CREATE TABLE IF NOT EXISTS `comments` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `POST_ID` int(11) DEFAULT NULL,
  `NAME` varchar(64) DEFAULT NULL,
  `COMMENT` varchar(256) DEFAULT NULL,
  `CREATE_DATE` datetime(6) DEFAULT NULL,
  `EDIT_DATE` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_COMMENT_POST_ID` (`POST_ID`),
  CONSTRAINT `FK_COMMENT_POST_ID` FOREIGN KEY (`POST_ID`) REFERENCES `post` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table blog.comments: ~0 rows (approximately)
DELETE FROM `comments`;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;

-- Dumping structure for table blog.post
CREATE TABLE IF NOT EXISTS `post` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `BLOG_ID` int(11) NOT NULL,
  `AUTHOR_ID` int(64) DEFAULT NULL,
  `SECTION` varchar(64) DEFAULT NULL,
  `SUBJECT` varchar(64) DEFAULT NULL,
  `DRAFT` varchar(64) DEFAULT NULL,
  `BODY` varchar(1024) DEFAULT NULL,
  `CREATED_ON` datetime(6) DEFAULT NULL,
  `EDIT_DATE` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_POST_BLOG_ID` (`BLOG_ID`),
  KEY `FK_POST_AUTHOR_ID` (`AUTHOR_ID`),
  CONSTRAINT `FK_POST_AUTHOR_ID` FOREIGN KEY (`AUTHOR_ID`) REFERENCES `author` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_POST_BLOG_ID` FOREIGN KEY (`BLOG_ID`) REFERENCES `blog` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table blog.post: ~0 rows (approximately)
DELETE FROM `post`;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
/*!40000 ALTER TABLE `post` ENABLE KEYS */;

-- Dumping structure for table blog.post_tag
CREATE TABLE IF NOT EXISTS `post_tag` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `POST_ID` int(11) DEFAULT NULL,
  `TAG_ID` int(11) DEFAULT NULL,
  `CREATE_DATE` datetime(6) DEFAULT NULL,
  `EDIT_DATE` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_POST_TAG_POST_ID` (`POST_ID`),
  KEY `FK_POST_TAG_TAG_ID` (`TAG_ID`),
  CONSTRAINT `FK_POST_TAG_POST_ID` FOREIGN KEY (`POST_ID`) REFERENCES `post` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_POST_TAG_TAG_ID` FOREIGN KEY (`TAG_ID`) REFERENCES `tag` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table blog.post_tag: ~0 rows (approximately)
DELETE FROM `post_tag`;
/*!40000 ALTER TABLE `post_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `post_tag` ENABLE KEYS */;

-- Dumping structure for table blog.tag
CREATE TABLE IF NOT EXISTS `tag` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` int(11) DEFAULT NULL,
  `CREATE_DATE` datetime(6) DEFAULT NULL,
  `EDIT_DATE` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table blog.tag: ~0 rows (approximately)
DELETE FROM `tag`;
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;

-- Dumping structure for table blog.user
CREATE TABLE IF NOT EXISTS `user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(64) NOT NULL,
  `AGE` int(4) DEFAULT NULL,
  `ADDRESS` varchar(64) DEFAULT NULL,
  `PHONE_NUMBER` varchar(11) DEFAULT NULL,
  `ID_CARD` varchar(19) DEFAULT NULL,
  `CREATE_DATE` datetime(6) DEFAULT NULL,
  `EDIT_DATE` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- Dumping data for table blog.user: ~9 rows (approximately)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`ID`, `NAME`, `AGE`, `ADDRESS`, `PHONE_NUMBER`, `ID_CARD`, `CREATE_DATE`, `EDIT_DATE`) VALUES
	(1, 'jeck001', 21, 'XXXXXXXXX', '12345678901', '123456789987654321', '2017-04-06 13:48:54.000000', '2017-04-06 13:48:54.000000'),
	(2, 'jeck002', 22, 'XXXXXXXXX', '12345678901', '123456789987654321', '2017-04-06 13:48:54.000000', '2017-04-06 13:48:54.000000'),
	(3, 'jeck003', 23, 'XXXXXXXXX', '12345678901', '123456789987654321', '2017-04-06 13:48:54.000000', '2017-04-06 13:48:54.000000'),
	(4, 'jeck004', 24, 'XXXXXXXXX', '12345678901', '123456789987654321', '2017-04-06 13:48:54.000000', '2017-04-06 13:48:54.000000'),
	(8, 'jeck005', 19, 'chengdu, sichuan', '1234567899', '1234567890123456789', '2017-04-12 15:06:06.000000', '2017-04-12 15:06:06.000000'),
	(9, 'jeck006', 19, 'chengdu, sichuan', '1234567899', '1234567890123456789', '2017-04-12 15:13:11.000000', '2017-04-12 15:13:11.000000'),
	(10, 'jeck007', 19, 'chengdu, sichuan', '1234567899', '1234567890123456789', '2017-04-12 15:14:44.000000', '2017-04-12 15:14:44.000000'),
	(11, 'jeck008', 19, 'chengdu, sichuan', '1234567899', '1234567890123456789', '2017-04-12 15:20:24.000000', '2017-04-12 15:20:24.000000'),
	(12, 'jeck009', 19, 'neijiang, sichuan', '1234567899', '1234567890123456789', '2017-04-12 15:21:25.000000', '2017-04-12 15:21:25.000000'),
	(18, 'jeck010', 19, 'chengdu, sichuan', '1234567899', '1234567890123456789', '2017-04-14 13:58:37.000000', '2017-04-14 13:58:37.000000');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
