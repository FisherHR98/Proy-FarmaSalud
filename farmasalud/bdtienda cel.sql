-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-12-2021 a las 04:36:31
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bdtienda`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_ADIDETA` (`NFAC` CHAR(5), `CODP` CHAR(5), `CANT` INT, `EST` INT)  BEGIN
INSERT INTO DETALLE_RECIBO(num_fac, cod_pro, cant_pro, estado)
VALUES(NFAC, CODP, CANT, EST);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_ADIFACT` (IN `FV` DATE, IN `IGV` CHAR(1), IN `CODV` CHAR(5), IN `CODC` CHAR(5), IN `EST` INT, IN `TP` CHAR(10))  BEGIN
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

CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_ADIREC` (IN `FV` DATE, IN `IGV` CHAR(1), IN `CODV` CHAR(5), IN `CODC` CHAR(5), IN `EST` INT, IN `TP` CHAR(10))  BEGIN
DECLARE CUENTA INT;
DECLARE NROF CHAR(5);

SELECT COALESCE(MAX(NUM_FAC),0)+1 INTO CUENTA FROM FACTURAC;
SET NROF=LPAD(CUENTA,5, '0');

INSERT INTO facturac(num_fac, fecha_fac, igv_rec, cod_ven, estado,cod_cli, tipo, guia_remi) VALUES (NROF, FV, IGV,CODV,EST,CODC,TP,null);

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_RegistroVentas` (`AN` INT)  BEGIN
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

CREATE TABLE `cliente` (
  `cod_cli` varchar(5) NOT NULL DEFAULT '',
  `nom_cli` varchar(30) NOT NULL,
  `dni` varchar(8) DEFAULT NULL,
  `cod_dis` varchar(5) DEFAULT NULL,
  `telefono` int(9) DEFAULT NULL,
  `estado` int(1) NOT NULL,
  `ruc` varchar(11) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`cod_cli`, `nom_cli`, `dni`, `cod_dis`, `telefono`, `estado`, `ruc`, `direccion`) VALUES
('C0001', 'Jorge Salazar', '71775665', 'D0003', 2147483647, 1, NULL, 'Jr. chota 1453'),
('C0002', 'Jose Solorzano SAC', NULL, 'D0004', 945676301, 1, '12365897456', 'Jr cuscano 456'),
('C0003', 'PEPSIP SAC', NULL, 'D0005', 945585963, 1, '12000589631', 'Av labarthe 2114'),
('C0004', 'Juan Rodrigues Sosa', '45236985', 'D0002', 945585963, 1, NULL, 'Av labarthe 2114'),
('C0005', 'fffgh', '22222222', 'D0006', 4444444, 0, '', 'fdghghgh'),
('C0006', 'Armando Salazar', '51236921', 'D0001', 95685231, 1, '', 'Av los aire 223'),
('C0007', 'Juan', '78996566', 'D0005', 456632, 1, '', 'av. no se');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_recibo`
--

CREATE TABLE `detalle_recibo` (
  `num_fac` varchar(5) NOT NULL,
  `cod_pro` varchar(5) NOT NULL,
  `cant_pro` int(11) NOT NULL,
  `estado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `detalle_recibo`
--

INSERT INTO `detalle_recibo` (`num_fac`, `cod_pro`, `cant_pro`, `estado`) VALUES
('00003', 'PR003', 1, 1),
('00003', 'PR004', 4, 1),
('00003', 'PR005', 1, 1),
('00004', 'PR002', 1, 1),
('00004', 'PR004', 4, 1),
('00001', 'PR001', 5, 1),
('00001', 'PR002', 4, 1),
('00002', 'PR002', 4, 1),
('00003', 'PR003', 3, 1),
('00004', 'PR004', 4, 1),
('00005', 'PR005', 4, 1),
('00006', 'PR006', 5, 1),
('00007', 'PR006', 3, 1),
('00001', 'PR002', 2, 1),
('00002', 'PR003', 1, 1),
('00004', 'PR003', 1, 1),
('00006', 'PR003', 2, 1),
('00011', 'PR001', 2, 1),
('00007', 'PR001', 1, 1),
('00005', 'PR002', 2, 1),
('00002', 'PR002', 3, 1),
('00013', 'PR003', 2, 1),
('00011', 'PR003', 3, 1),
('00012', 'PR004', 2, 1),
('00014', 'PR004', 6, 1),
('00006', 'PR005', 5, 1),
('00022', 'PR005', 4, 1),
('00023', 'PR006', 3, 1),
('00008', 'PR006', 4, 1),
('00022', 'PR006', 5, 1),
('00021', 'PR003', 3, 1),
('00014', 'PR004', 6, 1),
('00006', 'PR005', 5, 1),
('00022', 'PR005', 4, 1),
('00009', 'PR006', 3, 1),
('00010', 'PR006', 4, 1),
('00022', 'PR006', 5, 1),
('00021', 'PR003', 3, 1),
('00014', 'PR004', 6, 1),
('00013', 'PR005', 5, 1),
('00020', 'PR005', 4, 1),
('00019', 'PR006', 3, 1),
('00018', 'PR006', 4, 1),
('00017', 'PR006', 5, 1),
('00016', 'PR003', 3, 1),
('00015', 'PR002', 1, 1),
('00027', 'PR003', 4, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `distrito`
--

CREATE TABLE `distrito` (
  `cod_dis` varchar(8) NOT NULL,
  `nom_dis` varchar(30) NOT NULL,
  `estado` varchar(1) NOT NULL
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

CREATE TABLE `empleado` (
  `cod_ven` varchar(5) NOT NULL,
  `nom_ven` varchar(30) NOT NULL,
  `ape_ven` varchar(30) NOT NULL,
  `usuario` varchar(8) NOT NULL,
  `contraseña` varchar(8) NOT NULL,
  `cargo` varchar(15) NOT NULL,
  `estado` varchar(2) NOT NULL
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

CREATE TABLE `facturac` (
  `num_fac` varchar(5) NOT NULL,
  `fecha_fac` date NOT NULL,
  `igv_rec` varchar(1) NOT NULL,
  `cod_ven` varchar(5) NOT NULL,
  `estado` varchar(1) NOT NULL,
  `cod_cli` varchar(5) NOT NULL,
  `tipo` varchar(10) NOT NULL,
  `guia_remi` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `facturac`
--

INSERT INTO `facturac` (`num_fac`, `fecha_fac`, `igv_rec`, `cod_ven`, `estado`, `cod_cli`, `tipo`, `guia_remi`) VALUES
('00001', '2017-11-12', 'S', 'E0001', '1', 'C0002', 'BOLETA', NULL),
('00002', '2017-11-15', 'S', 'E0002', '1', 'C0001', 'Factura', 'GR-0000001'),
('00003', '2017-11-16', 'S', 'E0005', '1', 'C0002', 'Factura', 'GR-0000002'),
('00004', '2017-12-17', 'S', 'E0003', '1', 'C0003', 'Boleta', NULL),
('00005', '2018-01-11', 'S', 'E0001', '1', 'C0003', 'Boleta', NULL),
('00006', '2018-02-12', 'S', 'E0002', '1', 'C0004', 'Factura', 'GR-0000003'),
('00007', '2018-02-27', 'S', 'E0004', '1', 'C0005', 'Factura', 'GR-0000004'),
('00008', '2018-03-21', 'S', 'E0005', '1', 'C0005', 'Boleta', NULL),
('00009', '2018-05-12', 'S', 'E0006', '1', 'C0005', 'Factura', 'GR-0000005'),
('00010', '2018-05-11', 'S', 'E0006', '1', 'C0006', 'Factura', 'GR-0000006'),
('00011', '2018-08-21', 'S', 'E0006', '1', 'C0001', 'Boleta', NULL),
('00012', '2018-11-09', 'S', 'E0002', '1', 'C0003', 'Factura', 'GR-0000007'),
('00013', '2019-01-06', 'S', 'E0002', '1', 'C0003', 'Factura', 'GR-0000008'),
('00014', '2019-02-03', 'S', 'E0003', '1', 'C0002', 'Factura', 'GR-0000009'),
('00015', '2019-02-10', 'S', 'E0004', '1', 'C0001', 'Boleta', NULL),
('00016', '2019-02-11', 'S', 'E0005', '1', 'C0002', 'Factura', 'GR-0000010'),
('00017', '2019-11-12', 'S', 'E0001', '1', 'C0002', 'Boleta', NULL),
('00018', '2020-01-09', 'S', 'E0005', '1', 'C0001', 'Factura', 'GR-0000011'),
('00019', '2020-05-09', 'S', 'E0001', '1', 'C0004', 'Boleta', NULL),
('00020', '2020-06-09', 'S', 'E0002', '1', 'C0001', 'Factura', 'GR-0000012'),
('00021', '2020-06-09', 'S', 'E0003', '1', 'C0003', 'Factura', 'GR-0000013'),
('00022', '2021-08-09', 'S', 'E0002', '1', 'C0003', 'Boleta', NULL),
('00023', '2021-09-09', 'S', 'E0003', '1', 'C0002', 'Factura', 'GR-0000014'),
('00024', '2021-10-09', 'S', 'E0005', '1', 'C0004', 'Factura', 'GR-0000014'),
('00025', '2021-11-09', 'S', 'E0004', '1', 'C0001', 'Boleta', NULL),
('00026', '2021-12-29', 'S', 'E0005', '1', 'C0005', 'Boleta', NULL),
('00027', '2021-11-30', 'S', 'E0001', '1', 'C0004', 'Boleta', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `marca`
--

CREATE TABLE `marca` (
  `cod_marca` varchar(5) NOT NULL,
  `nom_marca` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `marca`
--

INSERT INTO `marca` (`cod_marca`, `nom_marca`) VALUES
('MK001', 'HUAWEY'),
('MK002', 'SAMSUNG'),
('MK003', 'XIAOMI'),
('MK004', 'MOTOROLA'),
('MK005', 'APPLE'),
('MK006', 'GENERICO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `cod_pro` varchar(5) NOT NULL,
  `des_pro` varchar(100) NOT NULL,
  `precio` double NOT NULL,
  `cod_marca` varchar(5) NOT NULL,
  `estado` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`cod_pro`, `des_pro`, `precio`, `cod_marca`, `estado`) VALUES
('PR001', 'SMARTPHONE HUAWEI Y7 PRO', 756.2, 'MK001', '1'),
('PR002', 'Samsung Galaxy Note 21 Ultra', 1500, 'MK002', '1'),
('PR003', 'AUDIFONOS GL125', 25, 'MK002', '1'),
('PR004', 'Xiaomi Mi 10T Pro', 25, 'MK003', '1'),
('PR005', 'Poco X3 Pro', 1300, 'MK003', '1'),
('PR006', 'CARGADOR 2000A', 46, 'MK006', '1');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`cod_cli`);

--
-- Indices de la tabla `distrito`
--
ALTER TABLE `distrito`
  ADD PRIMARY KEY (`cod_dis`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`cod_ven`);

--
-- Indices de la tabla `facturac`
--
ALTER TABLE `facturac`
  ADD PRIMARY KEY (`num_fac`);

--
-- Indices de la tabla `marca`
--
ALTER TABLE `marca`
  ADD PRIMARY KEY (`cod_marca`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`cod_pro`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
