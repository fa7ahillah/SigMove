import javax.swing.*;
import java.awt.*;
import java.util.List;

public class WorkoutDetailPanel {
    private JPanel mainPanel;
    private JPanel listPanel;
    private JPanel buttonPanel;

    public WorkoutDetailPanel(String workoutName, List<Exercise> exercises, WorkoutGUI workoutGUI) {
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.DARK_GRAY);
        mainPanel.setLayout(new BorderLayout());

        listPanel = new JPanel();
        listPanel.setBackground(Color.DARK_GRAY);
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));

        JLabel workoutLabel = new JLabel("Detail Latihan: " + workoutName, JLabel.CENTER);
        workoutLabel.setFont(new Font("Arial", Font.BOLD, 18));
        workoutLabel.setForeground(Color.WHITE);
        listPanel.add(workoutLabel);

        for (Exercise exercise : exercises) {
            System.out.println("Menambahkan latihan: " + exercise.getName() + " - ID: " + exercise.getID());

            JButton exerciseButton = new JButton(exercise.getName());
            exerciseButton.setFont(new Font("Arial", Font.BOLD, 16));
            exerciseButton.setBackground(Color.GRAY);
            exerciseButton.setForeground(Color.BLACK);
            exerciseButton.setPreferredSize(new Dimension(300, 50));
            exerciseButton.setMaximumSize(new Dimension(300, 50));
            exerciseButton.setMinimumSize(new Dimension(300, 50));
            exerciseButton.setAlignmentX(Component.CENTER_ALIGNMENT);

            exerciseButton.addActionListener(e -> showDescription(exercise));

            listPanel.add(Box.createVerticalStrut(10));
            listPanel.add(exerciseButton);
        }

        JScrollPane scrollPane = new JScrollPane(listPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.DARK_GRAY);
        buttonPanel.setLayout(new FlowLayout());

        JButton mulaiButton = new JButton("Mulai");
        mulaiButton.setPreferredSize(new Dimension(100, 30));
        mulaiButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mulaiButton.addActionListener(e -> workoutGUI.showStartPage(exercises));
        buttonPanel.add(mulaiButton);

        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
    }

    private void showDescription(Exercise exercise) {
        JDialog descriptionDialog = new JDialog((Frame) null, "Deskripsi Latihan", true);
        descriptionDialog.setSize(400, 300);
        descriptionDialog.setLocationRelativeTo(null);
        descriptionDialog.setLayout(new BorderLayout());

        JPanel descriptionPanel = new JPanel();
        descriptionPanel.setBackground(Color.LIGHT_GRAY);
        descriptionPanel.setLayout(new BoxLayout(descriptionPanel, BoxLayout.Y_AXIS));
        descriptionPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel nameLabel = new JLabel("Nama: " + exercise.getName());
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        nameLabel.setForeground(Color.BLACK);
        descriptionPanel.add(nameLabel);

        JLabel targetAreaLabel = new JLabel("Target Area: " + String.join(", ", exercise.getTargetArea()));
        targetAreaLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        targetAreaLabel.setForeground(Color.BLACK);
        descriptionPanel.add(targetAreaLabel);

        JLabel descriptionLabel = new JLabel("Deskripsi: " + exercise.getDescription());
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        descriptionLabel.setForeground(Color.BLACK);
        descriptionPanel.add(descriptionLabel);

        descriptionDialog.add(descriptionPanel, BorderLayout.CENTER);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> descriptionDialog.dispose());
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.LIGHT_GRAY);
        buttonPanel.add(okButton);
        descriptionDialog.add(buttonPanel, BorderLayout.SOUTH);

        descriptionDialog.setVisible(true);
    }

    public JPanel getPanel() {
        return mainPanel;
    }
}
