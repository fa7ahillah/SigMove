import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(Color.BLACK);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Padding luar

        contentPanel.add(Box.createVerticalStrut(20)); // Spasi awal
        contentPanel.add(createLabeledField("Nama:", new JTextField()));
        contentPanel.add(Box.createVerticalStrut(15));
        contentPanel.add(createLabeledField("Username:", new JTextField()));
        contentPanel.add(Box.createVerticalStrut(15));
        contentPanel.add(createLabeledField("Usia:", new JTextField()));
        contentPanel.add(Box.createVerticalStrut(15));
        
        JPanel genderPanel = new JPanel();
        genderPanel.setBackground(Color.BLACK);
        genderPanel.setLayout(new BoxLayout(genderPanel, BoxLayout.X_AXIS));
        JLabel genderLabel = new JLabel("Jenis Kelamin:");
        genderLabel.setForeground(Color.WHITE);
        genderLabel.setPreferredSize(new Dimension(150, 25));
        JComboBox<String> genderComboBox = new JComboBox<>(new String[]{"Laki-laki", "Perempuan"});
        genderPanel.add(genderLabel);
        genderPanel.add(Box.createHorizontalStrut(10));
        genderPanel.add(genderComboBox);
        contentPanel.add(genderPanel);
        contentPanel.add(Box.createVerticalStrut(15));

        contentPanel.add(createLabeledField("Berat Badan (kg):", new JTextField()));
        contentPanel.add(Box.createVerticalStrut(15));
        contentPanel.add(createLabeledField("Tinggi Badan (cm):", new JTextField()));
        contentPanel.add(Box.createVerticalStrut(15));
        contentPanel.add(createLabeledField("Password:", new JPasswordField()));
        contentPanel.add(Box.createVerticalStrut(15));
        contentPanel.add(createLabeledField("Konfirmasi Password:", new JPasswordField()));
        contentPanel.add(Box.createVerticalStrut(30)); // Spasi sebelum tombol

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        signUpButton.setBackground(Color.ORANGE);
        signUpButton.setForeground(Color.BLACK);

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Sign Up berhasil!");
            }
        });

        contentPanel.add(signUpButton);
        contentPanel.add(Box.createVerticalStrut(20)); // Spasi bawah

        frame.add(contentPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private JPanel createLabeledField(String labelText, JComponent field) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setBackground(Color.BLACK);

        JLabel label = new JLabel(labelText);
        label.setForeground(Color.WHITE);
        label.setPreferredSize(new Dimension(150, 25));

        panel.add(label);
        panel.add(Box.createHorizontalStrut(10)); // Spasi antara label dan field
        panel.add(field);
        field.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25)); // Memastikan field lebar penuh

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SignUpForm::new);
    }
}
