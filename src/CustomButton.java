import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class CustomButton extends JButton {
    public CustomButton(String text) {
        super(text);
        setContentAreaFilled(false); 
        setFocusPainted(false); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Shape roundedRectangle = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 40, 40);
        g2.setColor(getBackground());
        g2.fill(roundedRectangle);
        g2.setColor(getForeground());
        g2.drawString(getText(), getWidth() / 2 - g2.getFontMetrics().stringWidth(getText()) / 2, getHeight() / 2 + g2.getFontMetrics().getAscent() / 2 - 2);
        
        g2.dispose();
        super.paintComponent(g);
    }
}
