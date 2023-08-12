
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class prob5 extends JFrame {
    private JTextField redField;
    private JTextField greenField;
    private JTextField blueField;
    private JLabel resultLabel;

    public prob5() {
        setTitle("Text RGB");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crearea containerului principal
        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        // Crearea panoului pentru introducerea valorilor RGB
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));

        JLabel redLabel = new JLabel("Rosu:");
        redField = new JTextField();
        JLabel greenLabel = new JLabel("Verde:");
        greenField = new JTextField();
        JLabel blueLabel = new JLabel("Albastru:");
        blueField = new JTextField();
        JButton submitButton = new JButton("Schimba culoarea");

        inputPanel.add(redLabel);
        inputPanel.add(redField);
        inputPanel.add(greenLabel);
        inputPanel.add(greenField);
        inputPanel.add(blueLabel);
        inputPanel.add(blueField);
        inputPanel.add(submitButton);

        container.add(inputPanel, BorderLayout.CENTER);

        // Crearea etichetei pentru afișarea culorii rezultate
        resultLabel = new JLabel();
        resultLabel.setOpaque(true);
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(resultLabel, BorderLayout.SOUTH);

        // Adăugarea acțiunii de apăsare a butonului Submit
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int red = Integer.parseInt(redField.getText());
                    int green = Integer.parseInt(greenField.getText());
                    int blue = Integer.parseInt(blueField.getText());

                    if (red >= 0 && red <= 255 && green >= 0 && green <= 255 && blue >= 0 && blue <= 255) {
                        Color color = new Color(red, green, blue);
                        resultLabel.setText("Culoare: Rosu = " + red + " Verde = " + green + " Albastru = " + blue);
                        resultLabel.setForeground(color);
                    } else {
                        throw new IllegalArgumentException("Valorile trebuie să fie între 0 și 255.");
                    }
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Eroare: Introduceți valori numerice între 0 și 255.");
                    resultLabel.setForeground(Color.RED);
                } catch (IllegalArgumentException ex) {
                    resultLabel.setText("Eroare: " + ex.getMessage());
                    resultLabel.setForeground(Color.RED);
                }
            }
        });

        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            prob5 five = new prob5();
            five.setVisible(true);
        });
    }
}
