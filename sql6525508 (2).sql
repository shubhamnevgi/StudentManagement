-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 06, 2022 at 01:09 PM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sql6525508`
--

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE `attendance` (
  `Year` varchar(30) NOT NULL,
  `Branch` varchar(40) NOT NULL,
  `RegNo` varchar(20) NOT NULL,
  `SCode` varchar(30) NOT NULL,
  `Mid` int(20) NOT NULL,
  `PresentD` varchar(20) NOT NULL,
  `AbsentD` varchar(20) NOT NULL,
  `Total` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`Year`, `Branch`, `RegNo`, `SCode`, `Mid`, `PresentD`, `AbsentD`, `Total`) VALUES
('Information Technology', 'Second Year (SE)', 'T-21-0470', 'ITC301', 11, '16', '2', '14'),
('Information Technology', 'Second Year (SE)', 'T-21-0470', 'ITC301', 7, '15', '1', '14'),
('Information Technology', 'Second Year (SE)', 'T-21-0470', 'ITC301', 8, '16', '0', '16'),
('Information Technology', 'Second Year (SE)', 'T-21-0470', 'ITC301', 9, '16', '0', '16'),
('Information Technology', 'Second Year (SE)', 'T-21-0470', 'ITC301', 10, '16', '0', '16'),
('Information Technology', 'Second Year (SE)', 'T-21-0470', 'ITC302', 9, '16', '0', '16'),
('Information Technology', 'Second Year (SE)', 'T-21-0470', 'ITC302', 10, '15', '1', '14');

-- --------------------------------------------------------

--
-- Table structure for table `iamarks`
--

CREATE TABLE `iamarks` (
  `Year` varchar(30) NOT NULL,
  `Branch` varchar(30) NOT NULL,
  `RegNo` varchar(30) NOT NULL,
  `SCode` varchar(30) NOT NULL,
  `IA` int(11) NOT NULL,
  `Total` int(11) NOT NULL,
  `Obtained` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `iamarks`
--

INSERT INTO `iamarks` (`Year`, `Branch`, `RegNo`, `SCode`, `IA`, `Total`, `Obtained`) VALUES
('Information Technology', 'Second Year (SE)', 'T-21-0470', 'ITC301', 1, 20, 9),
('Information Technology', 'Second Year (SE)', 'T-21-0470', 'ITC301', 2, 20, 12);

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `RegNo` varchar(30) NOT NULL,
  `Name` varchar(40) NOT NULL,
  `RollNo` int(11) DEFAULT NULL,
  `Gender` varchar(10) DEFAULT NULL,
  `Year` varchar(40) DEFAULT NULL,
  `Branch` varchar(40) DEFAULT NULL,
  `Address` varchar(50) DEFAULT NULL,
  `Pass` varchar(20) NOT NULL,
  `Verified` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`RegNo`, `Name`, `RollNo`, `Gender`, `Year`, `Branch`, `Address`, `Pass`, `Verified`) VALUES
('T-21-0470', 'Shubham Nevgi', 46, 'Male', 'Second Year (SE)', 'Information Technology', 'MIDC, Ratnagiri', 'T-21-0470', 'Y'),
('TD-21-4267', 'Shubham', 32, 'Male', 'First Year (FE)', 'Information Technology', 'MIDC', 'TD-21-4267', 'Y');

-- --------------------------------------------------------

--
-- Table structure for table `subjects`
--

CREATE TABLE `subjects` (
  `Branch` varchar(30) NOT NULL,
  `Year` varchar(20) NOT NULL,
  `SCode` varchar(20) NOT NULL,
  `SName` varchar(60) NOT NULL,
  `Sem` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `subjects`
--

INSERT INTO `subjects` (`Branch`, `Year`, `SCode`, `SName`, `Sem`) VALUES
('Information Technology', 'Second Year (SE)', 'ITC301', 'Engineering Mathematics 3', 3),
('Information Technology', 'Second Year (SE)', 'ITC302', 'Data Structure And Analysis', 3),
('Information Technology', 'Second Year (SE)', 'ITC303', 'Database Management System', 3),
('Information Technology', 'Second Year (SE)', 'ITC304', 'Principle of Commmunication', 3),
('Information Technology', 'Second Year (SE)', 'ITC305', 'Paradigms and Computer Program', 3),
('Information Technology', 'Second Year (SE)', 'ITC401', 'Engineering Mathematics 4', 4),
('Information Technology', 'Second Year (SE)', 'ITC402', 'Computer Network and Network Design', 4),
('Information Technology', 'Second Year (SE)', 'ITC403', 'Operating System', 4),
('Information Technology', 'Second Year (SE)', 'ITC404', 'Automata Theory', 4),
('Information Technology', 'Second Year (SE)', 'ITC405', 'Computer Organization and Architecture', 4);

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE `teacher` (
  `RegNo` varchar(20) NOT NULL,
  `Name` varchar(40) NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `Address` varchar(250) NOT NULL,
  `Admin` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`RegNo`, `Name`, `Gender`, `Address`, `Admin`) VALUES
('IT001', 'Saurabh Shahane', 'Male', 'Ratnagiri', 'N'),
('IT002', ' S.SANKARESWARI', 'Female', 'Ratnagiri', 'Y');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`RegNo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
