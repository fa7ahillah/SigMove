import java.sql.*;

public class DatabaseManager {

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
        } catch (ClassNotFoundException e) {
            System.out.println("Driver MySQL tidak ditemukan.");
            e.printStackTrace();
        }
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/sigmove", "root", "");
    }

    public static boolean saveUserData(String nama, String username, int usia, String jenisKelamin, int beratBadan, int tinggiBadan, String password) {
        String sql = "INSERT INTO user (name, username, usia, gender, weight, height, password) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nama);
            stmt.setString(2, username);
            stmt.setInt(3, usia);
            stmt.setString(4, jenisKelamin);
            stmt.setInt(5, beratBadan);
            stmt.setInt(6, tinggiBadan);
            stmt.setString(7, password);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Terjadi kesalahan saat menyimpan data: " + e.getMessage());
            return false; 
        }
    }

    public static boolean showLatihan(String nama_latihan, String kategori, String jenis, int level, String gambar) {
        String sql = "SELECT nama_latihan, level, gambar FROM latihan WHERE kategori = ? AND nama_latihan = ? AND level = ?";
        boolean result = false;
    
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            // Mengisi parameter sesuai urutan pada query SQL
            stmt.setString(1, kategori);
            stmt.setString(2, nama_latihan);
            stmt.setInt(3, level);
    
            // Menjalankan query
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Jika ada hasil, set result ke true
                    result = true;
                    // Opsional: Cetak data atau proses hasil query
                    System.out.println("Nama Latihan: " + rs.getString("nama_latihan"));
                    System.out.println("Level: " + rs.getInt("level"));
                    System.out.println("Gambar: " + rs.getString("gambar"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return result;
    }
}

