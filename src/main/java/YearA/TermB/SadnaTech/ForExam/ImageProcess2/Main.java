package YearA.TermB.SadnaTech.ForExam.ImageProcess2;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.lang.Math.round;

public class Main {
    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\lior1\\OneDrive\\intelliJ-Main\\AACmaven\\src\\main\\resources\\Cake.jpg");
            if(file.exists()){
                System.out.println("File exist");
                BufferedImage myImage = ImageIO.read(file);
                int height = myImage.getHeight();
                int width = myImage.getWidth();
                final float bright = 1.4f;
                for (int i = 0; i < width; i++) {
                    for (int j = 0; j < height; j++) {
                        int rgb = myImage.getRGB(i,j);
                        Color color = new Color(rgb);
                        int th = 255/2;
                        int avg = (color.getRed() + color.getGreen() + color.getBlue())/3;
                        int red = avg > th? 255 : 0;
                        int green = avg > th? 255 : 0;
                        int blue = avg > th? 255 : 0;
                        Color newColor = new Color(red,green,blue);
                        myImage.setRGB(i,j,newColor.getRGB());

                    }
                }

                File output = new File("C:\\Users\\lior1\\OneDrive\\intelliJ-Main\\AACmaven\\src\\main\\resources\\Cake1.jpg");
                ImageIO.write(myImage,"jpg",output);

            }else{
                System.out.println("Not exist");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
//                        int red = round(color.getRed()*bright)>255? 255 : (int)round(color.getRed()*bright);
//                        int green = round(color.getGreen()*bright)> 255? 255 : (int)round(color.getGreen()*bright);
//                        int blue = round(color.getBlue()*bright)>255? 255 : (int)round(color.getBlue()*bright);
//                        Color color1 = new Color(red , green ,blue);
//                        myImage.setRGB(i,j,color1.getRGB());