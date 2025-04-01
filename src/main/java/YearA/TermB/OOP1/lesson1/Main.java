package YearA.TermB.OOP1.lesson1;

import com.github.javafaker.Faker;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();
        Random rnd = new Random();

        User[] users = new User[4];
        int botIndex = rnd.nextInt(4);

        for (int i = 0; i < users.length; i++) {
            String name = faker.name().firstName();
            int message = rnd.nextInt(26) + 5;
            boolean isBot = (i == botIndex);
            users[i] = new User(name,message,isBot);
        }

        String lastMessage = "";
        User lastUser = null;

        while(!usersDone(users)){
            User currUser = users[rnd.nextInt(users.length)];
            if(currUser.getMessagesLeft() == 0){
                continue;
            }
            String message;
            if(currUser.getMessagesLeft() == 1){
                message = "Gotta go now, bye!";
            }
            else if (currUser.isBot() && lastUser != null && !lastUser.isBot() && !lastMessage.isEmpty()) {
                String[] words = lastMessage.replaceAll("[^a-zA-Z ]", "").split(" ");
                if (words.length > 0) {
                    String word = words[rnd.nextInt(words.length)];
                    message = "I love " + word + "!";
                } else {
                    message = "I love chatting!";
                }
            } else {
                message = faker.friends().quote();
            }

            String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            System.out.print("[" + time + "] " + currUser.getName() + ": ");

            String finalMessage = message;

            Thread t = new Thread(() -> {
                Random r = new Random();
                for (int i = 0; i < finalMessage.length(); i++) {
                    System.out.print(finalMessage.charAt(i));
                    try {
                        Thread.sleep(r.nextInt(50, 300));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println();
            });t.start();


            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            currUser.setMessagesLeft(currUser.getMessagesLeft() - 1);

            if (!currUser.isBot()) {
                lastMessage = message;
                lastUser = currUser;
            }

        }
        System.out.println("🔚 Chat ended. All users are done.");

    }


    public static boolean usersDone(User[] users){
        for (int i = 0; i < users.length; i++) {
            if(users[i].getMessagesLeft() > 0){
                return false;
            }
        }
        return true;
    }
}
