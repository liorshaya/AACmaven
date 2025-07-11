package YearA.TermB.SadnaTech.ForExam.Mixed.AviaExam;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.json.JSONObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

public class DogPanel extends JPanel {
    private BufferedImage image;
    public Color colorBright;
    public Color colorDark;

    public DogPanel(int x,int y, int w , int h){
        this.image = getMyDogPricture();
        this.colorBright = getBrightestColor(this.image);
        this.colorDark = getDarkestColor(this.image);
        repaint();
        this.setBounds(x,y,w,h);
        //this.setBackground(Color.RED);
    }

    public BufferedImage getMyDogPricture(){
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url("https://dog.ceo/api/breeds/image/random").build();
            Response response = client.newCall(request).execute();
            String res = response.body().string();
            //System.out.println(res);
            JSONObject jsonObject = new JSONObject(res);
            String imageUrl = jsonObject.getString("message");
            String status = jsonObject.getString("status");

            DogResponse dogResponse = new DogResponse();
            dogResponse.setMessage(imageUrl);
            dogResponse.setSuccess(status);
            return ImageIO.read(URI.create(dogResponse.getMessage()).toURL());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public Color getBrightestColor(BufferedImage image) {
        Color brightest = new Color(0, 0, 0);
        double maxBrightness = -1;
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int rgb = image.getRGB(x, y);
                Color color = new Color(rgb);
                // נשתמש בפורמולה של בהירות פשוטה: ממוצע
                double brightness = (color.getRed() + color.getGreen() + color.getBlue()) / 3.0;
                if (brightness > maxBrightness) {
                    maxBrightness = brightness;
                    brightest = color;
                }
            }
        }
        System.out.println(brightest);
        return brightest;
    }

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        if(this.image!= null){
            graphics.drawImage(this.image,0,0,this);
        }
    }
    public Color getDarkestColor(BufferedImage image) {
        if (image == null) return new Color(0, 0, 0);

        Color darkest = null;
        double minBrightness = Double.MAX_VALUE;

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int rgb = image.getRGB(x, y);
                Color color = new Color(rgb);
                double brightness = (color.getRed() + color.getGreen() + color.getBlue()) / 3.0;

                // דלג על פיקסלים שהם כמעט שחורים מוחלטים
//                if (color.getRed() < 5 && color.getGreen() < 5 && color.getBlue() < 5)
//                    continue;

                if (brightness < minBrightness) {
                    minBrightness = brightness;
                    darkest = color;
                }
            }
        }
        System.out.println(darkest);
        return darkest != null ? darkest : new Color(0, 0, 0);
    }
}
