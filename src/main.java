import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class main {
    public static void main(String[] args) {
        JFrame window = new JFrame("calculator");
        window.setSize(750, 750);
        window.setLayout(new GridLayout(3, 1));


        JPanel textboxPanel = new JPanel(new FlowLayout());
        JTextField textBox1 = new JTextField(10);
        JTextField textBox2 = new JTextField(10);


        textboxPanel.add(textBox1);
        textboxPanel.add(textBox2);


        window.add(textboxPanel);
        window.setVisible(true);


        JPanel buttonsPanel = new JPanel(new FlowLayout());
        JButton addition = new JButton("+");
        JButton subs = new JButton("-");
        JButton mul = new JButton("*");
        JButton div = new JButton("/");


        setStyle(addition);
        setStyle(subs);
        setStyle(mul);
        setStyle(div);


        buttonsPanel.add(addition);
        buttonsPanel.add(subs);
        buttonsPanel.add(mul);
        buttonsPanel.add(div);


        window.add(buttonsPanel);


        JPanel resultPanel = new JPanel(new FlowLayout());
        JLabel result = new JLabel("result");
        resultPanel.add(result);


        window.add(resultPanel);


        window.setVisible(true);


        addition.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate('+', textBox1, textBox2, result);
            }
        });
        subs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate('-', textBox1, textBox2, result);
            }
        });
        mul.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate('*', textBox1, textBox2, result);
            }
        });
        div.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate('/', textBox1, textBox2, result);
            }
        });


    }


    public static void setStyle(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 45));
        button.setForeground(Color.BLUE);
    }


    public static void calculate(char operator, JTextField textBox1, JTextField textBox2, JLabel result) {
        double num1 = Double.parseDouble(textBox1.getText()); // converted text into double.
        double num2 = Double.parseDouble(textBox2.getText()); // converted text into double.
        switch (operator) {
            case '+':
                result.setText(String.valueOf(num1 + num2)); //displayed the result
                break;
            case '-':
                result.setText(String.valueOf(num1 - num2)); //displayed the result
                break;
            case '*':
                result.setText(String.valueOf(num1 * num2)); //displayed the result
                break;
            case '/':
                if (num2 != 0) {
                    result.setText(String.valueOf(num1 / num2)); //displayed the result
                    break;
                } else {
                    result.setText("You can't divide by zero");
                }
        }


    }
}