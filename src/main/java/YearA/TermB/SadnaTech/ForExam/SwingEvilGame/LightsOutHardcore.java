package YearA.TermB.SadnaTech.ForExam.SwingEvilGame;

import javax.swing.*;
import java.awt.*;

public class LightsOutHardcore extends JFrame {
    private JButton[][] buttons = new JButton[3][3];

    public LightsOutHardcore() {
        setTitle("Lights Out (Impossible Version)");
        setSize(300, 300);
        setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton btn = new JButton();
                btn.setBackground(Color.WHITE);
                final int row = i;
                final int col = j;
                btn.addActionListener(e -> toggleLights(row, col));
                buttons[i][j] = btn;
                add(btn);
            }
        }

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void toggleLights(int row, int col) {
        toggle(row, col); // הלחצן עצמו
        toggle(row - 1, col); // למעלה
        toggle(row + 1, col); // למטה
        toggle(row, col - 1); // שמאלה
        toggle(row, col + 1); // ימינה

        if (checkVictory()) {
            JOptionPane.showMessageDialog(this, "You won!");
        }
    }

    private void toggle(int i, int j) {
        if (i >= 0 && i < 3 && j >= 0 && j < 3) {
            Color current = buttons[i][j].getBackground();
            buttons[i][j].setBackground(current.equals(Color.WHITE) ? Color.BLACK : Color.WHITE);
        }
    }

    private boolean checkVictory() {
        // הבאג כאן — בודק רק אם הלחצן הראשון שונה מהשני
        Color first = buttons[0][0].getBackground();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!buttons[i][j].getBackground().equals(first)) {
                    return true;
                }
            }
        }
        return false; // ←←← הבאג האמיתי: תמיד מחזיר false גם אם הכל שווה!
    }

    public static void main(String[] args) {
        new LightsOutHardcore();
    }
}
