CREATE DATABASE IF NOT EXISTS `bank_manage` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bank_manage`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: testdb
-- ------------------------------------------------------
-- Server version	5.1.35-community

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
-- Table structure for table `bank_admin`
--

DROP TABLE IF EXISTS `bank_admin`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bank_admin` (
  `id`             bigint(20)   NOT NULL AUTO_INCREMENT,
  `username`       varchar(255) NOT NULL,
  `password`       varchar(255) NOT NULL,
  `email_host`     varchar(255) NOT NULL DEFAULT '',
  `email_port`     varchar(255) NOT NULL DEFAULT '',
  `email_account`  varchar(255) NOT NULL DEFAULT '',
  `email_password` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `bank_apply`
--

DROP TABLE IF EXISTS `bank_apply`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bank_apply` (
  `id`                bigint(20)   NOT NULL AUTO_INCREMENT,
  `first_name`        varchar(255) NOT NULL,
  `last_name`         varchar(255) NOT NULL,
  `identity_id`       varchar(50)  NOT NULL
  COMMENT 'passport/license id number',
  `identity_id_type`  int(11)      NOT NULL
  COMMENT '1.passport 2.driver license',
  `account_type`      int(11)      NOT NULL
  COMMENT '1.current account 2.student current account 3.young saver account 4.golden older account',
  `card_type`         int(11)      NOT NULL
  COMMENT '1.debit card 2.credit card(Not supported yet)',
  `graduate_date`     datetime              DEFAULT NULL
  COMMENT 'if the account type is student current account',
  `university`        varchar(255)          DEFAULT NULL
  COMMENT 'if the account type is student current account',
  `student_id`        varchar(50)           DEFAULT NULL
  COMMENT 'if the account type is student current account',
  `parent_user_id`    bigint(20)            DEFAULT NULL
  COMMENT 'if the account type is young savers account',
  `parent_first_name` varchar(255)          DEFAULT NULL
  COMMENT 'if the account type is young savers account',
  `parent_last_name`  varchar(255)          DEFAULT NULL
  COMMENT 'if the account type is young savers account',
  `birth_date`        datetime     NOT NULL,
  `gender`            int(11)      NOT NULL
  COMMENT '0.woman 1.man',
  `address`           varchar(255) NOT NULL,
  `email`             varchar(255) NOT NULL,
  `phone`             varchar(20)  NOT NULL,
  `apply_time`        datetime     NOT NULL,
  `status`            int(11)      NOT NULL DEFAULT '0'
  COMMENT '0.pending for being approved 1.pass 2.deny',
  `remark`            varchar(255) NOT NULL DEFAULT ''
  COMMENT 'Approved / reason for being denied.',
  `user_id`           bigint(20)            DEFAULT NULL
  COMMENT 'after being approved, get connected to model id',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `bank_staff`
--

DROP TABLE IF EXISTS `bank_staff`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bank_staff` (
  `id`         bigint(20)   NOT NULL AUTO_INCREMENT,
  `staff_id`   bigint(20)   NOT NULL
  COMMENT 'staff visible, for login. get by auto-generated',
  `password`   varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name`  varchar(255) NOT NULL,
  `email`      varchar(255) NOT NULL,
  `status`     int(11)      NOT NULL
  COMMENT '0.invalid 1.valid',
  PRIMARY KEY (`id`),
  UNIQUE KEY `staff_id` (`staff_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `model`
--

DROP TABLE IF EXISTS `model`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id`              bigint(20)   NOT NULL AUTO_INCREMENT,
  `user_id`         bigint(20)   NOT NULL
  COMMENT 'model visible, for login. get by auto-generated',
  `pin`             int(11)      NOT NULL
  COMMENT 'get by auto-generated 6 digit',
  `login_pin_digit` int(11)               DEFAULT NULL
  COMMENT '3 digit, represent which 3 of 6 digit model has to input. get by auto-generated',
  `first_name`      varchar(255) NOT NULL,
  `last_name`       varchar(255) NOT NULL,
  `gender`          int(11)      NOT NULL
  COMMENT '0. woman 1.man',
  `birth_date`      datetime     NOT NULL,
  `address`         varchar(255) NOT NULL,
  `email`           varchar(255) NOT NULL,
  `phone`           varchar(20)  NOT NULL,
  `status`          int(11)      NOT NULL DEFAULT '1'
  COMMENT '0.blocked 1.normal 2.pending for being deleted 3.deleted.',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`user_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_account`
--

DROP TABLE IF EXISTS `user_account`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_account` (
  `id`             bigint(20)   NOT NULL AUTO_INCREMENT,
  `account_number` bigint(20)   NOT NULL
  COMMENT 'account number, the last 8 digit of iban',
  `account_type`   int(11)      NOT NULL
  COMMENT '1.current account 2.student current account',
  `bic`            varchar(255) NOT NULL DEFAULT 'BOFIIE2DXXX',
  `iban`           varchar(255) NOT NULL
  COMMENT 'iban, get by auto-generated.',
  `user_id`        bigint(20)            DEFAULT NULL,
  `status`         int(11)      NOT NULL DEFAULT '1'
  COMMENT '0.blocked 1.normal 2.pending for being deleted 3.deleted.',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_account_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_card`
--

DROP TABLE IF EXISTS `user_card`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_card` (
  `id`            bigint(20) NOT NULL AUTO_INCREMENT,
  `card_number`   bigint(20) NOT NULL,
  `card_type`     int(11)    NOT NULL DEFAULT '1'
  COMMENT '1.debit card 2.credit card(Not supported yet)',
  `pin`           int(11)    NOT NULL
  COMMENT 'get by auto-generated 6 digit',
  `balance`       double              DEFAULT NULL,
  `currency_type` int(11)    NOT NULL DEFAULT '0'
  COMMENT '0.euro 1.....',
  `expired_date`  datetime   NOT NULL,
  `account_id`    bigint(20) NOT NULL,
  `status`        int(11)    NOT NULL DEFAULT '1'
  COMMENT '0.blocked 1.normal 2.pending for being deleted 3.deleted.',
  PRIMARY KEY (`id`),
  KEY `account_id` (`account_id`),
  CONSTRAINT `user_card_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `user_account` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_operation_history`
--

DROP TABLE IF EXISTS `user_operation_history`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_operation_history` (
  `id`             bigint(20) NOT NULL AUTO_INCREMENT,
  `operate_no`     bigint(20) NOT NULL
  COMMENT 'long int. get by auto-generated',
  `operate_type`   int(11)             DEFAULT NULL
  COMMENT '0.charge 1.deposit 2.withdraw 3.transfer sent 4.transfer received 5.change_profile 6.login 7.create 8.remove',
  `operate_time`   datetime   NOT NULL,
  `operate_source` int(11)             DEFAULT NULL
  COMMENT '1.self-service 2.ATM 3.other',
  `amount`         double              DEFAULT NULL,
  `currency_type`  int(11)    NOT NULL DEFAULT '0'
  COMMENT '0.euro 1......',
  `balance`        double     NOT NULL,
  `description`    varchar(500)        DEFAULT NULL,
  `status`         int(11)    NOT NULL
  COMMENT '0.pending 1.fail 2.success',
  `user_id`        bigint(20)          DEFAULT NULL,
  `to_payee_id`    bigint(20)          DEFAULT NULL,
  `account_id`     bigint(20)          DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `to_payee_id` (`to_payee_id`),
  KEY `account_id` (`account_id`),
  CONSTRAINT `user_operation_history_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `user_operation_history_ibfk_2` FOREIGN KEY (`to_payee_id`) REFERENCES `user_payee` (`id`),
  CONSTRAINT `user_operation_history_ibfk_3` FOREIGN KEY (`account_id`) REFERENCES `user_account` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_payee`
--

DROP TABLE IF EXISTS `user_payee`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_payee` (
  `id`      bigint(20)   NOT NULL AUTO_INCREMENT,
  `name`    varchar(255) NOT NULL,
  `iban`    varchar(255) NOT NULL,
  `user_id` bigint(20)            DEFAULT NULL
  COMMENT 'whose payee',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_payee_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

-- Dump completed on 2018-10-17 16:28:27
