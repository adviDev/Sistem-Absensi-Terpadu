/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author user
 */
public class sesiAbsensi {
    private static int idSesi;
    private static int idJadwal;
    private static String tanggal;
    private static String waktuMulai;
    private static String idRuanganAktual;

    public sesiAbsensi(int idSesi, int idJadwal, String tanggal, String waktuMulai, String idRuanganAktual) {
        this.idSesi = idSesi;
        this.idJadwal=idJadwal;
        this.tanggal = tanggal;
        this.waktuMulai=waktuMulai;
        this.idRuanganAktual=idRuanganAktual;
    }

    public static int getIdSesi() {
        return idSesi;
    }

    public static void setIdSesi(int idSesi) {
        sesiAbsensi.idSesi = idSesi;
    }

    public static int getIdJadwal() {
        return idJadwal;
    }

    public static void setIdJadwal(int idJadwal) {
        sesiAbsensi.idJadwal = idJadwal;
    }

    public static String getTanggal() {
        return tanggal;
    }

    public static void setTanggal(String tanggal) {
        sesiAbsensi.tanggal = tanggal;
    }

    public static String getWaktuMulai() {
        return waktuMulai;
    }

    public static void setWaktuMulai(String waktuMulai) {
        sesiAbsensi.waktuMulai = waktuMulai;
    }

    public static String getIdRuanganAktual() {
        return idRuanganAktual;
    }

    public static void setIdRuanganAktual(String idRuanganAktual) {
        sesiAbsensi.idRuanganAktual = idRuanganAktual;
    }
    
}
