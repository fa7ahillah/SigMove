import javax.swing.*;
import java.awt.*;
import java.util.List;

public class WorkoutGUI {
    private JFrame frame;
    private JPanel mainPanel;

    public void createAndShowGUI() {
        frame = new JFrame("SigMove");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.DARK_GRAY);

        frame.add(mainPanel);
        frame.setVisible(true);

        returnToMainPage(); 
    }

    public void showWorkoutDetail(String workoutName) {
        mainPanel.removeAll();

        Workout workout = new Workout();
        List<Exercise> exercises = workout.getFilteredExercises(workoutName);
        WorkoutDetailPanel workoutDetailPanel = new WorkoutDetailPanel(workoutName, exercises, this);

        mainPanel.add(workoutDetailPanel.getPanel(), BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    public void showStartPage(List<Exercise> exercises) {
        mainPanel.removeAll();

        StartWorkoutPanel startWorkoutPanel = new StartWorkoutPanel(exercises, this);
        mainPanel.add(startWorkoutPanel.getPanel(), BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    public void showWorkoutResult(WorkoutResult result) {
        mainPanel.removeAll();

        WorkoutResultPanel resultPanel = new WorkoutResultPanel(result, this);
        mainPanel.add(resultPanel.getPanel(), BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    public void returnToMainPage() {
        mainPanel.removeAll();

        LoginPanel loginPanel = new LoginPanel();
        WorkoutOptionPanel workoutOptionPanel = new WorkoutOptionPanel(this);

        JPanel combinedPanel = new JPanel(new BorderLayout());
        combinedPanel.add(loginPanel.getPanel(), BorderLayout.WEST);
        combinedPanel.add(workoutOptionPanel.getPanel(), BorderLayout.CENTER);

        mainPanel.add(combinedPanel, BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }
}
