package dao;

import config.koneksi;
import java.util.List;
import model.detailAbsensi;
import java.sql.*;
import java.util.ArrayList;
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
