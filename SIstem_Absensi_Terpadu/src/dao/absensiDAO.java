package dao;

import config.koneksi;
import java.util.List;
import model.detailAbsensi;
import java.sql.*;
import java.util.ArrayList;
import model.rekapAbsensi;
public class absensiDAO {
    
//    /**
//     * fungsi untuk menyimpan data absen sekaligus
//     * @param listAbsensi 
//     */
//    public void simpanAbsensi(List<detailAbsensi> listAbsensi){
//        String sql = "insert into detail_absensi(id_jadwal, nim, status_kehadiran, waktu_scan) values(?,?,?,now())";
//        Connection conn = null;
//        PreparedStatement ps = null;
//        try {
//            conn = koneksi.getConnection();
//            ps = conn.prepareStatement(sql);
//            conn.setAutoCommit(false);
//            
//            for (detailAbsensi data : listAbsensi) {
//                ps.setInt(1, data.getIdDetail());
//                ps.setString(2, data.getNim());
//                ps.setString(3, data.getStatusKehadiran());
//                
//                ps.addBatch();
//            }
//            ps.executeBatch();
//            
//            conn.commit();
//            
//            System.out.println(listAbsensi.size()+" data tersimpan");
//            
//            
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//            try { if(conn != null) conn.rollback(); } catch(SQLException ex){}
//        } finally {
//            try {
//            if (ps != null) ps.close();
//            if (conn != null) conn.close();
//            } catch (SQLException e) {            
//            }
//        }
//    }
    
    public void simpanDetailAbsensi(int idSesi, String nim, String status) {
        String sql = "INSERT INTO detail_absensi (id_sesi, nim, status_kehadiran, waktu_absen) VALUES (?, ?, ?, NOW())";
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idSesi);
            ps.setString(2, nim);
            ps.setString(3, status);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error Simpan Detail: " + e.getMessage());
        }
    }
    
    
    /**
     * fungsi membuat sesi baru ketika dosen memulai kelas
     * return idsesi
     * @param idJadwal
     * @return 
     */
public int buatSesiBaru(int idJadwal) {
    int idSesi = 0;
    String sql = "INSERT INTO sesi_absensi (id_jadwal, tanggal, status) VALUES (?, NOW(), 'Berlangsung')";
    
    try (Connection conn = koneksi.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) { // Penting: RETURN_GENERATED_KEYS
        
        ps.setInt(1, idJadwal);
        int affectedRows = ps.executeUpdate();

        if (affectedRows > 0) {
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    idSesi = rs.getInt(1); // Ambil ID Sesi yang baru terbentuk
                }
            }
        }
    } catch (SQLException e) {
        System.err.println("Error Buat Sesi: " + e.getMessage());
    }
    return idSesi;
}
    
   public void tutupSesi(int idSesi) {
        String sql = "UPDATE sesi_absensi SET status = 'Selesai' WHERE id_sesi = ?";
        try (Connection conn = koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idSesi);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error Tutup Sesi: " + e.getMessage());
        }
    }
   
   public int getIdJadwal(String idKelas, String namaMatkul, String nip) {
        int idJadwal = 0;
        String sql = "SELECT j.id_jadwal FROM jadwal_kuliah j " +
                     "JOIN mata_kuliah mk ON j.kode_mk = mk.kode_mk " +
                     "WHERE j.id_kelas = ? AND mk.nama_mk = ? AND j.nip_dosen = ?";
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, idKelas);
            ps.setString(2, namaMatkul);
            ps.setString(3, nip);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                idJadwal = rs.getInt("id_jadwal");
            }
        } catch (SQLException e) {
            System.err.println("Error Get ID Jadwal: " + e.getMessage());
        }
        return idJadwal;
    }
   
    /**
     * fungsi rekap absensi mahasiswa
     * return rekapabsensi
     * @param nim
     * @return 
     */
    public rekapAbsensi getRekapAbsensi(String nim){
        rekapAbsensi rekap = new rekapAbsensi();
        rekap.setNim(nim);
        String sql = "select "
                + "sum(case when status_kehadiran='Hadir' then 1 else 0 end) as jml_hadir, "
                + "sum(case when status_kehadiran='Sakit' then 1 else 0 end) as jml_sakit, "
                + "sum(case when status_kehadiran='Izin' then 1 else 0 end) as jml_izin, "
                + "sum(case when status_kehadiran='Alpa' then 1 else 0 end) as jml_alpa "
                + "from detail_absensi "
                + "where nim = ? ";
        try (Connection conn = koneksi.getConnection();
                PreparedStatement ps=conn.prepareStatement(sql)){
            ps.setString(1, nim);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                rekap.setTotalHadir(rs.getInt("jml_hadir"));
                rekap.setTotalSakit(rs.getInt("jml_sakit"));
                rekap.setTotalIzin(rs.getInt("jml_izin"));
                rekap.setTotalAlpa(rs.getInt("jml_alpa"));
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rekap;
    }
    /**
     * mengambil riwayat absensi
     * return tanggal, mata kuliah, status kehadiran
     * @param nim
     * @return 
     * 
     */
    public List<String[]> getRiwayatAbsensi(String nim){
        List<String[]> listRiwayat = new ArrayList<>();
        
        String sql = "select s.tanggal, mk.nama_mk, d.status_kehadiran "
                + "from detail_absensi d "
                + "join sesi_absensi s on d.id_sesi = s.id_sesi "
                + "join jadwal_kuliah j on s.id_jadwal = j.id_jadwal "
                + "join mata_kuliah mk on j.kode_mk=mk.kode_mk "
                + "where d.nim = ? "
                + "order by s.tanggal desc";
        try (Connection con=koneksi.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, nim);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                String tanggal = rs.getString("tanggal");
                String matkul = rs.getString("nama_mk");
                String status = rs.getString("status_kehadiran");
                
                String[] data = {tanggal, matkul, status};
                listRiwayat.add(data);
            }
            
        } catch (SQLException e) {
            System.err.println("Error Get Riwayat: " + e.getMessage());
        }
        return listRiwayat;
    }
}
