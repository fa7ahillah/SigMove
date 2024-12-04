import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkoutDetails extends JFrame {
    public WorkoutDetails(String programName, String[] exercises) {
        setTitle(programName);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Program: " + programName, SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        JList<String> exerciseList = new JList<>(exercises);
        add(new JScrollPane(exerciseList), BorderLayout.CENTER);

        JButton startButton = new JButton("Mulai Program");
        add(startButton, BorderLayout.SOUTH);

        startButton.addActionListener(e -> {
            if (!exerciseList.isSelectionEmpty()) {
                String selectedExercise = exerciseList.getSelectedValue();
                new WorkoutSession(selectedExercise);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Pilih salah satu olahraga terlebih dahulu!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
