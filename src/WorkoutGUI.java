import javax.swing.*;
import java.awt.*;
import java.util.List;

public class WorkoutGUI {
    private JFrame frame;

    public void createAndShowGUI() {
        frame = new JFrame("SigMove");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.DARK_GRAY);

        LoginPanel loginPanel = new LoginPanel();
        WorkoutOptionPanel workoutOptionPanel = new WorkoutOptionPanel(this);

        mainPanel.add(loginPanel.getPanel(), BorderLayout.WEST);
        mainPanel.add(workoutOptionPanel.getPanel(), BorderLayout.CENTER);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    public void showWorkoutDetail(String workoutName) {
        frame.getContentPane().removeAll();

        Workout workout = new Workout();
        List<Exercise> exercises = workout.getFilteredExercises(workoutName);
        WorkoutDetailPanel workoutDetailPanel = new WorkoutDetailPanel(workoutName, exercises, this);

        frame.add(workoutDetailPanel.getPanel());
        frame.revalidate();
        frame.repaint();
    }

    public void showStartPage(List<Exercise> exercises) {
        frame.getContentPane().removeAll();

        StartWorkoutPanel startWorkoutPanel = new StartWorkoutPanel(exercises, this); 
        frame.add(startWorkoutPanel.getPanel());
        frame.revalidate();
        frame.repaint();
    }

    public void showWorkoutResult(WorkoutResult result) {
        frame.getContentPane().removeAll();

        WorkoutResultPanel resultPanel = new WorkoutResultPanel(result, this); 
        frame.add(resultPanel.getPanel());
        frame.revalidate();
        frame.repaint();
    }
}
