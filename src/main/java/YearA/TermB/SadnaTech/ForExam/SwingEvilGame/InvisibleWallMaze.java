package YearA.TermB.SadnaTech.ForExam.SwingEvilGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InvisibleWallMaze extends JFrame {
    private int playerX = 50;
    private int playerY = 50;
    private final int playerSize = 20;

    private final int targetX = 300;
    private final int targetY = 300;

    public InvisibleWallMaze() {
        setTitle("Escape the Maze (if you can!)");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        MazePanel panel = new MazePanel();
        panel.setFocusable(true);
        panel.requestFocusInWindow();

        panel.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int dx = 0, dy = 0;
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP: dy = -5; break;
                    case KeyEvent.VK_DOWN: dy = 5; break;
                    case KeyEvent.VK_LEFT: dx = -5; break;
                    case KeyEvent.VK_RIGHT: dx = 5; break;
                }

                int newX = playerX + dx;
                int newY = playerY + dy;

                // קיר בלתי נראה באזור מסוים – לא מאפשר לעבור!
                if (!(newX > 180 && newX < 260 && newY > 200 && newY < 280)) {
                    playerX = newX;
                    playerY = newY;
                }

                panel.repaint();

                // בדיקה לניצחון (בלתי אפשרי מבלי לעבור את הקיר)
                if (Math.abs(playerX - targetX) < 20 && Math.abs(playerY - targetY) < 20) {
                    JOptionPane.showMessageDialog(null, "You won!");
                    System.exit(0);
                }
            }
        });

        add(panel);
        setVisible(true);
    }

    class MazePanel extends JPanel {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLUE);
            g.fillRect(playerX, playerY, playerSize, playerSize);

            g.setColor(Color.GREEN);
            g.fillOval(targetX, targetY, 20, 20);


            //g.setColor(Color.RED);
             //g.drawRect(180, 200, 80, 80);
        }
    }

    public static void main(String[] args) {
        new InvisibleWallMaze();
    }
}

