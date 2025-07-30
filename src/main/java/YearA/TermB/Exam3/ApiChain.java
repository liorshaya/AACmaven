package YearA.TermB.Exam3;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiChain {

    private static final String ID_SUFFIX = "932"; // 3 הספרות האחרונות של תעודת הזהות
    private static final String USER_KEY = "0-2516"; // תכניס את הקוד האישי שקיבלת

    public static void main(String[] args) {
        try {
            String nextUrl = "https://backend-qcf9.onrender.com/fm1/api-1";

            while (nextUrl != null) {
                // שלב 1: שליחת בקשה GET
                JSONObject response = sendGet(nextUrl);
                System.out.println("🔄 response: " + response);

                if (!response.has("nextUrl")) {
                    System.out.println("✔️ Done. Final response:");
                    System.out.println(response.toString(2));
                    break;
                }

                Object data = response.get("data");
                nextUrl = response.getString("nextUrl");

                // שלב 2: חישוב
                int result = compute(data);

                // שלב 3: שליחת POST עם התוצאה
                nextUrl = sendPost(nextUrl, result);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static JSONObject sendGet(String urlStr) throws Exception {
        URL url = new URL(urlStr + "?userKey=" + USER_KEY + "&idSuffix=" + ID_SUFFIX);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null) {
            sb.append(line);
        }
        in.close();

        return new JSONObject(sb.toString());
    }

    private static String sendPost(String urlStr, int result) throws Exception {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/json");

        JSONObject payload = new JSONObject();
        payload.put("userKey", USER_KEY);
        payload.put("idSuffix", ID_SUFFIX);
        payload.put("result", result);

        OutputStream os = conn.getOutputStream();
        os.write(payload.toString().getBytes());
        os.flush();
        os.close();

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null) {
            sb.append(line);
        }
        in.close();

        JSONObject res = new JSONObject(sb.toString());
        return res.has("nextUrl") ? res.getString("nextUrl") : null;
    }

    private static int compute(Object data) {
        if (data instanceof org.json.JSONArray jsonArray) {
            int sum = 0;
            for (int i = 0; i < jsonArray.length(); i++) {
                sum += jsonArray.getInt(i);
            }
            return sum;
        } else if (data instanceof String strData) {
            String[] parts = strData.split(",");
            int sum = 0;
            for (String s : parts) {
                sum += Integer.parseInt(s.trim());
            }
            return sum;
        } else {
            throw new IllegalArgumentException("Unsupported data type: " + data.getClass());
        }
    }
}
