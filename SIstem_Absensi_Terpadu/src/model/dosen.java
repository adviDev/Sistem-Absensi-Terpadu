package model;
public class dosen {
    private String nip;
    private String namaDosen;

    public dosen() {
    }
    
    public dosen(String nip, String namaDosen){
        this.nip = nip;
        this.namaDosen = namaDosen;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNamaDosen() {
        return namaDosen;
    }

    public void setNamaDosen(String namaDosen) {
        this.namaDosen = namaDosen;
    }

    
}
