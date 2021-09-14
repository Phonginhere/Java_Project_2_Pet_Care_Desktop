-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 12, 2021 at 02:50 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ql_thucungcare`
--
CREATE DATABASE IF NOT EXISTS `ql_thucungcare` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `ql_thucungcare`;

-- --------------------------------------------------------

--
-- Table structure for table `chamsoc`
--

DROP TABLE IF EXISTS `chamsoc`;
CREATE TABLE IF NOT EXISTS `chamsoc` (
  `id_chamsoc` tinyint(11) NOT NULL AUTO_INCREMENT,
  `thoigiankethuc_chamsoc` date NOT NULL,
  `price_chamsoc` int(20) NOT NULL,
  `cachchua_chamsoc` varchar(300) CHARACTER SET utf8 COLLATE utf8_vietnamese_ci NOT NULL,
  `idnhanvien_chamsoc` tinyint(11) DEFAULT NULL,
  `id_datlich` tinyint(11) NOT NULL,
  `sendemail` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id_chamsoc`),
  KEY `fk_nhanvien_chamsoc` (`idnhanvien_chamsoc`),
  KEY `fk_datlich` (`id_datlich`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `chamsoc`
--

INSERT INTO `chamsoc` (`id_chamsoc`, `thoigiankethuc_chamsoc`, `price_chamsoc`, `cachchua_chamsoc`, `idnhanvien_chamsoc`, `id_datlich`, `sendemail`) VALUES
(21, '2021-01-30', 50000, 'cho u?ng thu?c', 1, 24, NULL),
(22, '2021-01-30', 20000, 'cho uong thuoc', 1, 24, NULL),
(23, '2021-01-30', 50000, 'tiem chung', 13, 24, NULL),
(24, '2021-01-31', 100000, 'tiem phong 5 lieu', 20, 34, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `datlich`
--

DROP TABLE IF EXISTS `datlich`;
CREATE TABLE IF NOT EXISTS `datlich` (
  `id_datlich` tinyint(11) NOT NULL AUTO_INCREMENT,
  `thoigian_datlich` date NOT NULL,
  `id_khachhang` tinyint(11) NOT NULL,
  `id_thucung_datlich` tinyint(11) NOT NULL,
  `trieuchung_datlich` varchar(300) CHARACTER SET utf8 COLLATE utf8_vietnamese_ci NOT NULL,
  `type` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_datlich`),
  KEY `fk_khachhang` (`id_khachhang`),
  KEY `fk_thucung` (`id_thucung_datlich`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `datlich`
--

INSERT INTO `datlich` (`id_datlich`, `thoigian_datlich`, `id_khachhang`, `id_thucung_datlich`, `trieuchung_datlich`, `type`) VALUES
(24, '2021-01-28', 4, 19, 'buon ngu, chong mat, dau dau ', 3),
(25, '2021-01-28', 7, 17, 'di ngu kho khan, haha', 2),
(26, '2021-01-28', 7, 17, 'chiu', 4),
(27, '2021-01-29', 4, 19, 'di ve sinh nhieu', 3),
(29, '2021-01-29', 7, 17, 'kho ngu', 2),
(30, '2021-01-30', 6, 16, 'Dau Dau', 1),
(33, '2021-01-30', 7, 17, 'Dau Dau', 1),
(34, '2021-01-31', 14, 25, 'dau dau, chan an', 3);

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

DROP TABLE IF EXISTS `khachhang`;
CREATE TABLE IF NOT EXISTS `khachhang` (
  `id_khachhang` tinyint(11) NOT NULL AUTO_INCREMENT,
  `ten_khachhang` varchar(30) CHARACTER SET utf8 COLLATE utf8_vietnamese_ci NOT NULL,
  `sdt_khachhang` varchar(12) NOT NULL,
  `diachi_khachhang` varchar(50) CHARACTER SET utf8 COLLATE utf8_vietnamese_ci NOT NULL,
  `ngaythem_khachhang` date NOT NULL,
  `ngaysua_khachhang` date DEFAULT NULL,
  `Email` varchar(96) NOT NULL,
  PRIMARY KEY (`id_khachhang`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`id_khachhang`, `ten_khachhang`, `sdt_khachhang`, `diachi_khachhang`, `ngaythem_khachhang`, `ngaysua_khachhang`, `Email`) VALUES
(4, 'phongg', '0987654321', 'hahahoeoe', '2021-01-23', '2021-01-30', 'phong2@outlook.com'),
(6, 'phongg', '0987654321', 'halo', '2021-01-26', '2021-01-26', 'phong@gmail.com'),
(7, 'dam vinh hung', '0987654321', 'oke', '2021-01-26', '2021-01-29', 'mrdam@'),
(12, 'Tran Van A', '0987654321', 'Cau Giay, Ha Noi', '2021-01-30', NULL, 'vana@gmail.com'),
(13, 'tungtran', '0374703512', 'Hn', '2021-01-30', NULL, 'tung@gmail.com'),
(14, 'tung', '0374703512', 'cau giay', '2021-01-30', '2021-01-30', 'tung@gmail.com'),
(15, 'Nguyen Duc B', '0987654321', 'Thanh Xuan, Ha Noi', '2021-01-30', NULL, 'ducnguyen@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
CREATE TABLE IF NOT EXISTS `nhanvien` (
  `id_nhanvien` tinyint(11) NOT NULL AUTO_INCREMENT,
  `fullname_nhanvien` varchar(50) NOT NULL,
  `sdt_nhanvien` varchar(12) NOT NULL,
  `email_nhanvien` varchar(96) NOT NULL,
  `pass_nhanvien` varchar(100) NOT NULL,
  `type_nhanvien` tinyint(1) NOT NULL,
  `username_nhanvien` varchar(20) NOT NULL,
  PRIMARY KEY (`id_nhanvien`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`id_nhanvien`, `fullname_nhanvien`, `sdt_nhanvien`, `email_nhanvien`, `pass_nhanvien`, `type_nhanvien`, `username_nhanvien`) VALUES
(1, 'admin', '0987654321', 'admin@gmail.com', 'ea48576f30be1669971699c09ad05c94', 1, 'admin'),
(7, 'tran hai phong', '0987654321', 'phong@meme', 'd959caadac9b13dcb3e609440135cf54', 1, 'meme'),
(9, 'daniel smith', '01324567890', 'danilel@gmail.com', '1c53f5d43ac376081922439e1cf34efd', 2, 'fojoeok'),
(12, 'leu tho tue', '0987654321', 'leu@gmail.com', 'a74298e4a259759687e3a5acb2e7ae12', 2, 'tenlatue'),
(13, 'yen nhi', '0987654321', 'nhi@gmail.com', '715bbf34cdef78e740abecc27e398ead', 1, 'nhibui'),
(16, 'phong', '0981234567', 'phong@gm', '827ccb0eea8a706c4c34a16891f84e7b', 2, 'phong123'),
(19, 'Tran Hai Phong', '0123456789', 'phong@', 'cc435cc61e91b0c2c12cdc9eb8071eb6', 2, 'phongg'),
(20, 'Luong Phanh ', '0987654321', 'phanh@gmail.com', 'f4929cdb7ceda6858828ab2e6c277974', 2, 'phanh123'),
(22, 'Nguyen Van B', '0987543212', 'nva@gmail.com', 'd959caadac9b13dcb3e609440135cf54', 2, 'nvb'),
(23, 'Nguyen Van C', '0981726354', 'vanc@gmail.com', 'ea48576f30be1669971699c09ad05c94', 2, 'nvc123'),
(25, 'Nguyen Duc A', '0987654321', 'ducnguyen@gmail.com', 'ea48576f30be1669971699c09ad05c94', 2, 'ducnguyen');

-- --------------------------------------------------------

--
-- Table structure for table `thucung`
--

DROP TABLE IF EXISTS `thucung`;
CREATE TABLE IF NOT EXISTS `thucung` (
  `id_thucung` tinyint(11) NOT NULL AUTO_INCREMENT,
  `name_thucung` varchar(30) CHARACTER SET utf8 COLLATE utf8_vietnamese_ci NOT NULL,
  `tuoi_thucung` tinyint(11) NOT NULL,
  `loaidongvat_thucung` varchar(15) CHARACTER SET utf8 COLLATE utf8_vietnamese_ci NOT NULL,
  `id_khachhang_thucung` tinyint(11) NOT NULL,
  PRIMARY KEY (`id_thucung`),
  KEY `fk_khachhang_thucung` (`id_khachhang_thucung`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `thucung`
--

INSERT INTO `thucung` (`id_thucung`, `name_thucung`, `tuoi_thucung`, `loaidongvat_thucung`, `id_khachhang_thucung`) VALUES
(16, 'monkey', 17, 'khi', 6),
(17, 'mr bin', 12, 'huou cao co', 7),
(18, 'bim', 4, 'vit', 4),
(19, 'pico', 12, 'meo', 4),
(20, 'kopi', 10, 'meo', 6),
(25, 'Pinu', 2, 'meo', 14);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chamsoc`
--
ALTER TABLE `chamsoc`
  ADD CONSTRAINT `fk_datlich` FOREIGN KEY (`id_datlich`) REFERENCES `datlich` (`id_datlich`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_nhanvien_chamsoc` FOREIGN KEY (`idnhanvien_chamsoc`) REFERENCES `nhanvien` (`id_nhanvien`) ON DELETE SET NULL ON UPDATE SET NULL;

--
-- Constraints for table `datlich`
--
ALTER TABLE `datlich`
  ADD CONSTRAINT `fk_khachhang` FOREIGN KEY (`id_khachhang`) REFERENCES `khachhang` (`id_khachhang`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_thucung` FOREIGN KEY (`id_thucung_datlich`) REFERENCES `thucung` (`id_thucung`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `thucung`
--
ALTER TABLE `thucung`
  ADD CONSTRAINT `fk_khachhang_thucung` FOREIGN KEY (`id_khachhang_thucung`) REFERENCES `khachhang` (`id_khachhang`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
