import javax.swing.*;
import java.awt.*;
import java.util.List;

public class StartWorkoutPanel {
    private JPanel mainPanel;
    private JLabel workoutNameLabel;
    private JLabel workoutImageLabel;
    private JLabel timerLabel;
    private JLabel targetLabel; 
    private JButton nextButton;
    private WorkoutGUI workoutGUI;
    private StartWorkout startWorkout;
    private Timer timer;
    private int countdown;
    private boolean isRestSession;

    public StartWorkoutPanel(List<Exercise> exercises, WorkoutGUI workoutGUI) {
        this.workoutGUI = workoutGUI;
        this.startWorkout = new StartWorkout(exercises, workoutGUI);

        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.DARK_GRAY);

        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.GRAY);
        topPanel.setLayout(new BorderLayout());

        workoutNameLabel = new JLabel("", JLabel.CENTER);
        workoutNameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        workoutNameLabel.setForeground(Color.WHITE);
        topPanel.add(workoutNameLabel, BorderLayout.NORTH);

        workoutImageLabel = new JLabel("", JLabel.CENTER);
        topPanel.add(workoutImageLabel, BorderLayout.CENTER);

        JPanel labelsPanel = new JPanel(new GridLayout(2, 1)); 
        labelsPanel.setBackground(Color.GRAY);

        timerLabel = new JLabel("", JLabel.CENTER);
        timerLabel.setFont(new Font("Arial", Font.BOLD, 30));
        timerLabel.setForeground(Color.RED);
        labelsPanel.add(timerLabel);

        targetLabel = new JLabel("", JLabel.CENTER);
        targetLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        targetLabel.setForeground(Color.YELLOW); 
        labelsPanel.add(targetLabel);

        topPanel.add(labelsPanel, BorderLayout.SOUTH);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.GRAY);
        nextButton = new JButton("Next");
        nextButton.setFont(new Font("Arial", Font.BOLD, 16));
        nextButton.setPreferredSize(new Dimension(100, 50));
        nextButton.addActionListener(e -> nextExercise());
        bottomPanel.add(nextButton);

        mainPanel.add(topPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        startWorkout.startWorkout();
        updateCurrentExercise();
    }

    private void nextExercise() {
        if (timer != null) {
            timer.stop();
        }

        if (isRestSession) {
            startWorkout.nextExercise();
            isRestSession = false;
        } else {
            isRestSession = true;
        }

        updateCurrentExercise();
    }

    private void updateCurrentExercise() {
        Exercise currentExercise = startWorkout.getCurrentExercise();
        if (currentExercise != null) {
            workoutNameLabel.setText(isRestSession ? "Rest Session" : "Workout: " + currentExercise.getName());
            updateWorkoutImage(currentExercise.getImagePath());

            if (currentExercise instanceof TimeBasedExercise) {
                TimeBasedExercise timeBasedExercise = (TimeBasedExercise) currentExercise;
                startCountdown(timeBasedExercise.getDuration(), false);
                targetLabel.setText(""); 
            } else if (currentExercise instanceof TargetBasedExercise) {
                TargetBasedExercise targetBasedExercise = (TargetBasedExercise) currentExercise;
                targetLabel.setText("Target: " + targetBasedExercise.getJumlahTarget()); 
                timerLabel.setText(""); 
            } else if (isRestSession) {
                startCountdown(30, true); 
                targetLabel.setText(""); 
            } else {
                timerLabel.setText("");
                targetLabel.setText("");
            }
        } else {
            showWorkoutResults();
        }
    }

    private void showWorkoutResults() {
        WorkoutResult result = startWorkout.getWorkoutResult();
        workoutGUI.showWorkoutResult(result);
    }

    private void startCountdown(int duration, boolean isRest) {
        countdown = duration;
        timerLabel.setText(String.valueOf(countdown) + " seconds");
        timer = new Timer(1000, e -> {
            countdown--;
            if (countdown >= 0) {
                timerLabel.setText(String.valueOf(countdown) + " seconds");
            } else {
                timer.stop();
                timerLabel.setText("Time's up!");
                if (isRest) {
                    nextExercise();
                }
            }
        });
        timer.start();
    }

    private void updateWorkoutImage(String imagePath) {
        if (imagePath != null && !imagePath.isEmpty()) {
            ImageIcon icon = new ImageIcon(imagePath);
            if (icon.getIconWidth() != -1) {
                Image image = icon.getImage();
                Image resizedImage = image.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
                workoutImageLabel.setIcon(new ImageIcon(resizedImage));
                workoutImageLabel.setText("");
            } else {
                workoutImageLabel.setText("Image not found");
                workoutImageLabel.setIcon(null);
            }
        } else {
            workoutImageLabel.setText("No image available");
            workoutImageLabel.setIcon(null);
        }
    }

    public JPanel getPanel() {
        return mainPanel;
    }
}
