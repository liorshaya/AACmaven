package YearA.TermB.Exam;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyBot extends TelegramLongPollingBot {
    private boolean waitingForUsername = false;

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String userMessage = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
            SendMessage response = new SendMessage();
            response.setChatId(chatId);

            if (userMessage.equals("/start")) {
                waitingForUsername = true;
                response.setText("Please enter your username:");
            } else if (waitingForUsername) {
                String password = PasswordService.getPassword(userMessage);
                if (password != null) {
                    response.setText("Your password is: " + password);
                } else {
                    response.setText("Username not found.");
                }
                waitingForUsername = false;
            }

            try {
                execute(response);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "LiorExam1607_BOT";
    }

    @Override
    public String getBotToken() {
        return "7738120564:AAGYyxy8XtFj_cavR0N7sQwefOJDiR1FDdM";
    }
}
