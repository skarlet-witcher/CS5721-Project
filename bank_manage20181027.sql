CREATE DATABASE  IF NOT EXISTS `bank_manage` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bank_manage`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: bank_manage
-- ------------------------------------------------------
-- Server version	5.1.35-community

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bank_admin`
--

DROP TABLE IF EXISTS `bank_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bank_admin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bank_admin`
--

LOCK TABLES `bank_admin` WRITE;
/*!40000 ALTER TABLE `bank_admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `bank_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bank_staff`
--

DROP TABLE IF EXISTS `bank_staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bank_staff` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `staff_id` bigint(20) NOT NULL COMMENT 'staff visible, for login. get by auto-generated',
  `password` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `status` int(11) NOT NULL COMMENT '0.invalid 1.valid',
  PRIMARY KEY (`id`),
  UNIQUE KEY `staff_id` (`staff_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bank_staff`
--

LOCK TABLES `bank_staff` WRITE;
/*!40000 ALTER TABLE `bank_staff` DISABLE KEYS */;
INSERT INTO `bank_staff` VALUES (1,1000000000,'123456','lu','hao','sb@qq.com',1);
/*!40000 ALTER TABLE `bank_staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_config`
--

DROP TABLE IF EXISTS `sys_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `conf_key` varchar(255) NOT NULL,
  `value` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_config`
--

LOCK TABLES `sys_config` WRITE;
/*!40000 ALTER TABLE `sys_config` DISABLE KEYS */;
INSERT INTO `sys_config` VALUES (1,'email','YourEmailAddress'),(2,'password','PASSWORD');
/*!40000 ALTER TABLE `sys_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT 'user visible, for login. get by auto-generated',
  `pin` varchar(6) NOT NULL COMMENT 'get by auto-generated 6 digit',
  `login_pin_digit` varchar(3) DEFAULT NULL COMMENT '3 digit, represent which 3 of 6 digit user has to input. get by auto-generated',
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `gender` int(11) NOT NULL COMMENT '0. woman 1.man',
  `birth_date` datetime NOT NULL,
  `address` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '0.blocked 1.normal 2.pending for being deleted 3.deleted.',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`user_id`),
  KEY `fk_user_id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,1000000000,'123123','134','xiangkai','tang',1,'1996-03-23 00:00:00','ul','haha@qq.com','123333222',1),(2,1000000001,'321321','321','hao','lu',2,'2018-01-01 00:00:00','hell','shit@qq.com','17481748',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_account`
--

DROP TABLE IF EXISTS `user_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_number` bigint(20) NOT NULL COMMENT 'account number, the last 8 digit of iban',
  `account_type` bigint(20) NOT NULL COMMENT '1.current account 2.student current account',
  `bic` varchar(255) NOT NULL DEFAULT 'BOFIIE2DXXX',
  `iban` varchar(255) NOT NULL COMMENT 'iban, get by auto-generated.',
  `user_id` bigint(20) DEFAULT NULL,
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '0.blocked 1.normal 2.pending for being deleted 3.deleted.',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `account_type` (`account_type`),
  KEY `fk_account_id` (`id`),
  CONSTRAINT `user_account_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `user_account_ibfk_2` FOREIGN KEY (`account_type`) REFERENCES `user_account_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_account`
--

LOCK TABLES `user_account` WRITE;
/*!40000 ALTER TABLE `user_account` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_account_type`
--

DROP TABLE IF EXISTS `user_account_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_account_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT 'the name of account type',
  `description` varchar(1000) DEFAULT '',
  `minimum_age` int(11) NOT NULL DEFAULT '0',
  `maximum_age` int(11) NOT NULL DEFAULT '100',
  `card_type` int(11) NOT NULL COMMENT '1.debit card 2.credit card',
  `physical_card` int(11) NOT NULL COMMENT '0.no 1.yes',
  `student_info_require` int(11) NOT NULL COMMENT '0.no 1.yes',
  `charge_selfservice_trans` double NOT NULL DEFAULT '0' COMMENT 'charge percentage per transaction',
  `charge_atm_deposit_withdraw` double NOT NULL DEFAULT '0' COMMENT 'charge percentage per d/w',
  `charge_per_quarter` int(11) NOT NULL DEFAULT '0' COMMENT '0.no 1.yes',
  `charge_per_quarter_minimum_banlance` double NOT NULL DEFAULT '0',
  `charge_per_quarter_amount` double NOT NULL DEFAULT '0',
  `charge_per_year` double NOT NULL DEFAULT '0',
  `charge_card_issue` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_account_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_account_type`
--

LOCK TABLES `user_account_type` WRITE;
/*!40000 ALTER TABLE `user_account_type` DISABLE KEYS */;
INSERT INTO `user_account_type` VALUES (1,'Current account','',18,200,1,1,0,0.1,0.25,1,3000,5,30,12),(2,'Student current account','',16,200,1,1,1,0,0,0,0,0,0,0),(3,'Young saver account','',6,18,1,0,0,0,0,0,0,0,5,0),(4,'Golden elder account','',66,200,1,1,0,0,0,0,0,0,5,0);
/*!40000 ALTER TABLE `user_account_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_apply_archive`
--

DROP TABLE IF EXISTS `user_apply_archive`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_apply_archive` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `identity_id` varchar(50) DEFAULT NULL COMMENT 'passport/license id number',
  `identity_id_type` int(11) DEFAULT NULL COMMENT '1.passport 2.driver license',
  `account_type` bigint(20) NOT NULL COMMENT '1.current account 2.student current account 3.young saver account 4.golden older account',
  `card_type` int(11) NOT NULL COMMENT '1.debit card 2.credit card(Not supported yet)',
  `graduate_date` datetime DEFAULT NULL COMMENT 'if the account type is student current account',
  `university` varchar(255) DEFAULT NULL COMMENT 'if the account type is student current account',
  `student_id` varchar(50) DEFAULT NULL COMMENT 'if the account type is student current account',
  `parent_user_id` bigint(20) DEFAULT NULL COMMENT 'if the account type is young savers account',
  `parent_first_name` varchar(255) DEFAULT NULL COMMENT 'if the account type is young savers account',
  `parent_last_name` varchar(255) DEFAULT NULL COMMENT 'if the account type is young savers account',
  `birth_date` datetime DEFAULT NULL,
  `gender` int(11) DEFAULT NULL COMMENT '0.woman 1.man',
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `apply_time` datetime NOT NULL,
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '0.pending for being approved 1.pass 2.deny',
  `remark` varchar(255) DEFAULT '' COMMENT 'Approved / reason for being denied.',
  `user_id` bigint(20) DEFAULT NULL COMMENT 'after being approved, get connected to user id',
  `new_user_apply` int(11) NOT NULL COMMENT '0.no 1.yes',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_apply_archive`
--

LOCK TABLES `user_apply_archive` WRITE;
/*!40000 ALTER TABLE `user_apply_archive` DISABLE KEYS */;
INSERT INTO `user_apply_archive` VALUES (19,'','','',0,4,1,NULL,NULL,NULL,NULL,NULL,NULL,'1970-01-01 01:00:00',0,'','','','2018-10-26 23:13:57',0,'pending',1000000000,0);
/*!40000 ALTER TABLE `user_apply_archive` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_card`
--

DROP TABLE IF EXISTS `user_card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_card` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `card_number` bigint(20) NOT NULL,
  `card_type` int(11) NOT NULL DEFAULT '1' COMMENT '1.debit card 2.credit card',
  `pin` varchar(6) NOT NULL COMMENT 'get by auto-generated 6 digit',
  `balance` double NOT NULL DEFAULT '0',
  `currency_type` int(11) NOT NULL DEFAULT '0' COMMENT '0.euro 1.....',
  `expired_date` datetime NOT NULL,
  `account_id` bigint(20) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '0.blocked 1.normal 2.pending for being deleted 3.deleted.',
  PRIMARY KEY (`id`),
  KEY `account_id` (`account_id`),
  CONSTRAINT `user_card_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `user_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_card`
--

LOCK TABLES `user_card` WRITE;
/*!40000 ALTER TABLE `user_card` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_history`
--

DROP TABLE IF EXISTS `user_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `operate_no` varchar(255) NOT NULL COMMENT 'string. get by auto-generated',
  `operate_type` int(11) DEFAULT NULL COMMENT '0.charge 1.deposit 2.withdraw 3.transfer sent 4.transfer received 5.change_profile 6.login 7.create 8.remove',
  `operate_time` datetime NOT NULL,
  `operate_source` int(11) DEFAULT NULL COMMENT '1.self-service 2.ATM 3.others',
  `amount` double DEFAULT NULL,
  `currency_type` int(11) DEFAULT NULL COMMENT '0.euro 1......',
  `balance` double DEFAULT NULL COMMENT 'balance after operation',
  `description` varchar(500) DEFAULT NULL,
  `status` int(11) NOT NULL COMMENT '0.pending 1.fail 2.success',
  `user_id` bigint(20) DEFAULT NULL,
  `to_payee_id` bigint(20) DEFAULT NULL,
  `account_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `to_payee_id` (`to_payee_id`),
  KEY `account_id` (`account_id`),
  CONSTRAINT `user_history_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `user_history_ibfk_2` FOREIGN KEY (`to_payee_id`) REFERENCES `user_payee` (`id`),
  CONSTRAINT `user_history_ibfk_3` FOREIGN KEY (`account_id`) REFERENCES `user_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_history`
--

LOCK TABLES `user_history` WRITE;
/*!40000 ALTER TABLE `user_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_payee`
--

DROP TABLE IF EXISTS `user_payee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_payee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `iban` varchar(255) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL COMMENT 'whose payee',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `fk_user_payee` (`id`),
  CONSTRAINT `user_payee_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_payee`
--

LOCK TABLES `user_payee` WRITE;
/*!40000 ALTER TABLE `user_payee` DISABLE KEYS */;
INSERT INTO `user_payee` VALUES (1,'xiangkai','IE12BOFI23341234000000',1);
/*!40000 ALTER TABLE `user_payee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-27  0:00:18
