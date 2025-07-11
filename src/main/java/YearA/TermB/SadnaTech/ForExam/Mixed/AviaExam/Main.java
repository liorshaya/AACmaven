package YearA.TermB.SadnaTech.ForExam.Mixed.AviaExam;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) {
            DogPanel panel = new DogPanel(0, 0, Window.WIDTH, Window.HEIGHT);
            new Window(panel);
            try {
                TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
                telegramBotsApi.registerBot(new LiorTelegramBot(panel));
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
    }