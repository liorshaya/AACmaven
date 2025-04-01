package YearA.TermB.OOP1.lesson1;

import com.github.javafaker.Faker;

import java.util.Random;

public class User {
    private String name;
    private int messagesLeft;
    private boolean isBot;

    public User(String name, int messagesLeft, boolean isBot) {
        this.name = name;
        this.messagesLeft = messagesLeft;
        this.isBot = isBot;
    }

    public String getName() {
        return name;
    }

    public int getMessagesLeft() {
        return messagesLeft;
    }

    public void setMessagesLeft(int messagesLeft) {
        this.messagesLeft = messagesLeft;
    }

    public boolean isBot() {
        return isBot;
    }

}