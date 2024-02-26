-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 26, 2024 at 06:19 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `coursemanagement`
--
CREATE DATABASE IF NOT EXISTS `coursemanagement` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `coursemanagement`;
-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `COURSEID` int(11) NOT NULL,
  `TITLE` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `CREDITS` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `DEPARTMENTID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`COURSEID`, `TITLE`, `CREDITS`, `DEPARTMENTID`) VALUES
(29, 'OOP', '4', 123),
(32, 'CTDL', '4', 124);

-- --------------------------------------------------------

--
-- Table structure for table `courseinstructor`
--

CREATE TABLE `courseinstructor` (
  `COURSEID` int(11) NOT NULL,
  `PERSONID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `courseinstructor`
--

INSERT INTO `courseinstructor` (`COURSEID`, `PERSONID`) VALUES
(29, 123),
(29, 131),
(32, 123),
(32, 131);

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `DEPARTMENTID` int(11) NOT NULL,
  `NAME` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `BUDGET` double DEFAULT NULL,
  `STARTDATE` date DEFAULT NULL,
  `ADMINISTRATOR` varchar(155) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`DEPARTMENTID`, `NAME`, `BUDGET`, `STARTDATE`, `ADMINISTRATOR`) VALUES
(123, 'Department1', 1000, '2001-10-12', ''),
(124, 'Department2', 1000, '2001-10-12', ''),
(125, 'Department1', 1000, '2001-10-14', ''),
(126, 'Department1', 1000, '2001-10-14', 'abc');

-- --------------------------------------------------------

--
-- Table structure for table `officeassignment`
--

CREATE TABLE `officeassignment` (
  `INSTRUCTOR` int(11) NOT NULL,
  `LOCATION` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `TIMESTAMP` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `officeassignment`
--

INSERT INTO `officeassignment` (`INSTRUCTOR`, `LOCATION`, `TIMESTAMP`) VALUES
(123, 'ddd', '2024-02-26'),
(131, 'abcasdas', '2024-02-26');

-- --------------------------------------------------------

--
-- Table structure for table `onlinecourse`
--

CREATE TABLE `onlinecourse` (
  `COURSEID` int(11) NOT NULL,
  `URL` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `onlinecourse`
--

INSERT INTO `onlinecourse` (`COURSEID`, `URL`) VALUES
(29, 'oop.com');

-- --------------------------------------------------------

--
-- Table structure for table `onsitecourse`
--

CREATE TABLE `onsitecourse` (
  `COURSEID` int(11) NOT NULL,
  `LOCATION` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `DAYS` varchar(20) DEFAULT NULL,
  `TIMES` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `onsitecourse`
--

INSERT INTO `onsitecourse` (`COURSEID`, `LOCATION`, `DAYS`, `TIMES`) VALUES
(32, 'HCM', 'Sunday ', '02:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

CREATE TABLE `person` (
  `PERSONID` int(11) NOT NULL,
  `LASTNAME` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `FIRSTNAME` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `HIREDATE` date DEFAULT NULL,
  `ENROLLMENTDATE` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `person`
--

INSERT INTO `person` (`PERSONID`, `LASTNAME`, `FIRSTNAME`, `HIREDATE`, `ENROLLMENTDATE`) VALUES
(123, 'THANH', 'GV', '2024-02-02', NULL),
(124, 'Tí', 'Nguyễn', NULL, '2024-02-29'),
(125, 'Tèo', 'Nguyễn Văn', NULL, '2024-02-16'),
(131, 'Tèo', 'Nguyễn Văn', '2024-02-29', NULL),
(132, 'Tèo', 'Nguyễn', '2024-02-24', NULL),
(133, 'Thanh', 'Nguyen', NULL, '2024-02-08'),
(134, 'C', 'Nguyễn Văn', NULL, '2024-02-16'),
(135, 'B', 'Nguyễn Văn', NULL, '2024-02-16'),
(136, 'A', 'Nguyễn Văn', NULL, '2024-02-16'),
(137, 'C', 'Nguyễn Văn', NULL, '2024-02-16'),
(150, 'Ti ', 'Nguyễn', '2024-02-29', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `studentgrade`
--

CREATE TABLE `studentgrade` (
  `ENROLLMENTID` int(11) NOT NULL,
  `COURSEID` int(11) DEFAULT NULL,
  `STUDENTID` int(11) DEFAULT NULL,
  `GRADE` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `studentgrade`
--

INSERT INTO `studentgrade` (`ENROLLMENTID`, `COURSEID`, `STUDENTID`, `GRADE`) VALUES
(12, 29, 124, 7),
(13, 29, 125, 9.5),
(14, 29, 133, 8),
(15, 29, 134, 0),
(16, 29, 135, 8.5),
(17, 29, 137, NULL),
(20, 32, 124, NULL),
(21, 32, 125, 8.75),
(22, 32, 133, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`COURSEID`),
  ADD KEY `DEPARTMENTID` (`DEPARTMENTID`);

--
-- Indexes for table `courseinstructor`
--
ALTER TABLE `courseinstructor`
  ADD PRIMARY KEY (`COURSEID`,`PERSONID`),
  ADD KEY `courseinstructor_ibfk_2` (`PERSONID`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`DEPARTMENTID`);

--
-- Indexes for table `officeassignment`
--
ALTER TABLE `officeassignment`
  ADD PRIMARY KEY (`INSTRUCTOR`);

--
-- Indexes for table `onlinecourse`
--
ALTER TABLE `onlinecourse`
  ADD PRIMARY KEY (`COURSEID`);

--
-- Indexes for table `onsitecourse`
--
ALTER TABLE `onsitecourse`
  ADD PRIMARY KEY (`COURSEID`);

--
-- Indexes for table `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`PERSONID`);

--
-- Indexes for table `studentgrade`
--
ALTER TABLE `studentgrade`
  ADD PRIMARY KEY (`ENROLLMENTID`),
  ADD KEY `studentgrade_ibfk_2` (`STUDENTID`),
  ADD KEY `COURSEID` (`COURSEID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `course`
--
ALTER TABLE `course`
  MODIFY `COURSEID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `department`
--
ALTER TABLE `department`
  MODIFY `DEPARTMENTID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=127;

--
-- AUTO_INCREMENT for table `onlinecourse`
--
ALTER TABLE `onlinecourse`
  MODIFY `COURSEID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `person`
--
ALTER TABLE `person`
  MODIFY `PERSONID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=151;

--
-- AUTO_INCREMENT for table `studentgrade`
--
ALTER TABLE `studentgrade`
  MODIFY `ENROLLMENTID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `course`
--
ALTER TABLE `course`
  ADD CONSTRAINT `course_ibfk_1` FOREIGN KEY (`DEPARTMENTID`) REFERENCES `department` (`DEPARTMENTID`);

--
-- Constraints for table `courseinstructor`
--
ALTER TABLE `courseinstructor`
  ADD CONSTRAINT `courseinstructor_ibfk_2` FOREIGN KEY (`PERSONID`) REFERENCES `person` (`PERSONID`),
  ADD CONSTRAINT `courseinstructor_ibfk_3` FOREIGN KEY (`COURSEID`) REFERENCES `course` (`COURSEID`);

--
-- Constraints for table `officeassignment`
--
ALTER TABLE `officeassignment`
  ADD CONSTRAINT `officeassignment_ibfk_1` FOREIGN KEY (`INSTRUCTOR`) REFERENCES `person` (`PERSONID`);

--
-- Constraints for table `onlinecourse`
--
ALTER TABLE `onlinecourse`
  ADD CONSTRAINT `onlinecourse_ibfk_1` FOREIGN KEY (`COURSEID`) REFERENCES `course` (`COURSEID`);

--
-- Constraints for table `onsitecourse`
--
ALTER TABLE `onsitecourse`
  ADD CONSTRAINT `onsitecourse_ibfk_1` FOREIGN KEY (`COURSEID`) REFERENCES `course` (`COURSEID`);

--
-- Constraints for table `studentgrade`
--
ALTER TABLE `studentgrade`
  ADD CONSTRAINT `studentgrade_ibfk_2` FOREIGN KEY (`STUDENTID`) REFERENCES `person` (`PERSONID`),
  ADD CONSTRAINT `studentgrade_ibfk_3` FOREIGN KEY (`COURSEID`) REFERENCES `course` (`COURSEID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
