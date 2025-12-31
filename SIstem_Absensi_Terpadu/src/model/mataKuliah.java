package model;
public class mataKuliah {
    private String kodeMK; //kode mata kuliah
    private String namaMK; //nama mata kuliah
    private int sks;
    private int semesterPaket;

    public mataKuliah() {
    }
    
    public mataKuliah(String kodeMK, String namaMK, int sks, int semesterPaket){
        this.kodeMK = kodeMK;
        this.namaMK = namaMK;
        this.sks = sks;
        this.semesterPaket = semesterPaket;
    }

    public String getKodeMK() {
        return kodeMK;
    }

    public void setKodeMK(String kodeMK) {
        this.kodeMK = kodeMK;
    }

    public String getNamaMK() {
        return namaMK;
    }

    public void setNamaMK(String namaMK) {
        this.namaMK = namaMK;
    }

    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }

    public int getSemesterPaket() {
        return semesterPaket;
    }

    public void setSemesterPaket(int semesterPaket) {
        this.semesterPaket = semesterPaket;
    }

    
    
}
