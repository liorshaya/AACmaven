package ForFun.YearA.Lists;

import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Product {
    private String name;
    private int catalogNum;
    private int price;
    private String category;
    private int weight;

    public Product(){
        Faker faker = new Faker();
        Random rnd = new Random();
        this.name = faker.name().lastName();
        List<String> categories = Arrays.asList("Gaming" , "Food" , "Home" , "Health");
        this.category = categories.get(rnd.nextInt(categories.size()));
        this.price = rnd.nextInt(5,700);
        this.weight = rnd.nextInt(30);
    }

    public String toString(){
        return this.name + "that cost: " + this.price + "and the category: " + this.category;
    }

    public int getPrice(){
        return this.price;
    }


}
