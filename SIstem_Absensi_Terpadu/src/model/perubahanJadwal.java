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
    private int idPerubahan;
    private int idJadwal;
    private String tanggalBaru;
    private String jamMulaiBaru;
    private String jamSelesaiBaru;
    private String idRuanganBaru;
    private String status;

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

    public int getIdPerubahan() {
        return idPerubahan;
    }

    public void setIdPerubahan(int idPerubahan) {
        this.idPerubahan = idPerubahan;
    }

    public int getIdJadwal() {
        return idJadwal;
    }

    public void setIdJadwal(int idJadwal) {
        this.idJadwal = idJadwal;
    }

    public String getTanggalBaru() {
        return tanggalBaru;
    }

    public void setTanggalBaru(String tanggalBaru) {
        this.tanggalBaru = tanggalBaru;
    }

    public String getJamMulaiBaru() {
        return jamMulaiBaru;
    }

    public void setJamMulaiBaru(String jamMulaiBaru) {
        this.jamMulaiBaru = jamMulaiBaru;
    }

    public String getJamSelesaiBaru() {
        return jamSelesaiBaru;
    }

    public void setJamSelesaiBaru(String jamSelesaiBaru) {
        this.jamSelesaiBaru = jamSelesaiBaru;
    }

    public String getIdRuanganBaru() {
        return idRuanganBaru;
    }

    public void setIdRuanganBaru(String idRuanganBaru) {
        this.idRuanganBaru = idRuanganBaru;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    }
