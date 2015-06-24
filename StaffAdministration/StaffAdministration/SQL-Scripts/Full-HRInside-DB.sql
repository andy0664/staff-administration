-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: staffadministration
-- ------------------------------------------------------
-- Server version	5.6.22-log

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
-- Table structure for table `announcement`
--

DROP TABLE IF EXISTS `announcement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `announcement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `day` date DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  `message` varchar(255) DEFAULT NULL,
  `notRead` int(11) NOT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `version` bigint(20) NOT NULL,
  `employeeId` int(11) NOT NULL,
  `managerId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_mdsw0etnjvyqmnjt532o8c568` (`employeeId`),
  KEY `FK_kjpspe8xblu1cce0o6w832oag` (`managerId`),
  CONSTRAINT `FK_kjpspe8xblu1cce0o6w832oag` FOREIGN KEY (`managerId`) REFERENCES `employee` (`id`),
  CONSTRAINT `FK_mdsw0etnjvyqmnjt532o8c568` FOREIGN KEY (`employeeId`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `announcement`
--

LOCK TABLES `announcement` WRITE;
/*!40000 ALTER TABLE `announcement` DISABLE KEYS */;
INSERT INTO `announcement` VALUES (1,'2016-06-07','','Birthday: Maria Musterfrau ',0,'Birthday',0,5,3),(2,'2016-04-10','','Birthday: Max Mustermann ',0,'Birthday',0,4,2);
/*!40000 ALTER TABLE `announcement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `shortcut` varchar(5) NOT NULL,
  `version` bigint(20) NOT NULL,
  `manager_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_9dn8wjbqeyk4nif0cty690spq` (`shortcut`),
  KEY `FK_pwsg2i9mf3et4f3fi0w5up61m` (`manager_id`),
  CONSTRAINT `FK_pwsg2i9mf3et4f3fi0w5up61m` FOREIGN KEY (`manager_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'IT Department','IT',0,2),(2,'Public Relations','PR',0,3);
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `zip` int(11) NOT NULL,
  `dayOfBirth` date NOT NULL,
  `dayOfEntry` date NOT NULL,
  `firstName` varchar(255) NOT NULL,
  `jobDescription` varchar(255) NOT NULL,
  `lastName` varchar(255) NOT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `salary` float NOT NULL,
  `ssn` int(11) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `version` bigint(20) NOT NULL,
  `department_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_jxe7etk9n6etjilii75ye6d51` (`ssn`),
  UNIQUE KEY `UK_rvjwbm53mfe2cv8fsh5ge5e1y` (`mail`),
  UNIQUE KEY `UK_9rb47eja4kduve75d2aeen2pb` (`phone`),
  UNIQUE KEY `UK_hdcovryi3sexfx3p8womg5b9a` (`userName`),
  KEY `FK_lk0a412kck2kdc6slousi528s` (`department_id`),
  CONSTRAINT `FK_lk0a412kck2kdc6slousi528s` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Woodstock','should','Barkey',8020,'1968-11-17','1978-09-05','Cheyenne','television','Ruiz','admin@hrinside.at','$2a$04$iPApf3wYPXmuW6zUaZvTJuCUeW9a9HH7cwc2tXIbBh9F.AVLev29m','+43 1234567','ROLE_ADMIN',1234.5,12345,'Available','admin',0,NULL),(2,'Graz','Österreich','Street 1',8010,'1998-12-28','2010-01-11','Lukas','Manager IT','Müller','managerIT@hrinside.at','$2a$04$iPApf3wYPXmuW6zUaZvTJuCUeW9a9HH7cwc2tXIbBh9F.AVLev29m','+43 6354128','ROLE_MANAGER',3500,98765,'Available','managerIT',2,1),(3,'Graz','Österreich','Street 2',8020,'2000-03-08','2013-06-04','Sarah','Managerin PR','Maier','managerPR@hrinside.at','$2a$04$b/Ocr7DYFAL9zJ.gkRbi2.nfjCdRKAjvTk15FBvB9IlfVl3qehHRO','+43 7654321','ROLE_MANAGER',2900,32453,'Available','managerPR',2,2),(4,'Graz','Österreich','Street 3',8052,'2001-04-10','2011-05-09','Max','Employee IT','Mustermann','employeeIT@hrinside.at','$2a$04$XM58R/gnJL5KePIlfatPzuOoO7Letpm2uG2B7aL9ZvrnyVT6pwczC','+43 1256732','ROLE_EMPLOYEE',2345,87653,'Available','employeeIT',2,1),(5,'Graz','Österreich','Street 4',8020,'2009-06-07','2015-06-02','Maria','Employee PR','Musterfrau','employeePR@hrinside.at','$2a$04$UInVAZcBCUrDC4IiufF.GOyJV40ekjnxWgvBR6XhZxTuXdhdiYa3y','+43 4587123','ROLE_EMPLOYEE',2200,34256,'Available','employeePR',2,2);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `events`
--

DROP TABLE IF EXISTS `events`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `events` (
  `event_id` int(11) NOT NULL,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `event_name` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `department_visibility` bit(1) DEFAULT NULL,
  PRIMARY KEY (`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `events`
--

LOCK TABLES `events` WRITE;
/*!40000 ALTER TABLE `events` DISABLE KEYS */;
/*!40000 ALTER TABLE `events` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `events_rec`
--

DROP TABLE IF EXISTS `events_rec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `events_rec` (
  `event_id` int(11) NOT NULL,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `rec_type` varchar(255) DEFAULT NULL,
  `event_length` int(11) DEFAULT NULL,
  `event_pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `events_rec`
--

LOCK TABLES `events_rec` WRITE;
/*!40000 ALTER TABLE `events_rec` DISABLE KEYS */;
/*!40000 ALTER TABLE `events_rec` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `message` varchar(150) NOT NULL,
  `title` varchar(255) NOT NULL,
  `version` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `timerecord`
--

DROP TABLE IF EXISTS `timerecord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `timerecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `endDate` date NOT NULL,
  `endTime` time NOT NULL,
  `startDate` date NOT NULL,
  `startTime` time NOT NULL,
  `typ` varchar(255) NOT NULL,
  `version` bigint(20) NOT NULL,
  `employee_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_glei1hn86sg5irdcx3vlb7wq9` (`employee_id`),
  CONSTRAINT `FK_glei1hn86sg5irdcx3vlb7wq9` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timerecord`
--

LOCK TABLES `timerecord` WRITE;
/*!40000 ALTER TABLE `timerecord` DISABLE KEYS */;
/*!40000 ALTER TABLE `timerecord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userrole`
--

DROP TABLE IF EXISTS `userrole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userrole` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  `idEmployee` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_rkj9okoif2rswq7frfa08gumm` (`idEmployee`),
  CONSTRAINT `FK_rkj9okoif2rswq7frfa08gumm` FOREIGN KEY (`idEmployee`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userrole`
--

LOCK TABLES `userrole` WRITE;
/*!40000 ALTER TABLE `userrole` DISABLE KEYS */;
INSERT INTO `userrole` VALUES (1,'ROLE_MANAGER',1),(2,'ROLE_ADMIN',1),(3,'ROLE_EMPLOYEE',1),(4,'ROLE_EMPLOYEE',2),(5,'ROLE_MANAGER',2),(6,'ROLE_MANAGER',3),(7,'ROLE_EMPLOYEE',3),(8,'ROLE_EMPLOYEE',4),(9,'ROLE_EMPLOYEE',5);
/*!40000 ALTER TABLE `userrole` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-06-23 23:15:08
