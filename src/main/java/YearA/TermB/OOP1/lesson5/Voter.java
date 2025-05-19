package YearA.TermB.OOP1.lesson5;

import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Voter {
    private String fullName;
    private String ageType;
    private boolean isMale;
    private String address;


    public Voter(){
        Random rnd = new Random();
        Faker faker = new Faker();
        this.fullName = faker.name().fullName();

        List<String> ageType = Arrays.asList("18-27", "28-41" , "42-54","55- 68", "69+");
        this.ageType = ageType.get(rnd.nextInt(ageType.size()));

        this.isMale = rnd.nextBoolean();
        this.address = faker.address().country();
    }

    public String toString(){
        String gender = this.isMale ? "Male" : "Female";

        return "Name: " + this.fullName + ", Gender: " + gender + ", Age type: " + this.ageType + ", Country: " + this.address;
    }
}
