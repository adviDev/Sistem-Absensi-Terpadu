package dao;

import config.koneksi;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import model.mahasiswa;
public class mahasiswaDAO {
    List<mahasiswa> getMahasiswaByKelas(int idKelas){
        List<mahasiswa> listMhs = new ArrayList<>();
        
        String sql = "select m.nim, m.nama_mahasiswa, m.angkatan "
                + "from mahasiswa m "
                + "join anggota_kelas ak on m.nim=ak.nim "
                + "where ak.id_kelas = ? "
                + "order by m.nama_mahasiswa asc";
        try (Connection conn = koneksi.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, idKelas);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                mahasiswa m = new mahasiswa();
                m.setNim(rs.getString("nim"));
                m.setNama(rs.getString("nama_mahasiswa"));
                m.setAngkatan(rs.getInt("angkatan"));
                listMhs.add(m);
                
            }
            
        } catch (SQLException e) {
            System.err.println("Error Get Mahasiswa by Kelas: " + e.getMessage());
        }
        return listMhs;
    }
    
    public mahasiswa getProfil(String nim){
        mahasiswa m = null;
        String sql = "select * from mahasiswa where nim = ?";
        try (Connection conn= koneksi.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, nim);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                m = new mahasiswa();
                m.setNim(rs.getString("nim"));
                m.setNim(rs.getString("nama_mahasiswa"));
                m.setAngkatan(rs.getInt("angkatan"));
            }
            
        } catch (SQLException e) {
            System.err.println("Error Get Profil: " + e.getMessage());
        }
        return m;
    }
}
