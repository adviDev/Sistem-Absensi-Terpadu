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
    private int idSesi;
    private int idJadwal;
    private String tanggal;
    private String waktuMulai;
    private String idRuanganAktual;

    public sesiAbsensi() {
    }

    public sesiAbsensi(int idSesi, int idJadwal, String tanggal, String waktuMulai, String idRuanganAktual) {
        this.idSesi = idSesi;
        this.idJadwal=idJadwal;
        this.tanggal = tanggal;
        this.waktuMulai=waktuMulai;
        this.idRuanganAktual=idRuanganAktual;
    }

    public int getIdSesi() {
        return idSesi;
    }

    public void setIdSesi(int idSesi) {
        this.idSesi = idSesi;
    }

    public int getIdJadwal() {
        return idJadwal;
    }

    public void setIdJadwal(int idJadwal) {
        this.idJadwal = idJadwal;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getWaktuMulai() {
        return waktuMulai;
    }

    public void setWaktuMulai(String waktuMulai) {
        this.waktuMulai = waktuMulai;
    }

    public String getIdRuanganAktual() {
        return idRuanganAktual;
    }

    public void setIdRuanganAktual(String idRuanganAktual) {
        this.idRuanganAktual = idRuanganAktual;
    }

    
}
