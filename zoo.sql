-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-06-2020 a las 17:43:35
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `zoo`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alimentacion`
--

CREATE TABLE `alimentacion` (
  `idAlimentacion` int(255) NOT NULL,
  `tipo` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `alimentacion`
--

INSERT INTO `alimentacion` (`idAlimentacion`, `tipo`) VALUES
(1, 'carnivoro'),
(2, 'herbivoro'),
(3, 'omnivoro');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `animales`
--

CREATE TABLE `animales` (
  `idAnimales` bigint(20) UNSIGNED NOT NULL,
  `nombres` varchar(255) NOT NULL,
  `idAlimentacion` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `animales`
--

INSERT INTO `animales` (`idAnimales`, `nombres`, `idAlimentacion`) VALUES
(3, 'Tortuga', 3),
(4, 'Zorro', 3),
(5, 'Girafa', 2),
(6, 'perro', 3),
(26, 'mono', 3),
(27, ' ornitorrinco', 3);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alimentacion`
--
ALTER TABLE `alimentacion`
  ADD PRIMARY KEY (`idAlimentacion`);

--
-- Indices de la tabla `animales`
--
ALTER TABLE `animales`
  ADD PRIMARY KEY (`idAnimales`),
  ADD UNIQUE KEY `idAnimales` (`idAnimales`),
  ADD KEY `idAlimentacion` (`idAlimentacion`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `animales`
--
ALTER TABLE `animales`
  MODIFY `idAnimales` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `animales`
--
ALTER TABLE `animales`
  ADD CONSTRAINT `animales_ibfk_1` FOREIGN KEY (`idAlimentacion`) REFERENCES `alimentacion` (`idAlimentacion`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
