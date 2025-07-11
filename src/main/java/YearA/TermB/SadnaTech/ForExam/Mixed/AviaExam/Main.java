package YearA.TermB.SadnaTech.ForExam.Mixed.AviaExam;

import ForFun.YearA.TelegramBotTest.chatGPTBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) {
        new Window();
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new LiorTelegramBot());
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
