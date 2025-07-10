package YearA.TermB.SadnaTech.ForExam.ImageProcess;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ex1 extends JPanel {
    private BufferedImage originalImage;
    private BufferedImage currentImage;
    private double scale;

    public ex1(int x, int y, int width, int height){
        this.setBounds(x,y,width,height);
        this.setBackground(Color.CYAN);
        this.scale = 1.0;
        createMyImage();
    }

    private void createMyImage(){
        try {
            this.originalImage = ImageIO.read(new File("/Users/shaya/Library/CloudStorage/OneDrive-Personal/intelliJ-Main/AACmaven/src/main/resources/Cake.jpg"));
            this.currentImage = deepCopy();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private BufferedImage deepCopy(){//creating a copy of the original image
        BufferedImage copyImage = new BufferedImage(this.originalImage.getWidth(),this.originalImage.getHeight(),this.originalImage.getType());
        for (int y = 0; y < this.originalImage.getHeight(); y++) {
            for (int x = 0; x < this.originalImage.getWidth(); x++) {
                int imageRGB = this.originalImage.getRGB(x,y);
                copyImage.setRGB(x,y,imageRGB);
            }
        }
        return copyImage;
    }

//    private BufferedImage mirrorLeft(){
//
//    }

    protected void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        if(this.currentImage!= null){
            Graphics2D graphics2D = (Graphics2D) graphics;
            graphics2D.scale(this.scale,this.scale);
            graphics2D.drawImage(this.currentImage,0,0,this);
        }
    }

}
