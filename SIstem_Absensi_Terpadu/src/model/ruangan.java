/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author user
 */
public class ruangan {
    private static String idRuangan;
    private static String namaRuangan;
    private static int kapasitas;

    public ruangan() {
    }

    public ruangan(String idRuangan, String namaRuangan, int kapasitas) {
        this.idRuangan=idRuangan;
        this.namaRuangan=namaRuangan;
        this.kapasitas=kapasitas;
    }

    public static String getIdRuangan() {
        return idRuangan;
    }

    public static void setIdRuangan(String idRuangan) {
        ruangan.idRuangan = idRuangan;
    }

    public static String getNamaRuangan() {
        return namaRuangan;
    }

    public static void setNamaRuangan(String namaRuangan) {
        ruangan.namaRuangan = namaRuangan;
    }

    public static int getKapasitas() {
        return kapasitas;
    }

    public static void setKapasitas(int kapasitas) {
        ruangan.kapasitas = kapasitas;
    }
    
}
