/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;
import java.sql.*;
/**
 *
 * @author user
 */
public class koneksi {
    private static Connection con;
    public static Connection getConnection(){
        if(con == null){
            try {       
            String url = "jdbc:mysql://localhost/db_presensi_terpadu";
            String usr = "root";
            String pass = "1234";  
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, usr, pass);
            System.out.println("koneksi berhasil");
            }  catch (ClassNotFoundException e) {
                System.out.println("driver tidak ditemukan");
            } catch(SQLException e){
                System.out.println("gagal koneksi : "+ e.getMessage());                     
                }     
        }
        return con;
    }
}
