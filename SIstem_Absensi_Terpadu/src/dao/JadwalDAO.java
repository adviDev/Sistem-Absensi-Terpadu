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
    /**
     * mengambil data jadwal berdasarkan kelas
     * @param idKelas
     * @return 
     */
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
    
    public List<jadwalKuliah> getJadwalByDosen(String nip){
        String sql = "select "
                + "jk.id_jadwal, d.nama_dosen, k.nama_kelas, mk.nama_mk, "
                + "r.nama_ruangan, jk.hari, jk.jam_mulai, jk.jam_selesai "
                + "from jadwal_kuliah jk "
                + "inner join dosen d on jk.nip_dosen=d.nip "
                + "inner join kelas k on jk.id_kelas=k.id_kelas "
                + "inner join mata_kuliah mk on jk.kode_mk=mk.kode_mk "
                + "inner join ruangan r on jk.id_ruangan=r.id_ruangan "
                + "where jk.nip_dosen=? "
                + "order by jk.hari asc;";
        List<jadwalKuliah> listJadwal = new ArrayList<>();
        try (Connection conn = koneksi.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, nip);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                jadwalKuliah jk = new jadwalKuliah();
                //masukkan data deafult
                jk.setIdJadwal(rs.getInt("id_jadwal"));
                jk.setJamMulai(rs.getString("jam_mulai"));
                jk.setJamSelesai(rs.getString("jam_selesai"));                
                jk.setHari(rs.getString("hari"));                
                //masukkan hasil data join                
                jk.setNamaDosen(rs.getString("nama_dosen"));
                jk.setNamaKelas(rs.getString("nama_kelas"));
                jk.setNamaMk(rs.getString("nama_mk"));
                jk.setNamaRuangan(rs.getString("nama_ruangan"));
                
                //mamasukkan data ke dalam list
                listJadwal.add(jk);
                
            }
            
        } catch (SQLException e) {
            System.out.println("gagal query: "+e.getMessage());
        }
        
        return listJadwal;
    }
}
