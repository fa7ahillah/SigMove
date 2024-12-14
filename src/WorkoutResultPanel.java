import javax.swing.*;
import java.awt.*;

public class WorkoutResultPanel {
    private JPanel panel;

    public WorkoutResultPanel(WorkoutResult result, WorkoutGUI workoutGUI) {
        panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Workout Results", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        panel.add(titleLabel);

        JLabel exercisesLabel = new JLabel("Total Exercises: " + result.getTotalExercises(), JLabel.CENTER);
        exercisesLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        exercisesLabel.setForeground(Color.WHITE);
        panel.add(exercisesLabel);

        JLabel caloriesLabel = new JLabel("Total Calories Burned: " + result.getTotalCalories(), JLabel.CENTER);
        caloriesLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        caloriesLabel.setForeground(Color.WHITE);
        panel.add(caloriesLabel);

        JLabel timeLabel = new JLabel("Total Time: " + result.getTotalTime() + " seconds", JLabel.CENTER);
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        timeLabel.setForeground(Color.WHITE);
        panel.add(timeLabel);

        JButton backButton = new JButton("Kembali ke Halaman Utama");
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.setPreferredSize(new Dimension(250, 50));
        backButton.addActionListener(e -> workoutGUI.createAndShowGUI());
        panel.add(backButton);
    }

    public JPanel getPanel() {
        return panel;
    }
}
