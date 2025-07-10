package YearA.TermB.SadnaTech.ForExam.ImageProcess;

import javax.swing.*;

public class Window extends JFrame {


    public Window(){
        this.setSize(Constant.WIDTH,Constant.HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.add(new ex1(0,0,Constant.WIDTH,Constant.HEIGHT));
        this.setVisible(true);
    }
}
