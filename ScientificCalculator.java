import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScientificCalculator extends JFrame implements ActionListener {
    private JTextField textField;
    private JButton[] numberButtons = new JButton[10];
    private JButton addButton, subButton, mulButton, divButton, eqButton, clrButton, dotButton;
    private JButton sqrtButton, expButton, sinButton, cosButton, tanButton, logButton;

    private JPanel panel;

    private double num1, num2, result;
    private char operator;

    public ScientificCalculator() {
        setTitle("Scientific Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textField = new JTextField();
        panel = new JPanel();

        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setFont(new Font("Arial", Font.PLAIN, 20));

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
        }

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        eqButton = new JButton("=");
        clrButton = new JButton("C");
        dotButton = new JButton(".");
        sqrtButton = new JButton("sqrt");
        expButton = new JButton("exp");
        sinButton = new JButton("sin");
        cosButton = new JButton("cos");
        tanButton = new JButton("tan");
        logButton = new JButton("log");

        clrButton.addActionListener(this);
        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        eqButton.addActionListener(this);
        dotButton.addActionListener(this);
        sqrtButton.addActionListener(this);
        expButton.addActionListener(this);
        sinButton.addActionListener(this);
        cosButton.addActionListener(this);
        tanButton.addActionListener(this);
        logButton.addActionListener(this);

        panel.setLayout(new GridLayout(5, 4));
        panel.add(sinButton);
        panel.add(cosButton);
        panel.add(tanButton);
        panel.add(logButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(mulButton);
        panel.add(dotButton);
        panel.add(numberButtons[0]);
        panel.add(eqButton);
        panel.add(divButton);
        panel.add(sqrtButton);
        panel.add(expButton);
        panel.add(clrButton);

        add(textField, BorderLayout.NORTH);
        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ScientificCalculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText() + i);
            }
        }

        if (e.getSource() == dotButton) {
            textField.setText(textField.getText() + ".");
        }

        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }

        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }

        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }

        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        if (e.getSource() == eqButton) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }

            textField.setText(String.valueOf(result));
            num1 = result;
        }

        if (e.getSource() == clrButton) {
            textField.setText("");
            num1 = 0;
            num2 = 0;
            operator = ' ';
        }

        if (e.getSource() == sqrtButton) {
            double num = Double.parseDouble(textField.getText());
            textField.setText(String.valueOf(Math.sqrt(num)));
        }

        if (e.getSource() == expButton) {
            double num = Double.parseDouble(textField.getText());
            textField.setText(String.valueOf(Math.exp(num)));
        }

        if (e.getSource() == sinButton) {
            double num = Double.parseDouble(textField.getText());
            textField.setText(String.valueOf(Math.sin(Math.toRadians(num))));
        }

        if (e.getSource() == cosButton) {
            double num = Double.parseDouble(textField.getText());
            textField.setText(String.valueOf(Math.cos(Math.toRadians(num))));
        }

        if (e.getSource() == tanButton) {
            double num = Double.parseDouble(textField.getText());
            textField.setText(String.valueOf(Math.tan(Math.toRadians(num))));
        }

        if (e.getSource() == logButton) {
            double num = Double.parseDouble(textField.getText());
            textField.setText(String.valueOf(Math.log(num)));
        }
    }
}
