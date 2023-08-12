
import javax.swing.*;
import java.awt.*;

public class prob2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(prob2::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Problema 2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Canvas canvas = new Canvas() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);

 
                int canvasWidth = getWidth();
                int canvasHeight = getHeight();

                int circleSize = Math.min(canvasWidth, canvasHeight);

                int circleX = (canvasWidth - circleSize) / 2;
                int circleY = (canvasHeight - circleSize) / 2;

                g.setColor(Color.RED);
                g.fillOval(circleX, circleY, circleSize, circleSize);
            }
        };

        frame.getContentPane().add(canvas);

        //frame.pack();
        frame.setLocationRelativeTo(null); // frame pe centru
        frame.setVisible(true);
    }
}
