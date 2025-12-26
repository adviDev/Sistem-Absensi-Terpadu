# Sistem Absensi & Administrasi Akademik Terpadu

Aplikasi desktop berbasis Java untuk pengelolaan administrasi akademik kampus dengan sistem "Kuliah Paket" (Fixed Schedule). Aplikasi ini dirancang untuk mempermudah manajemen jadwal, validasi ketersediaan ruangan secara real-time, dan pencatatan absensi mahasiswa.

## 🚀 Fitur Utama

* **Manajemen Master Data:** Pengelolaan data Mahasiswa, Dosen, Mata Kuliah, dan Ruangan.
* **Penjadwalan Sistem Paket:** Penentuan jadwal kuliah yang terkunci berdasarkan Kelas (bukan KRS perorangan).
* **Cek Ketersediaan Ruangan:** Fitur untuk melihat status ruangan (Kosong/Terpakai) secara *real-time* untuk menghindari bentrok.
* **Manajemen Perubahan Jadwal:** Penanganan dosen yang ingin memindahkan jadwal (Reschedule) atau mengganti kelas kosong.
* **Absensi Otomatis:** Generate daftar hadir otomatis berdasarkan siswa yang terdaftar dalam satu kelas paket.

## 🛠️ Teknologi yang Digunakan

* **Bahasa Pemrograman:** Java (JDK 17+)
* **GUI Framework:** Java Swing (JFrame)
* **Database:** MySQL / MariaDB
* **Driver:** MySQL JDBC Connector
* **Konsep:** MVC (Model-View-Controller) & DAO (Data Access Object) Pattern

## 📦 Cara Instalasi & Menjalankan

1.  **Clone Repositori**
    ```bash
    git clone [https://github.com/adviDev/sistem-absensi-terpadu.git](https://github.com/adviDev/sistem-absensi-terpadu.git)
    ```
2.  **Import Database**
    * Buka phpMyAdmin atau tool database lainnya.
    * Buat database baru dengan nama `db_presensi_terpadu`.
    * Import file `database.sql` yang ada di folder `sql/` (Pastikan Anda menyertakan file SQL Anda nanti).
3.  **Konfigurasi Koneksi**
    * Buka file `src/com/kampus/app/config/Koneksi.java`.
    * Sesuaikan username dan password database lokal Anda.
4.  **Run Aplikasi**
    * Jalankan file `MainApp.java` melalui IDE (NetBeans/IntelliJ).

## 📝 Status Proyek
Proyek ini dikembangkan sebagai bagian dari studi kasus pengembangan aplikasi Java Desktop dengan koneksi database MySQL Native.
