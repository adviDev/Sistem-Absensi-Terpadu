/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author user
 */
public class jadwalKuliah {
    // variabel default dalam tabel
    private static int idJadwal;
    private static int idKelas;
    private static String kodeMK;
    private static String nipDosen;
    private static String idRuangan;
    private static String hari;
    private static String jamMulai;
    private static String jamSelesai;
    // variabel tambahan(display)
    private static String namaDosen;
    private static String namaMk;
    private static String namaRuangan;
    private static String namaKelas;
    public jadwalKuliah() {
    }

    public jadwalKuliah(int idJadwal,int idKelas,String kodeMK, String nipDosen,String idRuangan,String hari, String jamMulai,String jamSelesai) {
        this.idJadwal = idJadwal;
        this.idKelas = idKelas;
        this.kodeMK = kodeMK;
        this.nipDosen = nipDosen;
        this.idRuangan = idRuangan;
        this.hari = hari;
        this.jamMulai=jamMulai;
        this.jamSelesai=jamSelesai;
    }

    public static int getIdJadwal() {
        return idJadwal;
    }

    public static void setIdJadwal(int idJadwal) {
        jadwalKuliah.idJadwal = idJadwal;
    }

    public static int getIdKelas() {
        return idKelas;
    }

    public static void setIdKelas(int idKelas) {
        jadwalKuliah.idKelas = idKelas;
    }

    public static String getKodeMK() {
        return kodeMK;
    }

    public static void setKodeMK(String kodeMK) {
        jadwalKuliah.kodeMK = kodeMK;
    }

    public static String getNipDosen() {
        return nipDosen;
    }

    public static void setNipDosen(String nipDosen) {
        jadwalKuliah.nipDosen = nipDosen;
    }

    public static String getIdRuangan() {
        return idRuangan;
    }

    public static void setIdRuangan(String idRuangan) {
        jadwalKuliah.idRuangan = idRuangan;
    }

    public static String getHari() {
        return hari;
    }

    public static void setHari(String hari) {
        jadwalKuliah.hari = hari;
    }

    public static String getJamMulai() {
        return jamMulai;
    }

    public static void setJamMulai(String jamMulai) {
        jadwalKuliah.jamMulai = jamMulai;
    }

    public static String getJamSelesai() {
        return jamSelesai;
    }

    public static void setJamSelesai(String jamSelesai) {
        jadwalKuliah.jamSelesai = jamSelesai;
    }

    public static String getNamaDosen() {
        return namaDosen;
    }

    public static void setNamaDosen(String namaDosen) {
        jadwalKuliah.namaDosen = namaDosen;
    }

    public static String getNamaMk() {
        return namaMk;
    }

    public static void setNamaMk(String namaMk) {
        jadwalKuliah.namaMk = namaMk;
    }

    public static String getNamaRuangan() {
        return namaRuangan;
    }

    public static void setNamaRuangan(String namaRuangan) {
        jadwalKuliah.namaRuangan = namaRuangan;
    }

    public static String getNamaKelas() {
        return namaKelas;
    }

    public static void setNamaKelas(String namaKelas) {
        jadwalKuliah.namaKelas = namaKelas;
    }
    
    
    
}
