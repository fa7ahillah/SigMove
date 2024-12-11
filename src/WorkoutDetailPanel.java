import javax.swing.*;
import java.awt.*;
import java.util.List;

public class WorkoutDetailPanel {
    private JPanel panel;

    public WorkoutDetailPanel(String workoutName, List<Exercise> exercises, WorkoutGUI workoutGUI) {
        panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel workoutLabel = new JLabel(workoutName, JLabel.CENTER);
        workoutLabel.setFont(new Font("Arial", Font.BOLD, 18));
        workoutLabel.setForeground(Color.WHITE);
        panel.add(workoutLabel);

        for (Exercise exercise : exercises) {
            JPanel exercisePanel = new JPanel();
            exercisePanel.setBackground(Color.GRAY);
            exercisePanel.setLayout(new BoxLayout(exercisePanel, BoxLayout.Y_AXIS));
            exercisePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            Dimension panelSize = new Dimension(300, 150); 
            exercisePanel.setPreferredSize(panelSize);
            exercisePanel.setMaximumSize(panelSize);
            exercisePanel.setMinimumSize(panelSize);

            JLabel nameLabel = new JLabel("Nama: " + exercise.getName());
            nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
            nameLabel.setForeground(Color.BLACK);
            exercisePanel.add(nameLabel);

            JLabel targetAreaLabel = new JLabel("Target Area: " + exercise.getTargetArea());
            targetAreaLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            targetAreaLabel.setForeground(Color.BLACK);
            exercisePanel.add(targetAreaLabel);

            JLabel durationLabel = new JLabel("Duration: " + (exercise.getDuration() > 0 ? exercise.getDuration() + " detik" : "-"));
            durationLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            durationLabel.setForeground(Color.BLACK);
            exercisePanel.add(durationLabel);

            JLabel jumlahTargetLabel = new JLabel("Jumlah Target: " + (exercise.getJumlahTarget() > 0 ? exercise.getJumlahTarget() + " kali" : "-"));
            jumlahTargetLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            jumlahTargetLabel.setForeground(Color.BLACK);
            exercisePanel.add(jumlahTargetLabel);

            JLabel descriptionLabel = new JLabel("Deskripsi: " + exercise.getDescription());
            descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            descriptionLabel.setForeground(Color.BLACK);
            exercisePanel.add(descriptionLabel);

            panel.add(Box.createVerticalGlue());
            panel.add(Box.createHorizontalGlue());
            panel.add(exercisePanel);
            panel.add(Box.createHorizontalGlue());
            panel.add(Box.createVerticalGlue());
        }

        JButton mulaiButton = new JButton("Mulai");
        mulaiButton.setPreferredSize(new Dimension(100, 30));
        mulaiButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mulaiButton.addActionListener(e -> workoutGUI.showStartPage(exercises));
        panel.add(mulaiButton);
    }

    public JPanel getPanel() {
        return panel;
    }
}
