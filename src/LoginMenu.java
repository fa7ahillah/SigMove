import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginMenu {
    // Constructor
    public LoginMenu() {
        // Frame utama
        JFrame frame = new JFrame("SigMove");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        // Panel atas (Header)
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(44, 62, 80)); 
        JLabel titleLabel = new JLabel("Login");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setForeground(Color.WHITE);
        headerPanel.add(titleLabel);

        // Panel form login menggunakan GridBagLayout
        JPanel loginPanel = new JPanel(new GridBagLayout());
        loginPanel.setBackground(new Color(52, 73, 94));
        loginPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50)); // Padding luar

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding antar elemen
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Label dan Field Username
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        usernameLabel.setForeground(Color.WHITE);
        JTextField usernameField = new JTextField(15);
        usernameField.setFont(new Font("Arial", Font.PLAIN, 16));

        gbc.gridx = 0;
        gbc.gridy = 0;
        loginPanel.add(usernameLabel, gbc);

        gbc.gridx = 1;
        loginPanel.add(usernameField, gbc);

        // Label dan Field Password
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 16));
        passwordLabel.setForeground(Color.WHITE);
        JPasswordField passwordField = new JPasswordField(15);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 16));

        gbc.gridx = 0;
        gbc.gridy = 1;
        loginPanel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        loginPanel.add(passwordField, gbc);

        // Tombol Login
        JButton loginButton = new JButton("Log In");
        loginButton.setBackground(Color.ORANGE);
        loginButton.setForeground(Color.BLACK);
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        loginPanel.add(loginButton, gbc);

        // Tombol Exit
        JButton exitButton = new JButton("Exit");
        exitButton.setBackground(Color.ORANGE);
        exitButton.setForeground(Color.BLACK);
        exitButton.setFont(new Font("Arial", Font.BOLD, 16));

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        loginPanel.add(exitButton, gbc);

        // Label untuk navigasi ke Sign Up
        JLabel signUpLabel = new JLabel("<HTML><U>Belum punya akun? Silahkan daftar</U></HTML>");
        signUpLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        signUpLabel.setForeground(Color.ORANGE);
        signUpLabel.setHorizontalAlignment(SwingConstants.CENTER);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        loginPanel.add(signUpLabel, gbc);

        // Action listener untuk tombol Login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (checkCredentials(username, password)) {
                    JOptionPane.showMessageDialog(frame, "Login berhasil! Selamat datang, " + username + ".");
                    frame.dispose(); // Tutup frame login
                    showMainMenu();  // Tampilkan menu utama
                } else {
                    JOptionPane.showMessageDialog(frame, "Login gagal! Username atau password salah.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Action listener untuk tombol Exit
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(frame, "Apakah Anda yakin ingin keluar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        // Action listener untuk label Sign Up
        signUpLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                new SignUpForm();
                frame.dispose(); // Menutup frame login saat sign up diklik
            }
        });

        // Menambahkan panel ke frame
        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(loginPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    // Method untuk memeriksa kredensial di database
    private boolean checkCredentials(String username, String password) {
        String url = "jdbc:mysql://localhost:3306/sigmove"; // Ganti dengan nama database Anda
        String dbUsername = "root"; // Username database
        String dbPassword = "";     // Password database (kosong jika default)

        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";

        try (Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            return rs.next(); // Jika ada hasil, berarti kredensial benar
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // Method untuk menampilkan menu utama
    private void showMainMenu() {
        // Implementasi untuk menampilkan menu utama
    }

    // Main method
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load driver MySQL
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Driver JDBC tidak ditemukan!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        SwingUtilities.invokeLater(LoginMenu::new);
    }
}
