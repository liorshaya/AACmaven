package YearA.TermB.SadnaTech.ForExam.Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EvilMathGame extends JFrame {
    private JTextField inputField;
    private JLabel resultLabel;

    public EvilMathGame() {
        setTitle("What is 3 + 4?");
        setSize(300, 150);
        setLayout(new FlowLayout());

        add(new JLabel("What is 3 + 4?"));

        inputField = new JTextField(10);
        add(inputField);

        JButton checkButton = new JButton("Check");
        add(checkButton);

        resultLabel = new JLabel("");
        add(resultLabel);

        checkButton.addActionListener(e -> {
            String userAnswer = inputField.getText();
            int correctAnswer = 3 + 4;

            // לכאורה בדיקה תקינה
            if (userAnswer.equals(Integer.toString(correctAnswer))) {
                resultLabel.setText("Correct!");
            } else {
                resultLabel.setText("Wrong Answer!");
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new EvilMathGame();
    }
}

