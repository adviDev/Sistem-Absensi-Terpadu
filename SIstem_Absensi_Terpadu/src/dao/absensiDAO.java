package dao;

import config.koneksi;
import java.util.List;
import model.detailAbsensi;
import java.sql.*;
import model.rekapAbsensi;
public class absensiDAO {
    
    /**
     * fungsi untuk menyimpan data absen sekaligus
     * @param listAbsensi 
     */
    public void simpanAbsensi(List<detailAbsensi> listAbsensi){
        String sql = "insert into detail_absensi(id_jadwal, nim, status_kehadiran, waktu_scan) values(?,?,?,now())";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = koneksi.getConnection();
            ps = conn.prepareStatement(sql);
            conn.setAutoCommit(false);
            
            for (detailAbsensi data : listAbsensi) {
                ps.setInt(1, data.getIdDetail());
                ps.setString(2, data.getNim());
                ps.setString(3, data.getStatusKehadiran());
                
                ps.addBatch();
            }
            ps.executeBatch();
            
            conn.commit();
            
            System.out.println(listAbsensi.size()+" data tersimpan");
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            try { if(conn != null) conn.rollback(); } catch(SQLException ex){}
        } finally {
            try {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
            } catch (SQLException e) {            
            }
        }
    }
    
    
    /**
     * fungsi membuat sesi baru ketika dosen memulai kelas
     * return idsesi
     * @param idJadwal
     * @param tanggal
     * @return 
     */
    public int mulaiSesiBaru(int idJadwal, String tanggal){
        int idSesiBaru = -1;
        
        String sqlcek="select id_sesi from sesi_absensi where id_jadwal =? and tanggal=?";
        String sqlInsert="insert into sesi_absensi(id_jadwal,tanggal,status) values(?,?,'BUKA')";
        try (Connection conn=koneksi.getConnection()){
            try (PreparedStatement psCek=conn.prepareStatement(sqlcek)){
                psCek.setInt(1, idJadwal);
                psCek.setString(2, tanggal);
                ResultSet rs = psCek.executeQuery();
                if (rs.next()) {
                    return rs.getInt("id_sesi");                            }
                
            } 
            try (PreparedStatement ps=conn.prepareStatement(sqlInsert,Statement.RETURN_GENERATED_KEYS)){
                ps.setInt(1, idJadwal);
                ps.setString(2, tanggal);
                
                int affectedrows=ps.executeUpdate();
                if (affectedrows>0) {
                    try (ResultSet generateKeys=ps.getGeneratedKeys()){
                        if (generateKeys.next()) {
                            idSesiBaru=generateKeys.getInt(1);
                        }
                        
                    }
                }
                
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return idSesiBaru;
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
        String sql = "select"
                + "sum(case when status='hadir' then 1 else 0 end) as jml_hadir,"
                + "sum(case when status='sakit' then 1 else 0 end) as jml_sakit,"
                + "sum(case when status='izin' then 1 else 0 end) as jml_izin,"
                + "sum(case when status='alpa' then 1 else 0 end) as jml_alpa,"
                + "from detail_absensi "
                + "where nim = ?";
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
}
