-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-11-2024 a las 05:33:04
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `petcare`
--
CREATE DATABASE IF NOT EXISTS `petcare` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `petcare`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `horarios_cuidado_mascotas`
--

CREATE TABLE `horarios_cuidado_mascotas` (
  `id` bigint(20) NOT NULL,
  `nombre_mascota` varchar(50) NOT NULL,
  `tipo` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rutina_mascota`
--

CREATE TABLE `rutina_mascota` (
  `id` bigint(20) NOT NULL,
  `actividad` varchar(100) DEFAULT NULL,
  `hora` varchar(255) DEFAULT NULL,
  `horario_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `horarios_cuidado_mascotas`
--
ALTER TABLE `horarios_cuidado_mascotas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `rutina_mascota`
--
ALTER TABLE `rutina_mascota`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKmaoqctid7ryt8rd5veawwjxku` (`horario_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `horarios_cuidado_mascotas`
--
ALTER TABLE `horarios_cuidado_mascotas`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `rutina_mascota`
--
ALTER TABLE `rutina_mascota`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `rutina_mascota`
--
ALTER TABLE `rutina_mascota`
  ADD CONSTRAINT `FKmaoqctid7ryt8rd5veawwjxku` FOREIGN KEY (`horario_id`) REFERENCES `horarios_cuidado_mascotas` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
