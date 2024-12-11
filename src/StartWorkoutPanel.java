import javax.swing.*;
import java.awt.*;
import java.util.List;

public class StartWorkoutPanel {
    private JPanel panel;
    private List<Exercise> exercises;
    private int currentExerciseIndex;

    public StartWorkoutPanel(List<Exercise> exercises) {
        this.exercises = exercises;
        this.currentExerciseIndex = 0;
        panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.setLayout(new BorderLayout());

        showCurrentExercise();
    }

    private void showCurrentExercise() {
        panel.removeAll();

        if (currentExerciseIndex < exercises.size()) {
            Exercise currentExercise = exercises.get(currentExerciseIndex);

            JLabel nameLabel = new JLabel(currentExercise.getName(), JLabel.CENTER);
            nameLabel.setFont(new Font("Arial", Font.BOLD, 24));
            nameLabel.setForeground(Color.WHITE);

            JLabel targetAreaLabel = new JLabel("Target Area: " + currentExercise.getTargetArea(), JLabel.CENTER);
            targetAreaLabel.setFont(new Font("Arial", Font.PLAIN, 20));
            targetAreaLabel.setForeground(Color.WHITE);

            JLabel durationLabel = new JLabel("Duration: " + (currentExercise.getDuration() > 0 ? currentExercise.getDuration() + " detik" : "-"), JLabel.CENTER);
            durationLabel.setFont(new Font("Arial", Font.PLAIN, 20));
            durationLabel.setForeground(Color.WHITE);

            JLabel jumlahTargetLabel = new JLabel("Jumlah Target: " + (currentExercise.getJumlahTarget() > 0 ? currentExercise.getJumlahTarget() + " kali" : "-"), JLabel.CENTER);
            jumlahTargetLabel.setFont(new Font("Arial", Font.PLAIN, 20));
            jumlahTargetLabel.setForeground(Color.WHITE);

            JLabel descriptionLabel = new JLabel("Deskripsi: " + currentExercise.getDescription(), JLabel.CENTER);
            descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 20));
            descriptionLabel.setForeground(Color.WHITE);

            JButton nextButton = new JButton("Next");
            nextButton.addActionListener(e -> {
                currentExerciseIndex++;
                showCurrentExercise();
            });

            panel.add(nameLabel, BorderLayout.NORTH);
            JPanel detailsPanel = new JPanel();
            detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
            detailsPanel.setBackground(Color.DARK_GRAY);
            detailsPanel.add(targetAreaLabel);
            detailsPanel.add(durationLabel);
            detailsPanel.add(jumlahTargetLabel);
            detailsPanel.add(descriptionLabel);
            panel.add(detailsPanel, BorderLayout.CENTER);
            panel.add(nextButton, BorderLayout.SOUTH);

        } else {
            JLabel endLabel = new JLabel("selamat", JLabel.CENTER);
            endLabel.setFont(new Font("Arial", Font.BOLD, 24));
            endLabel.setForeground(Color.WHITE);
            panel.add(endLabel, BorderLayout.CENTER);
        }

        panel.revalidate();
        panel.repaint();
    }

    public JPanel getPanel() {
        return panel;
    }
}
