/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author user
 */
public class detailAbsensi {
    private static int idDetail;
    private static int idSesi;
    private static String nim;
    private static String statusKehadiran;
    private static String waktuScan;

    public detailAbsensi() {
    }
    
    public detailAbsensi(int idDetail,int idSesi,String nim,String statusKehadiran,String waktuScan) {
        this.idDetail = idDetail;
        this.idSesi = idSesi;
        this.nim = nim;
        this.statusKehadiran = statusKehadiran;
        this.waktuScan = waktuScan;
        
    }

    public static int getIdDetail() {
        return idDetail;
    }

    public static void setIdDetail(int idDetail) {
        detailAbsensi.idDetail = idDetail;
    }

    public static int getIdSesi() {
        return idSesi;
    }

    public static void setIdSesi(int idSesi) {
        detailAbsensi.idSesi = idSesi;
    }

    public static String getNim() {
        return nim;
    }

    public static void setNim(String nim) {
        detailAbsensi.nim = nim;
    }

    public static String getStatusKehadiran() {
        return statusKehadiran;
    }

    public static void setStatusKehadiran(String statusKehadiran) {
        detailAbsensi.statusKehadiran = statusKehadiran;
    }

    public static String getWaktuScan() {
        return waktuScan;
    }

    public static void setWaktuScan(String waktuScan) {
        detailAbsensi.waktuScan = waktuScan;
    }
    
    


}
