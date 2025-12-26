-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Dec 26, 2025 at 07:20 AM
-- Server version: 8.0.44
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_presensi_terpadu`
--

-- --------------------------------------------------------

--
-- Table structure for table `anggota_kelas`
--

CREATE TABLE `anggota_kelas` (
  `id_kelas` int NOT NULL,
  `nim` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `detail_absensi`
--

CREATE TABLE `detail_absensi` (
  `id_detail` int NOT NULL,
  `id_sesi` int DEFAULT NULL,
  `nim` varchar(20) DEFAULT NULL,
  `status_kehadiran` enum('Hadir','Sakit','Izin','Alpa') DEFAULT 'Alpa',
  `waktu_scan` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `dosen`
--

CREATE TABLE `dosen` (
  `nip` varchar(20) NOT NULL,
  `nama_dosen` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `jadwal_kuliah`
--

CREATE TABLE `jadwal_kuliah` (
  `id_jadwal` int NOT NULL,
  `id_kelas` int DEFAULT NULL,
  `kode_mk` varchar(10) DEFAULT NULL,
  `nip_dosen` varchar(20) DEFAULT NULL,
  `id_ruangan` varchar(10) DEFAULT NULL,
  `hari` enum('Senin','Selasa','Rabu','Kamis','Jumat','Sabtu') DEFAULT NULL,
  `jam_mulai` time DEFAULT NULL,
  `jam_selesai` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `kelas`
--

CREATE TABLE `kelas` (
  `id_kelas` int NOT NULL,
  `nama_kelas` varchar(20) DEFAULT NULL,
  `semester_tingkat` int DEFAULT NULL,
  `id_tahun` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `nim` varchar(20) NOT NULL,
  `nama_mahasiswa` varchar(100) DEFAULT NULL,
  `angkatan` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `mata_kuliah`
--

CREATE TABLE `mata_kuliah` (
  `kode_mk` varchar(10) NOT NULL,
  `nama_mk` varchar(100) DEFAULT NULL,
  `sks` int DEFAULT NULL,
  `semester_paket` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `perubahan_jadwal`
--

CREATE TABLE `perubahan_jadwal` (
  `id_perubahan` int NOT NULL,
  `id_jadwal` int DEFAULT NULL,
  `tanggal_baru` date DEFAULT NULL,
  `jam_mulai_baru` time DEFAULT NULL,
  `jam_selesai_baru` time DEFAULT NULL,
  `id_ruangan_baru` varchar(10) DEFAULT NULL,
  `status` enum('disetujui','menunggu','batal') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ruangan`
--

CREATE TABLE `ruangan` (
  `id_ruangan` varchar(10) NOT NULL,
  `nama_ruangan` varchar(50) DEFAULT NULL,
  `kapasitas` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `sesi_absensi`
--

CREATE TABLE `sesi_absensi` (
  `id_sesi` int NOT NULL,
  `id_jadwal` int DEFAULT NULL,
  `tanggal` date DEFAULT NULL,
  `waktu_mulai` datetime DEFAULT CURRENT_TIMESTAMP,
  `id_ruangan_aktual` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tahun_akademik`
--

CREATE TABLE `tahun_akademik` (
  `id_tahun` int NOT NULL,
  `nama_semester` varchar(20) DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id_user` int NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` enum('admin','dosen','mahasiswa') NOT NULL,
  `is_active` tinyint(1) DEFAULT '1',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `anggota_kelas`
--
ALTER TABLE `anggota_kelas`
  ADD PRIMARY KEY (`id_kelas`,`nim`),
  ADD KEY `nim` (`nim`);

--
-- Indexes for table `detail_absensi`
--
ALTER TABLE `detail_absensi`
  ADD PRIMARY KEY (`id_detail`),
  ADD KEY `id_sesi` (`id_sesi`),
  ADD KEY `nim` (`nim`);

--
-- Indexes for table `dosen`
--
ALTER TABLE `dosen`
  ADD PRIMARY KEY (`nip`);

--
-- Indexes for table `jadwal_kuliah`
--
ALTER TABLE `jadwal_kuliah`
  ADD PRIMARY KEY (`id_jadwal`),
  ADD KEY `id_kelas` (`id_kelas`),
  ADD KEY `kode_mk` (`kode_mk`),
  ADD KEY `nip_dosen` (`nip_dosen`),
  ADD KEY `id_ruangan` (`id_ruangan`);

--
-- Indexes for table `kelas`
--
ALTER TABLE `kelas`
  ADD PRIMARY KEY (`id_kelas`),
  ADD KEY `id_tahun` (`id_tahun`);

--
-- Indexes for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`nim`);

--
-- Indexes for table `mata_kuliah`
--
ALTER TABLE `mata_kuliah`
  ADD PRIMARY KEY (`kode_mk`);

--
-- Indexes for table `perubahan_jadwal`
--
ALTER TABLE `perubahan_jadwal`
  ADD PRIMARY KEY (`id_perubahan`),
  ADD KEY `id_jadwal` (`id_jadwal`),
  ADD KEY `id_ruangan_baru` (`id_ruangan_baru`);

--
-- Indexes for table `ruangan`
--
ALTER TABLE `ruangan`
  ADD PRIMARY KEY (`id_ruangan`);

--
-- Indexes for table `sesi_absensi`
--
ALTER TABLE `sesi_absensi`
  ADD PRIMARY KEY (`id_sesi`),
  ADD KEY `id_jadwal` (`id_jadwal`);

--
-- Indexes for table `tahun_akademik`
--
ALTER TABLE `tahun_akademik`
  ADD PRIMARY KEY (`id_tahun`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `detail_absensi`
--
ALTER TABLE `detail_absensi`
  MODIFY `id_detail` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `jadwal_kuliah`
--
ALTER TABLE `jadwal_kuliah`
  MODIFY `id_jadwal` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `kelas`
--
ALTER TABLE `kelas`
  MODIFY `id_kelas` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `perubahan_jadwal`
--
ALTER TABLE `perubahan_jadwal`
  MODIFY `id_perubahan` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `sesi_absensi`
--
ALTER TABLE `sesi_absensi`
  MODIFY `id_sesi` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tahun_akademik`
--
ALTER TABLE `tahun_akademik`
  MODIFY `id_tahun` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id_user` int NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `anggota_kelas`
--
ALTER TABLE `anggota_kelas`
  ADD CONSTRAINT `anggota_kelas_ibfk_1` FOREIGN KEY (`id_kelas`) REFERENCES `kelas` (`id_kelas`) ON DELETE CASCADE,
  ADD CONSTRAINT `anggota_kelas_ibfk_2` FOREIGN KEY (`nim`) REFERENCES `mahasiswa` (`nim`) ON DELETE CASCADE;

--
-- Constraints for table `detail_absensi`
--
ALTER TABLE `detail_absensi`
  ADD CONSTRAINT `detail_absensi_ibfk_1` FOREIGN KEY (`id_sesi`) REFERENCES `sesi_absensi` (`id_sesi`),
  ADD CONSTRAINT `detail_absensi_ibfk_2` FOREIGN KEY (`nim`) REFERENCES `mahasiswa` (`nim`);

--
-- Constraints for table `jadwal_kuliah`
--
ALTER TABLE `jadwal_kuliah`
  ADD CONSTRAINT `jadwal_kuliah_ibfk_1` FOREIGN KEY (`id_kelas`) REFERENCES `kelas` (`id_kelas`) ON DELETE CASCADE,
  ADD CONSTRAINT `jadwal_kuliah_ibfk_2` FOREIGN KEY (`kode_mk`) REFERENCES `mata_kuliah` (`kode_mk`),
  ADD CONSTRAINT `jadwal_kuliah_ibfk_3` FOREIGN KEY (`nip_dosen`) REFERENCES `dosen` (`nip`),
  ADD CONSTRAINT `jadwal_kuliah_ibfk_4` FOREIGN KEY (`id_ruangan`) REFERENCES `ruangan` (`id_ruangan`);

--
-- Constraints for table `kelas`
--
ALTER TABLE `kelas`
  ADD CONSTRAINT `kelas_ibfk_1` FOREIGN KEY (`id_tahun`) REFERENCES `tahun_akademik` (`id_tahun`);

--
-- Constraints for table `perubahan_jadwal`
--
ALTER TABLE `perubahan_jadwal`
  ADD CONSTRAINT `perubahan_jadwal_ibfk_1` FOREIGN KEY (`id_jadwal`) REFERENCES `jadwal_kuliah` (`id_jadwal`),
  ADD CONSTRAINT `perubahan_jadwal_ibfk_2` FOREIGN KEY (`id_ruangan_baru`) REFERENCES `ruangan` (`id_ruangan`);

--
-- Constraints for table `sesi_absensi`
--
ALTER TABLE `sesi_absensi`
  ADD CONSTRAINT `sesi_absensi_ibfk_1` FOREIGN KEY (`id_jadwal`) REFERENCES `jadwal_kuliah` (`id_jadwal`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
