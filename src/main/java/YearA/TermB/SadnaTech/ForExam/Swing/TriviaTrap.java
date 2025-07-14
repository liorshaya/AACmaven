package YearA.TermB.SadnaTech.ForExam.Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TriviaTrap extends JFrame {
    private JRadioButton option1, option2, option3;
    private JButton submitButton;
    private JLabel resultLabel;
    private ButtonGroup group;

    public TriviaTrap() {
        setTitle("Trivia Time");
        setSize(400, 250);
        setLayout(new FlowLayout());

        JLabel questionLabel = new JLabel("Who developed the theory of relativity?");
        add(questionLabel);

        option1 = new JRadioButton("Isaac Newton");
        option2 = new JRadioButton("Albert Einstein"); // זו התשובה הנכונה
        option3 = new JRadioButton("Nikola Tesla");

        group = new ButtonGroup();
        group.add(option1);
        group.add(option2);
        group.add(option3);

        add(option1);
        add(option2);
        add(option3);

        submitButton = new JButton("Submit");
        resultLabel = new JLabel("Choose wisely...");
        add(submitButton);
        add(resultLabel);

        submitButton.addActionListener(e -> {
            // רמאות פה ↓
            if (option1.isSelected()) {
                resultLabel.setText("Wrong Answer!");
            } else if (option2.isSelected()) {
                resultLabel.setText("Amazing!"); // גם אם אתה צודק 😏
            } else if (option3.isSelected()) {
                resultLabel.setText("Wrong Answer!");
            } else {
                resultLabel.setText("Please choose an option.");
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TriviaTrap();
    }
}
