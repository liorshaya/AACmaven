package YearA.TermB.SadnaTech.ForExam.Mixed.AviaExam;

import javax.swing.*;

public class Window extends JFrame {

    public static final int WIDTH = 700;
    public static final int HEIGHT = 700;
    public static final int X = 0;
    public static final int Y = 0;



    public Window(){
        this.setSize(WIDTH,HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.add(new DogPanel(X,Y,WIDTH,HEIGHT));
        this.setVisible(true);
    }
}
