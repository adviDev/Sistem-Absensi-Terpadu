package dao;
import config.koneksi;
import java.sql.*;
public class dosenDAO {
    public String getNamaDosen(String nip){
        String nama="";        
        String sql = "select * from dosen where nip = ?";
        try (Connection conn = koneksi.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, nip);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nama = rs.getString("nama_dosen");                
            }
        } catch (SQLException e) {
            System.err.println("Error Get Profil: " + e.getMessage());
        }
        if (nama.isEmpty()) {
            return nip;
        }
        return nama;
    }
}
