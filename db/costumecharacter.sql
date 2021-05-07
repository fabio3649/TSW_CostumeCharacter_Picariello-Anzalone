CREATE DATABASE  IF NOT EXISTS `costumecharacter` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `costumecharacter`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: costumecharacter
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `idProduct` int NOT NULL,
  `name` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `description` varchar(300) DEFAULT NULL,
  `age` varchar(45) NOT NULL,
  `size` varchar(20) DEFAULT NULL,
  `numberCopies` int NOT NULL,
  `iva` varchar(5) NOT NULL,
  `price` double NOT NULL,
  `weight` double NOT NULL,
  `urlImage` varchar(300) NOT NULL,
  PRIMARY KEY (`idProduct`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Costume Batman','Costume','Costume di Batman per adulto. <br> Consigliato per Cosplayer <br> Include: Tuta con stampa di muscoli,<br> cintura,<br> mantello,<br> maschera,<br> copristivali e guanti ','adulto','XL',0,'22',49.9,10,'/CostumeCharacter/images/batmanCostumeDeluxe.jpg'),(2,'Costume Iron-Man','Costume','Costume Iron man per adulto','adulto','XL',6,'22',89.9,15,'/CostumeCharacter/images/ironman.jpg'),(3,'Maschera Spiderman bambino','Maschera','Maschera Spiderman per bambino. <br> Festeggia il carnevale e diventa il supereroe più bello di tutti. <br> Stupisci i tuoi amichetti.','bambino','NULL',0,'22',19.9,0.5,'/CostumeCharacter/images/mascheraSpidermanBambino.jpg'),(4,'Maschera Walter White BB','Maschera','Maschera di Walter Wite dalla serie Tv Netflx Breaking Bad. <br> Maschera originale del protagonista della serie. <br> Prodotta interamente a mano. <br> Materiale: Lattice.','adulto','NULL',15,'22',39.9,1.5,'/CostumeCharacter/images/maskWW.png'),(5,'Maschera Arlecchino Commedia dell\'Arte','Maschera','Maschera di commedia dell\'arte dello zanni Arlecchino. <br> Prodotta interamente a mano. <br> Materiali: Cuoio.','adulto','NULL',7,'22',129.9,1,'/CostumeCharacter/images/arlecchino.jpg'),(6,'Costume biancaneve','Costume','Costume della principessa Disney Biancaneve. <br> Festeggia il carnevale e diventa la principessa della festa. <br> Stupisci i tuoi amichetti.','bambino','5-6 anni',25,'22',29.9,4.9,'/CostumeCharacter/images/biancaneveBambina.jpg');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-04 14:13:41
