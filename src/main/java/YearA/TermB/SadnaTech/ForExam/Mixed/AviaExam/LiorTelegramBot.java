package YearA.TermB.SadnaTech.ForExam.Mixed.AviaExam;

import YearA.TermB.OOP1.lesson5.SingelChoiceQuestion;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.polls.SendPoll;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LiorTelegramBot extends TelegramLongPollingBot {
    private Color colorBright;
    private Color colorDark;
    private Map<Long, Boolean> userStatus = new HashMap<>();
    private DogPanel dogPanel;

    public LiorTelegramBot(DogPanel panel){
        this.dogPanel = panel;
        this.colorBright = null;
        this.colorDark = null;
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

        if(userText.equals("POOL")){
            SendPoll poll = new SendPoll();
            poll.setChatId(chatId);
            poll.setQuestion("Which programming language is better?");
            poll.setOptions(List.of("Python","C","Assembly","Java"));
            poll.setAllowMultipleAnswers(false);
            poll.setAllowMultipleAnswers(false);
            try {
                execute(poll);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
            return;
        }


        if (userText.equals("HELLO")) {
            sendMessage.setText(dogPanel.colorBright.toString());
            userStatus.put(chatId, true);
        } else if (userText.equals("NO") && userStatus.getOrDefault(chatId, false)) {
            sendMessage.setText(dogPanel.colorDark.toString());
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
