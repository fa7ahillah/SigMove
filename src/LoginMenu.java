import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginMenu {
    // Username dan password
    private final String defaultUsername = "user";
    private final String defaultPassword = "1234";

    // Constructor
    public LoginMenu() {
        // Frame utama
        JFrame frame = new JFrame("SigMove");
        frame.setSize(800, 600);
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

        // Form Login
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(3, 2, 10, 10));
        loginPanel.setBorder(BorderFactory.createEmptyBorder(50, 150, 50, 150));
        loginPanel.setBackground(new Color(52, 73, 94)); 

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        usernameLabel.setForeground(Color.WHITE);

        JTextField usernameField = new JTextField();
        usernameField.setFont(new Font("Arial", Font.PLAIN, 16));

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 16));
        passwordLabel.setForeground(Color.WHITE);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 16));

        JButton loginButton = new JButton("Log In");
        loginButton.setBackground(Color.ORANGE); 
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));

        JButton exitButton = new JButton("Exit");
        exitButton.setBackground(Color.ORANGE);
        exitButton.setForeground(Color.WHITE);
        exitButton.setFont(new Font("Arial", Font.BOLD, 16));

        // Tambah komponen 
        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);
        loginPanel.add(exitButton);

        // Tambah panel ke frame
        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(loginPanel, BorderLayout.CENTER);

        // Action login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (username.equals(defaultUsername) && password.equals(defaultPassword)) {
                    JOptionPane.showMessageDialog(frame, "Login berhasil! Selamat datang, " + username + ".");
                    frame.dispose();
                    showMainMenu();
                } else {
                    JOptionPane.showMessageDialog(frame, "Login gagal! Username atau password salah.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Action exit
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(frame, "Apakah Anda yakin ingin keluar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        frame.setVisible(true);
    }

    // menu utama
    private void showMainMenu() {
        JFrame mainFrame = new JFrame("SigMove");
        mainFrame.setSize(800, 600);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(new BorderLayout());

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(44, 62, 80));
        JLabel titleLabel = new JLabel("Apa yang ingin Anda latih?");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        headerPanel.add(titleLabel);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(2, 2, 10, 10));
        contentPanel.setBackground(new Color(52, 73, 94));

        String[] categories = {"DADA", "PERUT", "LENGAN", "KAKI"};

        for (String category : categories) {
            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());
            panel.setBackground(new Color(127, 140, 141));

            JLabel label = new JLabel(category, SwingConstants.CENTER);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            label.setForeground(Color.WHITE);
            panel.add(label, BorderLayout.NORTH);

            JLabel imagePlaceholder = new JLabel("Image", SwingConstants.CENTER);
            imagePlaceholder.setFont(new Font("Arial", Font.ITALIC, 16));
            imagePlaceholder.setForeground(Color.LIGHT_GRAY);
            panel.add(imagePlaceholder, BorderLayout.CENTER);

            JLabel footerLabel = new JLabel("11 LATIHAN", SwingConstants.CENTER);
            footerLabel.setFont(new Font("Arial", Font.BOLD, 14));
            footerLabel.setForeground(Color.ORANGE);
            panel.add(footerLabel, BorderLayout.SOUTH);

            contentPanel.add(panel);
        }

        mainFrame.add(headerPanel, BorderLayout.NORTH);
        mainFrame.add(contentPanel, BorderLayout.CENTER);
        mainFrame.setVisible(true);
    }

    // Main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginMenu::new);
    }
}
