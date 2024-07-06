import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;

class CircularLabel extends JLabel {
    public CircularLabel() {
        super();
        setPreferredSize(new Dimension(100, 100));
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw the circle
        int diameter = Math.min(getWidth(), getHeight());
        int x = (getWidth() - diameter) / 2;
        int y = (getHeight() - diameter) / 2;
        g2.setColor(new Color(234, 230, 230));
        g2.fillOval(x, y, diameter, diameter);

        g2.setColor(Color.GREEN);
        g2.setStroke(new BasicStroke(2));
        g2.drawOval(x, y, diameter, diameter);

        // Draw the text
        g2.setColor(Color.BLACK);
        g2.setFont(new Font("Arial", Font.BOLD, 30));
        FontMetrics fm = g2.getFontMetrics();
        String text = getText();
        int textWidth = fm.stringWidth(text);
        int textHeight = fm.getAscent();
        int textX = getWidth() / 2 - textWidth / 2;
        int textY = getHeight() / 2 + textHeight / 4;
        g2.drawString(text, textX, textY);


    }
}
