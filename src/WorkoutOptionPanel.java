import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WorkoutOptionPanel {
    private JPanel panel;
    private WorkoutGUI workoutGUI;

    public WorkoutOptionPanel(WorkoutGUI workoutGUI) {
        this.workoutGUI = workoutGUI;
        panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(30, 30, 30)); 

        JLabel titleLabel = new JLabel("Pilih Program Latihan Anda", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24)); 
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0)); 
        panel.add(titleLabel, BorderLayout.NORTH);

        JPanel workoutPanel = new JPanel(new GridLayout(2, 2, 15, 15)); 
        workoutPanel.setBackground(new Color(30, 30, 30));

        addWorkoutOption(workoutPanel, "DADA", "9 LATIHAN", "assets\\dada.png");
        addWorkoutOption(workoutPanel, "PERUT", "15 LATIHAN", "assets\\perut.png");
        addWorkoutOption(workoutPanel, "LENGAN", "19 LATIHAN", "assets\\lengan.png");
        addWorkoutOption(workoutPanel, "KAKI", "15 LATIHAN", "assets\\kaki.png");

        panel.add(workoutPanel, BorderLayout.CENTER);
    }

    private void addWorkoutOption(JPanel panel, String name, String exercises, String imagePath) {
        JPanel optionPanel = new JPanel(new BorderLayout());
        optionPanel.setBackground(new Color(50, 50, 50)); 
        optionPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 

        JLabel imageLabel = new JLabel("", JLabel.CENTER);
        ImageIcon icon = new ImageIcon(imagePath); 
        Image image = icon.getImage();
        Image resizedImage = image.getScaledInstance(150, 150, Image.SCALE_SMOOTH); 
        imageLabel.setIcon(new ImageIcon(resizedImage));
        imageLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 

        optionPanel.add(imageLabel, BorderLayout.CENTER);

        JLabel nameLabel = new JLabel(name, JLabel.CENTER);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setBackground(new Color(70, 70, 70));
        nameLabel.setOpaque(true);
        nameLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0)); 
        optionPanel.add(nameLabel, BorderLayout.NORTH);

        JLabel exercisesLabel = new JLabel(exercises, JLabel.CENTER);
        exercisesLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        exercisesLabel.setForeground(Color.LIGHT_GRAY);
        exercisesLabel.setBackground(new Color(70, 70, 70));
        exercisesLabel.setOpaque(true);
        exercisesLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0)); 
        optionPanel.add(exercisesLabel, BorderLayout.SOUTH);

        optionPanel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                workoutGUI.showWorkoutDetail(name);
            }
        });

        panel.add(optionPanel);
    }

    public JPanel getPanel() {
        return panel;
    }
}
