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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `idClass` varchar(1) NOT NULL,
  `name` varchar(45) NOT NULL,
  `description` varchar(300) NOT NULL,
  PRIMARY KEY (`idClass`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES ('A','Supereroi','Costumi, maschere e accessori di supereroi del fumetto e cartoni animati.'),('B','Film & Serie TV','Costumi, maschere e accessori tratti da personaggi del mondo del cinema.'),('C','Disney','Costumi, maschere e accessori del mondo Disney principlamente per bambini.'),('D','Teatro','Costumi, maschere e accessori per spettacoli teatrali.');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `idOrder` int NOT NULL,
  `paymentMethod` varchar(45) NOT NULL,
  `date` date NOT NULL,
  `status` varchar(45) DEFAULT NULL,
  `totalPrice` int NOT NULL,
  `shippingCosts` int DEFAULT NULL,
  `user` varchar(100) NOT NULL,
  PRIMARY KEY (`idOrder`),
  KEY `user_idx` (`user`),
  CONSTRAINT `user` FOREIGN KEY (`user`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

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
  `size` varchar(10) DEFAULT NULL,
  `numberCopies` int NOT NULL,
  `iva` int NOT NULL,
  `price` double NOT NULL,
  `weight` double NOT NULL,
  `urlImage` varchar(300) NOT NULL,
  `category` varchar(1) NOT NULL,
  PRIMARY KEY (`idProduct`),
  KEY `category_idx` (`category`),
  CONSTRAINT `category` FOREIGN KEY (`category`) REFERENCES `category` (`idClass`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Costume Batman Deluxe','Costume','Costume di Batman per adulto. <br> Consigliato per Cosplayer <br> Include: Tuta con stampa di muscoli,<br> cintura,<br> mantello,<br> maschera,<br> copristivali e guanti','adulto','XL',5,22,89.99,4,'/CostumeCharacter/images/batmanCostumeDeluxe.jpg','A'),(2,'Costume Iron-Man','Costume','Costume di Iron-Man Avengers per adulto. <br> Include armatura completa realizzata in resina. <br> Per manutenzione leggere il manuale incluso nell\'acquisto.','adulto','One size',2,22,189.9,8,'/CostumeCharacter/images/ironman1.jpg','A'),(3,'Maschera Walter White BB','Maschera','Maschera di Walter Wite dalla serie Tv Netflx Breaking Bad. <br> Maschera originale del protagonista della serie. <br> Prodotta interamente a mano. <br> Materiale: Lattice.','adulto','NULL',1,22,99.99,3,'/CostumeCharacter/images/maskWW.png','B'),(4,'Costume Batman Deluxe','Costume','Costume di Batman per adulto. <br> Consigliato per Cosplayer <br> Include: Tuta con stampa di muscoli,<br> cintura,<br> mantello,<br> maschera,<br> copristivali e guanti ','adulto','L',10,22,89.99,3.9,'/CostumeCharacter/images/batmanCostumeDeluxe.jpg','A'),(5,'Maschera Arlecchino di Commedia dell\'Arte','Maschera','Maschera di commedia dell\\\'arte dello zanni Arlecchino. <br> Prodotta interamente a mano. <br> Materiali: Cuoio.','adulto','NULL',0,22,149.9,1,'/CostumeCharacter/images/arlecchino.jpg','D'),(6,'Costume Biancaneve','Costume','Costume della principessa Disney Biancaneve. <br> Festeggia il carnevale e diventa la principessa della festa. <br> Stupisci i tuoi amichetti.','bambino','3-4 anni',6,22,24.9,1,'/CostumeCharacter/images/biancaneveBambina.jpg','C'),(7,'Maschera Spiderman ','Maschera','Maschera Spiderman per bambino. <br> Festeggia il carnevale e diventa il supereroe più bello di tutti. <br> Stupisci i tuoi amichetti.','bambino','NULL',10,22,14.9,1,'/CostumeCharacter/images/mascheraSpidermanBambino.jpg','A'),(8,'Costume Biancaneve','Costume','Costume della principessa Disney Biancaneve. <br> Festeggia il carnevale e diventa la principessa della festa. <br> Stupisci i tuoi amichetti.','bambino','7-9 anni',5,22,24.9,1,'/CostumeCharacter/images/biancaneveBambina.jpg','C'),(9,'Costume Joker da Il Cavaliere Oscuro','Costume','Costume del villain Joker <br> Film Il Cavaliere Oscuro. <br> Include:  Cappotto e Gilet. <br> Camicia e Pantaloni. <br> Guanti Cravatta e Catena in vita.','adulto','L',3,22,119.9,3,'/CostumeCharacter/images/jokerPreview.jpg','B'),(10,'Costume Joker da Il Cavaliere Oscuro','Costume','Costume del villain Joker <br> Film Il Cavaliere Oscuro. <br> Include:  Cappotto e Gilet. <br> Camicia e Pantaloni. <br> Guanti Cravatta e Catena in vita.','adulto','XL',2,22,129.9,3,'/CostumeCharacter/images/jokerPreview.jpg','B');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `name` varchar(80) NOT NULL,
  `surname` varchar(100) NOT NULL,
  `telephoneNumber` int DEFAULT NULL,
  `e-mail` varchar(100) NOT NULL,
  `billingAddress` varchar(100) DEFAULT NULL,
  `billingCAP` int DEFAULT NULL,
  `billingCity` varchar(80) DEFAULT NULL,
  `billingProvince` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-11 15:17:33
