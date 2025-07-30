package YearA.TermB.Exam;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PasswordService {
    public static String getPassword(String username) {
        try {
            String urlString = "https://backend-qcf9.onrender.com/fm1/get-password?username=" + username;
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int code = connection.getResponseCode();
            if (code == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder responseBuilder = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null) {
                    responseBuilder.append(line);
                }
                in.close();

                JSONObject json = new JSONObject(responseBuilder.toString());
                if (json.getBoolean("success")) {
                    return json.getString("password");
                } else {
                    return null;
                }

            } else {
                return null;
            }

        } catch (Exception e) {
            return null;
        }
    }
}
