
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class prob1 extends JFrame implements ActionListener {
    // GUI components
    private JTextField displayField;
    private JButton[] numberButtons;
    private JButton addButton, subtractButton, multiplyButton, divideButton, equalsButton, clearButton;

    // Calculator variables
    private double operand1, operand2;
    private String operator;

    public prob1() {
        // Set up the GUI
        super("Calculator");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel displayPanel = new JPanel();
        displayField = new JTextField(20);
        displayPanel.add(displayField);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 4));
        numberButtons = new JButton[10];
        
        //rand 1
        numberButtons[7] = new JButton("7");
        numberButtons[7].addActionListener(this);
        buttonPanel.add(numberButtons[7]);
        numberButtons[8] = new JButton("8");
        numberButtons[8].addActionListener(this);
        buttonPanel.add(numberButtons[8]);
        numberButtons[9] = new JButton("9");
        numberButtons[9].addActionListener(this);
        buttonPanel.add(numberButtons[9]);
        addButton = new JButton("+");
        addButton.addActionListener(this);
        buttonPanel.add(addButton);
        
        //rand 2
        numberButtons[4] = new JButton("4");
        numberButtons[4].addActionListener(this);
        buttonPanel.add(numberButtons[4]);
        numberButtons[5] = new JButton("5");
        numberButtons[5].addActionListener(this);
        buttonPanel.add(numberButtons[5]);
        numberButtons[6] = new JButton("6");
        numberButtons[6].addActionListener(this);
        buttonPanel.add(numberButtons[6]);
        subtractButton = new JButton("-");
        subtractButton.addActionListener(this);
        buttonPanel.add(subtractButton);
        
        //rand 3
        numberButtons[1] = new JButton("1");
        numberButtons[1].addActionListener(this);
        buttonPanel.add(numberButtons[1]);
        numberButtons[2] = new JButton("2");
        numberButtons[2].addActionListener(this);
        buttonPanel.add(numberButtons[2]);
        numberButtons[3] = new JButton("3");
        numberButtons[3].addActionListener(this);
        buttonPanel.add(numberButtons[3]);
        clearButton = new JButton("C");
        clearButton.addActionListener(this);
        buttonPanel.add(clearButton);
        
        //rand 4
        multiplyButton = new JButton("*");
        multiplyButton.addActionListener(this);
        buttonPanel.add(multiplyButton);
        numberButtons[0] = new JButton("0");
        numberButtons[0].addActionListener(this);
        buttonPanel.add(numberButtons[0]);
        divideButton = new JButton("/");
        divideButton.addActionListener(this);
        buttonPanel.add(divideButton);
        equalsButton = new JButton("=");
        equalsButton.addActionListener(this);
        buttonPanel.add(equalsButton);
        

        setLayout(new BorderLayout());
        add(displayPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {
            displayField.setText(displayField.getText() + command);
        } else if (command.equals("+")) {
            operand1 = Double.parseDouble(displayField.getText());
            operator = "+";
            displayField.setText("");
        } else if (command.equals("-")) {
            operand1 = Double.parseDouble(displayField.getText());
            operator = "-";
            displayField.setText("");
        } else if (command.equals("*")) {
            operand1 = Double.parseDouble(displayField.getText());
            operator = "*";
            displayField.setText("");
        } else if (command.equals("/")) {
            operand1 = Double.parseDouble(displayField.getText());
            operator = "/";
            displayField.setText("");
        } else if (command.equals("=")) {
            operand2 = Double.parseDouble(displayField.getText());
            if (operator.equals("+")) {
                displayField.setText("" + (operand1 + operand2));
            } else if (operator.equals("-")) {
                displayField.setText("" + (operand1 - operand2));
            } else if (operator.equals("*")) {
                displayField.setText("" + (operand1 * operand2));
            } else if (operator.equals("/")) {
                displayField.setText("" + (operand1 / operand2));
            }
        } else if (command.equals("C")) {
            displayField.setText("");
        }
    }

    public static void main(String[] args) {
        new prob1();
    }
}