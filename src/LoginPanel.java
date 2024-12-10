import javax.swing.*;
import java.awt.*;

public class LoginPanel {
    private JPanel panel;

    public LoginPanel() {
        panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.DARK_GRAY);
        panel.setPreferredSize(new Dimension(200, 600));

        JButton loginButton = new JButton("Log In");
        loginButton.setPreferredSize(new Dimension(185, 42));
        loginButton.setBackground(new Color(173, 216, 230));
        loginButton.setForeground(Color.WHITE);

        JButton signupButton = new JButton("Sign Up");
        signupButton.setPreferredSize(new Dimension(185, 42));
        signupButton.setBackground(Color.WHITE);
        signupButton.setForeground(Color.BLACK);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(5, 0, 5, 0);
        panel.add(loginButton, gbc);

        gbc.gridy = 1;
        panel.add(signupButton, gbc);
    }

    public JPanel getPanel() {
        return panel;
    }
}
