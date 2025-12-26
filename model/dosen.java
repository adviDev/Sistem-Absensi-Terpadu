package model;
public class dosen {
    private static String nip;
    private static String namaDosen;
    public dosen(String nip, String namaDosen){
        this.nip = nip;
        this.namaDosen = namaDosen;
    }
    public String getNip(){return nip;}
    public String getNamaDosen(){return namaDosen;}

    public static void setNip(String nip) {
        dosen.nip = nip;
    }

    public static void setNamaDosen(String namaDosen) {
        dosen.namaDosen = namaDosen;
    }
    
}
