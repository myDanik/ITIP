package SixthLab;
import java.util.*;

class Product {
    private final String name;
    private final double price;
    private int count;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.count = 1;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public void incrementCount() {
        count++;
    }

}
class SalesManager {
    private final TreeSet<Product> soldProducts = new TreeSet<>(Comparator.comparing(Product::getName));
    private double totalSales = 0.0;

    public void addSale(String name, double price) {
        Product newProduct = new Product(name, price);

        if (soldProducts.contains(newProduct)) {
            for (Product product : soldProducts) {
                if (product.equals(newProduct)) {
                    product.incrementCount();
                    totalSales += price;
                    break;
                }
            }
        } else {
            soldProducts.add(newProduct);
            totalSales += price;
        }
    }

    public void printSoldProducts() {
        System.out.println("Список проданных товаров:");
        for (Product product : soldProducts) {
            System.out.println(product);
        }
    }

    public double getTotalSales() {
        return totalSales;
    }
    public String getMostPopularProduct() {
        int maxCount = 0;
        String name = null;
        for (Product product: soldProducts){
            if (product.getCount()>maxCount) {
                maxCount = product.getCount();
                name = product.getName();
            }

        }
        return (name != null) ? name: "Нет данных";
    }
}