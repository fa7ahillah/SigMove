import javax.swing.*;
import java.awt.*;

public class WorkoutResultPanel {
    private JPanel panel;

    public WorkoutResultPanel(WorkoutResult result, WorkoutGUI workoutGUI) {
        panel = new JPanel();
        panel.setBackground(new Color(30, 30, 30));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); 

        JLabel titleLabel = new JLabel("Hasil Workout", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT); 
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(20)); 

        JLabel exercisesLabel = new JLabel("Total Latihan: " + result.getTotalExercises(), JLabel.CENTER);
        exercisesLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        exercisesLabel.setForeground(Color.LIGHT_GRAY);
        exercisesLabel.setAlignmentX(Component.CENTER_ALIGNMENT); 
        panel.add(exercisesLabel);
        panel.add(Box.createVerticalStrut(10)); 

        JLabel caloriesLabel = new JLabel("Total Kalori Terbakar: " + result.getTotalCalories(), JLabel.CENTER);
        caloriesLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        caloriesLabel.setForeground(Color.LIGHT_GRAY);
        caloriesLabel.setAlignmentX(Component.CENTER_ALIGNMENT); 
        panel.add(caloriesLabel);
        panel.add(Box.createVerticalStrut(10)); 

        JLabel timeLabel = new JLabel("Total Waktu: " + result.getTotalTime() + " detik", JLabel.CENTER);
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        timeLabel.setForeground(Color.LIGHT_GRAY);
        timeLabel.setAlignmentX(Component.CENTER_ALIGNMENT); 
        panel.add(timeLabel);
        panel.add(Box.createVerticalStrut(20)); 

        CustomButton backButton = new CustomButton("Kembali ke Halaman Utama");
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.setBackground(new Color(70, 130, 180)); 
        backButton.setForeground(Color.WHITE);
        backButton.setPreferredSize(new Dimension(250, 50));
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT); 
        backButton.addActionListener(e -> workoutGUI.returnToMainPage());
        panel.add(backButton);
    }

    public JPanel getPanel() {
        return panel;
    }
}
