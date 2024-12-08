import javax.swing.*;
import java.awt.*;

public class WorkoutGUI {
    private JFrame frame;

    public void createAndShowGUI() {
        frame = new JFrame("SigMove");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Setup main panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.DARK_GRAY);

        // Create and add panels
        LoginPanel loginPanel = new LoginPanel();
        WorkoutOptionPanel workoutOptionPanel = new WorkoutOptionPanel(this);

        mainPanel.add(loginPanel.getPanel(), BorderLayout.WEST);
        mainPanel.add(workoutOptionPanel.getPanel(), BorderLayout.CENTER);

        // Add main panel to frame
        frame.add(mainPanel);
        frame.setVisible(true);
    }

    public void showWorkoutDetail(String workoutName) {
        frame.getContentPane().removeAll();
        WorkoutDetailPanel workoutDetailPanel = new WorkoutDetailPanel(workoutName);
        frame.add(workoutDetailPanel.getPanel());
        frame.revalidate();
        frame.repaint();
    }
}
