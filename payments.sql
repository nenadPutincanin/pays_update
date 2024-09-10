-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 02, 2023 at 03:23 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `payments`
--

-- --------------------------------------------------------

--
-- Table structure for table `pays`
--

CREATE TABLE `pays` (
  `paysId` int(11) NOT NULL,
  `workerId` int(11) NOT NULL,
  `date` date NOT NULL,
  `earnings` decimal(10,0) DEFAULT NULL,
  `payments` decimal(10,0) DEFAULT NULL,
  `saldo` decimal(12,10) DEFAULT NULL,
  `description` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pays`
--

INSERT INTO `pays` (`paysId`, `workerId`, `date`, `earnings`, `payments`, `saldo`, `description`) VALUES
(10, 5, '2023-06-17', '100000', '0', '0.0000000000', 'Plata jun'),
(14, 5, '2023-06-18', '0', '100000', '0.0000000000', 'Isplata maj'),
(15, 9, '2023-06-18', '100000', '0', '0.0000000000', 'Plata maj'),
(16, 5, '2023-06-18', '0', '50000', '0.0000000000', 'Isplata maj'),
(17, 5, '2023-06-18', '50000', '0', '0.0000000000', 'Zarada'),
(18, 9, '2023-06-18', '0', '100000', '0.0000000000', 'plata'),
(19, 8, '2023-06-18', '0', '100000', '0.0000000000', 'plata jun'),
(20, 8, '2023-06-18', '100000', '0', '0.0000000000', 'plata maj'),
(21, 8, '2023-06-18', '100000', '0', '0.0000000000', 'plata jun'),
(22, 8, '2023-06-18', '100000', '0', '0.0000000000', 'plata jul'),
(23, 8, '2023-06-18', '100000', '0', '0.0000000000', 'plata seo'),
(24, 4, '2023-06-18', '100000', '0', '0.0000000000', 'plata maj'),
(25, 9, '2023-06-18', '100000', '0', '0.0000000000', 'sasa'),
(29, 4, '2023-06-24', '0', '100000', '0.0000000000', 'Isplata'),
(30, 8, '2023-06-24', '0', '100000', '0.0000000000', 'Isplata'),
(31, 8, '2023-06-24', '0', '100000', '0.0000000000', 'Isplata'),
(32, 8, '2023-06-24', '0', '100000', '0.0000000000', 'Isplata'),
(33, 8, '2023-06-24', '0', '50000', '0.0000000000', 'Isplata'),
(34, 8, '2023-06-24', '50000', '0', '0.0000000000', 'Zarada'),
(35, 9, '2023-06-24', '0', '100000', '0.0000000000', 'Isplata'),
(39, 2, '2023-06-24', '50000', '0', '0.0000000000', 'Zarada'),
(40, 2, '2023-06-24', '0', '50000', '0.0000000000', 'Isplata'),
(42, 2, '2023-06-24', '100000', '0', '0.0000000000', 'Zarada'),
(43, 2, '2023-06-24', '0', '100000', '0.0000000000', 'Isplata'),
(44, 2, '2023-06-24', '100000', '0', '0.0000000000', 'Zarada'),
(45, 2, '2023-06-24', '0', '100000', '0.0000000000', 'Isplata'),
(52, 9, '2023-06-24', '100000', '0', '0.0000000000', 'Zarad'),
(53, 8, '2023-06-24', '100000', '0', '0.0000000000', 'Zarada'),
(54, 5, '2023-06-24', '100000', '0', '0.0000000000', 'Zarada'),
(55, 4, '2023-06-24', '100000', '0', '0.0000000000', 'Zarada'),
(56, 3, '2023-06-24', '100000', '0', '0.0000000000', 'Zarad'),
(57, 2, '2023-06-24', '100000', '0', '0.0000000000', 'Zarad'),
(59, 2, '2023-06-24', '0', '100000', '0.0000000000', 'Isplata'),
(60, 3, '2023-06-24', '0', '100000', '0.0000000000', 'Isplata'),
(61, 2, '2023-06-24', '100000', '0', '0.0000000000', 'Zarada'),
(62, 2, '2023-06-24', '50000', '0', '0.0000000000', 'Zarada'),
(63, 2, '2023-06-24', '0', '20000', '0.0000000000', 'Isplata'),
(64, 37, '2023-06-24', '40000', '0', '0.0000000000', 'Zarada'),
(65, 37, '2023-06-24', '0', '60000', '0.0000000000', 'Zarada'),
(66, 37, '2023-06-24', '20000', '0', '0.0000000000', 'Zarada'),
(68, 2, '2023-06-25', '0', '130000', '0.0000000000', 'Isplata'),
(69, 4, '2023-06-25', '0', '100000', '0.0000000000', 'Isplata'),
(70, 2, '2023-06-27', '50000', '0', '0.0000000000', 'Isplata'),
(71, 4, '2023-06-27', '30000', '0', '0.0000000000', 'Isplata'),
(72, 36, '2023-07-02', '100000', '0', '0.0000000000', 'Zarada'),
(73, 38, '2023-07-02', '100000', '0', '0.0000000000', 'Zarada'),
(74, 37, '2023-07-02', '0', '20000', '0.0000000000', 'Isplata'),
(75, 8, '2023-07-02', '20000', '0', '0.0000000000', 'Zarada maj'),
(76, 37, '2023-07-02', '20000', '0', '0.0000000000', 'Zarada');

-- --------------------------------------------------------

--
-- Table structure for table `worker`
--

CREATE TABLE `worker` (
  `workerId` int(11) NOT NULL,
  `firstName` varchar(60) NOT NULL,
  `lastName` varchar(60) NOT NULL,
  `position` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `worker`
--

INSERT INTO `worker` (`workerId`, `firstName`, `lastName`, `position`) VALUES
(2, 'Milan', 'Savić', 'Paker'),
(3, 'Vladimir', 'Lazić', 'Direktor '),
(4, 'Miroslav ', 'Gajin', 'Pekar'),
(5, 'Bojan', 'Leontijević', 'Pekar'),
(8, 'Nikola', 'Komlenic', 'Pekar'),
(9, 'Sladjan', 'Mijalkovic', 'Direktor'),
(36, 'Jelena', 'Ivanovic', 'Kuvar'),
(37, 'Gordana', 'Ilic', 'Higijenicarka'),
(38, 'Jelena', 'Momcilović', 'Administrativni radnik');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pays`
--
ALTER TABLE `pays`
  ADD PRIMARY KEY (`paysId`,`workerId`),
  ADD KEY `FK_workers_pays` (`workerId`);

--
-- Indexes for table `worker`
--
ALTER TABLE `worker`
  ADD PRIMARY KEY (`workerId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pays`
--
ALTER TABLE `pays`
  MODIFY `paysId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=77;

--
-- AUTO_INCREMENT for table `worker`
--
ALTER TABLE `worker`
  MODIFY `workerId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `pays`
--
ALTER TABLE `pays`
  ADD CONSTRAINT `FK_workers_pays` FOREIGN KEY (`workerId`) REFERENCES `worker` (`workerId`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
