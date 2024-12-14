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
        panel.setBackground(Color.DARK_GRAY);

        JLabel titleLabel = new JLabel("Apa yang ingin Anda latih?", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.WHITE);
        panel.add(titleLabel, BorderLayout.NORTH);

        JPanel workoutPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        workoutPanel.setBackground(Color.DARK_GRAY);

        addWorkoutOption(workoutPanel, "DADA", "11 LATIHAN", "https://github.com/fa7ahillah/SigMove/blob/bce5db4f98f35996172ae1577cc9a80357a815ff/assets/dada.png");
        addWorkoutOption(workoutPanel, "PERUT", "16 LATIHAN", "https://github.com/fa7ahillah/SigMove/blob/bce5db4f98f35996172ae1577cc9a80357a815ff/assets/perut.png");
        addWorkoutOption(workoutPanel, "LENGAN", "19 LATIHAN", "https://github.com/fa7ahillah/SigMove/blob/bce5db4f98f35996172ae1577cc9a80357a815ff/assets/lengan.png");
        addWorkoutOption(workoutPanel, "KAKI", "23 LATIHAN", "https://github.com/fa7ahillah/SigMove/blob/bce5db4f98f35996172ae1577cc9a80357a815ff/assets/kaki.png");

        panel.add(workoutPanel, BorderLayout.CENTER);
    }

    private void addWorkoutOption(JPanel panel, String name, String exercises, String imagePath) {
        JPanel optionPanel = new JPanel(new BorderLayout());
        optionPanel.setBackground(Color.GRAY);

        JLabel imageLabel = new JLabel("", JLabel.CENTER);
        imageLabel.setForeground(Color.WHITE);

        ImageIcon icon = new ImageIcon(imagePath); 
        Image image = icon.getImage(); 
        Image resizedImage = image.getScaledInstance(300, 300, Image.SCALE_SMOOTH); 
        imageLabel.setIcon(new ImageIcon(resizedImage));

        optionPanel.add(imageLabel, BorderLayout.CENTER);

        JLabel nameLabel = new JLabel(name, JLabel.CENTER);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        nameLabel.setForeground(Color.BLACK);
        nameLabel.setBackground(Color.ORANGE);
        nameLabel.setOpaque(true);
        optionPanel.add(nameLabel, BorderLayout.NORTH);

        JLabel exercisesLabel = new JLabel(exercises, JLabel.CENTER);
        exercisesLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        exercisesLabel.setForeground(Color.BLACK);
        exercisesLabel.setBackground(Color.ORANGE);
        exercisesLabel.setOpaque(true);
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
