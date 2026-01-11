package dao;

import config.koneksi;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
public class rekapDAO {
    public List<String> getMatkulDosen(String nip){
        List<String> list = new ArrayList<>();
        String sql = "select distinct mk.nama_mk "
                + "from jadwal_kuliah j "
                + "join mata_kuliah mk on j.kode_mk=mk.kode_mk "
                + "where j.nip_dosen = ? "                
                + "order by mk.nama_mk";
        try (Connection con = koneksi.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, nip);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                list.add(rs.getString("nama_mk"));
            }
        } catch (SQLException e) {
            System.err.println("Error load Matkul: "+e.getMessage());
        }
        return list;
    }
    
    public List<String> getKelasDosen(String nip){
        List<String> list = new ArrayList<>();
        String sql = "select distinct k.nama_kelas "
                + "from jadwal_kuliah j "
                + "join kelas k on j.id_kelas = k.id_kelas "
                + "where j.nip_dosen = ? "
                + "order by k.nama_kelas";
                
        try (Connection con = koneksi.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, nip);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                list.add(rs.getString("nama_kelas"));
            }
        } catch (SQLException e) {
            System.err.println("Error load kelas: "+e.getMessage());
        }
        return list;
    }
    
    public DefaultTableModel getRekapAbsensi(String nip, String matkul,String idKelas){
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Mengunci semua sel agar tidak bisa diedit
            }
        };        
        model.addColumn("NIM");
        model.addColumn("Nama");
        model.addColumn("H");
        model.addColumn("I");
        model.addColumn("A");
        model.addColumn("S");
        
        String sql = "select "
                + "m.nim, "
                + "m.nama_mahasiswa, "
                + "sum(case when da.status_kehadiran = 'Hadir' then 1 else 0 end) as total_h, "
                + "sum(case when da.status_kehadiran = 'Izin' then 1 else 0 end) as total_i, "
                + "sum(case when da.status_kehadiran = 'Alpa' then 1 else 0 end) as total_a, "
                + "sum(case when da.status_kehadiran = 'Sakit' then 1 else 0 end) as total_s "
                + "from mahasiswa m "
                + "join anggota_kelas ak on m.nim=ak.nim "
                + "join kelas k on ak.id_kelas=k.id_kelas "
                + "left join detail_absensi da on m.nim=da.nim and da.id_sesi in ( "
                + "select sa.id_sesi "
                + "from sesi_absensi sa "
                + "join jadwal_kuliah j on sa.id_jadwal = j.id_jadwal "
                + "join mata_kuliah mk on j.kode_mk=mk.kode_mk "
                + "where j.nip_dosen = ? and mk.nama_mk = ? "
                + ") "
                + "where k.nama_kelas = ? "
                + "group by m.nim, m.nama_mahasiswa "
                + "order by m.nim asc";

        try (Connection con = koneksi.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, nip);
            ps.setString(2, matkul);
            ps.setString(3, idKelas);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Object[] row = {
                    rs.getString("nim"),
                    rs.getString("nama_mahasiswa"),
                    rs.getString("total_h"),
                    rs.getString("total_i"),
                    rs.getString("total_a"),
                    rs.getString("total_s")
                };
                model.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return model;
    }
    
    
}
