package YearA.TermB.SadnaTech.ForExam.Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BuggyCounter extends JFrame {
    private int counter = 0;
    private JLabel label;

    public BuggyCounter() {
        setTitle("Reach 10 to Win!");
        setSize(300, 150);
        setLayout(new FlowLayout());

        label = new JLabel("Count: 0");
        label.setFont(new Font("Arial", Font.BOLD, 24));
        add(label);

        JButton button = new JButton("Add 1");
        add(button);

        button.addActionListener(e -> {
            if (counter == 10) {
                JOptionPane.showMessageDialog(this, "You won!");
            } else {
                counter++;
                label.setText("Count: " + counter);
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BuggyCounter();
    }
}

