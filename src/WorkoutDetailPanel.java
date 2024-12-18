import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class WorkoutDetailPanel {
    private JPanel mainPanel;
    private JPanel listPanel;

    public WorkoutDetailPanel(String workoutName, List<Exercise> exercises, WorkoutGUI workoutGUI) {
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(30, 30, 30)); 

        
        JLabel workoutLabel = new JLabel("Detail Latihan: " + workoutName, JLabel.CENTER);
        workoutLabel.setFont(new Font("Arial", Font.BOLD, 24)); 
        workoutLabel.setForeground(Color.WHITE);
        workoutLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0)); 
        mainPanel.add(workoutLabel, BorderLayout.NORTH);

        
        listPanel = new JPanel();
        listPanel.setBackground(new Color(30, 30, 30));
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        listPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 

        for (Exercise exercise : exercises) {
            JPanel exercisePanel = createExercisePanel(exercise);
            listPanel.add(Box.createVerticalStrut(10)); 
            listPanel.add(exercisePanel);
        }

        
        JScrollPane scrollPane = new JScrollPane(listPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        mainPanel.add(scrollPane, BorderLayout.CENTER);

        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(30, 30, 30));

        CustomButton startButton = new CustomButton("Mulai");
        startButton.setFont(new Font("Arial", Font.BOLD, 16));
        startButton.setBackground(new Color(70, 130, 180)); 
        startButton.setForeground(Color.WHITE);
        startButton.setPreferredSize(new Dimension(100, 30));
        startButton.addActionListener(e -> workoutGUI.showStartPage(exercises));
        buttonPanel.add(startButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
    }

    private JPanel createExercisePanel(Exercise exercise) {
        JPanel exercisePanel = new JPanel(new BorderLayout());
        exercisePanel.setBackground(new Color(50, 50, 50)); 
        exercisePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 

        
        JLabel imageLabel = new JLabel("", JLabel.CENTER);
        String imagePath = exercise.getImagePath();
        ImageIcon icon = new ImageIcon(imagePath);
        
        if (icon.getIconWidth() != -1) { 
            Image image = icon.getImage();
            Image resizedImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH); 
            imageLabel.setIcon(new ImageIcon(resizedImage));
            imageLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
        } else {
            imageLabel.setText("Gambar tidak ditemukan");
            imageLabel.setForeground(Color.RED); 
        }

        exercisePanel.add(imageLabel, BorderLayout.WEST);

        JPanel infoPanel = new JPanel();
        infoPanel.setBackground(new Color(50, 50, 50));
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 

        JLabel nameLabel = new JLabel(exercise.getName());
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        nameLabel.setForeground(Color.WHITE);
        infoPanel.add(nameLabel);

        JLabel targetAreaLabel = new JLabel("Target Area: " + String.join(", ", exercise.getTargetArea()));
        targetAreaLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        targetAreaLabel.setForeground(Color.LIGHT_GRAY);
        infoPanel.add(targetAreaLabel);

        exercisePanel.add(infoPanel, BorderLayout.CENTER);

        exercisePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showExerciseDetails(exercise);
            }
        });

        return exercisePanel;
    }

    private void showExerciseDetails(Exercise exercise) {
        UIManager.put("OptionPane.background", new Color(50, 50, 50));
        UIManager.put("Panel.background", new Color(50, 50, 50));
        UIManager.put("OptionPane.messageForeground", Color.WHITE);
        UIManager.put("Button.background", new Color(70, 70, 70));
        UIManager.put("Button.foreground", Color.WHITE);

        JPanel popupPanel = new JPanel();
        popupPanel.setLayout(new BoxLayout(popupPanel, BoxLayout.Y_AXIS));
        popupPanel.setBackground(new Color(50, 50, 50));
        popupPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 

        JLabel imageLabel = new JLabel("", JLabel.CENTER);
        ImageIcon icon = new ImageIcon(exercise.getImagePath());
        Image image = icon.getImage();
        Image resizedImage = image.getScaledInstance(150, 150, Image.SCALE_SMOOTH); 
        imageLabel.setIcon(new ImageIcon(resizedImage));
        imageLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
        popupPanel.add(imageLabel);

        JLabel nameLabel = new JLabel(exercise.getName());
        nameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        nameLabel.setForeground(Color.WHITE);
        popupPanel.add(nameLabel);

        JLabel targetAreaLabel = new JLabel("Target Area: " + String.join(", ", exercise.getTargetArea()));
        targetAreaLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        targetAreaLabel.setForeground(Color.LIGHT_GRAY);
        popupPanel.add(targetAreaLabel);

        JLabel descriptionLabel = new JLabel("Deskripsi: " + exercise.getDescription());
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        descriptionLabel.setForeground(Color.LIGHT_GRAY);
        popupPanel.add(descriptionLabel);

        JOptionPane.showMessageDialog(mainPanel,
                popupPanel,
                "Detail Latihan",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public JPanel getPanel() {
        return mainPanel;
    }
}
