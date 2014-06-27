-- MySQL dump 10.13  Distrib 5.5.37, for debian-linux-gnu (i686)
--
-- Host: localhost    Database: forum
-- ------------------------------------------------------
-- Server version	5.5.37-0ubuntu0.12.04.1

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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL DEFAULT '',
  `description` text,
  `content` varchar(255) DEFAULT NULL,
  `date_add` datetime DEFAULT NULL,
  `id_author` bigint(20) DEFAULT NULL,
  `id_category` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Announcements','Announcements and general project news',NULL,NULL,NULL,NULL),(2,'Container','Discussion on Spring\'s dependency injection container, including XML and annotation-based configuration.',NULL,NULL,NULL,NULL),(3,'Data','Discussion on data access with Spring. This forum is for Spring Data Community Extensions like Solr, Elasticsearch, Couchbase, FuzzyDB.',NULL,NULL,NULL,NULL),(4,'Security','Discussing on securing applications with Spring Security and its extensions.',NULL,NULL,NULL,NULL),(5,'Web','Discussion on developing web applications with Spring, including usage of Spring MVC and its REST support, as well as the HATEOAS, Web Flow, and Social projects.',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text CHARACTER SET utf8 NOT NULL,
  `id_topic` int(11) NOT NULL,
  `id_author` int(11) NOT NULL DEFAULT '0',
  `date_add` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `id_author` (`id_author`),
  KEY `id_topic` (`id_topic`),
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`id_author`) REFERENCES `user` (`id`),
  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`id_topic`) REFERENCES `topic` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,'This question is probably a better candidate for StackOverflow, perhaps with the \"spring\" tag.\r\n\r\nCould you post your question there?\r\nThe forums are moving to stackoverflow, a page explaining all this will be available there in a few days: http://spring.io/questions',3,2,'2014-06-27 12:37:01'),(2,'Yes I have the same problem. I think you will need a setter method to support mock injection. In my understanding you don\'t need a testAppContext.xml if you are not making some form of integration testing with real parts (configured in your testAppContext.xml).\r\n\r\nYou probably want to avoid creating Mock implementations of your collaborators to inject them in the testAppContext.xml.\r\n\r\nIf you need only use a mocking framework and directly set the collaborators to perform your unit test then I believe it is preferable to do so.',3,1,'2014-06-27 12:37:01'),(3,'If this is just the test, how are you setting OutsideService in your non-test code if you don\'t have a setter? Are you using the constructor? Are you hardcoding the dependency by using \'new\'?',3,2,'2014-06-27 12:37:01');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profile`
--

DROP TABLE IF EXISTS `profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profile` (
  `owner_id` int(11) NOT NULL AUTO_INCREMENT,
  `name_first` varchar(255) NOT NULL DEFAULT '',
  `name_last` varchar(255) NOT NULL DEFAULT '',
  `web_site` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`owner_id`),
  CONSTRAINT `profile_ibfk_1` FOREIGN KEY (`owner_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profile`
--

LOCK TABLES `profile` WRITE;
/*!40000 ALTER TABLE `profile` DISABLE KEYS */;
/*!40000 ALTER TABLE `profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topic`
--

DROP TABLE IF EXISTS `topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `topic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL DEFAULT '',
  `content` text NOT NULL,
  `date_add` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `id_author` int(11) NOT NULL DEFAULT '0',
  `id_category` int(11) NOT NULL DEFAULT '0',
  `category_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_author` (`id_author`),
  KEY `id_category` (`id_category`),
  CONSTRAINT `topic_ibfk_1` FOREIGN KEY (`id_author`) REFERENCES `user` (`id`),
  CONSTRAINT `topic_ibfk_2` FOREIGN KEY (`id_category`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topic`
--

LOCK TABLES `topic` WRITE;
/*!40000 ALTER TABLE `topic` DISABLE KEYS */;
INSERT INTO `topic` VALUES (2,'Spring Framework 3.2.5 Released','The fifth maintenance release in the Spring Framework 3.2.x line is now available via Maven Central or the SpringSource repository. This release includes nearly 50 bug fixes and improvements and we recommend that all users upgrade.','2014-06-27 10:12:06',1,1,NULL),(3,'Mock injection','How can I,\r\n\r\npropagate a mock service created in a unit test? I would like, that spring when the test starts uses as bean injection of the service, the service mock.\r\n\r\nThanks.\r\n\r\nRegards.','2014-06-27 10:16:31',1,2,NULL);
/*!40000 ALTER TABLE `topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) NOT NULL DEFAULT '',
  `name_first` varchar(255) DEFAULT NULL,
  `name_last` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL DEFAULT '',
  `skype` varchar(255) DEFAULT '',
  `id_role` int(11) NOT NULL DEFAULT '1',
  `is_enabled` tinyint(4) DEFAULT '1',
  `email` varchar(255) NOT NULL DEFAULT '',
  `date_add` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `id_role` (`id_role`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`id_role`) REFERENCES `user_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'jekamell','Jeka','Mell','e10adc3949ba59abbe56e057f20f883e','jekamell',1,1,'55jeka@gmail.com','2014-06-27 09:02:15'),(2,'bclozel',NULL,NULL,'e10adc3949ba59abbe56e057f20f883e',NULL,1,1,'bclozel@gmail.com','2014-06-27 10:19:24');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) NOT NULL DEFAULT '',
  `title` varchar(255) NOT NULL DEFAULT '',
  `date_add` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,'ROLE_USER','Зарегистрированный пользователь','2014-06-18 12:35:57'),(2,'ROLE_ADMIN','Администратор','2014-06-18 12:35:57');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-06-27 23:33:50
