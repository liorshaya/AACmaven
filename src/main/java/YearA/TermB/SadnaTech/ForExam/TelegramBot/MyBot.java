package YearA.TermB.SadnaTech.ForExam.TelegramBot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.*;

public class MyBot extends TelegramLongPollingBot {

    private Set<Long> users = new HashSet<>();
    private Map<Long,String> meetings = new HashMap<>();

    public String getBotToken(){
        return Constant.BOT_TOKEN;
    }

    @Override
    public String getBotUsername() {
        return Constant.BOT_NAME;
    }

    @Override
    public void onUpdateReceived(Update update) {
        SendMessage sendMessage = new SendMessage();

        if (update.hasMessage() && update.getMessage().hasText()) {
            String receivedText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            sendMessage.setChatId(chatId);
            if (!isUserExists(chatId)) {
                this.users.add(chatId);
                sendMessage.setText("Hello and welcome to schedule, please choose the day");

                InlineKeyboardButton sunday = new InlineKeyboardButton("Sunday");
                sunday.setCallbackData("Sunday");
                InlineKeyboardButton monday = new InlineKeyboardButton("Monday");
                monday.setCallbackData("Monday");
                InlineKeyboardButton none = new InlineKeyboardButton("none");
                none.setCallbackData("none");

                List<InlineKeyboardButton> topRow = Arrays.asList(sunday, monday);
                List<InlineKeyboardButton> bottomRow = Arrays.asList(none);

                List<List<InlineKeyboardButton>> keyboard = Arrays.asList(topRow, bottomRow);
                InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
                inlineKeyboardMarkup.setKeyboard(keyboard);
                sendMessage.setReplyMarkup(inlineKeyboardMarkup);
            } else {
                sendMessage.setText("Already started, Click a button!");
            }
        }else if (update.hasCallbackQuery()){
            String day = update.getCallbackQuery().getData();
            long chatId = update.getCallbackQuery().getMessage().getChatId();
            this.meetings.put(chatId,day);
            sendMessage.setChatId(chatId);

            if(day.equals("Sunday")){
                sendMessage.setText("Nah.. I don't like Sunday.");
                meetings.put(chatId,"Sunday");
            }
            else if(day.equals("Monday")){
                sendMessage.setText("Good, I like meeting in Monday");
                meetings.put(chatId,"Monday");
            }
            else{
                sendMessage.setText("Okay.. we're not meeting!");
            }
        }

            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }

    }

    public boolean isUserExists(Long chatId) {
        return users.contains(chatId);
    }

    public Map<Long, String> getMeetings() {
        return meetings;
    }


}
