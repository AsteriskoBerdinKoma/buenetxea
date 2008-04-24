-- phpMyAdmin SQL Dump
-- version 2.10.2
-- http://www.phpmyadmin.net
-- 
-- Servidor: localhost
-- Tiempo de generación: 24-04-2008 a las 20:49:30
-- Versión del servidor: 5.0.37
-- Versión de PHP: 5.2.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

-- 
-- Base de datos: `buenetxea`
-- 

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `cliente`
-- 

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- 
-- Volcar la base de datos para la tabla `cliente`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `descripcion`
-- 

DROP TABLE IF EXISTS `descripcion`;
CREATE TABLE IF NOT EXISTS `descripcion` (
  `fk_peritaje_fecha` datetime NOT NULL,
  `tipo` varchar(45) NOT NULL,
  `m2` int(10) unsigned NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY  (`fk_peritaje_fecha`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 
-- Volcar la base de datos para la tabla `descripcion`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `inmueble`
-- 

DROP TABLE IF EXISTS `inmueble`;
CREATE TABLE IF NOT EXISTS `inmueble` (
  `referencia` int(10) unsigned NOT NULL auto_increment,
  `zona` varchar(100) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `vendido` tinyint(1) NOT NULL,
  PRIMARY KEY  (`referencia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- 
-- Volcar la base de datos para la tabla `inmueble`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `peritaje`
-- 

DROP TABLE IF EXISTS `peritaje`;
CREATE TABLE IF NOT EXISTS `peritaje` (
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
-- Volcar la base de datos para la tabla `peritaje`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `preferencia`
-- 

DROP TABLE IF EXISTS `preferencia`;
CREATE TABLE IF NOT EXISTS `preferencia` (
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
  PRIMARY KEY  (`fk_cliente_dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- 
-- Volcar la base de datos para la tabla `preferencia`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `propietario`
-- 

DROP TABLE IF EXISTS `propietario`;
CREATE TABLE IF NOT EXISTS `propietario` (
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- 
-- Volcar la base de datos para la tabla `propietario`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `rel_cliente_inmueble`
-- 

DROP TABLE IF EXISTS `rel_cliente_inmueble`;
CREATE TABLE IF NOT EXISTS `rel_cliente_inmueble` (
  `fk_cliente_dni` int(10) unsigned NOT NULL auto_increment,
  `fk_inmueble_referencia` int(10) unsigned NOT NULL,
  `fecha` datetime NOT NULL,
  `precio_venta` double NOT NULL,
  `honorarios` double NOT NULL,
  `iva` double NOT NULL,
  `precio_propietario` double NOT NULL,
  PRIMARY KEY  (`fk_cliente_dni`,`fk_inmueble_referencia`),
  KEY `FK_rel_cliente_inmueble_2` (`fk_inmueble_referencia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabla para las ventas' AUTO_INCREMENT=1 ;

-- 
-- Volcar la base de datos para la tabla `rel_cliente_inmueble`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `rel_inmueble_propietario`
-- 

DROP TABLE IF EXISTS `rel_inmueble_propietario`;
CREATE TABLE IF NOT EXISTS `rel_inmueble_propietario` (
  `fk_inmueble_referencia` int(10) unsigned NOT NULL auto_increment,
  `fk_propietario_dni` int(10) unsigned NOT NULL,
  `nuevo_precio` varchar(45) NOT NULL,
  `fecha` datetime NOT NULL,
  `observaciones` varchar(100) NOT NULL,
  PRIMARY KEY  (`fk_inmueble_referencia`,`fk_propietario_dni`),
  KEY `FK_rel_inmueble_propietario_2` (`fk_propietario_dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- 
-- Volcar la base de datos para la tabla `rel_inmueble_propietario`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `rel_peritaje_inmueble`
-- 

DROP TABLE IF EXISTS `rel_peritaje_inmueble`;
CREATE TABLE IF NOT EXISTS `rel_peritaje_inmueble` (
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
  KEY `FK_rel_peritaje_inmueble_2` (`fk_inmueble_referencia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 
-- Volcar la base de datos para la tabla `rel_peritaje_inmueble`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `rel_visita`
-- 

DROP TABLE IF EXISTS `rel_visita`;
CREATE TABLE IF NOT EXISTS `rel_visita` (
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
  KEY `FK_rel_visita_2` (`fk_cliente_dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 
-- Volcar la base de datos para la tabla `rel_visita`
-- 


-- 
-- Filtros para las tablas descargadas (dump)
-- 

-- 
-- Filtros para la tabla `descripcion`
-- 
ALTER TABLE `descripcion`
  ADD CONSTRAINT `FK_descripcion_1` FOREIGN KEY (`fk_peritaje_fecha`) REFERENCES `peritaje` (`fecha`);

-- 
-- Filtros para la tabla `preferencia`
-- 
ALTER TABLE `preferencia`
  ADD CONSTRAINT `FK_preferencia_1` FOREIGN KEY (`fk_cliente_dni`) REFERENCES `cliente` (`dni`);

-- 
-- Filtros para la tabla `rel_cliente_inmueble`
-- 
ALTER TABLE `rel_cliente_inmueble`
  ADD CONSTRAINT `FK_rel_cliente_inmueble_1` FOREIGN KEY (`fk_cliente_dni`) REFERENCES `cliente` (`dni`),
  ADD CONSTRAINT `FK_rel_cliente_inmueble_2` FOREIGN KEY (`fk_inmueble_referencia`) REFERENCES `inmueble` (`referencia`);

-- 
-- Filtros para la tabla `rel_inmueble_propietario`
-- 
ALTER TABLE `rel_inmueble_propietario`
  ADD CONSTRAINT `FK_rel_inmueble_propietario_1` FOREIGN KEY (`fk_inmueble_referencia`) REFERENCES `inmueble` (`referencia`),
  ADD CONSTRAINT `FK_rel_inmueble_propietario_2` FOREIGN KEY (`fk_propietario_dni`) REFERENCES `propietario` (`dni`);

-- 
-- Filtros para la tabla `rel_peritaje_inmueble`
-- 
ALTER TABLE `rel_peritaje_inmueble`
  ADD CONSTRAINT `FK_rel_peritaje_inmueble_1` FOREIGN KEY (`fk_peritaje_fecha`) REFERENCES `peritaje` (`fecha`),
  ADD CONSTRAINT `FK_rel_peritaje_inmueble_2` FOREIGN KEY (`fk_inmueble_referencia`) REFERENCES `inmueble` (`referencia`);

-- 
-- Filtros para la tabla `rel_visita`
-- 
ALTER TABLE `rel_visita`
  ADD CONSTRAINT `FK_rel_visita_2` FOREIGN KEY (`fk_cliente_dni`) REFERENCES `cliente` (`dni`);
