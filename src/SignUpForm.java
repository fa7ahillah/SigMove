import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUpForm {
    public SignUpForm() {
        JFrame frame = new JFrame("SignMove");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(new BorderLayout());

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.BLACK);
        JLabel titleLabel = new JLabel("SignMove");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.ORANGE);
        headerPanel.add(titleLabel);
        frame.add(headerPanel, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBackground(Color.BLACK);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Padding luar
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Spasi antar elemen
        gbc.fill = GridBagConstraints.HORIZONTAL;

        int row = 0;
        JTextField namaField = new JTextField(15);
        JTextField usernameField = new JTextField(15);
        JTextField usiaField = new JTextField(15);
        JTextField beratBadanField = new JTextField(15);
        JTextField tinggiBadanField = new JTextField(15);
        JPasswordField passwordField = new JPasswordField(15);
        JPasswordField confirmPasswordField = new JPasswordField(15);

        contentPanel.add(createLabeledField("Nama:", namaField), createGbc(row++));
        contentPanel.add(createLabeledField("Username:", usernameField), createGbc(row++));
        contentPanel.add(createLabeledField("Usia:", usiaField), createGbc(row++));

        JPanel genderPanel = new JPanel(new BorderLayout());
        genderPanel.setBackground(Color.BLACK);
        JLabel genderLabel = new JLabel("Jenis Kelamin:");
        genderLabel.setForeground(Color.WHITE);
        JComboBox<String> genderComboBox = new JComboBox<>(new String[]{"Male", "Female"});
        genderPanel.add(genderLabel, BorderLayout.WEST);
        genderPanel.add(genderComboBox, BorderLayout.CENTER);
        gbc.gridy = row++;
        contentPanel.add(genderPanel, gbc);

        contentPanel.add(createLabeledField("Berat Badan (kg):", beratBadanField), createGbc(row++));
        contentPanel.add(createLabeledField("Tinggi Badan (cm):", tinggiBadanField), createGbc(row++));
        contentPanel.add(createLabeledField("Password:", passwordField), createGbc(row++));
        contentPanel.add(createLabeledField("Konfirmasi Password:", confirmPasswordField), createGbc(row++));

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setBackground(Color.ORANGE);
        signUpButton.setForeground(Color.BLACK);
        signUpButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); 
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = namaField.getText();
                String username = usernameField.getText();
                int usia = Integer.parseInt(usiaField.getText());
                String jenisKelamin = (String) genderComboBox.getSelectedItem();
                int beratBadan = Integer.parseInt(beratBadanField.getText());
                int tinggiBadan = Integer.parseInt(tinggiBadanField.getText());
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                if (password.equals(confirmPassword)) {
                    boolean isSaved = DatabaseManager.saveUserData(nama, username, usia, jenisKelamin, beratBadan, tinggiBadan, password);
                    if (isSaved) {
                        JOptionPane.showMessageDialog(frame, "Pendaftaran berhasil!");
                        frame.dispose(); 
                        new LoginMenu(); 
                    } else {
                        JOptionPane.showMessageDialog(frame, "Pendaftaran gagal. Tunggu beberapa saat dan coba lagi.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Password dan konfirmasi password tidak cocok!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        gbc.gridy = row++;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        contentPanel.add(signUpButton, gbc);

        JLabel loginLabel = new JLabel("<HTML><U>Sudah daftar? Silahkan login</U></HTML>");
        loginLabel.setForeground(Color.ORANGE);
        loginLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); 
        loginLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                frame.dispose(); 
                new LoginMenu(); 
            }
        });

        gbc.gridy = row++;
        gbc.anchor = GridBagConstraints.CENTER;
        contentPanel.add(loginLabel, gbc);

        frame.add(contentPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private GridBagConstraints createGbc(int row) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        return gbc;
    }

    private JPanel createLabeledField(String labelText, JComponent field) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.BLACK);

        JLabel label = new JLabel(labelText);
        label.setForeground(Color.WHITE);
        label.setPreferredSize(new Dimension(150, 25));
        field.setPreferredSize(new Dimension(180, 25));

        panel.add(label, BorderLayout.WEST);
        panel.add(field, BorderLayout.CENTER);
        return panel;
    }

    //tester
    public static void main(String[] args) {
        SwingUtilities.invokeLater(SignUpForm::new);
    }
}
