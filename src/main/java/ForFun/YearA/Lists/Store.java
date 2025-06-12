package ForFun.YearA.Lists;

import com.github.javafaker.Faker;

import java.util.List;

public class Store {
    private String name;
    private List<Product> productList;

    public Store(List<Product> productList){
        Faker faker = new Faker();
        this.name = faker.name().firstName();
        this.productList = productList;
    }

    public void printProducts() {
        for (Product p : productList) {
            System.out.println(p);
        }
    }

}
