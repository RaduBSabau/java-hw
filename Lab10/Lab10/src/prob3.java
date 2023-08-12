
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class prob3 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(prob3::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Problema 3");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                try {
                    BufferedImage image = ImageIO.read(new File("imagine.jpg")); 

                    g.drawImage(image, 0, 0, null);


                    g.setColor(new Color(255, 0, 0)); 
                    Font font = new Font("Arial", Font.BOLD, 20); 


                    g.setFont(font);
                    g.drawString("nume.jpg", 10, image.getHeight() + 30); 
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };


        frame.getContentPane().add(panel);


        //frame.pack();
        frame.setLocationRelativeTo(null); // frame centru
        frame.setVisible(true);
    }
}
