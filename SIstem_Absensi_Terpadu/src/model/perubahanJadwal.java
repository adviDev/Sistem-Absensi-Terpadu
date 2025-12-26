/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author user
 */
public class perubahanJadwal {
    private static int idPerubahan;
    private static int idJadwal;
    private static String tanggalBaru;
    private static String jamMulaiBaru;
    private static String jamSelesaiBaru;
    private static String idRuanganBaru;
    private static String status;

    public perubahanJadwal() {
    }

    public perubahanJadwal(int idPerubahan, int idJadwal, String tanggalBaru, String jamMulaiBaru,String jamSelesaiBaru, String idRuanganBaru, String status) {
        this.idPerubahan=idPerubahan;
        this.idJadwal=idJadwal;
        this.tanggalBaru=tanggalBaru;
        this.jamMulaiBaru=jamMulaiBaru;
        this.jamSelesaiBaru=jamSelesaiBaru;
        this.idRuanganBaru=idRuanganBaru;
        this.status=status;
    }

    public static int getIdPerubahan() {
        return idPerubahan;
    }

    public static void setIdPerubahan(int idPerubahan) {
        perubahanJadwal.idPerubahan = idPerubahan;
    }

    public static int getIdJadwal() {
        return idJadwal;
    }

    public static void setIdJadwal(int idJadwal) {
        perubahanJadwal.idJadwal = idJadwal;
    }

    public static String getTanggalBaru() {
        return tanggalBaru;
    }

    public static void setTanggalBaru(String tanggalBaru) {
        perubahanJadwal.tanggalBaru = tanggalBaru;
    }

    public static String getJamMulaiBaru() {
        return jamMulaiBaru;
    }

    public static void setJamMulaiBaru(String jamMulaiBaru) {
        perubahanJadwal.jamMulaiBaru = jamMulaiBaru;
    }

    public static String getJamSelesaiBaru() {
        return jamSelesaiBaru;
    }

    public static void setJamSelesaiBaru(String jamSelesaiBaru) {
        perubahanJadwal.jamSelesaiBaru = jamSelesaiBaru;
    }

    public static String getIdRuanganBaru() {
        return idRuanganBaru;
    }

    public static void setIdRuanganBaru(String idRuanganBaru) {
        perubahanJadwal.idRuanganBaru = idRuanganBaru;
    }

    public static String getStatus() {
        return status;
    }

    public static void setStatus(String status) {
        perubahanJadwal.status = status;
    }
    
    }
