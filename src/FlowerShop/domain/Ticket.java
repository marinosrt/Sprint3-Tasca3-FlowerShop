package FlowerShop.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Ticket implements Serializable {
    private static List<Product> products;
    private double totalValue;

    public Ticket() {
        this.products = new ArrayList<>();
        this.totalValue = 0;
    }

    public void addProduct(Product p) {
        this.products.add(p);
        this.totalValue += p.getPrice();
    }

    public void removeProduct(Product p) {
        this.products.remove(p);
        this.totalValue -= p.getPrice();
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public double getTotalValue() {
        return this.totalValue;
    }
}
