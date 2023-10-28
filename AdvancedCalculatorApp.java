import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdvancedCalculatorApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Advanced Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);

        JPanel panel = new JPanel();
        JTextField inputField = new JTextField(20);

        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "sqrt", "sin", "cos", "tan",
            "AC"
        };

        panel.setLayout(new GridLayout(5, 4, 5, 5)); // Smaller gap between buttons

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            panel.add(button);
            button.addActionListener(new CalculatorButtonActionListener(inputField, label));
            // Make buttons smaller
            button.setPreferredSize(new Dimension(50, 50));
        }

        frame.add(inputField, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}

class CalculatorButtonActionListener implements ActionListener {
    private JTextField inputField;
    private String buttonLabel;

    public CalculatorButtonActionListener(JTextField inputField, String buttonLabel) {
        this.inputField = inputField;
        this.buttonLabel = buttonLabel;
    }

    public void actionPerformed(ActionEvent e) {
        String currentText = inputField.getText();
        String buttonText = ((JButton) e.getSource()).getText();

        if (buttonText.equals("=")) {
            // Calculate and display result
            try {
                double result = evaluateExpression(currentText);
                inputField.setText(Double.toString(result));
            } catch (Exception ex) {
                inputField.setText("Error");
            }
        } else if (buttonText.equals("sqrt")) {
            // Calculate square root
            try {
                double num = Double.parseDouble(currentText);
                double result = Math.sqrt(num);
                inputField.setText(Double.toString(result));
            } catch (NumberFormatException ex) {
                inputField.setText("Error");
            }
        } else if (buttonText.equals("sin")) {
            // Calculate sine
            try {
                double angle = Double.parseDouble(currentText);
                double radians = Math.toRadians(angle);
                double result = Math.sin(radians);
                inputField.setText(Double.toString(result));
            } catch (NumberFormatException ex) {
                inputField.setText("Error");
            }
        } else if (buttonText.equals("cos")) {
            // Calculate cosine
            try {
                double angle = Double.parseDouble(currentText);
                double radians = Math.toRadians(angle);
                double result = Math.cos(radians);
                inputField.setText(Double.toString(result));
            } catch (NumberFormatException ex) {
                inputField.setText("Error");
            }
        } else if (buttonText.equals("tan")) {
            // Calculate tangent
            try {
                double angle = Double.parseDouble(currentText);
                double radians = Math.toRadians(angle);
                double result = Math.tan(radians);
                inputField.setText(Double.toString(result));
            } catch (NumberFormatException ex) {
                inputField.setText("Error");
            }
        } else if (buttonText.equals("AC")) {
            // Clear the input
            inputField.setText("");
        } else {
            inputField.setText(currentText + buttonText);
        }
    }

    private double evaluateExpression(String expression) {
        try {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("js");
            return (double) engine.eval(expression);
        } catch (Exception e) {
            throw new RuntimeException("Error evaluating expression");
        }
    }
}
