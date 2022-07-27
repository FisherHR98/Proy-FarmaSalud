-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-07-2022 a las 02:25:28
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bdfarmacia`
--
CREATE DATABASE IF NOT EXISTS `bdfarmacia` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `bdfarmacia`;

DELIMITER $$
--
-- Procedimientos
--
DROP PROCEDURE IF EXISTS `SP_ADIDETA`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_ADIDETA` (`NFAC` CHAR(5), `CODP` CHAR(5), `CANT` INT, `EST` INT)   BEGIN
INSERT INTO DETALLE_RECIBO(num_fac, cod_pro, cant_pro, estado)
VALUES(NFAC, CODP, CANT, EST);
END$$

DROP PROCEDURE IF EXISTS `SP_ADIFACT`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_ADIFACT` (IN `FV` DATE, IN `IGV` CHAR(1), IN `CODV` CHAR(5), IN `CODC` CHAR(5), IN `EST` INT, IN `TP` CHAR(10))   BEGIN
DECLARE CUENTA INT;
DECLARE NROF CHAR(5);

DECLARE CUENTAG INT;
DECLARE GUIA CHAR(10);

SELECT COALESCE(MAX(NUM_FAC),0)+1 INTO CUENTA FROM FACTURAC;
SET NROF=LPAD(CUENTA,5, '0');

SELECT RIGHT(COALESCE(MAX(GUIA_REMI),0),7)+1 INTO CUENTAG FROM FACTURAC;
SET GUIA=CONCAT("GR-",LPAD(CUENTAG,7, '0'));

INSERT INTO facturac(num_fac, fecha_fac, igv_rec, cod_ven, estado,cod_cli, tipo, guia_remi) VALUES (NROF, FV, IGV,CODV,EST,CODC,TP,GUIA);

END$$

DROP PROCEDURE IF EXISTS `SP_ADIREC`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_ADIREC` (IN `FV` DATE, IN `IGV` CHAR(1), IN `CODV` CHAR(5), IN `CODC` CHAR(5), IN `EST` INT, IN `TP` CHAR(10))   BEGIN
DECLARE CUENTA INT;
DECLARE NROF CHAR(5);

SELECT COALESCE(MAX(NUM_FAC),0)+1 INTO CUENTA FROM FACTURAC;
SET NROF=LPAD(CUENTA,5, '0');

INSERT INTO facturac(num_fac, fecha_fac, igv_rec, cod_ven, estado,cod_cli, tipo, guia_remi) VALUES (NROF, FV, IGV,CODV,EST,CODC,TP,null);

END$$

DROP PROCEDURE IF EXISTS `SP_RegistroVentas`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_RegistroVentas` (`AN` INT)   BEGIN
Select year(fecha_fac), e.cod_ven, nom_ven,SUM(d.cant_pro*p.precio) ventas
from empleado e join facturac f on(e.cod_ven=f.cod_ven) 
join detalle_recibo d on (d.num_fac=f.num_fac) 
join producto p on(p.cod_pro=d.cod_pro)
where YEAR(fecha_fac)=AN
GROUP by e.cod_ven;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `cod_cli` varchar(5) NOT NULL DEFAULT '',
  `nom_cli` varchar(30) NOT NULL,
  `dni` varchar(8) DEFAULT NULL,
  `cod_dis` varchar(5) DEFAULT NULL,
  `telefono` int(9) DEFAULT NULL,
  `estado` int(1) NOT NULL,
  `ruc` varchar(11) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`cod_cli`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`cod_cli`, `nom_cli`, `dni`, `cod_dis`, `telefono`, `estado`, `ruc`, `direccion`) VALUES
('C0000', 'Anonimo', '0', NULL, NULL, 1, NULL, NULL),
('C0001', 'Jorge Salazar', '71775665', 'D0003', 2147483647, 1, NULL, 'Jr. chota 1453'),
('C0002', 'Jose Solorzano SAC', NULL, 'D0004', 945676301, 1, '12365897456', 'Jr cuscano 456'),
('C0003', 'PEPSIP SAC', NULL, 'D0005', 945585963, 1, '12000589631', 'Av labarthe 2114'),
('C0004', 'Juan Rodrigues Sosa', '45236985', 'D0002', 945585963, 1, NULL, 'Av labarthe 2114'),
('C0005', 'fffgh', '22222222', 'D0006', 4444444, 1, '', 'fdghghgh'),
('C0006', 'Armando Salazar', '51236921', 'D0001', 95685231, 1, '', 'Av los aire 223'),
('C0007', 'Juan', '78996566', 'D0005', 456632, 0, '', 'av. no se'),
('C0009', 'Alfonso', '34567890', 'D0007', 999999997, 0, '', 'av 124'),
('C0010', 'dfdf', '12334456', 'D0005', 5234234, 1, '', 'dsfsdf');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_recibo`
--

DROP TABLE IF EXISTS `detalle_recibo`;
CREATE TABLE IF NOT EXISTS `detalle_recibo` (
  `num_fac` varchar(5) NOT NULL,
  `cod_pro` varchar(5) NOT NULL,
  `cant_pro` int(11) NOT NULL,
  `estado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `detalle_recibo`
--

INSERT INTO `detalle_recibo` (`num_fac`, `cod_pro`, `cant_pro`, `estado`) VALUES
('00001', 'PR002', 5, 1),
('00001', 'PR003', 4, 1),
('00001', 'PR001', 4, 1),
('00002', 'PR003', 4, 1),
('00002', 'PR002', 3, 1),
('00002', 'PR004', 1, 1),
('00003', 'PR004', 3, 1),
('00003', 'PR003', 10, 1),
('00004', 'PR003', 2, 1),
('00004', 'PR001', 3, 1),
('00005', 'PR002', 1, 1),
('00005', 'PR003', 1, 1),
('00006', 'PR003', 2, 1),
('00006', 'PR001', 2, 1),
('00007', 'PR003', 2, 1),
('00008', 'PR002', 1, 1),
('00008', 'PR001', 2, 1),
('00009', 'PR003', 2, 1),
('00009', 'PR001', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `distrito`
--

DROP TABLE IF EXISTS `distrito`;
CREATE TABLE IF NOT EXISTS `distrito` (
  `cod_dis` varchar(8) NOT NULL,
  `nom_dis` varchar(30) NOT NULL,
  `estado` varchar(1) NOT NULL,
  PRIMARY KEY (`cod_dis`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `distrito`
--

INSERT INTO `distrito` (`cod_dis`, `nom_dis`, `estado`) VALUES
('D0001', 'San Luis', '1'),
('D0002', 'La Victoria', '1'),
('D0003', 'Barranco', '1'),
('D0004', 'Breña', '1'),
('D0005', 'Carabayllo', '1'),
('D0006', 'Cieneguilla', '1'),
('D0007', 'Independecia', '1'),
('D0008', 'Jesús María', '1'),
('D0009', 'Miraflores', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

DROP TABLE IF EXISTS `empleado`;
CREATE TABLE IF NOT EXISTS `empleado` (
  `cod_ven` varchar(5) NOT NULL,
  `nom_ven` varchar(30) NOT NULL,
  `ape_ven` varchar(30) NOT NULL,
  `usuario` varchar(8) NOT NULL,
  `contraseña` varchar(8) NOT NULL,
  `cargo` varchar(15) NOT NULL,
  `estado` varchar(2) NOT NULL,
  PRIMARY KEY (`cod_ven`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`cod_ven`, `nom_ven`, `ape_ven`, `usuario`, `contraseña`, `cargo`, `estado`) VALUES
('E0001', 'jose', 'luis', 'j15', 'j15', 'Gerente', '1'),
('E0002', 'Juan', 'Perez', 'asdf', 'jkl', 'Cajera', '0'),
('E0003', 'asdsad', 'adas', 'dfdf', 'dfdf', 'Secretaria', '0'),
('E0004', 'Brandon3333', 'Sierra', 'brand124', 'brand124', 'Cajera', '1'),
('E0005', 'luis', 'chavez', 'luis14', 'luis24', 'Secretaria', '0'),
('E0006', 'Bety', 'Salazar', 'BT056', 'bt056', 'Secretaria', '0'),
('E0007', 'Juana', 'Gomez', 'JG222', 'jg555', 'Secretaria', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facturac`
--

DROP TABLE IF EXISTS `facturac`;
CREATE TABLE IF NOT EXISTS `facturac` (
  `num_fac` varchar(5) NOT NULL,
  `fecha_fac` date NOT NULL,
  `igv_rec` varchar(1) NOT NULL,
  `cod_ven` varchar(5) NOT NULL,
  `estado` varchar(1) NOT NULL,
  `cod_cli` varchar(5) NOT NULL,
  `tipo` varchar(10) NOT NULL,
  `guia_remi` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`num_fac`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `facturac`
--

INSERT INTO `facturac` (`num_fac`, `fecha_fac`, `igv_rec`, `cod_ven`, `estado`, `cod_cli`, `tipo`, `guia_remi`) VALUES
('00001', '2022-07-25', 'N', 'E0001', '1', 'C0004', 'Boleta', NULL),
('00002', '2022-07-25', 'S', 'E0001', '1', 'C0004', 'Boleta', NULL),
('00003', '2022-07-25', 'S', 'E0001', '1', 'C0000', 'Anonimo', NULL),
('00004', '2022-07-25', 'S', 'E0001', '1', 'C0000', 'Anonimo', NULL),
('00005', '2022-07-25', 'S', 'E0004', '1', 'C0000', 'Anonimo', NULL),
('00006', '2022-07-25', 'S', 'E0001', '1', 'C0000', 'Anonimo', NULL),
('00007', '2022-07-25', 'S', 'E0001', '1', 'C0000', 'Anonimo', NULL),
('00008', '2022-07-26', 'S', 'E0001', '1', 'C0000', 'Anonimo', NULL),
('00009', '2022-07-26', 'S', 'E0001', '1', 'C0000', 'Anonimo', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `marca`
--

DROP TABLE IF EXISTS `marca`;
CREATE TABLE IF NOT EXISTS `marca` (
  `cod_marca` varchar(5) NOT NULL,
  `nom_marca` varchar(40) NOT NULL,
  PRIMARY KEY (`cod_marca`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `marca`
--

INSERT INTO `marca` (`cod_marca`, `nom_marca`) VALUES
('1', 'Farmindustria'),
('2', 'Medifarma'),
('3', 'Quilab'),
('4', 'Genfar');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

DROP TABLE IF EXISTS `producto`;
CREATE TABLE IF NOT EXISTS `producto` (
  `cod_pro` varchar(5) NOT NULL,
  `des_pro` varchar(100) NOT NULL,
  `precio` double NOT NULL,
  `stock` int(11) NOT NULL,
  `cod_marca` varchar(5) NOT NULL,
  `estado` varchar(1) NOT NULL,
  PRIMARY KEY (`cod_pro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`cod_pro`, `des_pro`, `precio`, `stock`, `cod_marca`, `estado`) VALUES
('PR001', 'Diclofenaco 50mg tableta ', 0.5, 2, '4', '1'),
('PR002', 'HIPOGLOS UNGUENTO 35G', 22.5, 1, '3', '1'),
('PR003', 'PARACETAMOL 500G TABLETA x10', 1, 33, '2', '1'),
('PR004', 'BETAMETASONA 0.05% CREMA 20g', 9.8, 1, '1', '1');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
