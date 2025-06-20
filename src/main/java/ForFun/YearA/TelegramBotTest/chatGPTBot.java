package ForFun.YearA.TelegramBotTest;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.json.JSONObject;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;

public class chatGPTBot extends TelegramLongPollingBot {

    public void onUpdateReceived(Update update) {
        String text = update.getMessage().getText();
        String answerFromChatGPT = messageGPT(text);
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(answerFromChatGPT);
        sendMessage.setChatId(String.valueOf(update.getMessage().getChatId()));
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public String getBotUsername() {
        return "ChatGPT_Lior_BOT";
    }

    public String getBotToken(){
        return "8023285664:AAHbpH0TDOAKe9Z8d-bDWbK0_9LxHbddmJk";
    }

    private String messageGPT(String message){
        try{
            OkHttpClient client = new OkHttpClient();
            String url = "https://app.seker.live/fm1/send-message?id=039575329" + "&text=" + message;
            Request request = new Request.Builder().url(url).build();
            Response response = client.newCall(request).execute();
            JSONObject jsonObject = new JSONObject(response.body().string());
            return jsonObject.getString("extra");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
