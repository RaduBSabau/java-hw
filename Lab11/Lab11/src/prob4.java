
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class prob4 extends JFrame {
    private JTextField nameField;
    private JTextField groupField;
    private JLabel infoLabel;

    public prob4() {
        setTitle("User Info");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crearea containerului principal
        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        // Crearea panoului pentru introducerea datelor
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));

        JLabel nameLabel = new JLabel("Nume:");
        nameField = new JTextField();
        JLabel groupLabel = new JLabel("Grupa:");
        groupField = new JTextField();
        JButton submitButton = new JButton("Enter");

        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(groupLabel);
        inputPanel.add(groupField);
        inputPanel.add(submitButton);

        container.add(inputPanel, BorderLayout.CENTER);

        // Crearea etichetei pentru afișarea informațiilor
        infoLabel = new JLabel();
        infoLabel.setOpaque(true);
        infoLabel.setBackground(new Color(122, 123, 129));
        infoLabel.setForeground(Color.WHITE);
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(infoLabel, BorderLayout.SOUTH);

        // Adăugarea acțiunii de apăsare a butonului Submit
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String group = groupField.getText();

                String infoText = "Nume: " + name + " | Grupa: " + group;
                infoLabel.setText(infoText);
            }
        });

        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            prob4 userInfoApp = new prob4();
            userInfoApp.setVisible(true);
        });
    }
}
