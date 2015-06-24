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
-- Dumping data for table `announcement`
--

LOCK TABLES `announcement` WRITE;
/*!40000 ALTER TABLE `announcement` DISABLE KEYS */;
INSERT INTO `announcement` VALUES (1,'2016-06-07','','Birthday: Maria Musterfrau ',0,'Birthday',0,5,3),(2,'2016-04-10','','Birthday: Max Mustermann ',0,'Birthday',0,4,2);
/*!40000 ALTER TABLE `announcement` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `Announcement` WRITE;
/*!40000 ALTER TABLE `Announcement` DISABLE KEYS */;
INSERT INTO `Announcement` VALUES (1,'2016-06-07','','Birthday: Maria Musterfrau ',0,'Birthday',0,5,3),(2,'2016-04-10','','Birthday: Max Mustermann ',0,'Birthday',0,4,2);
/*!40000 ALTER TABLE `Announcement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'IT Department','IT',0,2),(2,'Public Relations','PR',0,3);
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `Department` WRITE;
/*!40000 ALTER TABLE `Department` DISABLE KEYS */;
INSERT INTO `Department` VALUES (1,'IT Department','IT',0,2),(2,'Public Relations','PR',0,3);
/*!40000 ALTER TABLE `Department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (2,'Graz','Österreich','Street 1',8010,'1998-12-28','2010-01-11','Lukas','Manager IT','Müller','managerIT@hrinside.at','$2a$04$iPApf3wYPXmuW6zUaZvTJuCUeW9a9HH7cwc2tXIbBh9F.AVLev29m','+43 6354128','ROLE_MANAGER',3500,98765,'Available','managerIT',2,1),(3,'Graz','Österreich','Street 2',8020,'2000-03-08','2013-06-04','Sarah','Managerin PR','Maier','managerPR@hrinside.at','$2a$04$b/Ocr7DYFAL9zJ.gkRbi2.nfjCdRKAjvTk15FBvB9IlfVl3qehHRO','+43 7654321','ROLE_MANAGER',2900,32453,'Available','managerPR',2,2),(4,'Graz','Österreich','Street 3',8052,'2001-04-10','2011-05-09','Max','Employee IT','Mustermann','employeeIT@hrinside.at','$2a$04$XM58R/gnJL5KePIlfatPzuOoO7Letpm2uG2B7aL9ZvrnyVT6pwczC','+43 1256732','ROLE_EMPLOYEE',2345,87653,'Available','employeeIT',2,1),(5,'Graz','Österreich','Street 4',8020,'2009-06-07','2015-06-02','Maria','Employee PR','Musterfrau','employeePR@hrinside.at','$2a$04$UInVAZcBCUrDC4IiufF.GOyJV40ekjnxWgvBR6XhZxTuXdhdiYa3y','+43 4587123','ROLE_EMPLOYEE',2200,34256,'Available','employeePR',2,2);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `Employee` WRITE;
/*!40000 ALTER TABLE `Employee` DISABLE KEYS */;
INSERT INTO `Employee` VALUES (2,'Graz','Österreich','Street 1',8010,'1998-12-28','2010-01-11','Lukas','Manager IT','Müller','managerIT@hrinside.at','$2a$04$iPApf3wYPXmuW6zUaZvTJuCUeW9a9HH7cwc2tXIbBh9F.AVLev29m','+43 6354128','ROLE_MANAGER',3500,98765,'Available','managerIT',2,1),(3,'Graz','Österreich','Street 2',8020,'2000-03-08','2013-06-04','Sarah','Managerin PR','Maier','managerPR@hrinside.at','$2a$04$b/Ocr7DYFAL9zJ.gkRbi2.nfjCdRKAjvTk15FBvB9IlfVl3qehHRO','+43 7654321','ROLE_MANAGER',2900,32453,'Available','managerPR',2,2),(4,'Graz','Österreich','Street 3',8052,'2001-04-10','2011-05-09','Max','Employee IT','Mustermann','employeeIT@hrinside.at','$2a$04$XM58R/gnJL5KePIlfatPzuOoO7Letpm2uG2B7aL9ZvrnyVT6pwczC','+43 1256732','ROLE_EMPLOYEE',2345,87653,'Available','employeeIT',2,1),(5,'Graz','Österreich','Street 4',8020,'2009-06-07','2015-06-02','Maria','Employee PR','Musterfrau','employeePR@hrinside.at','$2a$04$UInVAZcBCUrDC4IiufF.GOyJV40ekjnxWgvBR6XhZxTuXdhdiYa3y','+43 4587123','ROLE_EMPLOYEE',2200,34256,'Available','employeePR',2,2);
/*!40000 ALTER TABLE `Employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `events`
--

LOCK TABLES `events` WRITE;
/*!40000 ALTER TABLE `events` DISABLE KEYS */;
/*!40000 ALTER TABLE `events` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `Events` WRITE;
/*!40000 ALTER TABLE `Events` DISABLE KEYS */;
/*!40000 ALTER TABLE `Events` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Dumping data for table `events_rec`
--

LOCK TABLES `events_rec` WRITE;
/*!40000 ALTER TABLE `events_rec` DISABLE KEYS */;
/*!40000 ALTER TABLE `events_rec` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `Events_rec` WRITE;
/*!40000 ALTER TABLE `Events_rec` DISABLE KEYS */;
/*!40000 ALTER TABLE `Events_rec` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `News` WRITE;
/*!40000 ALTER TABLE `News` DISABLE KEYS */;
/*!40000 ALTER TABLE `News` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `timerecord`
--

LOCK TABLES `timerecord` WRITE;
/*!40000 ALTER TABLE `timerecord` DISABLE KEYS */;
/*!40000 ALTER TABLE `timerecord` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `Timerecord` WRITE;
/*!40000 ALTER TABLE `Timerecord` DISABLE KEYS */;
/*!40000 ALTER TABLE `Timerecord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `userrole`
--

LOCK TABLES `userrole` WRITE;
/*!40000 ALTER TABLE `userrole` DISABLE KEYS */;
INSERT INTO `userrole` VALUES(4,'ROLE_EMPLOYEE',2),(5,'ROLE_MANAGER',2),(6,'ROLE_MANAGER',3),(7,'ROLE_EMPLOYEE',3),(8,'ROLE_EMPLOYEE',4),(9,'ROLE_EMPLOYEE',5);
/*!40000 ALTER TABLE `userrole` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `Userrole` WRITE;
/*!40000 ALTER TABLE `Userrole` DISABLE KEYS */;
INSERT INTO `Userrole` VALUES(4,'ROLE_EMPLOYEE',2),(5,'ROLE_MANAGER',2),(6,'ROLE_MANAGER',3),(7,'ROLE_EMPLOYEE',3),(8,'ROLE_EMPLOYEE',4),(9,'ROLE_EMPLOYEE',5);
/*!40000 ALTER TABLE `Userrole` ENABLE KEYS */;
UNLOCK TABLES;

/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-06-23 22:59:21
