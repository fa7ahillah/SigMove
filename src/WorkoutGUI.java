import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
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

        List<Exercise> exercises = getExercisesForWorkout(workoutName);
        WorkoutDetailPanel workoutDetailPanel = new WorkoutDetailPanel(workoutName, exercises, this);

        frame.add(workoutDetailPanel.getPanel());
        frame.revalidate();
        frame.repaint();
    }

    public void showStartPage(List<Exercise> exercises) {
        frame.getContentPane().removeAll();

        StartWorkoutPanel startWorkoutPanel = new StartWorkoutPanel(exercises);
        frame.add(startWorkoutPanel.getPanel());
        frame.revalidate();
        frame.repaint();
    }

    private List<Exercise> getExercisesForWorkout(String workoutName) {
        List<Exercise> exercises = new ArrayList<>();

        if (workoutName.equals("DADA")) {
            exercises.add(new Exercise(1, "Jumping Jacks", 30, 0, "Dada", "Latihan untuk memperkuat otot dada dan lengan."));
            exercises.add(new Exercise(2, "Incline Push-Ups", 0, 16, "Dada", "Latihan untuk memperkuat otot dada."));
            exercises.add(new Exercise(2, "Knee Push-Ups", 0, 15, "Dada", "Latihan untuk memperkuat otot dada."));
            exercises.add(new Exercise(2, "Push-Ups", 0, 15, "Dada", "Latihan untuk memperkuat otot dada."));
            exercises.add(new Exercise(2, "Wide Arm Push-Ups", 0, 15, "Dada", "Latihan untuk memperkuat otot dada."));
            exercises.add(new Exercise(2, "Incline Push-Ups", 0, 15, "Dada", "Latihan untuk memperkuat otot dada."));
            exercises.add(new Exercise(2, "Box Push-Ups", 0, 15, "Dada", "Latihan untuk memperkuat otot dada."));
            exercises.add(new Exercise(2, "Wide Arm Push-Ups", 0, 15, "Dada", "Latihan untuk memperkuat otot dada."));
            exercises.add(new Exercise(2, "Hindu Push-Ups", 0, 15, "Dada", "Latihan untuk memperkuat otot dada."));
            exercises.add(new Exercise(2, "Cobra Stretch", 0, 15, "Dada", "Latihan untuk memperkuat otot dada."));
            exercises.add(new Exercise(2, "Chest Stretch", 0, 15, "Dada", "Latihan untuk memperkuat otot dada."));
        } else if (workoutName.equals("PERUT")) {
            exercises.add(new Exercise(3, "Plank", 60, 0, "Perut", "Latihan untuk memperkuat otot perut."));
            exercises.add(new Exercise(4, "Crunch", 0, 30, "Perut", "Latihan untuk memperkuat otot perut."));
        } else if (workoutName.equals("LENGAN")) {
            exercises.add(new Exercise(5, "Bicep Curl", 0, 10, "Lengan", "Latihan untuk memperkuat otot lengan."));
            exercises.add(new Exercise(6, "Tricep Dip", 0, 15, "Lengan", "Latihan untuk memperkuat otot tricep."));
        } else if (workoutName.equals("KAKI")) {
            exercises.add(new Exercise(7, "Squat", 0, 15, "Kaki", "Latihan untuk memperkuat otot kaki."));
            exercises.add(new Exercise(8, "Lunge", 0, 20, "Kaki", "Latihan untuk memperkuat otot kaki."));
        }

        return exercises;
    }
}
