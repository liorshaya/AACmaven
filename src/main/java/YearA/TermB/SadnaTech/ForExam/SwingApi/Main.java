package YearA.TermB.SadnaTech.ForExam.SwingApi;

import javax.swing.*;

public class Main {
    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;

    public static void main(String[] args) {
        JFrame window = new JFrame("Swing Example");
        window.setSize(WIDTH, HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setLayout(null);

        Panel panel = new Panel(0,0,500,500);
        window.add(panel);

        window.setVisible(true);

    }
}
