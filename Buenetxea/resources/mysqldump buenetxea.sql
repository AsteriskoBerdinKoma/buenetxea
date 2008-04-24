-- MySQL dump 10.11
--
-- Host: localhost    Database: buenetxea
-- ------------------------------------------------------
-- Server version	5.0.37-community-nt

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente` (
  `dni` int(10) unsigned NOT NULL auto_increment,
  `fecha` datetime NOT NULL,
  `asesor` varchar(45) NOT NULL,
  `medio` varchar(45) NOT NULL,
  `apellido1` varchar(45) NOT NULL,
  `apellido2` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `nacionalidad` varchar(45) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `telefono` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `descripcion`
--

DROP TABLE IF EXISTS `descripcion`;
CREATE TABLE `descripcion` (
  `fk_peritaje_fecha` datetime NOT NULL,
  `tipo` varchar(45) NOT NULL,
  `m2` int(10) unsigned NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY  (`fk_peritaje_fecha`),
  CONSTRAINT `FK_descripcion_1` FOREIGN KEY (`fk_peritaje_fecha`) REFERENCES `peritaje` (`fecha`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `descripcion`
--

LOCK TABLES `descripcion` WRITE;
/*!40000 ALTER TABLE `descripcion` DISABLE KEYS */;
/*!40000 ALTER TABLE `descripcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inmueble`
--

DROP TABLE IF EXISTS `inmueble`;
CREATE TABLE `inmueble` (
  `referencia` int(10) unsigned NOT NULL auto_increment,
  `zona` varchar(100) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `vendido` tinyint(1) NOT NULL,
  PRIMARY KEY  (`referencia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inmueble`
--

LOCK TABLES `inmueble` WRITE;
/*!40000 ALTER TABLE `inmueble` DISABLE KEYS */;
/*!40000 ALTER TABLE `inmueble` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `peritaje`
--

DROP TABLE IF EXISTS `peritaje`;
CREATE TABLE `peritaje` (
  `fecha` datetime NOT NULL COMMENT 'Fecha y hora del peritaje',
  `nombre_perito` varchar(45) NOT NULL COMMENT 'Nombre completo del perito',
  `tipo_inmueble` varchar(45) NOT NULL COMMENT 'Piso, Local, Casa, Parking',
  `tipo_venta` varchar(45) NOT NULL COMMENT 'Verde, Exclusiva',
  `m2_constr` int(10) unsigned NOT NULL,
  `gas` varchar(45) NOT NULL,
  `luminoso` varchar(45) NOT NULL,
  `techos` varchar(45) NOT NULL,
  `exterior` varchar(45) NOT NULL,
  `anos_finca` int(10) unsigned NOT NULL,
  `portero` varchar(45) NOT NULL,
  `ascensor` tinyint(1) NOT NULL,
  `m2_utiles` int(10) unsigned NOT NULL,
  `calefaccion` varchar(45) NOT NULL,
  `pintura` varchar(45) NOT NULL,
  `tipo_suelo` varchar(45) NOT NULL,
  `orientacion` varchar(45) NOT NULL COMMENT 'N, S, E, O, NE, NO, SE, SO',
  `desalojo` tinyint(1) NOT NULL,
  `m2_parcela` int(10) unsigned NOT NULL,
  `puertas` varchar(45) NOT NULL,
  `ventanas` varchar(45) NOT NULL,
  `muebles` varchar(45) NOT NULL,
  `altura_edif` int(10) unsigned NOT NULL COMMENT 'Altura en pisos del edificio',
  `altura_real_piso` int(10) unsigned NOT NULL COMMENT 'Altura del inmueble en el edificio',
  `gastos_comun` double NOT NULL,
  `observaciones` text NOT NULL,
  PRIMARY KEY  (`fecha`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `peritaje`
--

LOCK TABLES `peritaje` WRITE;
/*!40000 ALTER TABLE `peritaje` DISABLE KEYS */;
/*!40000 ALTER TABLE `peritaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `preferencia`
--

DROP TABLE IF EXISTS `preferencia`;
CREATE TABLE `preferencia` (
  `fk_cliente_dni` int(10) unsigned NOT NULL auto_increment,
  `tipo` varchar(45) NOT NULL,
  `desde_metros` int(10) unsigned NOT NULL,
  `hasta_metros` int(10) unsigned NOT NULL,
  `exterior` tinyint(1) NOT NULL,
  `desde_habitacion` int(10) unsigned NOT NULL,
  `hasta_habitacion` int(10) unsigned NOT NULL,
  `zona` varchar(100) NOT NULL,
  `banos` int(10) unsigned NOT NULL,
  `aseos` int(10) unsigned NOT NULL,
  `presupuesto` double NOT NULL,
  `observaciones` text NOT NULL,
  `altura` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`fk_cliente_dni`),
  CONSTRAINT `FK_preferencia_1` FOREIGN KEY (`fk_cliente_dni`) REFERENCES `cliente` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `preferencia`
--

LOCK TABLES `preferencia` WRITE;
/*!40000 ALTER TABLE `preferencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `preferencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `propietario`
--

DROP TABLE IF EXISTS `propietario`;
CREATE TABLE `propietario` (
  `dni` int(10) unsigned NOT NULL auto_increment,
  `apellido1` varchar(45) NOT NULL,
  `apellido2` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `domicilio_postal` varchar(45) NOT NULL,
  `codigo_postal` int(10) unsigned NOT NULL,
  `ciudad` varchar(45) NOT NULL,
  `tel_fijo` int(10) unsigned NOT NULL,
  `tel_movil` int(10) unsigned NOT NULL,
  `horario_fijo` varchar(45) NOT NULL,
  `horario_movil` varchar(45) NOT NULL,
  PRIMARY KEY  (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `propietario`
--

LOCK TABLES `propietario` WRITE;
/*!40000 ALTER TABLE `propietario` DISABLE KEYS */;
/*!40000 ALTER TABLE `propietario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rel_cliente_inmueble`
--

DROP TABLE IF EXISTS `rel_cliente_inmueble`;
CREATE TABLE `rel_cliente_inmueble` (
  `fk_cliente_dni` int(10) unsigned NOT NULL auto_increment,
  `fk_inmueble_referencia` int(10) unsigned NOT NULL,
  `fecha` datetime NOT NULL,
  `precio_venta` double NOT NULL,
  `honorarios` double NOT NULL,
  `iva` double NOT NULL,
  `precio_propietario` double NOT NULL,
  PRIMARY KEY  (`fk_cliente_dni`,`fk_inmueble_referencia`),
  KEY `FK_rel_cliente_inmueble_2` (`fk_inmueble_referencia`),
  CONSTRAINT `FK_rel_cliente_inmueble_1` FOREIGN KEY (`fk_cliente_dni`) REFERENCES `cliente` (`dni`),
  CONSTRAINT `FK_rel_cliente_inmueble_2` FOREIGN KEY (`fk_inmueble_referencia`) REFERENCES `inmueble` (`referencia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabla para las ventas';

--
-- Dumping data for table `rel_cliente_inmueble`
--

LOCK TABLES `rel_cliente_inmueble` WRITE;
/*!40000 ALTER TABLE `rel_cliente_inmueble` DISABLE KEYS */;
/*!40000 ALTER TABLE `rel_cliente_inmueble` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rel_inmueble_propietario`
--

DROP TABLE IF EXISTS `rel_inmueble_propietario`;
CREATE TABLE `rel_inmueble_propietario` (
  `fk_inmueble_referencia` int(10) unsigned NOT NULL auto_increment,
  `fk_propietario_dni` int(10) unsigned NOT NULL,
  `nuevo_precio` varchar(45) NOT NULL,
  `fecha` datetime NOT NULL,
  `observaciones` varchar(100) NOT NULL,
  PRIMARY KEY  (`fk_inmueble_referencia`,`fk_propietario_dni`),
  KEY `FK_rel_inmueble_propietario_2` (`fk_propietario_dni`),
  CONSTRAINT `FK_rel_inmueble_propietario_1` FOREIGN KEY (`fk_inmueble_referencia`) REFERENCES `inmueble` (`referencia`),
  CONSTRAINT `FK_rel_inmueble_propietario_2` FOREIGN KEY (`fk_propietario_dni`) REFERENCES `propietario` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rel_inmueble_propietario`
--

LOCK TABLES `rel_inmueble_propietario` WRITE;
/*!40000 ALTER TABLE `rel_inmueble_propietario` DISABLE KEYS */;
/*!40000 ALTER TABLE `rel_inmueble_propietario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rel_peritaje_inmueble`
--

DROP TABLE IF EXISTS `rel_peritaje_inmueble`;
CREATE TABLE `rel_peritaje_inmueble` (
  `fk_peritaje_fecha` datetime NOT NULL,
  `fk_inmueble_referencia` int(10) unsigned NOT NULL,
  `llaves` tinyint(1) NOT NULL,
  `precio_venta` double NOT NULL,
  `precio_comision` double NOT NULL,
  `iva` double NOT NULL,
  `neto_propietario` double NOT NULL,
  `ideal_venta` double NOT NULL,
  `ideal_opcion_compra` double NOT NULL,
  `ideal_compra` double NOT NULL,
  `cartel` tinyint(1) NOT NULL,
  PRIMARY KEY  (`fk_peritaje_fecha`,`fk_inmueble_referencia`),
  KEY `FK_rel_peritaje_inmueble_2` (`fk_inmueble_referencia`),
  CONSTRAINT `FK_rel_peritaje_inmueble_1` FOREIGN KEY (`fk_peritaje_fecha`) REFERENCES `peritaje` (`fecha`),
  CONSTRAINT `FK_rel_peritaje_inmueble_2` FOREIGN KEY (`fk_inmueble_referencia`) REFERENCES `inmueble` (`referencia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rel_peritaje_inmueble`
--

LOCK TABLES `rel_peritaje_inmueble` WRITE;
/*!40000 ALTER TABLE `rel_peritaje_inmueble` DISABLE KEYS */;
/*!40000 ALTER TABLE `rel_peritaje_inmueble` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rel_visita`
--

DROP TABLE IF EXISTS `rel_visita`;
CREATE TABLE `rel_visita` (
  `fecha` datetime NOT NULL,
  `representante` varchar(45) NOT NULL,
  `precio` double NOT NULL,
  `no_le_gusta_zona` tinyint(1) NOT NULL,
  `quieren_mas_alto` tinyint(1) NOT NULL,
  `muchas_reformas` tinyint(1) NOT NULL,
  `quieren_mas_habit` tinyint(1) NOT NULL,
  `visita_anulada_comprador` tinyint(1) NOT NULL,
  `visita_anulada_propietario` tinyint(1) NOT NULL,
  `oscuro` tinyint(1) NOT NULL,
  `lo_quieren_mas_grande` tinyint(1) NOT NULL,
  `no_tiene_ascensor` tinyint(1) NOT NULL,
  `quieren_mas_banos` tinyint(1) NOT NULL,
  `concertada_2a_visita` tinyint(1) NOT NULL,
  `vendido_en_esta_visita` tinyint(1) NOT NULL,
  `planton` tinyint(1) NOT NULL,
  `le_gusta` tinyint(1) NOT NULL,
  `todo_exterior` tinyint(1) NOT NULL,
  `quieren_balcon_terraza` tinyint(1) NOT NULL,
  `no_gusta_distribucion` tinyint(1) NOT NULL,
  `alquilado_en_esta_visita` tinyint(1) NOT NULL,
  `gestion_venta_otra_agencia` tinyint(1) NOT NULL,
  `podriamos_peritar` tinyint(1) NOT NULL,
  `nombre_trabajador` varchar(45) NOT NULL,
  `categoria_trabajador` varchar(45) NOT NULL,
  `fk_inmueble_referencia` int(10) unsigned NOT NULL,
  `fk_cliente_dni` int(10) unsigned NOT NULL,
  PRIMARY KEY  USING BTREE (`fk_inmueble_referencia`,`fk_cliente_dni`),
  KEY `FK_rel_visita_2` (`fk_cliente_dni`),
  CONSTRAINT `FK_rel_visita_2` FOREIGN KEY (`fk_cliente_dni`) REFERENCES `cliente` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rel_visita`
--

LOCK TABLES `rel_visita` WRITE;
/*!40000 ALTER TABLE `rel_visita` DISABLE KEYS */;
/*!40000 ALTER TABLE `rel_visita` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2008-04-24 18:56:36
