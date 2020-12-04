-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 04, 2020 at 08:41 PM
-- Server version: 5.7.24
-- PHP Version: 7.2.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `softwarecompany`
--

-- --------------------------------------------------------

--
-- Table structure for table `game`
--

CREATE TABLE `game` (
  `game_id` int(11) NOT NULL,
  `name` varchar(75) NOT NULL,
  `platform` varchar(75) NOT NULL,
  `genre` varchar(75) NOT NULL,
  `age_rating` int(11) NOT NULL,
  `difficulty` varchar(75) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `game`
--

INSERT INTO `game` (`game_id`, `name`, `platform`, `genre`, `age_rating`, `difficulty`) VALUES
(1, 'Red Dead Redemption 2', 'Playstation/Xbox/PC', 'Action-Adventure', 18, 'Medium'),
(2, 'Call Of Duty: Modern Warfare', 'Playstation/Xbox/PC', 'First-Person Shooter', 18, 'Medium'),
(3, 'Super Mario Odyssey', 'Nintendo Switch', 'Adventure', 7, 'Easy'),
(4, 'The Crew 2', 'Playstation/Xbox', 'Racing', 12, 'Medium'),
(5, 'God of War', 'Playstation', 'Action-Adventure', 18, 'Hard'),
(6, 'Pokemon Mystery Dungeon DX', 'Nintendo Switch', 'Adventure', 7, 'Easy');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `game`
--
ALTER TABLE `game`
  ADD PRIMARY KEY (`game_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `game`
--
ALTER TABLE `game`
  MODIFY `game_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
