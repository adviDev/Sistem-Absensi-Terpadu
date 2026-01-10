package dao;
import config.koneksi;
import java.sql.*;
public class dosenDAO {
    public String getNamaDosen(String nip){
        String nama="";        
        String sql = "select nama_dosen from dosen where nip = ?";
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
//        if (nama.isEmpty()) {
//            return nip;
//        }
        return nama;
    }
    
public java.util.List<String[]> getJadwalHarian(String nip, String hari) {
    java.util.List<String[]> listJadwal = new java.util.ArrayList<>();
    System.out.println("=== DEBUG JADWAL ===");
    System.out.println("Mencari NIP  : " + nip);
    System.out.println("Mencari Hari : " + hari);
    String sql = "select j.jam_mulai, j.jam_selesai, m.nama_mk, k.nama_kelas "
            + "from jadwal_kuliah j "
            + "join mata_kuliah m on j.kode_mk=m.kode_mk "
            + "join kelas k on j.id_kelas = k.id_kelas "
            + "join dosen d on j.nip_dosen=d.nip "
            + "where d.nip= ? and j.hari= ? "
            + "order by j.jam_mulai asc";

    try (Connection conn = koneksi.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
        ps.setString(1, nip);  
        ps.setString(2, hari); 
        
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            String jam = rs.getString("jam_mulai") + " - " + rs.getString("jam_selesai");
            String matkul = rs.getString("nama_mk");
            String kelas = rs.getString("nama_kelas");            
            String[] data = {jam, matkul, kelas};
            listJadwal.add(data);
        }
    } catch (SQLException e) {
        System.err.println("Error Get Jadwal: " + e.getMessage());
    }
    
    return listJadwal;
}
}
