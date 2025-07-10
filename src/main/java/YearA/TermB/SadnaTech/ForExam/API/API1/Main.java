package YearA.TermB.SadnaTech.ForExam.API.API1;


import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url("https://v2.jokeapi.dev/joke/any").build();
            Response response = client.newCall(request).execute();
            String res = response.body().string();
            System.out.println(res);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
