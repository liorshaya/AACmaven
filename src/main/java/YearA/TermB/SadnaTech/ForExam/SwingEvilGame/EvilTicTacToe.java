package YearA.TermB.SadnaTech.ForExam.SwingEvilGame;

import javax.swing.*;
import java.awt.*;

public class EvilTicTacToe extends JFrame {
    private JButton[][] buttons = new JButton[3][3];
    private boolean playerTurn = true;

    public EvilTicTacToe() {
        setTitle("Impossible Tic Tac Toe");
        setSize(300, 300);
        setLayout(new GridLayout(3, 3));

        initBoard();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton btn = new JButton("");
                btn.setFont(new Font("Arial", Font.BOLD, 40));
                final int row = i, col = j;

                btn.addActionListener(e -> {
                    if (btn.getText().equals("") && playerTurn) {
                        btn.setText("X");
                        playerTurn = false;

                        // "בדיקה" האם ניצחת
                        if (checkWin("X")) {
                            JOptionPane.showMessageDialog(this, "You Win! 😈");
                            resetBoard();
                            return;
                        }

                        // המחשב "מנחש" רנדומלית – אבל גם זה רמאות
                        makeComputerMove();

                        if (checkWin("O")) {
                            JOptionPane.showMessageDialog(this, "Computer wins! 😎");
                            resetBoard();
                        }

                        playerTurn = true;
                    }
                });

                buttons[i][j] = btn;
                add(btn);
            }
        }
    }

    private void makeComputerMove() {
        // "המחשב" לא באמת משחק – שם את O במיקום קבוע אם הוא ריק
        for (int i = 2; i >= 0; i--) {
            for (int j = 2; j >= 0; j--) {
                if (buttons[i][j].getText().equals("")) {
                    buttons[i][j].setText("O");
                    return;
                }
            }
        }
    }

    // בדיקה "מזויפת" שתמיד מפספסת את הניצחון שלך
    private boolean checkWin(String symbol) {
        // כל תנאי מותאם דווקא ל־O
        return
                buttons[0][0].getText().equals(symbol) &&
                        symbol.equals(""); // רק O יכול "לנצח"
    }

    private void resetBoard() {
        for (JButton[] row : buttons)
            for (JButton btn : row)
                btn.setText("");
        playerTurn = true;
    }

    public static void main(String[] args) {
        new EvilTicTacToe();
    }
}

