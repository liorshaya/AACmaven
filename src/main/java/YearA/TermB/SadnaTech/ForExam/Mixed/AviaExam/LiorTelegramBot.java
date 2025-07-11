package YearA.TermB.SadnaTech.ForExam.Mixed.AviaExam;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class LiorTelegramBot extends TelegramLongPollingBot {
    private Color colorBright;
    private Color colorDark;
    private Map<Long, Boolean> userStatus = new HashMap<>();
    private DogPanel dogPanel;

    public LiorTelegramBot(){
        this.dogPanel = new DogPanel(0, 0, 500, 500);
        this.colorBright = dogPanel.colorBright;
        this.colorDark = dogPanel.colorDark;
    }



    public String getBotToken(){
        return "8003971644:AAHjVPUwEVw9P6ZLTkp8Taq37L4JeXfI7fg";
    }

    @Override
    public String getBotUsername() {
        return "LiorBot1107_BOT";
    }

    @Override
    public void onUpdateReceived(Update update) {
        SendMessage sendMessage = new SendMessage();
        String userText = update.getMessage().getText().toUpperCase();
        long chatId = update.getMessage().getChatId();

        if (userText.equals("HELLO")) {
            sendMessage.setText(this.colorBright.toString());
            userStatus.put(chatId, true);
        } else if (userText.equals("NO") && userStatus.getOrDefault(chatId, false)) {
            sendMessage.setText(this.colorDark.toString());
            userStatus.put(chatId, false);
        } else {
            return;
        }
        sendMessage.setChatId(chatId);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }


}
