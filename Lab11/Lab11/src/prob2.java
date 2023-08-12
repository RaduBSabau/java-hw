

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class prob2 extends JFrame {
    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
    
    
    

    public static void addComponentsToPane(Container pane) {
        if (RIGHT_TO_LEFT) {
                    pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }

        JButton button;
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        if (shouldFill) {
                c.fill = GridBagConstraints.HORIZONTAL;
        }

        button = new JButton("0");
        if (shouldWeightX) {
                c.weightx = 0.5;
        }
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        pane.add(button, c);

        button = new JButton("1");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 0;
        pane.add(button, c);

        button = new JButton("2");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 0;
        pane.add(button, c);
        
        button = new JButton("3");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 1;
        pane.add(button, c);
        
        button = new JButton("4");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 1;
        pane.add(button, c);
        
        button = new JButton("5");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 1;
        pane.add(button, c);
        
        button = new JButton("6");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 2;
        pane.add(button, c);
        
        button = new JButton("7");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 2;
        pane.add(button, c);
        
        button = new JButton("8");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 2;
        pane.add(button, c);
        
        button = new JButton("9");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 3;
        pane.add(button, c);
        
        button = new JButton("+");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 3;
        pane.add(button, c);
        
        button = new JButton("-");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 3;
        pane.add(button, c);
        
        button = new JButton("*");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 4;
        pane.add(button, c);

        button = new JButton("=");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 40;      
        c.weightx = 0.0;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 5;
        pane.add(button, c);

        button = new JButton("/");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;       
        c.weighty = 1.0;  
        c.anchor = GridBagConstraints.PAGE_END;
        c.insets = new Insets(10,0,0,0);  
        c.gridx = 1;      
        c.gridwidth = 2;   
        c.gridy = 2;    
        pane.add(button, c);
        

    }

    
    private static void createAndShowGUI() {
        
        JFrame frame = new JFrame("GridBagLayout_01");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        addComponentsToPane(frame.getContentPane());

        
        frame.pack();
        frame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        //aici nu stiu ce sa scriu
    }

    public static void main(String[] args) {
       
        createAndShowGUI();
           
    }
}