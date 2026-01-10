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
        try {
            // Memperbaiki error dengan membungkus pengecekan isClosed() dalam try-catch
            if (con == null || con.isClosed()) {
                String url = "jdbc:mysql://localhost:3306/db_presensi_terpadu";
                String user = "root";
                String password = "1234"; // sesuaikan dengan password MySQL Anda
                
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                con = DriverManager.getConnection(url, user, password);
            }
        } catch (SQLException e) {
            System.err.println("Gagal menghubungkan ke database: " + e.getMessage());
        }
        return con;
    }
}
