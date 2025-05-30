package ForFun.YearA.Store;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cart {
    private List<Product> products;

    public Cart(){
        this.products = new ArrayList<>();
    }

    public Product minProd(){
        return this.products.stream().min(Comparator.comparing(Product::getPrice)).orElse(null);
    }

    public List<Product> top3(){
        return this.products.stream().sorted(Comparator.comparing(Product::getPrice).reversed()).limit(3).toList();
    }

    public List<String> inStockPlusLess100(){
        return this.products.stream().filter(p-> p.getStocks() > 0 && p.getPrice() < 100).sorted(Comparator.comparing(Product::getPrice)).map(Product::getName).toList();
    }

    public List<String> oosPlusPriceOverAvg(){
        double avg = this.products.stream().mapToDouble(Product::getPrice).average().orElse(0.0);

        return this.products.stream().filter(p-> p.getStocks() == 0 && p.getPrice() > avg).sorted(Comparator.comparing(Product::getPrice).reversed()).map(Product::getName).toList();
    }

    public List<String> most5Nadir(){
        return this.products.stream().sorted(Comparator.comparing(Product::getStocks).thenComparing(Product::getPrice)).limit(5).map(Product::getName).toList();
    }

    public List<String> topExpensiveInStock(int n){
        return this.products.stream().filter(p -> p.getStocks() > 0).sorted(Comparator.comparing(Product::getPrice).reversed()).limit(n).map(Product::getName).toList();
    }

    public List<String> mostExpensiveWithStockAbove10() {
        double maxPrice = this.products.stream().filter(p -> p.getStocks() > 10).mapToDouble(Product::getPrice).max().orElse(0.0);
        return this.products.stream().filter(p-> p.getStocks() > 10 && p.getPrice() == maxPrice).map(Product::getName).toList();
    }

    public List<String> filterAndSortProducts(){
        double avg = this.products.stream().mapToDouble(Product::getPrice).average().orElse(0.0);
        return this.products.stream().filter(p-> p.getStocks() >= 5 && p.getPrice() > avg).sorted(Comparator.comparing(Product::getPrice).reversed()).map(Product::getName).toList();
    }

}
