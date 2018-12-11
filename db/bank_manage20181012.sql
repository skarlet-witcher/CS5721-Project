-- MySQL dump 10.13  Distrib 5.5.53, for Win32 (AMD64)
--
-- Host: localhost    Database: bank_manage
-- ------------------------------------------------------
-- Server version	5.5.53

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

--
-- Table structure for table `card`
--

DROP TABLE IF EXISTS `card`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `card` (
  `id`      bigint(20) NOT NULL AUTO_INCREMENT,
  `card_no` char(16)   NOT NULL,
  `balance` double              DEFAULT NULL,
  `user_id` bigint(20)          DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`)
)
  ENGINE = MyISAM
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `card`
--

LOCK TABLES `card` WRITE;
/*!40000 ALTER TABLE `card`
  DISABLE KEYS */;
/*!40000 ALTER TABLE `card`
  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `card_transaction`
--

DROP TABLE IF EXISTS `card_transaction`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `card_transaction` (
  `id`                 bigint(20) NOT NULL AUTO_INCREMENT,
  `transaction_no`     bigint(20) NOT NULL,
  `from_card_no`       char(16)            DEFAULT NULL,
  `to_card_no`         char(16)            DEFAULT NULL,
  `amount`             decimal(5, 2)       DEFAULT NULL,
  `transaction_status` int(11)             DEFAULT NULL,
  `currency_type`      varchar(15)         DEFAULT NULL,
  `description`        varchar(500)        DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `from_card_no` (`from_card_no`),
  KEY `to_card_no` (`to_card_no`)
)
  ENGINE = MyISAM
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `card_transaction`
--

LOCK TABLES `card_transaction` WRITE;
/*!40000 ALTER TABLE `card_transaction`
  DISABLE KEYS */;
/*!40000 ALTER TABLE `card_transaction`
  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `model`
--

DROP TABLE IF EXISTS `model`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id`         bigint(20) NOT NULL AUTO_INCREMENT,
  `username`   varchar(20)         DEFAULT NULL,
  `password`   varchar(20)         DEFAULT NULL,
  `first_name` varchar(32)         DEFAULT NULL,
  `last_name`  varchar(32)         DEFAULT NULL,
  `address`    varchar(128)        DEFAULT NULL,
  `email`      varchar(128)        DEFAULT NULL,
  `phone`      varchar(20)         DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
)
  ENGINE = MyISAM
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `model`
--

LOCK TABLES `model` WRITE;
/*!40000 ALTER TABLE `model`
  DISABLE KEYS */;
INSERT INTO `user`
VALUES (1, '123', '123', 'a', 'b', 'c', 'd', 'e');
/*!40000 ALTER TABLE `model`
  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_log`
--

DROP TABLE IF EXISTS `user_log`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_log` (
  `id`             bigint(20) NOT NULL AUTO_INCREMENT,
  `operation_type` varchar(20)         DEFAULT NULL
  COMMENT '1.deposit 2.withdraw 3.transfer 4.change_phone 5.change_address 6.create 7.remove 8.login',
  `operate_time`   datetime            DEFAULT NULL,
  `description`    varchar(500)        DEFAULT NULL,
  `user_id`        bigint(20)          DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`)
)
  ENGINE = MyISAM
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_log`
--

LOCK TABLES `user_log` WRITE;
/*!40000 ALTER TABLE `user_log`
  DISABLE KEYS */;
/*!40000 ALTER TABLE `user_log`
  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_staff`
--

DROP TABLE IF EXISTS `user_staff`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_staff` (
  `id`         bigint(20) NOT NULL AUTO_INCREMENT,
  `username`   varchar(20)         DEFAULT NULL,
  `password`   varchar(20)         DEFAULT NULL,
  `first_name` varchar(32)         DEFAULT NULL,
  `last_name`  varchar(32)         DEFAULT NULL,
  `address`    varchar(128)        DEFAULT NULL,
  `email`      varchar(128)        DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
)
  ENGINE = MyISAM
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_staff`
--

LOCK TABLES `user_staff` WRITE;
/*!40000 ALTER TABLE `user_staff`
  DISABLE KEYS */;
/*!40000 ALTER TABLE `user_staff`
  ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

-- Dump completed on 2018-10-12  0:46:10
