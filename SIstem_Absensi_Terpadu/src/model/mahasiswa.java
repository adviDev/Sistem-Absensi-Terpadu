package model;
public class mahasiswa {
    private String nim;
    private String nama;
    private int angkatan;

    public mahasiswa() {
    }
    
    
    public mahasiswa(String nim, String nama,int angkatan){
        this.nim = nim;
        this.nama = nama;
        this.angkatan = angkatan;
    }
    
    public String getNim(){return nim;}
    public String getNama(){return nama;}
    public int getAngkatan(){return angkatan;}

    public void setNim(String nim) {
        this.nim = nim;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAngkatan(int angkatan) {
        this.angkatan = angkatan;
    }
    
}
