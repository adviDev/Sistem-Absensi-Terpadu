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
    private int idDetail;
    private int idSesi;
    private String nim;
    private String statusKehadiran;
    private String waktuScan;

    public detailAbsensi() {
    }
    
    public detailAbsensi(int idDetail,int idSesi,String nim,String statusKehadiran,String waktuScan) {
        this.idDetail = idDetail;
        this.idSesi = idSesi;
        this.nim = nim;
        this.statusKehadiran = statusKehadiran;
        this.waktuScan = waktuScan;
        
    }

    public int getIdDetail() {
        return idDetail;
    }

    public void setIdDetail(int idDetail) {
        this.idDetail = idDetail;
    }

    public int getIdSesi() {
        return idSesi;
    }

    public void setIdSesi(int idSesi) {
        this.idSesi = idSesi;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getStatusKehadiran() {
        return statusKehadiran;
    }

    public void setStatusKehadiran(String statusKehadiran) {
        this.statusKehadiran = statusKehadiran;
    }

    public String getWaktuScan() {
        return waktuScan;
    }

    public void setWaktuScan(String waktuScan) {
        this.waktuScan = waktuScan;
    }

    


}
