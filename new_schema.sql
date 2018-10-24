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
-- Dumping data for table `bank_admin`
--

LOCK TABLES `bank_admin` WRITE;
/*!40000 ALTER TABLE `bank_admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `bank_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `bank_staff`
--

LOCK TABLES `bank_staff` WRITE;
/*!40000 ALTER TABLE `bank_staff` DISABLE KEYS */;
INSERT INTO `bank_staff` VALUES (1,1000000000,'123456','lu','hao','sb@qq.com',1);
/*!40000 ALTER TABLE `bank_staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sys_config`
--

LOCK TABLES `sys_config` WRITE;
/*!40000 ALTER TABLE `sys_config` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,1000000000,'123123','234','xiangkai','tang',1,'1996-03-23 00:00:00','ul','haha@qq.com','123333222',1),(2,1000000001,'321321','321','hao','lu',2,'2018-01-01 00:00:00','hell','shit@qq.com','17481748',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_account`
--

LOCK TABLES `user_account` WRITE;
/*!40000 ALTER TABLE `user_account` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_account_type`
--

LOCK TABLES `user_account_type` WRITE;
/*!40000 ALTER TABLE `user_account_type` DISABLE KEYS */;
INSERT INTO `user_account_type` VALUES (1,'Current account','',18,200,1,1,0,0.1,0.25,1,3000,5,30,12),(2,'Student current account','',16,200,1,1,1,0,0,0,0,0,0,0),(3,'Young saver account','',6,18,1,0,0,0,0,0,0,0,5,0),(4,'Golden elder account','',66,200,1,1,0,0,0,0,0,0,5,0);
/*!40000 ALTER TABLE `user_account_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_apply_archive`
--

LOCK TABLES `user_apply_archive` WRITE;
/*!40000 ALTER TABLE `user_apply_archive` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_apply_archive` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_card`
--

LOCK TABLES `user_card` WRITE;
/*!40000 ALTER TABLE `user_card` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_history`
--

LOCK TABLES `user_history` WRITE;
/*!40000 ALTER TABLE `user_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_history` ENABLE KEYS */;
UNLOCK TABLES;

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

-- Dump completed on 2018-10-24 16:17:03
