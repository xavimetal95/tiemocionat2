-- phpMyAdmin SQL Dump
-- version 3.4.11.1deb2+deb7u1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 18-06-2016 a las 18:11:32
-- Versión del servidor: 5.5.47
-- Versión de PHP: 5.4.45-0+deb7u2

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `ticemocionat2_mydb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE IF NOT EXISTS `categoria` (
  `idcategoria` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(25) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idcategoria`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`idcategoria`, `Nombre`) VALUES
(1, 'juego'),
(2, 'libro');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_emociones_juegos`
--

CREATE TABLE IF NOT EXISTS `detalle_emociones_juegos` (
  `iddetalle_emociones_juegos` int(11) NOT NULL AUTO_INCREMENT,
  `emociones_idemociones` int(11) NOT NULL,
  `juegos_idjuegos` int(11) NOT NULL,
  PRIMARY KEY (`iddetalle_emociones_juegos`),
  KEY `fk_detalle_emociones_juegos_emociones1_idx` (`emociones_idemociones`),
  KEY `fk_detalle_emociones_juegos_juegos1_idx` (`juegos_idjuegos`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_imagen_usuario`
--

CREATE TABLE IF NOT EXISTS `detalle_imagen_usuario` (
  `iddetalle_imagen_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `foto_perfil` tinyint(1) NOT NULL,
  `usuarios_idusuarios` int(11) NOT NULL,
  `multimedia_idmultimedia` int(11) NOT NULL,
  PRIMARY KEY (`iddetalle_imagen_usuario`),
  KEY `fk_detalle_imagen_usuario_usuarios1_idx` (`usuarios_idusuarios`),
  KEY `fk_detalle_imagen_usuario_multimedia1_idx` (`multimedia_idmultimedia`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=8 ;

--
-- Volcado de datos para la tabla `detalle_imagen_usuario`
--

INSERT INTO `detalle_imagen_usuario` (`iddetalle_imagen_usuario`, `foto_perfil`, `usuarios_idusuarios`, `multimedia_idmultimedia`) VALUES
(1, 1, 1, 52),
(2, 1, 3, 42),
(3, 1, 5, 20),
(4, 1, 6, 60),
(5, 1, 4, 1),
(6, 1, 7, 63),
(7, 1, 8, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_multimedia_juego`
--

CREATE TABLE IF NOT EXISTS `detalle_multimedia_juego` (
  `iddetalle_video_juego` int(11) NOT NULL AUTO_INCREMENT,
  `multimedia_idmultimedia` int(11) NOT NULL,
  `niveles_idniveles` int(11) NOT NULL,
  PRIMARY KEY (`iddetalle_video_juego`,`multimedia_idmultimedia`,`niveles_idniveles`),
  KEY `fk_detalle_video_juego_video1_idx` (`multimedia_idmultimedia`),
  KEY `fk_detalle_multimedia_juego_niveles1_idx` (`niveles_idniveles`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=23 ;

--
-- Volcado de datos para la tabla `detalle_multimedia_juego`
--

INSERT INTO `detalle_multimedia_juego` (`iddetalle_video_juego`, `multimedia_idmultimedia`, `niveles_idniveles`) VALUES
(1, 2, 1),
(2, 3, 4),
(3, 4, 7),
(4, 16, 12),
(5, 17, 10),
(6, 18, 11),
(7, 23, 1),
(8, 24, 1),
(9, 25, 1),
(10, 26, 1),
(11, 27, 13),
(12, 28, 13),
(13, 29, 13),
(14, 30, 13),
(15, 31, 4),
(16, 32, 4),
(17, 33, 4),
(18, 34, 4),
(19, 35, 4),
(20, 36, 4),
(21, 37, 4),
(22, 38, 13);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_niveles`
--

CREATE TABLE IF NOT EXISTS `detalle_niveles` (
  `iddetalle_niveles` int(11) NOT NULL AUTO_INCREMENT,
  `niveles_idniveles` int(11) NOT NULL,
  `usuarios_idusuarios` int(11) NOT NULL,
  PRIMARY KEY (`iddetalle_niveles`),
  KEY `fk_detalle_niveles_niveles1_idx` (`niveles_idniveles`),
  KEY `fk_detalle_niveles_usuarios1_idx` (`usuarios_idusuarios`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=22 ;

--
-- Volcado de datos para la tabla `detalle_niveles`
--

INSERT INTO `detalle_niveles` (`iddetalle_niveles`, `niveles_idniveles`, `usuarios_idusuarios`) VALUES
(1, 1, 3),
(2, 4, 3),
(3, 7, 3),
(4, 10, 3),
(5, 11, 3),
(6, 12, 3),
(7, 13, 3),
(14, 2, 3),
(16, 5, 3),
(17, 2, 5),
(18, 2, 1),
(20, 2, 7),
(21, 2, 14);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_observaciones`
--

CREATE TABLE IF NOT EXISTS `detalle_observaciones` (
  `iddetalle_observaciones` int(11) NOT NULL AUTO_INCREMENT,
  `observaciones_idobservaciones` int(11) NOT NULL,
  `psicologo_idusuarios` int(11) NOT NULL,
  `profesor_idusuarios` int(11) NOT NULL,
  `multimedia_idmultimedia` int(11) NOT NULL,
  PRIMARY KEY (`iddetalle_observaciones`,`observaciones_idobservaciones`,`psicologo_idusuarios`,`profesor_idusuarios`,`multimedia_idmultimedia`),
  KEY `fk_detalle_observaciones_observaciones1_idx` (`observaciones_idobservaciones`),
  KEY `fk_detalle_observaciones_usuarios2_idx` (`psicologo_idusuarios`),
  KEY `fk_detalle_observaciones_usuarios1_idx` (`profesor_idusuarios`),
  KEY `fk_detalle_observaciones_multimedia1_idx` (`multimedia_idmultimedia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `emociones`
--

CREATE TABLE IF NOT EXISTS `emociones` (
  `idemociones` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `descripcion` text COLLATE utf8_unicode_ci NOT NULL,
  `fuente` varchar(120) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idemociones`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `emociones`
--

INSERT INTO `emociones` (`idemociones`, `nombre`, `descripcion`, `fuente`) VALUES
(1, 'tristeza', 'Sentimiento de dolor anímico producido por un suceso desfavorable que suele manifestarse con un estado de ánimo pesimista, la insatisfacción y la tendencia al llanto.', '/M-master/pub/images/tristeza.jpg'),
(2, 'miedo', 'Sensación de angustia provocada por la presencia de un peligro real o imaginario.', '/M-master/pub/images/miedo.jpg'),
(3, 'rabia', 'Enojo grande que se manifiesta con palabras, gritos y ademanes bruscos y violentos.', '/M-master/pub/images/rabia.jpg'),
(4, 'alegria', 'Es un sentimiento grato y vivo que suele manifestarse con signos exteriores.', '/M-master/pub/images/alegria.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `juegos`
--

CREATE TABLE IF NOT EXISTS `juegos` (
  `idjuegos` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `descripcion` text COLLATE utf8_unicode_ci,
  `categoria_idcategoria` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idjuegos`),
  KEY `categoria_idcategoria` (`categoria_idcategoria`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=9 ;

--
-- Volcado de datos para la tabla `juegos`
--

INSERT INTO `juegos` (`idjuegos`, `nombre`, `descripcion`, `categoria_idcategoria`) VALUES
(1, 'Memory', 'Relaciona las distintas imagenes entre si', 1),
(2, 'relaciona', 'Pon la emocion junto a la cara a la cual se relacione', 1),
(3, 'Como me siento', 'Describe como te sientes en este momento', 1),
(4, 'Puzzle rabbit', 'Divertido puzzle donde tendras que juntar las piezas de un conejo', 1),
(5, 'Simpson atrapado', 'Escapa de la habitación donde te han encerrado', 1),
(6, 'Bob el correcaminos', 'Corre y salta esquivando divertidísimos obstaculos', 1),
(8, 'Berta', 'Es la historia de Berta y sus colonias', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `licencia`
--

CREATE TABLE IF NOT EXISTS `licencia` (
  `idlicencia` int(11) NOT NULL,
  `numusuarios` int(10) unsigned NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `multimedia`
--

CREATE TABLE IF NOT EXISTS `multimedia` (
  `idmultimedia` int(11) NOT NULL AUTO_INCREMENT,
  `fuente` varchar(120) COLLATE utf8_unicode_ci NOT NULL,
  `nombre` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idmultimedia`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=64 ;

--
-- Volcado de datos para la tabla `multimedia`
--

INSERT INTO `multimedia` (`idmultimedia`, `fuente`, `nombre`) VALUES
(1, '/M-master/pub/images/hombre.png', 'avatar'),
(2, '/M-master/pub/images/memory.jpg', 'juego'),
(3, '/M-master/pub/images/relaciona.jpg', 'juego'),
(4, '/M-master/pub/images/comosiento.jpg', 'juego'),
(16, '/M-master/pub/images/bob.jpg', 'juego'),
(17, '/M-master/pub/images/puzzle_rabbit.jpg', 'juego'),
(18, '/M-master/pub/images/simpson.jpg', 'juego'),
(19, '/M-master/pub/images/bombilla.jpg', 'juego'),
(20, '/M-master/pub/images/conejito.jpg', 'juego'),
(23, '/M-master/pub/images/memory/level1/alegria.png', 'alegria'),
(24, '/M-master/pub/images/memory/level1/rabia.png', 'rabia'),
(25, '/M-master/pub/images/memory/level1/sorpresa.png', 'sorpresa'),
(26, '/M-master/pub/images/memory/level1/tristeza.png', 'tristeza'),
(27, '/M-master/pub/video/cuento1/alegria.mp4', 'Alegria'),
(28, '/M-master/pub/video/cuento1/alegria_2.mp4', 'Alegria'),
(29, '/M-master/pub/video/cuento1/calma.mp4', 'Calma'),
(30, '/M-master/pub/video/cuento1/rabia.mp4', 'Rabia'),
(31, '/M-master/pub/images/relaciona/level1/alegria.gif', 'alegre'),
(32, '/M-master/pub/images/relaciona/level1/malegria.gif', 'muy alegre'),
(33, '/M-master/pub/images/relaciona/level1/mtristesa.gif', 'muy triste'),
(34, '/M-master/pub/images/relaciona/level1/por.gif', 'miedo'),
(35, '/M-master/pub/images/relaciona/level1/rabia.gif', 'rabia'),
(36, '/M-master/pub/images/relaciona/level1/sorpresa.gif', 'sorprendido'),
(37, '/M-master/pub/images/relaciona/level1/tristesa.gif', 'triste'),
(38, '/M-master/pub/images/berta.png', 'juego'),
(39, '../M-master/pub/images/grateful.png', '3'),
(40, '../M-master/pub/images/hombre.png', '3'),
(41, '../M-master/pub/images/avatar.png', '3'),
(42, '../M-master/pub/images/hombre.png', '3'),
(43, '/M-master/pub/images/dibujo/admin.jpg', 'test'),
(44, '/M-master/pub/images/dibujo/admin.jpg', 'test'),
(45, '/M-master/pub/images/dibujo/admin.jpg', 'test'),
(46, '/M-master/pub/images/dibujo/admin.jpg', 'test'),
(47, '../M-master/pub/images/m7mip.jpg', '1'),
(48, '../M-master/pub/images/mono-saca-la-lengua-con-risa.jpg', '1'),
(49, '../M-master/pub/images/mono-saca-la-lengua-con-risa.jpg', '1'),
(50, '../M-master/pub/images/Hunter.x.Hunter.full.1706825.jpg', '1'),
(51, '../M-master/pub/images/mono-saca-la-lengua-con-risa.jpg', '1'),
(52, '../M-master/pub/images/mono-saca-la-lengua-con-risa.jpg', '1'),
(53, '/M-master/pub/images/dibujo/admin.jpg', 'test'),
(54, '/M-master/pub/images/dibujo/admin.jpg', 'test'),
(55, '/M-master/pub/images/dibujo/admin.jpg', 'test'),
(56, '/M-master/pub/images/dibujo/carlos.jpg', 'test'),
(57, '../M-master/pub/images/Koala.jpg', '6'),
(58, '../M-master/pub/images/Koala.jpg', '6'),
(59, '../M-master/pub/images/Jellyfish.jpg', '7'),
(60, '../M-master/pub/images/logo-cefpnuria-h.jpg', '6'),
(61, '/M-master/pub/images/dibujo/erik.jpg', 'test'),
(62, '/M-master/pub/images/dibujo/erik.jpg', 'test'),
(63, '../M-master/pub/images/Koala.jpg', '7');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `niveles`
--

CREATE TABLE IF NOT EXISTS `niveles` (
  `idniveles` int(11) NOT NULL AUTO_INCREMENT,
  `nivel` int(11) NOT NULL,
  `juegos_idjuegos` int(11) NOT NULL,
  PRIMARY KEY (`idniveles`),
  KEY `fk_niveles_juegos1_idx` (`juegos_idjuegos`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=14 ;

--
-- Volcado de datos para la tabla `niveles`
--

INSERT INTO `niveles` (`idniveles`, `nivel`, `juegos_idjuegos`) VALUES
(1, 1, 1),
(2, 2, 1),
(3, 3, 1),
(4, 1, 2),
(5, 2, 2),
(6, 3, 2),
(7, 1, 3),
(8, 2, 3),
(9, 3, 3),
(10, 1, 4),
(11, 1, 5),
(12, 1, 6),
(13, 1, 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `observaciones`
--

CREATE TABLE IF NOT EXISTS `observaciones` (
  `idobservaciones` int(11) NOT NULL AUTO_INCREMENT,
  `observacion` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  PRIMARY KEY (`idobservaciones`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `poblacion`
--

CREATE TABLE IF NOT EXISTS `poblacion` (
  `id_poblacion` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id_poblacion`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `poblacion`
--

INSERT INTO `poblacion` (`id_poblacion`, `nombre`) VALUES
(1, 'Gava'),
(2, 'Viladecans'),
(3, 'Castelldefels');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE IF NOT EXISTS `rol` (
  `id_rol` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id_rol`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`id_rol`, `nombre`) VALUES
(1, 'Admin'),
(2, 'Usuario');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `apellidos` varchar(80) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `email` varchar(60) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `password` varchar(120) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `rol` int(11) NOT NULL DEFAULT '0',
  `poblacion` int(11) NOT NULL DEFAULT '0',
  `puntos` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_usuario`),
  KEY `fk_usuarios_rol1_idx` (`rol`),
  KEY `fk_usuarios_poblacion1_idx` (`poblacion`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=18 ;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `nombre`, `apellidos`, `email`, `password`, `rol`, `poblacion`, `puntos`) VALUES
(1, 'admin', 'admin', 'admin', 'admin', 1, 1, 100),
(3, 't', 'prueba', 'prueba@p.com', 'prueba', 2, 2, 450),
(4, 'juan', 'pedro', 'pedro', 'pedro', 2, 3, 10),
(5, 'sergio', 'fabregat', 'sergio', 'sergio', 2, 3, 950),
(6, 'carlos', 'carlos', 'carlos', 'carlos', 2, 2, 8700),
(7, 'erik', 'erik', 'erik', 'erik', 2, 1, 8550),
(8, 'test2', 'xavi', 'test2', 'test2', 2, 1, 4500),
(14, 'marcasru', '', 'email@gmail.com', 'marcasru', 2, 1, 50);

--
-- Disparadores `usuarios`
--
DROP TRIGGER IF EXISTS `controlarusers`;
DELIMITER //
CREATE TRIGGER `controlarusers` BEFORE INSERT ON `usuarios`
 FOR EACH ROW BEGIN
DECLARE numuser INT;
DECLARE useractual INT;
SELECT numusuarios from licencia into numuser;
SELECT COUNT(*) from usuarios into useractual;
IF numuser <= useractual  then SIGNAL SQLSTATE '50000' SET message_text = 'Te has pasado de numero de usuarios';
END IF;
END
//
DELIMITER ;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalle_emociones_juegos`
--
ALTER TABLE `detalle_emociones_juegos`
  ADD CONSTRAINT `fk_detalle_emociones_juegos_emociones1` FOREIGN KEY (`emociones_idemociones`) REFERENCES `emociones` (`idemociones`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_detalle_emociones_juegos_juegos1` FOREIGN KEY (`juegos_idjuegos`) REFERENCES `juegos` (`idjuegos`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `detalle_imagen_usuario`
--
ALTER TABLE `detalle_imagen_usuario`
  ADD CONSTRAINT `fk_detalle_imagen_usuario_multimedia1` FOREIGN KEY (`multimedia_idmultimedia`) REFERENCES `multimedia` (`idmultimedia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_detalle_imagen_usuario_usuarios1` FOREIGN KEY (`usuarios_idusuarios`) REFERENCES `usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `detalle_multimedia_juego`
--
ALTER TABLE `detalle_multimedia_juego`
  ADD CONSTRAINT `fk_detalle_multimedia_juego_niveles1` FOREIGN KEY (`niveles_idniveles`) REFERENCES `niveles` (`idniveles`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_detalle_video_juego_video1` FOREIGN KEY (`multimedia_idmultimedia`) REFERENCES `multimedia` (`idmultimedia`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `detalle_niveles`
--
ALTER TABLE `detalle_niveles`
  ADD CONSTRAINT `fk_detalle_niveles_niveles1` FOREIGN KEY (`niveles_idniveles`) REFERENCES `niveles` (`idniveles`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_detalle_niveles_usuarios1` FOREIGN KEY (`usuarios_idusuarios`) REFERENCES `usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `detalle_observaciones`
--
ALTER TABLE `detalle_observaciones`
  ADD CONSTRAINT `fk_detalle_observaciones_multimedia1` FOREIGN KEY (`multimedia_idmultimedia`) REFERENCES `multimedia` (`idmultimedia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_detalle_observaciones_observaciones1` FOREIGN KEY (`observaciones_idobservaciones`) REFERENCES `observaciones` (`idobservaciones`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_detalle_observaciones_usuarios1` FOREIGN KEY (`profesor_idusuarios`) REFERENCES `usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_detalle_observaciones_usuarios2` FOREIGN KEY (`psicologo_idusuarios`) REFERENCES `usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `juegos`
--
ALTER TABLE `juegos`
  ADD CONSTRAINT `juegos_ibfk_1` FOREIGN KEY (`categoria_idcategoria`) REFERENCES `categoria` (`idcategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `niveles`
--
ALTER TABLE `niveles`
  ADD CONSTRAINT `fk_niveles_juegos1` FOREIGN KEY (`juegos_idjuegos`) REFERENCES `juegos` (`idjuegos`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `fk_usuarios_poblacion1` FOREIGN KEY (`poblacion`) REFERENCES `poblacion` (`id_poblacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_usuarios_rol1` FOREIGN KEY (`rol`) REFERENCES `rol` (`id_rol`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
