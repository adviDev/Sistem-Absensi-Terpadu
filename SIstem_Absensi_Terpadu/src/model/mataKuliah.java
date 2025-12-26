package model;
public class mataKuliah {
    private static String kodeMK; //kode mata kuliah
    private static String namaMK; //nama mata kuliah
    private static int sks;
    private static int semesterPaket;
    public mataKuliah(String kodeMK, String namaMK, int sks, int semesterPaket){
        this.kodeMK = kodeMK;
        this.namaMK = namaMK;
        this.sks = sks;
        this.semesterPaket = semesterPaket;
    }
    public String getKodeMK(){return kodeMK;}
    public String getNamaMK(){return namaMK;}
    public int getSks(){return sks;}
    public int getSemesterPaket(){return semesterPaket;}

    public static void setKodeMK(String kodeMK) {
        mataKuliah.kodeMK = kodeMK;
    }

    public static void setNamaMK(String namaMK) {
        mataKuliah.namaMK = namaMK;
    }

    public static void setSks(int sks) {
        mataKuliah.sks = sks;
    }

    public static void setSemesterPaket(int semesterPaket) {
        mataKuliah.semesterPaket = semesterPaket;
    }
    
    
}
