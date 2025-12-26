/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author user
 */
public class anggotaKelas {
    private static int idKelas;
    private static String nim;

    public anggotaKelas(int idKelas, String nim) {
        this.idKelas = idKelas;
        this.nim = nim;
    }

    public static int getIdKelas() {
        return idKelas;
    }

    public static void setIdKelas(int idKelas) {
        anggotaKelas.idKelas = idKelas;
    }

    public static String getNim() {
        return nim;
    }

    public static void setNim(String nim) {
        anggotaKelas.nim = nim;
    }
    
    
}
