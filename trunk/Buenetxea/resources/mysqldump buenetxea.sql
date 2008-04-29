CREATE DATABASE `dbbuenetxea` /*!40100 DEFAULT CHARACTER SET latin1 */;

DROP TABLE IF EXISTS `dbbuenetxea`.`cliente`;
CREATE TABLE  `dbbuenetxea`.`cliente` (
  `dni` varchar(9) NOT NULL,
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

DROP TABLE IF EXISTS `dbbuenetxea`.`descripcion`;
CREATE TABLE  `dbbuenetxea`.`descripcion` (
  `fk_peritaje_fecha` datetime NOT NULL,
  `tipo` varchar(45) NOT NULL,
  `m2` int(10) unsigned NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY  (`fk_peritaje_fecha`),
  CONSTRAINT `FK_descripcion_1` FOREIGN KEY (`fk_peritaje_fecha`) REFERENCES `peritaje` (`fecha`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `dbbuenetxea`.`inmueble`;
CREATE TABLE  `dbbuenetxea`.`inmueble` (
  `referencia` int(10) unsigned NOT NULL auto_increment,
  `zona` varchar(100) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `vendido` tinyint(1) NOT NULL,
  PRIMARY KEY  (`referencia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `dbbuenetxea`.`peritaje`;
CREATE TABLE  `dbbuenetxea`.`peritaje` (
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

DROP TABLE IF EXISTS `dbbuenetxea`.`preferencia`;
CREATE TABLE  `dbbuenetxea`.`preferencia` (
  `fk_cliente_dni` varchar(9) NOT NULL,
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

DROP TABLE IF EXISTS `dbbuenetxea`.`propietario`;
CREATE TABLE  `dbbuenetxea`.`propietario` (
  `dni` varchar(9) NOT NULL,
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

DROP TABLE IF EXISTS `dbbuenetxea`.`rel_cliente_inmueble`;
CREATE TABLE  `dbbuenetxea`.`rel_cliente_inmueble` (
  `fk_cliente_dni` varchar(9) NOT NULL,
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

DROP TABLE IF EXISTS `dbbuenetxea`.`rel_inmueble_propietario`;
CREATE TABLE  `dbbuenetxea`.`rel_inmueble_propietario` (
  `fk_inmueble_referencia` int(10) unsigned NOT NULL auto_increment,
  `fk_propietario_dni` varchar(9) NOT NULL,
  `nuevo_precio` varchar(45) NOT NULL,
  `fecha` datetime NOT NULL,
  `observaciones` varchar(100) NOT NULL,
  PRIMARY KEY  (`fk_inmueble_referencia`,`fk_propietario_dni`),
  KEY `FK_rel_inmueble_propietario_2` (`fk_propietario_dni`),
  CONSTRAINT `FK_rel_inmueble_propietario_1` FOREIGN KEY (`fk_inmueble_referencia`) REFERENCES `inmueble` (`referencia`),
  CONSTRAINT `FK_rel_inmueble_propietario_2` FOREIGN KEY (`fk_propietario_dni`) REFERENCES `propietario` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `dbbuenetxea`.`rel_peritaje_inmueble`;
CREATE TABLE  `dbbuenetxea`.`rel_peritaje_inmueble` (
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

DROP TABLE IF EXISTS `dbbuenetxea`.`rel_visita`;
CREATE TABLE  `dbbuenetxea`.`rel_visita` (
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
  `fk_cliente_dni` varchar(9) NOT NULL,
  PRIMARY KEY  USING BTREE (`fk_inmueble_referencia`,`fk_cliente_dni`),
  KEY `FK_rel_visita_2` (`fk_cliente_dni`),
  CONSTRAINT `FK_rel_visita_2` FOREIGN KEY (`fk_cliente_dni`) REFERENCES `cliente` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
