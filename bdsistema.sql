-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 05-09-2010 a las 16:19:48
-- Versión del servidor: 5.1.41
-- Versión de PHP: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `bdsistema`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE IF NOT EXISTS `categoria` (
  `nombre` varchar(25) NOT NULL,
  `codcateg` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `imagen` text,
  PRIMARY KEY (`codcateg`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcar la base de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`nombre`, `codcateg`, `imagen`) VALUES
('Carrito', 1, ' file:/C:/Users/Richard/Documents/NetBeansProjects/SISTEMA-VENTA/src/ComponenteImagenes/carrito.png ');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `codcliente` varchar(30) NOT NULL,
  `nomdocumento` varchar(8) DEFAULT NULL,
  `numdocumento` varchar(11) DEFAULT NULL,
  `nombre` varchar(40) NOT NULL,
  `telefono` char(18) DEFAULT NULL,
  PRIMARY KEY (`codcliente`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`codcliente`, `nomdocumento`, `numdocumento`, `nombre`, `telefono`) VALUES
('0', 'RUC', '12345678912', 'ORUNA RODRIGUEZ BUDDY RICHARD', '(044)-276-121');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra`
--

CREATE TABLE IF NOT EXISTS `compra` (
  `idcompra` int(11) unsigned NOT NULL,
  `codcliente` varchar(30) DEFAULT NULL,
  `nroEmpleado` int(11) NOT NULL,
  `fechaCompra` datetime DEFAULT NULL,
  `tipocomprobante` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idcompra`),
  KEY `R_13` (`codcliente`),
  KEY `R_16` (`nroEmpleado`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `compra`
--

INSERT INTO `compra` (`idcompra`, `codcliente`, `nroEmpleado`, `fechaCompra`, `tipocomprobante`) VALUES
(1, '0', 1, '2010-08-30 00:00:00', 'BOLETA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_proveedor`
--

CREATE TABLE IF NOT EXISTS `detalle_proveedor` (
  `ruc` char(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `preciocompra` float DEFAULT NULL,
  `precioventa` float DEFAULT NULL,
  `nrofactura` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ruc`,`idProducto`,`nrofactura`),
  KEY `R_10` (`idProducto`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `detalle_proveedor`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE IF NOT EXISTS `empleado` (
  `nroEmpleado` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(25) NOT NULL,
  `apellido` varchar(25) NOT NULL,
  `dni` int(11) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `email` varchar(40) DEFAULT NULL,
  `telefono` char(20) DEFAULT NULL,
  `sexo` char(1) DEFAULT NULL,
  `edad` int(11) DEFAULT NULL,
  `celular` char(20) DEFAULT NULL,
  `imagen` text,
  PRIMARY KEY (`nroEmpleado`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcar la base de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`nroEmpleado`, `nombre`, `apellido`, `dni`, `direccion`, `email`, `telefono`, `sexo`, `edad`, `celular`, `imagen`) VALUES
(1, 'BUDDY RICHARD', 'ORUNA RODRIGUEZ', 47197204, 'Psj Gar. de la Vega #138 - La Esperanza Parte Baja', 'tkcrashr.18@gmail.com', '(44)-276-121', 'M', 19, '(44)-94882-5896', ' file:/C:/Users/Richard/Documents/NetBeansProjects/SISTEMA-VENTA/src/ComponenteImagenes/carritopeq.png ');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE IF NOT EXISTS `producto` (
  `idProducto` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(60) NOT NULL,
  `stock` int(11) NOT NULL,
  `unidadmed` varchar(20) NOT NULL,
  `codcateg` int(11) DEFAULT NULL,
  `preciounidad` float NOT NULL,
  `imagen` text,
  PRIMARY KEY (`idProducto`),
  KEY `R_24` (`codcateg`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Volcar la base de datos para la tabla `producto`
--

INSERT INTO `producto` (`idProducto`, `nombre`, `stock`, `unidadmed`, `codcateg`, `preciounidad`, `imagen`) VALUES
(3, 'AGUA MINERAL', 6, 'Botellas', 1, 1, ' file:/C:/Users/Richard/Documents/NetBeansProjects/SISTEMA-VENTA/src/ComponenteImagenes/Cancel__Red.jpg '),
(4, 'Yogurt', 11, 'Botella', 1, 3.49, ' file:/C:/Users/Richard/Documents/NetBeansProjects/SISTEMA-VENTA/src/ComponenteImagenes/new.jpg ');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE IF NOT EXISTS `proveedor` (
  `ruc` char(11) NOT NULL,
  `razonsocial` varchar(25) NOT NULL,
  `telefono` char(20) NOT NULL,
  `email` varchar(35) DEFAULT NULL,
  `direccion` varchar(50) NOT NULL,
  `tipo` varchar(25) NOT NULL,
  `lugar` varchar(20) DEFAULT NULL,
  `celular` char(20) DEFAULT NULL,
  PRIMARY KEY (`ruc`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`ruc`, `razonsocial`, `telefono`, `email`, `direccion`, `tipo`, `lugar`, `celular`) VALUES
('12345678911', 'COCA KOLA A.S.', '(044)-326-569', 'cocakola@gmail.com', 'Av.Masiche #378', 'Fabricante', 'Porvenir', '(044)-94835-8966');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `transaccion`
--

CREATE TABLE IF NOT EXISTS `transaccion` (
  `idProducto` int(11) NOT NULL,
  `idcompra` int(11) NOT NULL,
  `cantidad` tinyint(4) NOT NULL,
  PRIMARY KEY (`idProducto`,`idcompra`),
  KEY `R_18` (`idcompra`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `transaccion`
--

INSERT INTO `transaccion` (`idProducto`, `idcompra`, `cantidad`) VALUES
(4, 1, 5),
(3, 1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `nroEmpleado` int(11) NOT NULL,
  `id` varchar(18) NOT NULL,
  `password` varchar(18) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `nroEmpleado` (`nroEmpleado`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`nroEmpleado`, `id`, `password`) VALUES
(1, 'ADMINISTRADOR', '12345678');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
