
import javax.swing.*;
import java.awt.*;

public class prob1 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(prob1::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Problema 1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                
                g.setColor(Color.BLUE);
                
                Font currentFont = g.getFont();
                
                Font newFont = currentFont.deriveFont(Font.BOLD, 20f);
                
                g.setFont(newFont);
                
                int panelWidth = getWidth();
                int panelHeight = getHeight();
                
                FontMetrics fontMetrics = g.getFontMetrics();
                int textWidth = fontMetrics.stringWidth("2125");
                int textHeight = fontMetrics.getHeight();
                
                int centerX = (panelWidth - textWidth) / 2;
                int centerY = (panelHeight - textHeight) / 2 + fontMetrics.getAscent();
                g.drawString("2125", centerX, centerY);
            }
        };
        
        frame.getContentPane().add(panel);
        
        //frame.pack();
        frame.setLocationRelativeTo(null); // frame la centru
        frame.setVisible(true);
    }
}
