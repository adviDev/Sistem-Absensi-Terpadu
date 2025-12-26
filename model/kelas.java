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
    private static int idKelas;
    private static String namaKelas;
    private static int semesterTingkat;
    private static int idTahun;

    public kelas(int idKelas, String namaKelas, int semesterTingkat, int idTahun) {
        this.idKelas = idKelas;
        this.namaKelas = namaKelas;
        this.semesterTingkat = semesterTingkat;
        this.idTahun = idTahun;
    }



    public static int getIdKelas() {
        return idKelas;
    }

    public static String getNamaKelas() {
        return namaKelas;
    }

    public static int getSemesterTingkat() {
        return semesterTingkat;
    }

    public static int getIdTahun() {
        return idTahun;
    }

    public static void setIdKelas(int idKelas) {
        kelas.idKelas = idKelas;
    }

    public static void setNamaKelas(String namaKelas) {
        kelas.namaKelas = namaKelas;
    }

    public static void setSemesterTingkat(int semesterTingkat) {
        kelas.semesterTingkat = semesterTingkat;
    }

    public static void setIdTahun(int idTahun) {
        kelas.idTahun = idTahun;
    }
    
}
