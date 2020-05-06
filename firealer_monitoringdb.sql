-- phpMyAdmin SQL Dump
-- version 4.9.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: May 06, 2020 at 11:08 AM
-- Server version: 5.7.30
-- PHP Version: 7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `firealer_monitoringdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `devices`
--

CREATE TABLE `devices` (
  `id` int(11) NOT NULL,
  `device_id` varchar(100) NOT NULL,
  `device_status` varchar(10) NOT NULL,
  `device_floor` int(3) NOT NULL,
  `device_room` int(5) NOT NULL,
  `device_smoke` int(3) NOT NULL,
  `device_co2` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `devices`
--

INSERT INTO `devices` (`id`, `device_id`, `device_status`, `device_floor`, `device_room`, `device_smoke`, `device_co2`) VALUES
(1, '102', 'Deactive', 5, 20, 0, 0),
(2, '102', 'Deactive', 5, 20, 0, 0),
(3, '102', 'Deactive', 5, 20, 0, 0),
(4, '109', 'Active', 8, 2, 3, 4),
(5, '203', 'Active', 10, 12, 1, 3),
(6, '303', 'Active', 8, 12, 6, 8),
(7, '303', 'Active', 8, 12, 6, 8),
(8, '203', 'Active', 10, 12, 1, 3),
(9, '203', 'Active', 10, 12, 1, 3),
(10, '303', 'Active', 8, 12, 6, 8),
(11, '303', 'Active', 8, 12, 6, 8),
(12, '203', 'Active', 10, 12, 1, 3),
(13, '203', 'Active', 10, 12, 1, 3),
(14, '303', 'Active', 8, 12, 6, 8),
(15, '203', 'Active', 10, 12, 1, 3),
(16, '303', 'Active', 8, 12, 6, 8),
(17, '203', 'Active', 10, 12, 1, 3),
(18, '303', 'Active', 8, 12, 6, 8),
(19, '203', 'Active', 10, 12, 1, 3),
(20, '303', 'Active', 8, 12, 6, 8),
(21, '203', 'Active', 10, 12, 1, 3),
(22, '303', 'Active', 8, 12, 6, 8),
(23, '203', 'Active', 10, 12, 1, 3),
(24, '303', 'Active', 8, 12, 6, 8),
(25, '203', 'Active', 10, 12, 1, 3),
(26, '303', 'Active', 8, 12, 6, 8),
(27, '203', 'Active', 10, 12, 1, 3),
(28, '303', 'Active', 8, 12, 6, 8),
(29, '203', 'Active', 10, 12, 1, 3),
(30, '303', 'Active', 8, 12, 6, 8),
(31, '203', 'Active', 10, 12, 1, 3),
(32, '303', 'Active', 8, 12, 6, 8),
(33, '203', 'Active', 10, 12, 1, 3),
(34, '303', 'Active', 8, 12, 6, 8),
(35, '203', 'Active', 10, 12, 1, 3),
(36, '303', 'Active', 8, 12, 6, 8),
(37, '303', 'Active', 8, 12, 6, 8),
(38, '203', 'Active', 10, 12, 1, 3),
(39, '203', 'Active', 10, 12, 1, 3),
(40, '303', 'Active', 8, 12, 6, 8),
(41, '303', 'Active', 8, 12, 6, 8),
(42, '203', 'Active', 10, 12, 1, 3),
(43, '303', 'Active', 8, 12, 6, 8),
(44, '203', 'Active', 10, 12, 1, 3);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(20) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`) VALUES
(1, 'admin', 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `devices`
--
ALTER TABLE `devices`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `devices`
--
ALTER TABLE `devices`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
