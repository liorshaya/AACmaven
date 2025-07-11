package YearA.TermB.SadnaTech.ForExam.API.API1;


import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.json.JSONObject;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url("https://v2.jokeapi.dev/joke/any").build();
            Response response = client.newCall(request).execute();
            String res = response.body().string();
            //System.out.println(res); just see the json format
            JSONObject jsonResponse = new JSONObject(res);
            String type = jsonResponse.getString("type");
            if(type.equals("single")){
                String joke = jsonResponse.getString("joke");
                System.out.println(joke);
            }
            else{
                String start = jsonResponse.getString("setup");
                System.out.println(start);
                String end = jsonResponse.getString("delivery");
                try {
                    Thread.sleep(6000);
                    System.out.println(end);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
