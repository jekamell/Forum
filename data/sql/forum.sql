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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Announcements','Announcements and general project news'),(2,'Container','Discussion on Spring\'s dependency injection container, including XML and annotation-based configuration.'),(3,'Data','Discussion on data access with Spring. This forum is for Spring Data Community Extensions like Solr, Elasticsearch, Couchbase, FuzzyDB.'),(4,'Security','Discussing on securing applications with Spring Security and its extensions.'),(5,'Web','Discussion on developing web applications with Spring, including usage of Spring MVC and its REST support, as well as the HATEOAS, Web Flow, and Social projects.');
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
  PRIMARY KEY (`id`),
  KEY `id_author` (`id_author`),
  KEY `id_topic` (`id_topic`),
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`id_author`) REFERENCES `user` (`id`),
  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`id_topic`) REFERENCES `topic` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
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
  PRIMARY KEY (`id`),
  KEY `id_author` (`id_author`),
  KEY `id_category` (`id_category`),
  CONSTRAINT `topic_ibfk_1` FOREIGN KEY (`id_author`) REFERENCES `user` (`id`),
  CONSTRAINT `topic_ibfk_2` FOREIGN KEY (`id_category`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topic`
--

LOCK TABLES `topic` WRITE;
/*!40000 ALTER TABLE `topic` DISABLE KEYS */;
INSERT INTO `topic` VALUES (1,'Spring Framework 3.2.5 Released','The fifth maintenance release in the Spring Framework 3.2.x line is now available via Maven Central or the SpringSource repository. This release includes nearly 50 bug fixes and improvements and we recommend that all users upgrade.','2014-06-20 07:51:29',1,1),(2,'Spring Scala 1.0.0.RC1 has been released','Dear Spring community,\r\n\r\nI\'m pleased to announce that Spring Scala 1.0.0.RC1 has been released! This is first release candidate in the release cycle. It contains numerous small changes, mainly to prepare for a 1.0.0.RELEASE.\r\n\r\nPlease give it a shot! As before the jar is available for download at our milestone repository, http://repo.springsource.org/libs-milestone. For Maven users:\r\n\r\n<repositories>\r\n    <repository>\r\n        <id>milestone.repo.springsource.org</id>\r\n        <name>repo.springsource.org-milestone</name>\r\n        <url>https://repo.springsource.org/libs-milestone</url>\r\n    </repository>\r\n</repositories>\r\n<dependency>\r\n    <groupId>org.springframework.scala</groupId>\r\n    <artifactId>spring-scala_2.10</artifactId>\r\n    <version>1.0.0.RC1</version>\r\n</dependency>\r\n\r\nNote that we have started to include the Scala version number in the artifactId, a common practice for Scala libraries. \r\n\r\nThanks,\r\n\r\nArjen','2014-06-20 07:56:56',1,1),(3,'Spring Web Services 2.1.4.RELEASE released','Dear Spring community,\r\n\r\nI\'m pleased to announce that Spring Web Services 2.1.4.RELEASE has been released!\r\n\r\nThis is the latest GA release in the 2.1 release cycle. It mainly consists of bug fixes.\r\n\r\nPlease see the changelog for more details.\r\n\r\nThis release is currently available on our Maven release repository, and will be available on Maven Central and the download page shortly.\r\n\r\nFor more information, refer to \r\n\r\nhttp://static.springframework.org/spring-ws/sites/2.0','2014-06-20 07:57:37',1,1),(4,'ApplicationContext.xml cannot be found when starting Tomcat server','Hi guys,\r\nI know that this question had to be asked about million times but i have tried all suggested solutions for this and none of them have worked. I hope that it is not against rules of this foreum but ionstead of writing it down again i post here my unanswered question from stack overflo \r\n\r\nhttp://stackoverflow.com/questions/2...62254_23008148\r\n\r\nthanks for your help in advance','2014-06-20 07:59:41',1,2),(5,'Help me on this','I am working on existing web project. It is just developed using jsp and servlets and deployed on tomcat.\r\n\r\nWeb app maintainnce configurations in seperate file for configuration parameters. It is like this\r\n\r\ntomcat/conf/app.conf\r\n\r\nNO_WORKING_DYS 10\r\nNO_PEOPLE 5\r\n......\r\n....\r\n\r\n\r\nApp is reading this file in context listner and keep values in a map. Then what happen is, web application needed to be restarted after changing a configuration value. If not, new config value is not picked up. I know it is obvious since we are reading the config file inside the context listener.\r\n\r\n\r\nI need to know is there any possibility to overcome this issue (change config values with out restating or redeploing) using spring\r\nIOC container..\r\n\r\n\r\nThannk you...','2014-06-20 08:03:47',1,2);
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
  `password` varchar(255) NOT NULL DEFAULT '',
  `id_role` int(11) NOT NULL DEFAULT '1',
  `is_enabled` tinyint(4) DEFAULT '1',
  `email` varchar(255) NOT NULL DEFAULT '',
  `date_add` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `id_role` (`id_role`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`id_role`) REFERENCES `user_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'jekamell','123456',1,1,'55jeka@gmail.com','2014-06-16 15:32:30');
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

-- Dump completed on 2014-06-21  0:21:38
