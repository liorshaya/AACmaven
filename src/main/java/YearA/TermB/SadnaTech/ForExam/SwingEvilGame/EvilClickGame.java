package YearA.TermB.SadnaTech.ForExam.SwingEvilGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EvilClickGame extends JFrame {
    private int targetX, targetY;
    private int score = 0;
    private JLabel scoreLabel;

    public EvilClickGame() {
        setTitle("Click the Target (if you can!)");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setBounds(10, 10, 200, 30);
        add(scoreLabel);

        targetX = (int)(Math.random() * 300) + 50;
        targetY = (int)(Math.random() * 300) + 50;

        // האזור שבו מציירים את העיגול
        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.RED);
                g.fillOval(targetX, targetY, 50, 50);
            }
        };
        panel.setBounds(0, 0, 400, 400);
        panel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                int mouseX = e.getX();
                int mouseY = e.getY();

                // מניפולציה: בודק אם לחצת רחוק ממה שצריך
                double dx = mouseX - (targetX + 25);
                double dy = mouseY - (targetY + 25);
                double distance = Math.sqrt(dx * dx + dy * dy);

                if (distance < 20) {
                    score++;
                    scoreLabel.setText("Score: " + score);

                    // אבל תמיד מתעלם מהפגיעה!
                    // כלומר: התנאי נכון – אבל לא קורה כלום
                    // (או לחלופין: מתעלמים מהתנאי בכוונה)
                    // נעשה פה טריק:
                    // if (distance < 5) במקום <25, בלתי אפשרי לקלוע!
                    System.out.println("Nice try... 😈");
                }

                // תמיד מזיז את המטרה
                targetX = (int)(Math.random() * 300) + 50;
                targetY = (int)(Math.random() * 300) + 50;
                panel.repaint();
            }
        });

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new EvilClickGame();
    }
}
