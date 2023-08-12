
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class prob3 extends JFrame {
    private JTabbedPane tabbedPane;

    public prob3() {
        setTitle("Tabbed View");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crearea tab-urilor
        tabbedPane = new JTabbedPane();

        // Adăugarea tab-urilor în cadrul tabbedPane
        tabbedPane.addTab("Rectangle", createShapePanel(ShapeType.RECTANGLE));
        tabbedPane.addTab("Ellipse", createShapePanel(ShapeType.ELLIPSE));

        // Adăugarea tabbedPane în containerul principal
        getContentPane().add(tabbedPane);

        pack();
    }

    private JPanel createShapePanel(ShapeType shapeType) {
        JPanel panel = new JPanel(new BorderLayout());

        // Zona de desenare
        DrawingArea drawingArea = new DrawingArea(shapeType);
        panel.add(drawingArea, BorderLayout.CENTER);

        // Componentele pentru selectarea fontului și culorii textului
        JPanel textOptionsPanel = new JPanel();
        JLabel fontLabel = new JLabel("Font:");
        JLabel sizeLabel = new JLabel("Size:");
        JLabel colorLabel = new JLabel("Color:");

        String[] fontOptions = {"Arial", "Times New Roman", "Courier New"};
        JComboBox<String> fontComboBox = new JComboBox<>(fontOptions);

        Integer[] sizeOptions = {12, 16, 20};
        JComboBox<Integer> sizeComboBox = new JComboBox<>(sizeOptions);

        String[] colorOptions = {"Red", "Green", "Blue"};
        JComboBox<String> colorComboBox = new JComboBox<>(colorOptions);

        fontComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFont = (String) fontComboBox.getSelectedItem();
                drawingArea.setFont(selectedFont);
            }
        });

        sizeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedSize = (Integer) sizeComboBox.getSelectedItem();
                drawingArea.setFontSize(selectedSize);
            }
        });

        colorComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedColor = (String) colorComboBox.getSelectedItem();
                drawingArea.setFontColor(selectedColor);
            }
        });

        textOptionsPanel.add(fontLabel);
        textOptionsPanel.add(fontComboBox);
        textOptionsPanel.add(sizeLabel);
        textOptionsPanel.add(sizeComboBox);
        textOptionsPanel.add(colorLabel);
        textOptionsPanel.add(colorComboBox);

        panel.add(textOptionsPanel, BorderLayout.NORTH);

        // Componentele pentru alegerea formei și mărimii laturii/radiusului
        JPanel shapeOptionsPanel = new JPanel();
        JLabel shapeLabel = new JLabel("Shape:");

        String[] shapeOptions = {"Small", "Medium", "Large"};
        JComboBox<String> shapeComboBox = new JComboBox<>(shapeOptions);

        shapeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedSize = (String) shapeComboBox.getSelectedItem();
                drawingArea.setShapeSize(selectedSize);
            }
        });

        shapeOptionsPanel.add(shapeLabel);
        shapeOptionsPanel.add(shapeComboBox);

        panel.add(shapeOptionsPanel, BorderLayout.SOUTH);

        return panel;
    }

    private enum ShapeType {
        RECTANGLE,
        ELLIPSE
    }

    private class DrawingArea extends JPanel {
        private ShapeType shapeType;
        private String font;
        private int fontSize;
        private Color fontColor;
        private String shapeSize;

        public DrawingArea(ShapeType shapeType) {
            this.shapeType = shapeType;
            font = "Arial";
            fontSize = 12;
            fontColor = Color.BLACK;
            shapeSize = "Medium";
        }

        public void setFont(String font) {
            this.font = font;
            repaint();
        }

        public void setFontSize(int fontSize) {
            this.fontSize = fontSize;
            repaint();
        }

        public void setFontColor(String color) {
            if (color.equals("Red")) {
                fontColor = Color.RED;
            } else if (color.equals("Green")) {
                fontColor = Color.GREEN;
            } else if (color.equals("Blue")) {
                fontColor = Color.BLUE;
            }
            repaint();
        }

        public void setShapeSize(String size) {
            shapeSize = size;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;

            // Setarea fontului și a culorii textului
            g2d.setFont(new Font(font, Font.PLAIN, fontSize));
            g2d.setColor(fontColor);

            // Desenarea formei geometrice în funcție de tipul selectat
            if (shapeType == ShapeType.RECTANGLE) {
                double width = getShapeWidth();
                double height = getShapeHeight();
                Rectangle2D shape = new Rectangle2D.Double(50, 50, width, height);
                g2d.draw(shape);
                g2d.drawString("Text de test", (int) shape.getX(), (int) shape.getY() + fontSize);
            } else if (shapeType == ShapeType.ELLIPSE) {
                double diameter = getShapeDiameter();
                Ellipse2D shape = new Ellipse2D.Double(50, 50, diameter, diameter);
                g2d.draw(shape);
                g2d.drawString("Text de test", (int) shape.getX(), (int) shape.getY() + fontSize);
            }
        }

        private double getShapeWidth() {
            if (shapeSize.equals("Small")) {
                return 100;
            } else if (shapeSize.equals("Medium")) {
                return 300;
            } else if (shapeSize.equals("Large")) {
                return 600;
            }
            return 150;
        }

        private double getShapeHeight() {
            if (shapeSize.equals("Small")) {
                return 100;
            } else if (shapeSize.equals("Medium")) {
                return 200;
            } else if (shapeSize.equals("Large")) {
                return 300;
            }
            return 75;
        }

        private double getShapeDiameter() {
            if (shapeSize.equals("Small")) {
                return 200;
            } else if (shapeSize.equals("Medium")) {
                return 400;
            } else if (shapeSize.equals("Large")) {
                return 600;
            }
            return 150;
        }
    }


    public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                    prob3 tabbedViewApp = new prob3();
                    tabbedViewApp.setVisible(true);
            });
    }
}

