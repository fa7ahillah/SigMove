import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {
    public MainMenu() {
        setTitle("Workout Program");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400); 
        setLayout(new BorderLayout());

        // Header
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(70, 130, 180)); 
        headerPanel.setPreferredSize(new Dimension(500, 80));

        JLabel titleLabel = new JLabel("Pilih Program Latihan Anda", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setForeground(Color.WHITE);
        headerPanel.add(titleLabel);

        add(headerPanel, BorderLayout.NORTH);

        // Menu Buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1, 10, 10)); 
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50)); 

        JButton armButton = new JButton("Latihan Lengan");
        JButton chestButton = new JButton("Latihan Dada");
        JButton absButton = new JButton("Latihan Perut");
        JButton legsButton = new JButton("Latihan Kaki");

        buttonPanel.add(armButton);
        buttonPanel.add(chestButton);
        buttonPanel.add(absButton);
        buttonPanel.add(legsButton);

        add(buttonPanel, BorderLayout.CENTER);

        // Footer
        JPanel footerPanel = new JPanel();
        footerPanel.setPreferredSize(new Dimension(500, 50));
        footerPanel.setBackground(new Color(220, 220, 220)); 

        JLabel footerLabel = new JLabel("Semangat Berlatih!", SwingConstants.CENTER);
        footerLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        footerPanel.add(footerLabel);

        add(footerPanel, BorderLayout.SOUTH);

        // Button Actions
        armButton.addActionListener(e -> new WorkoutDetails("Latihan Lengan", new String[]{"Push-up", "Pull-up"}));
        chestButton.addActionListener(e -> new WorkoutDetails("Latihan Dada", new String[]{"Push-up",}));
        absButton.addActionListener(e -> new WorkoutDetails("Latihan Perut", new String[]{"Sit-up", "Plank",}));
        legsButton.addActionListener(e -> new WorkoutDetails("Latihan Kaki", new String[]{"Squats", "Lunges"}));

        setLocationRelativeTo(null); 
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainMenu());
    }
}
