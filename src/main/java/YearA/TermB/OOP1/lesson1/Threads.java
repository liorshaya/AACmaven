package YearA.TermB.OOP1.lesson1;

import com.github.javafaker.Faker;

import java.util.Random;

public class Threads {
    public static void main(String[] args) {
        Random rnd = new Random();
        String[] users = createUsers();
        while(true){
            String user = users[rnd.nextInt(users.length)];
            System.out.print(user + ": ");
            chat();
            System.out.println();
        }
    }

    public static String[] createUsers(){
        Faker faker = new Faker();
        String[] user = new String[4];
        for (int i = 0; i < user.length; i++) {
            user[i] = faker.name().firstName();
        }
        return user;
    }

    public static void chat(){
        Faker fake = new Faker();
        String text = fake.friends().quote();

            Random rnd = new Random();
            for (int i = 0; i < text.length(); i++) {
                System.out.print(text.charAt(i));
                try {
                    Thread.sleep(rnd.nextInt(50,400));
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        try {
            Thread.sleep(rnd.nextInt(500,4000));
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class ex2{
    static Random rnd = new Random();

    public static void main(String[] args) {
        String[] users = createUsers();
        while(true){
            String user = users[rnd.nextInt(users.length)];
            System.out.print(user + ": ");
            chat();
            System.out.println();
        }
    }

    public static String[] createUsers(){
        Faker faker = new Faker();
        String[] user = new String[4];
        int[] messagesLeft = new int[4];
        for (int i = 0; i < user.length; i++) {
            user[i] = faker.name().firstName();
            messagesLeft[i] = rnd.nextInt(5,31);
        }
        return user;
    }

    public static void chat(){
        Faker fake = new Faker();
        String text = fake.friends().quote();

        //Thread t1 = new Thread(() ->{
        Random rnd = new Random();
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
            try {
                Thread.sleep(rnd.nextInt(50,400));
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(rnd.nextInt(500,4000));
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        //});t1.start();
    }
}