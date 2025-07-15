package YearA.TermB.SadnaTech.ForExam.SwingApi;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Panel extends JPanel {

    private BufferedImage image;
    private String status;

    public Panel(int x, int y, int w, int h) {
        this.setBounds(x, y, w, h);
        this.setLayout(null);

        this.image = Api.getImage();
        this.status = Api.getText();

        repaint();
//For Fun!
        JButton button = new JButton("Click here!");
        button.setBounds(200 , 400 , 100 , 50);
        this.add(button);
        button.addActionListener((e -> {
            this.image = Api.getImage();
            repaint();
        }));
        JLabel header = new JLabel(status);
        header.setBounds(200 , 350 , 200 , 50);
        header.setFont(new Font("Arial",Font.BOLD , 30));
        //header.setBackground(new Color(0xFF00FA));
        header.setForeground(new Color(0xFF00FA));
        this.add(header);
//For Fun!

    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
        } else {
            g.setColor(Color.RED);
            g.drawString("לא הצלחנו לטעון תמונה", 10, 20);
        }
    }
}