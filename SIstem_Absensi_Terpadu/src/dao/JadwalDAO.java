/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import config.koneksi;
import model.jadwalKuliah;
import model.mataKuliah;
import model.kelas;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author user
 */
public class JadwalDAO {
    
    public List<jadwalKuliah> getJadwalByKelas(int idKelas){
        List<jadwalKuliah> listJadwal = new ArrayList<>();
        String sql = "SELECT "
                + "jk.id_jadwal, k.nama_kelas, d.nama_dosen, mk.nama_mk, "
                + "r.nama_ruangan, jk.hari, jk.jam_mulai, jk.jam_selesai "
                + "FROM jadwal_kuliah jk "
                + "INNER JOIN kelas k ON jk.id_kelas=k.id_kelas "
                + "INNER JOIN dosen d ON jk.nip_dosen=d.nip "
                + "INNER JOIN mata_kuliah mk ON jk.kode_mk=mk.kode_mk "
                + "INNER JOIN ruangan r ON jk.id_ruangan=r.id_ruangan "
                + "WHERE k.id_kelas = ? "
                + "ORDER BY jk.hari ASC;";
        try (Connection conn = koneksi.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, idKelas);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                jadwalKuliah jk = new jadwalKuliah();
                jk.setIdJadwal(rs.getInt("id_jadwal"));
                jk.setHari(rs.getString("hari"));
                jk.setJamMulai(rs.getString("jam_mulai"));
                jk.setJamSelesai(rs.getString("jam_selesai"));
                //masukkan data hasil join
                jk.setNamaDosen(rs.getString("nama_dosen"));
                jk.setNamaMk(rs.getString("nama_mk"));
                jk.setNamaRuangan(rs.getString("nama_ruangan"));
                jk.setNamaKelas(rs.getString("nama_kelas"));
                
                //masukkan ke dalam list
                listJadwal.add(jk);               
            }                        
        } catch (SQLException e) {
            System.out.println("gagal query: "+e.getMessage());
        }
        //return
        return listJadwal;
    }
}
