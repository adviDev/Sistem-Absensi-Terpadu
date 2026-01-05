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
    private int idJadwal;
    private int idKelas;
    private String kodeMK;
    private String nipDosen;
    private String idRuangan;
    private String hari;
    private String jamMulai;
    private String jamSelesai;
    // variabel tambahan(display)
    private String namaDosen;
    private String namaMk;
    private String namaRuangan;
    private String namaKelas;
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

    public int getIdJadwal() {
        return idJadwal;
    }

    public void setIdJadwal(int idJadwal) {
        this.idJadwal = idJadwal;
    }

    public int getIdKelas() {
        return idKelas;
    }

    public void setIdKelas(int idKelas) {
        this.idKelas = idKelas;
    }

    public String getKodeMK() {
        return kodeMK;
    }

    public void setKodeMK(String kodeMK) {
        this.kodeMK = kodeMK;
    }

    public String getNipDosen() {
        return nipDosen;
    }

    public void setNipDosen(String nipDosen) {
        this.nipDosen = nipDosen;
    }

    public String getIdRuangan() {
        return idRuangan;
    }

    public void setIdRuangan(String idRuangan) {
        this.idRuangan = idRuangan;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getJamMulai() {
        return jamMulai;
    }

    public void setJamMulai(String jamMulai) {
        this.jamMulai = jamMulai;
    }

    public String getJamSelesai() {
        return jamSelesai;
    }

    public void setJamSelesai(String jamSelesai) {
        this.jamSelesai = jamSelesai;
    }

    public String getNamaDosen() {
        return namaDosen;
    }

    public void setNamaDosen(String namaDosen) {
        this.namaDosen = namaDosen;
    }

    public String getNamaMk() {
        return namaMk;
    }

    public void setNamaMk(String namaMk) {
        this.namaMk = namaMk;
    }

    public String getNamaRuangan() {
        return namaRuangan;
    }

    public void setNamaRuangan(String namaRuangan) {
        this.namaRuangan = namaRuangan;
    }

    public String getNamaKelas() {
        return namaKelas;
    }

    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }

    
}
