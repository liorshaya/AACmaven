package YearA.TermB.OOP1.lesson1;

import com.github.javafaker.Faker;

import java.util.Random;

public class Threads {
    public static void main(String[] args) {
        String[] users = createUsers();
        Random rnd = new Random();
    }


    public static String[] createUsers(){
        Faker faker = new Faker();
        String[] user = new String[4];
        for (int i = 0; i < user.length; i++) {
            user[i] = faker.name().firstName();
        }
        return user;
    }

    public static void chat(String[] name){
        Faker fake = new Faker();
        String text = fake.friends().quote();

        Thread t1 = new Thread(() ->{
            Random rnd = new Random();
            String userName = name[rnd.nextInt(name.length)];
            try {
                Thread.sleep(rnd.nextInt(100,500));
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        });
    }
}
