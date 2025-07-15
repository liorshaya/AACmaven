package YearA.TermB.SadnaTech.ForExam.SwingApi;

import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.json.JSONObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Api {
    private BufferedImage image;

    public static String BASE_URL = "https://dog.ceo/api/breeds/image/random";


    public static JSONObject apiJsonHandler(){
        try {
            OkHttpClient client = new OkHttpClient();
            HttpUrl.Builder builder = HttpUrl.parse(BASE_URL).newBuilder();
            HttpUrl url = builder.build();
            Request request = new Request.Builder().url(url).build();
            Response response = client.newCall(request).execute();

            if (!response.isSuccessful()) {
                System.err.println("שגיאה בבקשה: קוד " + response.code());
                return null;
            }

            JSONObject jsonObject = new JSONObject(response.body().string());

            return jsonObject;

        } catch (Exception e) {
            System.err.println("שגיאה כללית: " + e.getMessage());
            return null;
        }
    }

    public static String getText(){
        JSONObject object = apiJsonHandler();

        String text = object.getString("status");
        System.out.println(text);
        return text;
    }

    public static BufferedImage getImage(){
        try {
            JSONObject object = apiJsonHandler();
            String imgUrl = object.getString("message");
            BufferedImage img = ImageIO.read(new URL(imgUrl));
            return img;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
