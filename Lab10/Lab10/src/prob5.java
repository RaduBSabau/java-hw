
// problema asta nu functioneaza nu imi shcimba culoarea cand face repaint
import javax.swing.*;
import java.awt.*;

public class prob5 {
    private static final int CIRCLE_SIZE = 300; // dim cerc
    private static final int DELAY = 100; // ms intre tranzitii cerc

    public static void main(String[] args) {
        SwingUtilities.invokeLater(prob5::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Aplicatie Java");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                int panelWidth = getWidth();
                int panelHeight = getHeight();

                int circleX = (panelWidth - CIRCLE_SIZE) / 2;
                int circleY = (panelHeight - CIRCLE_SIZE) / 2;

                g.setColor(getNextColor());
                g.fillOval(circleX, circleY, CIRCLE_SIZE, CIRCLE_SIZE);
            }
        };

        frame.getContentPane().add(panel);

        frame.pack();
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);

        // timer la care am setat delay-ul mai sus
        Timer timer = new Timer(DELAY, e -> {
            panel.repaint();
        });
        timer.start();
    }

    //schimbarea culorii
    private static Color getNextColor() {
        Color color = Color.RED;
        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();

        if (red > 0) {
            red--;
        } else if (green < 255) {
            green++;
        } else if (blue < 255) {
            blue++;
        }

        return new Color(red, green, blue);
    }
}
