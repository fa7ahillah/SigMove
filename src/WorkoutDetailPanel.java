import javax.swing.*;
import java.awt.*;

public class WorkoutDetailPanel {
    private JPanel panel;

    public WorkoutDetailPanel(String workoutName) {
        panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel workoutLabel = new JLabel("Detail Latihan: " + workoutName, JLabel.CENTER);
        workoutLabel.setFont(new Font("Arial", Font.BOLD, 18));
        workoutLabel.setForeground(Color.WHITE);
        panel.add(workoutLabel);

        String[] exercises = {"Exercise 1", "Exercise 2", "Exercise 3", "Exercise 4"};
        for (String exercise : exercises) {
            JLabel exerciseLabel = new JLabel(exercise);
            exerciseLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            exerciseLabel.setForeground(Color.WHITE);
            panel.add(exerciseLabel);
        }
    }

    public JPanel getPanel() {
        return panel;
    }
}
