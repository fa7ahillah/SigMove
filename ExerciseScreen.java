import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExerciseScreen {
    private JFrame frame;
    private JLabel timerLabel;
    private Timer timer;
    private int timeLeft = 20; 

    public ExerciseScreen() {
        frame = new JFrame("SigMove");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLayout(new BorderLayout());

        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton backButton = new JButton("←");
        JLabel headerLabel = new JLabel("Dada");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        headerPanel.add(backButton);
        headerPanel.add(headerLabel);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        //buat gambar
        ImageIcon exerciseImage = new ImageIcon(""); 
        JLabel imageLabel = new JLabel(exerciseImage);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel exerciseLabel = new JLabel("JUMPING JACKS");
        exerciseLabel.setFont(new Font("Arial", Font.BOLD, 16));
        exerciseLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        timerLabel = new JLabel(String.format("00:%02d", timeLeft));
        timerLabel.setFont(new Font("Arial", Font.BOLD, 28));
        timerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton skipButton = new JButton("SKIP");
        skipButton.setFont(new Font("Arial", Font.BOLD, 14));
        skipButton.setBackground(Color.CYAN);
        skipButton.setForeground(Color.BLACK);
        skipButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        skipButton.addActionListener(e -> {
            timer.stop(); 
            JOptionPane.showMessageDialog(frame, "Skipped to next exercise!");
        });

        contentPanel.add(Box.createVerticalStrut(20));
        contentPanel.add(imageLabel);
        contentPanel.add(Box.createVerticalStrut(20));
        contentPanel.add(exerciseLabel);
        contentPanel.add(Box.createVerticalStrut(20));
        contentPanel.add(timerLabel);
        contentPanel.add(Box.createVerticalStrut(20));
        contentPanel.add(skipButton);

        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(contentPanel, BorderLayout.CENTER);

        startTimer();

        frame.setVisible(true);
    }

    private void startTimer() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeLeft--;
                if (timeLeft >= 0) {
                    timerLabel.setText(String.format("00:%02d", timeLeft));
                } else {
                    timer.stop();
                    JOptionPane.showMessageDialog(frame, "Time's up! Move to the next exercise!");
                }
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ExerciseScreen::new);
    }
}
