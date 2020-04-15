-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 15, 2020 at 02:23 AM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `perpustakaan`
--

-- --------------------------------------------------------

--
-- Table structure for table `anggota`
--

CREATE TABLE `anggota` (
  `nis` varchar(10) NOT NULL,
  `namas` varchar(100) NOT NULL,
  `ttl` date NOT NULL,
  `jk` varchar(20) NOT NULL,
  `agama` varchar(20) NOT NULL,
  `kelas` varchar(5) NOT NULL,
  `daftar` date NOT NULL,
  `berlaku` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `anggota`
--

INSERT INTO `anggota` (`nis`, `namas`, `ttl`, `jk`, `agama`, `kelas`, `daftar`, `berlaku`) VALUES
('123', 'jungwoo', '1998-12-12', 'Laki-laki', 'Kristen', 'D', '2020-04-12', '2020-06-12'),
('124', 'haechan', '2000-02-09', 'Laki-laki', 'Katolik', 'B', '2020-03-13', '2020-05-13'),
('245', 'mark lee', '1999-11-25', 'Laki-laki', 'Katolik', 'A', '2020-11-12', '2021-01-12');

-- --------------------------------------------------------

--
-- Table structure for table `buku`
--

CREATE TABLE `buku` (
  `kode` varchar(10) NOT NULL,
  `namab` varchar(100) NOT NULL,
  `pengarang` varchar(100) NOT NULL,
  `penerbit` varchar(100) NOT NULL,
  `terbit` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `buku`
--

INSERT INTO `buku` (`kode`, `namab`, `pengarang`, `penerbit`, `terbit`) VALUES
('111', 'matematika', 'anto', 'gramedia', 2016),
('222', 'biologi', 'dwi', 'grahamedia', 2020),
('444', 'apaya lupa', 'haha', 'hihi', 2019);

-- --------------------------------------------------------

--
-- Table structure for table `karyawan`
--

CREATE TABLE `karyawan` (
  `nik` varchar(10) NOT NULL,
  `namak` varchar(100) NOT NULL,
  `jk` varchar(20) NOT NULL,
  `golongan` int(5) NOT NULL,
  `jabatan` varchar(20) NOT NULL,
  `tunjangan` int(20) NOT NULL,
  `gaji` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `karyawan`
--

INSERT INTO `karyawan` (`nik`, `namak`, `jk`, `golongan`, `jabatan`, `tunjangan`, `gaji`) VALUES
('566', 'eli', 'Perempuan', 3, 'Staff TU', 2500000, 7800000),
('789', 'jiji', 'Perempuan', 1, 'Manager', 8000000, 10000000),
('900', 'uiui', 'Laki-laki', 2, 'Pustakawan Penyelia', 4000000, 6700000);

-- --------------------------------------------------------

--
-- Table structure for table `peminjaman`
--

CREATE TABLE `peminjaman` (
  `no` varchar(10) NOT NULL,
  `nis` varchar(10) NOT NULL,
  `namas` varchar(100) NOT NULL,
  `kelas` varchar(5) NOT NULL,
  `kode` varchar(10) NOT NULL,
  `namab` varchar(100) NOT NULL,
  `penerbit` varchar(100) NOT NULL,
  `pinjam` date NOT NULL,
  `kembali` date NOT NULL,
  `lamapinjam` int(10) NOT NULL,
  `denda` int(20) NOT NULL,
  `nik` varchar(10) NOT NULL,
  `namak` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `anggota`
--
ALTER TABLE `anggota`
  ADD PRIMARY KEY (`nis`);

--
-- Indexes for table `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`kode`);

--
-- Indexes for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`nik`);

--
-- Indexes for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD PRIMARY KEY (`no`),
  ADD KEY `nis` (`nis`),
  ADD KEY `kode` (`kode`),
  ADD KEY `nik` (`nik`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD CONSTRAINT `peminjaman_ibfk_1` FOREIGN KEY (`nis`) REFERENCES `anggota` (`nis`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `peminjaman_ibfk_2` FOREIGN KEY (`nik`) REFERENCES `karyawan` (`nik`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `peminjaman_ibfk_3` FOREIGN KEY (`kode`) REFERENCES `buku` (`kode`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
