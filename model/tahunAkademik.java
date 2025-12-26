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
    private static int idTahun;
    private static String namaSemester;
    private static int isActive;

    public tahunAkademik(int idTahun, String namaSemester,int isActive) {
        this.idTahun=idTahun;
        this.namaSemester=namaSemester;
        this.isActive=isActive;
    }

    public static int getIdTahun() {
        return idTahun;
    }

    public static void setIdTahun(int idTahun) {
        tahunAkademik.idTahun = idTahun;
    }

    public static String getNamaSemester() {
        return namaSemester;
    }

    public static void setNamaSemester(String namaSemester) {
        tahunAkademik.namaSemester = namaSemester;
    }

    public static int getIsActive() {
        return isActive;
    }

    public static void setIsActive(int isActive) {
        tahunAkademik.isActive = isActive;
    }
    
}
