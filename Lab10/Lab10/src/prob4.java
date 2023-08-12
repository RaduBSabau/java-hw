
import javax.swing.*;
import java.awt.*;

public class prob4 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(prob4::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Problema 4");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);


                int panelWidth = getWidth();
                int panelHeight = getHeight();


                int graySize = Math.min(panelWidth, panelHeight) / 10;

                for (int i = 0; i < 10; i++) {
                    int grayValue = i * 25;
                    g.setColor(new Color(grayValue, grayValue, grayValue));
                    g.fillRect(i * graySize, i * graySize, panelWidth - i * graySize * 2, panelHeight - i * graySize * 2);
                }

                Color[] baseColors = {
                        Color.RED,
                        Color.GREEN,
                        Color.BLUE,
                        Color.YELLOW,
                        Color.CYAN,
                        Color.MAGENTA
                };

                // dem celula de culoare
                int colorSize = graySize * 2;

                // le desenam (celulele)
                for (int i = 0; i < baseColors.length; i++) {
                    g.setColor(baseColors[i]);
                    g.fillRect((i + 1) * graySize * 4, (i + 1) * graySize * 4, colorSize, colorSize);
                }
            }
        };

        frame.getContentPane().add(panel);

        //frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
