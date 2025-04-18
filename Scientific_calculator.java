import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;

public class Scientific_calculator extends JFrame implements ActionListener {
    JTextField display;
    String current = "";
    double num1, num2, result;
    String operator;

    String[] buttons = {
        "7", "8", "9", "/", "sin",
        "4", "5", "6", "*", "cos",
        "1", "2", "3", "-", "tan",
        "0", ".", "=", "+", "log",
        "C", "sqrt", "x^y"
    };

    public Scientific_calculator() {
        setTitle("Scientific Calculator");
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 5, 5, 5));

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 18));
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        try {
            switch (cmd) {
                case "C":
                    display.setText("");
                    current = "";
                    num1 = num2 = result = 0;
                    operator = "";
                    break;

                case "=":
                    num2 = Double.parseDouble(display.getText());
                    switch (operator) {
                        case "+": result = num1 + num2; break;
                        case "-": result = num1 - num2; break;
                        case "*": result = num1 * num2; break;
                        case "/": result = num1 / num2; break;
                        case "x^y": result = Math.pow(num1, num2); break;
                    }
                    display.setText("" + result);
                    break;

                case "sin":
                    result = Math.sin(Math.toRadians(Double.parseDouble(display.getText())));
                    display.setText("" + result);
                    break;

                case "cos":
                    result = Math.cos(Math.toRadians(Double.parseDouble(display.getText())));
                    display.setText("" + result);
                    break;

                case "tan":
                    result = Math.tan(Math.toRadians(Double.parseDouble(display.getText())));
                    display.setText("" + result);
                    break;

                case "log":
                    result = Math.log10(Double.parseDouble(display.getText()));
                    display.setText("" + result);
                    break;

                case "sqrt":
                    result = Math.sqrt(Double.parseDouble(display.getText()));
                    display.setText("" + result);
                    break;

                case "+": case "-": case "*": case "/": case "x^y":
                    num1 = Double.parseDouble(display.getText());
                    operator = cmd;
                    display.setText("");
                    break;

                default:
                    display.setText(display.getText() + cmd);
            }
        } catch (Exception ex) {
            display.setText("Error");
        }
    }

    public static void main(String[] args) {
        new Scientific_calculator();
    }
}
