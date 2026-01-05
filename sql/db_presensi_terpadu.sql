-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Dec 26, 2025 at 03:35 PM
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

--
-- Dumping data for table `anggota_kelas`
--

INSERT INTO `anggota_kelas` (`id_kelas`, `nim`) VALUES
(1, '230001'),
(1, '230002'),
(1, '230003'),
(1, '230004'),
(1, '230005'),
(1, '230006'),
(1, '230007'),
(1, '230008'),
(1, '230009'),
(1, '230010'),
(1, '230011'),
(1, '230012'),
(1, '230013'),
(1, '230014'),
(1, '230015'),
(1, '230016'),
(1, '230017'),
(1, '230018'),
(1, '230019'),
(1, '230020'),
(1, '230021'),
(1, '230022'),
(1, '230023'),
(1, '230024'),
(1, '230025'),
(1, '230026'),
(1, '230027'),
(1, '230028'),
(1, '230029'),
(1, '230030'),
(2, '230031'),
(2, '230032'),
(2, '230033'),
(2, '230034'),
(2, '230035'),
(2, '230036'),
(2, '230037'),
(2, '230038'),
(2, '230039'),
(2, '230040'),
(2, '230041'),
(2, '230042'),
(2, '230043'),
(2, '230044'),
(2, '230045'),
(2, '230046'),
(2, '230047'),
(2, '230048'),
(2, '230049'),
(2, '230050'),
(2, '230051'),
(2, '230052'),
(2, '230053'),
(2, '230054'),
(2, '230055'),
(2, '230056'),
(2, '230057'),
(2, '230058'),
(2, '230059'),
(2, '230060'),
(3, '230061'),
(3, '230062'),
(3, '230063'),
(3, '230064'),
(3, '230065'),
(3, '230066'),
(3, '230067'),
(3, '230068'),
(3, '230069'),
(3, '230070'),
(3, '230071'),
(3, '230072'),
(3, '230073'),
(3, '230074'),
(3, '230075'),
(3, '230076'),
(3, '230077'),
(3, '230078'),
(3, '230079'),
(3, '230080'),
(3, '230081'),
(3, '230082'),
(3, '230083'),
(3, '230084'),
(3, '230085'),
(3, '230086'),
(3, '230087'),
(3, '230088'),
(3, '230089'),
(3, '230090');

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

--
-- Dumping data for table `dosen`
--

INSERT INTO `dosen` (`nip`, `nama_dosen`) VALUES
('19800101', 'Dosen 1'),
('19800102', 'Dosen 2'),
('19800103', 'Dosen 3'),
('19800104', 'Dosen 4'),
('19800105', 'Dosen 5'),
('19800106', 'Dosen 6'),
('19800107', 'Dosen 7'),
('19800108', 'Dosen 8'),
('19800109', 'Dosen 9'),
('19800110', 'Dosen 10');

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

--
-- Dumping data for table `jadwal_kuliah`
--

INSERT INTO `jadwal_kuliah` (`id_jadwal`, `id_kelas`, `kode_mk`, `nip_dosen`, `id_ruangan`, `hari`, `jam_mulai`, `jam_selesai`) VALUES
(1, 1, 'TIF301', '19800101', '1', 'Senin', '08:00:00', '10:30:00'),
(2, 1, 'TIF302', '19800102', '2', 'Selasa', '10:30:00', '13:00:00'),
(3, 1, 'TIF303', '19800103', '3', 'Rabu', '08:00:00', '10:30:00'),
(4, 1, 'TIF304', '19800104', '4', 'Kamis', '13:00:00', '15:30:00'),
(5, 1, 'TIF305', '19800105', '5', 'Jumat', '08:00:00', '10:30:00'),
(6, 2, 'TIF301', '19800101', '1', 'Senin', '10:30:00', '13:00:00'),
(7, 2, 'TIF302', '19800102', '2', 'Selasa', '13:00:00', '15:30:00'),
(8, 2, 'TIF306', '19800106', '6', 'Rabu', '08:00:00', '10:30:00'),
(9, 2, 'TIF307', '19800107', '7', 'Kamis', '10:30:00', '12:30:00'),
(10, 2, 'TIF303', '19800103', '3', 'Jumat', '13:00:00', '15:30:00'),
(11, 3, 'TIF304', '19800104', '4', 'Senin', '13:00:00', '15:30:00'),
(12, 3, 'TIF305', '19800105', '5', 'Selasa', '08:00:00', '10:30:00'),
(13, 3, 'TIF306', '19800106', '6', 'Rabu', '13:00:00', '15:30:00'),
(14, 3, 'TIF308', '19800108', '8', 'Kamis', '08:00:00', '10:30:00'),
(15, 3, 'TIF302', '19800102', '2', 'Jumat', '10:30:00', '13:00:00');

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

--
-- Dumping data for table `kelas`
--

INSERT INTO `kelas` (`id_kelas`, `nama_kelas`, `semester_tingkat`, `id_tahun`) VALUES
(1, '3A-TIF', 3, 1),
(2, '3B-TIF', 3, 1),
(3, '3C-TIF', 3, 1);

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `nim` varchar(20) NOT NULL,
  `nama_mahasiswa` varchar(100) DEFAULT NULL,
  `angkatan` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `mahasiswa`
--

INSERT INTO `mahasiswa` (`nim`, `nama_mahasiswa`, `angkatan`) VALUES
('230001', 'Mahasiswa 3A-01', 2023),
('230002', 'Mahasiswa 3A-02', 2023),
('230003', 'Mahasiswa 3A-03', 2023),
('230004', 'Mahasiswa 3A-04', 2023),
('230005', 'Mahasiswa 3A-05', 2023),
('230006', 'Mahasiswa 3A-06', 2023),
('230007', 'Mahasiswa 3A-07', 2023),
('230008', 'Mahasiswa 3A-08', 2023),
('230009', 'Mahasiswa 3A-09', 2023),
('230010', 'Mahasiswa 3A-10', 2023),
('230011', 'Mahasiswa 3A-11', 2023),
('230012', 'Mahasiswa 3A-12', 2023),
('230013', 'Mahasiswa 3A-13', 2023),
('230014', 'Mahasiswa 3A-14', 2023),
('230015', 'Mahasiswa 3A-15', 2023),
('230016', 'Mahasiswa 3A-16', 2023),
('230017', 'Mahasiswa 3A-17', 2023),
('230018', 'Mahasiswa 3A-18', 2023),
('230019', 'Mahasiswa 3A-19', 2023),
('230020', 'Mahasiswa 3A-20', 2023),
('230021', 'Mahasiswa 3A-21', 2023),
('230022', 'Mahasiswa 3A-22', 2023),
('230023', 'Mahasiswa 3A-23', 2023),
('230024', 'Mahasiswa 3A-24', 2023),
('230025', 'Mahasiswa 3A-25', 2023),
('230026', 'Mahasiswa 3A-26', 2023),
('230027', 'Mahasiswa 3A-27', 2023),
('230028', 'Mahasiswa 3A-28', 2023),
('230029', 'Mahasiswa 3A-29', 2023),
('230030', 'Mahasiswa 3A-30', 2023),
('230031', 'Mahasiswa 3B-01', 2023),
('230032', 'Mahasiswa 3B-02', 2023),
('230033', 'Mahasiswa 3B-03', 2023),
('230034', 'Mahasiswa 3B-04', 2023),
('230035', 'Mahasiswa 3B-05', 2023),
('230036', 'Mahasiswa 3B-06', 2023),
('230037', 'Mahasiswa 3B-07', 2023),
('230038', 'Mahasiswa 3B-08', 2023),
('230039', 'Mahasiswa 3B-09', 2023),
('230040', 'Mahasiswa 3B-10', 2023),
('230041', 'Mahasiswa 3B-11', 2023),
('230042', 'Mahasiswa 3B-12', 2023),
('230043', 'Mahasiswa 3B-13', 2023),
('230044', 'Mahasiswa 3B-14', 2023),
('230045', 'Mahasiswa 3B-15', 2023),
('230046', 'Mahasiswa 3B-16', 2023),
('230047', 'Mahasiswa 3B-17', 2023),
('230048', 'Mahasiswa 3B-18', 2023),
('230049', 'Mahasiswa 3B-19', 2023),
('230050', 'Mahasiswa 3B-20', 2023),
('230051', 'Mahasiswa 3B-21', 2023),
('230052', 'Mahasiswa 3B-22', 2023),
('230053', 'Mahasiswa 3B-23', 2023),
('230054', 'Mahasiswa 3B-24', 2023),
('230055', 'Mahasiswa 3B-25', 2023),
('230056', 'Mahasiswa 3B-26', 2023),
('230057', 'Mahasiswa 3B-27', 2023),
('230058', 'Mahasiswa 3B-28', 2023),
('230059', 'Mahasiswa 3B-29', 2023),
('230060', 'Mahasiswa 3B-30', 2023),
('230061', 'Mahasiswa 3C-01', 2023),
('230062', 'Mahasiswa 3C-02', 2023),
('230063', 'Mahasiswa 3C-03', 2023),
('230064', 'Mahasiswa 3C-04', 2023),
('230065', 'Mahasiswa 3C-05', 2023),
('230066', 'Mahasiswa 3C-06', 2023),
('230067', 'Mahasiswa 3C-07', 2023),
('230068', 'Mahasiswa 3C-08', 2023),
('230069', 'Mahasiswa 3C-09', 2023),
('230070', 'Mahasiswa 3C-10', 2023),
('230071', 'Mahasiswa 3C-11', 2023),
('230072', 'Mahasiswa 3C-12', 2023),
('230073', 'Mahasiswa 3C-13', 2023),
('230074', 'Mahasiswa 3C-14', 2023),
('230075', 'Mahasiswa 3C-15', 2023),
('230076', 'Mahasiswa 3C-16', 2023),
('230077', 'Mahasiswa 3C-17', 2023),
('230078', 'Mahasiswa 3C-18', 2023),
('230079', 'Mahasiswa 3C-19', 2023),
('230080', 'Mahasiswa 3C-20', 2023),
('230081', 'Mahasiswa 3C-21', 2023),
('230082', 'Mahasiswa 3C-22', 2023),
('230083', 'Mahasiswa 3C-23', 2023),
('230084', 'Mahasiswa 3C-24', 2023),
('230085', 'Mahasiswa 3C-25', 2023),
('230086', 'Mahasiswa 3C-26', 2023),
('230087', 'Mahasiswa 3C-27', 2023),
('230088', 'Mahasiswa 3C-28', 2023),
('230089', 'Mahasiswa 3C-29', 2023),
('230090', 'Mahasiswa 3C-30', 2023);

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

--
-- Dumping data for table `mata_kuliah`
--

INSERT INTO `mata_kuliah` (`kode_mk`, `nama_mk`, `sks`, `semester_paket`) VALUES
('TIF301', 'Pemrograman Berorientasi Objek', 3, 3),
('TIF302', 'Basis Data Lanjut', 3, 3),
('TIF303', 'Jaringan Komputer', 3, 3),
('TIF304', 'Sistem Operasi', 3, 3),
('TIF305', 'Rekayasa Perangkat Lunak', 3, 3),
('TIF306', 'Pemrograman Web', 3, 3),
('TIF307', 'Interaksi Manusia dan Komputer', 2, 3),
('TIF308', 'Kecerdasan Buatan', 3, 3);

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

--
-- Dumping data for table `ruangan`
--

INSERT INTO `ruangan` (`id_ruangan`, `nama_ruangan`, `kapasitas`) VALUES
('1', 'Ruang 101', 40),
('10', 'Aula', 100),
('2', 'Ruang 102', 40),
('3', 'Ruang 103', 40),
('4', 'Ruang 104', 40),
('5', 'Ruang 105', 40),
('6', 'Lab 1', 30),
('7', 'Lab 2', 30),
('8', 'Lab 3', 30),
('9', 'Lab 4', 30);

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

--
-- Dumping data for table `tahun_akademik`
--

INSERT INTO `tahun_akademik` (`id_tahun`, `nama_semester`, `is_active`) VALUES
(1, '2025/2026', 1);

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
  MODIFY `id_jadwal` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `kelas`
--
ALTER TABLE `kelas`
  MODIFY `id_kelas` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

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
  MODIFY `id_tahun` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

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
