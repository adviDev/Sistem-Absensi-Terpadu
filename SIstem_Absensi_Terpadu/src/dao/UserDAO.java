 package dao;
import model.users;
import config.koneksi;
import java.sql.*;
public class UserDAO {
    /**
     * fungsi untuk cek login
     * mengembalikan objek user jika sukses, null jika gagal
     */
    public users login(String username, String password){
        users user = null;
        
        String sql = "select * from users where username=? and password=? and is_active=1";
        try (Connection conn = koneksi.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, username);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                user = new users();
                user.setIdUser(rs.getInt("id_user"));
                user.setUsername(rs.getString("username"));
                user.setRole(rs.getString("role"));
                user.setIsActive(rs.getBoolean("is_active"));
            }
            
        } catch (SQLException e) {
            System.out.println("error login : "+e.getMessage());
        }
        return user;
    }
    /**
     * fungsi untuk registrasi user baru     
     */    
    public boolean register(String username, String password, String role){
        String sql = "insert into users(username,password,role,is_active) values (?,?,?,1)";
        try (Connection conn = koneksi.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, role);
            int result = ps.executeUpdate();
            return result>0;
        } catch (SQLException e) {
            System.out.println("error register: "+e.getMessage());
            return false;
        }
    }
}
