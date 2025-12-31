/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author user
 */
public class tahunAkademik {
    private int idTahun;
    private String namaSemester;
    private int isActive;

    public tahunAkademik() {
    }

    public tahunAkademik(int idTahun, String namaSemester,int isActive) {
        this.idTahun=idTahun;
        this.namaSemester=namaSemester;
        this.isActive=isActive;
    }

    public int getIdTahun() {
        return idTahun;
    }

    public void setIdTahun(int idTahun) {
        this.idTahun = idTahun;
    }

    public String getNamaSemester() {
        return namaSemester;
    }

    public void setNamaSemester(String namaSemester) {
        this.namaSemester = namaSemester;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    
}
