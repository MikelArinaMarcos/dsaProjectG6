-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.10.2-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para test
CREATE DATABASE IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci */;
USE `test`;

-- Volcando estructura para tabla test.objeto
CREATE TABLE IF NOT EXISTS `objeto` (
  `idObjeto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(250) DEFAULT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  `precio` int(11) DEFAULT NULL,
  PRIMARY KEY (`idObjeto`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Volcando datos para la tabla test.objeto: ~2 rows (aproximadamente)
DELETE FROM `objeto`;
/*!40000 ALTER TABLE `objeto` DISABLE KEYS */;
INSERT INTO `objeto` (`idObjeto`, `nombre`, `descripcion`, `precio`) VALUES
	(1, 'Calculadora', 'Calcula cosas', 191919),
	(2, 'HaboCredito v2', 'Vacio', 1);
/*!40000 ALTER TABLE `objeto` ENABLE KEYS */;

-- Volcando estructura para tabla test.relacionou
CREATE TABLE IF NOT EXISTS `relacionou` (
  `idObjeto` int(11) DEFAULT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  KEY `FK__objeto` (`idObjeto`),
  KEY `FK__usuario` (`idUsuario`),
  CONSTRAINT `FK__objeto` FOREIGN KEY (`idObjeto`) REFERENCES `objeto` (`idObjeto`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `FK__usuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Volcando datos para la tabla test.relacionou: ~1 rows (aproximadamente)
DELETE FROM `relacionou`;
/*!40000 ALTER TABLE `relacionou` DISABLE KEYS */;
INSERT INTO `relacionou` (`idObjeto`, `idUsuario`) VALUES
	(2, 5);
/*!40000 ALTER TABLE `relacionou` ENABLE KEYS */;

-- Volcando estructura para tabla test.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `xp` int(11) NOT NULL DEFAULT 0,
  `username` varchar(50) DEFAULT NULL,
  `mail` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `lastName` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `dinero` int(11) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Volcando datos para la tabla test.usuario: ~2 rows (aproximadamente)
DELETE FROM `usuario`;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`idUsuario`, `xp`, `username`, `mail`, `name`, `lastName`, `password`, `dinero`) VALUES
	(5, 0, 'Alfredo', 'alfredo', 'asdasd', 'asdasd', 'asdasd', 99999),
	(6, 0, 'Retrovisor', 'asdasf', 'asfasgf', 'asfasgf', 'asgadsg', 100);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
