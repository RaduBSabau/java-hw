
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class prob6 extends JFrame {
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JComboBox<String> yearComboBox;
    private JComboBox<String> facultyComboBox;
    private JComboBox<String> courseComboBox;
    private JCheckBox fundingCheckbox1, fundingCheckbox2;
    private JTextArea infoTextArea;

    public prob6() {
        setTitle("Student Registration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crearea containerului principal
        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        // Crearea panoului pentru formularul de înregistrare
        JPanel formPanel = new JPanel(new GridLayout(7, 2));

        JLabel firstNameLabel = new JLabel("Nume:");
        firstNameField = new JTextField();
        JLabel lastNameLabel = new JLabel("Prenume:");
        lastNameField = new JTextField();
        JLabel yearLabel = new JLabel("An de studii:");
        yearComboBox = new JComboBox<>(new String[]{"Anul 1", "Anul 2", "Anul 3", "Anul 4", "Master"});
        JLabel facultyLabel = new JLabel("Facultatea:");
        facultyComboBox = new JComboBox<>(new String[]{"AC", "Constructii", "ETTI", "IE"});
        JLabel fundingLabel = new JLabel("Finanțare:");
        fundingCheckbox1 = new JCheckBox("Taxă");
        JLabel courseLabel = new JLabel("Cursul dorit:");
        courseComboBox = new JComboBox<>(new String[]{"Matematici Speciale", "Ecuatii Diferentiale", "Fizica I"});
        JButton registerButton = new JButton("Înregistrare");

        formPanel.add(firstNameLabel);
        formPanel.add(firstNameField);
        formPanel.add(lastNameLabel);
        formPanel.add(lastNameField);
        formPanel.add(yearLabel);
        formPanel.add(yearComboBox);
        formPanel.add(facultyLabel);
        formPanel.add(facultyComboBox);
        formPanel.add(fundingLabel);
        formPanel.add(fundingCheckbox1);
        formPanel.add(courseLabel);
        formPanel.add(courseComboBox);
        formPanel.add(registerButton);

        container.add(formPanel, BorderLayout.CENTER);

        // Crearea câmpului de text pentru afișarea informațiilor înregistrate
        infoTextArea = new JTextArea();
        infoTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(infoTextArea);
        container.add(scrollPane, BorderLayout.SOUTH);

        // Adăugarea acțiunii de apăsare a butonului de înregistrare
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String year = (String) yearComboBox.getSelectedItem();
                String faculty = (String) facultyComboBox.getSelectedItem();
                boolean funding1 = fundingCheckbox1.isSelected();
                String course = (String) courseComboBox.getSelectedItem();

                StringBuilder info = new StringBuilder();
                info.append("Nume: ").append(firstName).append("\n");
                info.append("Prenume: ").append(lastName).append("\n");
                info.append("An de studii: ").append(year).append("\n");
                info.append("Facultatea: ").append(faculty).append("\n");
                info.append("Finanțare: ").append(funding1 ? "Taxă" : "Buget").append("\n");
                info.append("Cursul dorit: ").append(course);

                infoTextArea.setText(info.toString());
            }
        });

        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            prob6 registrationApp = new prob6();
            registrationApp.setVisible(true);
        });
    }
}

