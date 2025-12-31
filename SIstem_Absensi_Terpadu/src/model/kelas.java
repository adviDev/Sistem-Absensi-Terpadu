/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author user
 */
public class kelas {
    private int idKelas;
    private String namaKelas;
    private int semesterTingkat;
    private int idTahun;

    public kelas() {
    }

    public kelas(int idKelas, String namaKelas, int semesterTingkat, int idTahun) {
        this.idKelas = idKelas;
        this.namaKelas = namaKelas;
        this.semesterTingkat = semesterTingkat;
        this.idTahun = idTahun;
    }

    public int getIdKelas() {
        return idKelas;
    }

    public void setIdKelas(int idKelas) {
        this.idKelas = idKelas;
    }

    public String getNamaKelas() {
        return namaKelas;
    }

    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }

    public int getSemesterTingkat() {
        return semesterTingkat;
    }

    public void setSemesterTingkat(int semesterTingkat) {
        this.semesterTingkat = semesterTingkat;
    }

    public int getIdTahun() {
        return idTahun;
    }

    public void setIdTahun(int idTahun) {
        this.idTahun = idTahun;
    }



}
