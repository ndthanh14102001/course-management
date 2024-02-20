-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2024 at 06:59 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

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

-- --------------------------------------------------------

--
-- Table structure for table `courseinstructor`
--

CREATE TABLE `courseinstructor` (
  `COURSEID` int(11) NOT NULL,
  `PERSONID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
(124, 'Department2', 1000, '2001-10-12', '');

-- --------------------------------------------------------

--
-- Table structure for table `officeassignment`
--

CREATE TABLE `officeassignment` (
  `INSTRUCTOR` int(11) NOT NULL,
  `LOCATION` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `TIMESTAMP` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `onlinecourse`
--

CREATE TABLE `onlinecourse` (
  `COURSEID` int(11) NOT NULL,
  `URL` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `onsitecourse`
--

CREATE TABLE `onsitecourse` (
  `COURSEID` int(11) NOT NULL,
  `LOCATION` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `DATES` date DEFAULT NULL,
  `TIMES` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
(123, 'thanh', 'thanh', '2024-02-02', '2024-02-29');

-- --------------------------------------------------------

--
-- Table structure for table `studentgrade`
--

CREATE TABLE `studentgrade` (
  `ENROLLMENTID` int(11) NOT NULL,
  `COURSEID` int(11) DEFAULT NULL,
  `STUDENTID` int(11) DEFAULT NULL,
  `GRADE` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
  MODIFY `COURSEID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `department`
--
ALTER TABLE `department`
  MODIFY `DEPARTMENTID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=125;

--
-- AUTO_INCREMENT for table `onlinecourse`
--
ALTER TABLE `onlinecourse`
  MODIFY `COURSEID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `person`
--
ALTER TABLE `person`
  MODIFY `PERSONID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=124;

--
-- AUTO_INCREMENT for table `studentgrade`
--
ALTER TABLE `studentgrade`
  MODIFY `ENROLLMENTID` int(11) NOT NULL AUTO_INCREMENT;

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
