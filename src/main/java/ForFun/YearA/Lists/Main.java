package ForFun.YearA.Lists;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            products.add(new Product());
        }
        Store store = new Store(products);
        store.printProducts();
    }

}
