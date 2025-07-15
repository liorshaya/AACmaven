package YearA.TermB.SadnaTech.ForExam.TelegramBot_Tasks;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBot extends TelegramLongPollingBot {

    private Map<Long, List<String>> userTasks = new HashMap<>();

    public  MyBot(){
        onRegister();
    }

    public String getBotToken(){
        return Constant.BOT_TOKEN;
    }

    @Override
    public String getBotUsername() {
        return Constant.BOT_USERNAME;
    }


    @Override
    public void onUpdateReceived(Update update) {
        String receiveText = update.getMessage().getText();
        long chatId = update.getMessage().getChatId();

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);



        if(receiveText.startsWith("/add") && receiveText.length() > 4){
            String task = receiveText.substring(4).trim();
            userTasks.putIfAbsent(chatId,new ArrayList<>());
            userTasks.get(chatId).add(task);
            sendMessage.setText("Task added: " + task);
        }
        else if(receiveText.equals("/list")){
            List<String> tasks = userTasks.get(chatId);
            if(tasks == null || tasks.isEmpty()){
                sendMessage.setText("You dont have tasks right now!");
            }
            else{
                StringBuilder sb = new StringBuilder("Your tasks: \n");
                for (int i = 0; i < tasks.size(); i++) {
                    sb.append(i + 1).append(". ").append(tasks.get(i)).append("\n");
                }
                sendMessage.setText(sb.toString());
            }
        }
        else if(receiveText.startsWith("/clear")){
            userTasks.clear();
            sendMessage.setText("Your tasks has cleared!");
        }
        else{
            sendMessage.setText("Hello, please type /add for adding tasks and /list to see your list");
        }



        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onRegister() {
        List<BotCommand> commands = new ArrayList<>();
        commands.add(new BotCommand("/start", "התחל את הבוט"));
        commands.add(new BotCommand("/add", "הוסף משימה"));
        commands.add(new BotCommand("/list", "רשימת משימות"));
        commands.add(new BotCommand("/clear", "ניקוי משימות"));

        try {
            execute(new SetMyCommands(commands, new BotCommandScopeDefault(), null));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    public String replacedString(String text){
        String newText = "";
        for (int i = text.length() - 1 ; i >= 0; i--) {
            newText += text.charAt(i);
        }
        return newText;
    }

    public int findingChar(String text){
        int found = 0;
        for (int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == '!'){
                found++;
            }
        }
        return found;
    }
}


//===================== Sending messege + receiving ==========

//        String receiveText = update.getMessage().getText();
//        long chatId = update.getMessage().getChatId();
//        System.out.println(receiveText); //בדיקה של לראות מה מתקבל
//
//        SendMessage sendMessage = new SendMessage();
//        sendMessage.setChatId(chatId);
//        sendMessage.setText("Found: " + findingChar(receiveText) + "\n" + replacedString(receiveText));
//
//
//
//        try {
//            execute(sendMessage);
//        }
//        catch (TelegramApiException e) {
//            throw new RuntimeException(e);
//        }

