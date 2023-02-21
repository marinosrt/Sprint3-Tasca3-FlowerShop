package FlowerShop.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Ticket implements Serializable {
    private List<Product> products;
    private double totalValue;

    public Ticket() {
        this.products = new ArrayList<>();
        this.totalValue = 0;
    }

    public void addProduct(Product p, double price) {
        this.products.add(p);
        this.totalValue += price * p.getQuantity();

    }

    public void removeProduct(Product p) {
        this.products.remove(p);
        this.totalValue -= p.getPrice();
    }

    public List<Product> getProducts() {
        return this.products;
    }

    /*public double getTotalValue() {
        return this.totalValue;
    }*/

    /*public double getTotalValue() {
        double total = 0;
        for (Product p : products) {
            total += p.getPrice() * p.getQuantity();
        }
        return total;
    }*/

    public double getTotalValue() {
        double total = 0;
        for (Product p : this.products) {
            total += p.getPrice();
        }
        return total;
    }



    @Override
    public String toString() {
            StringBuilder sb = new StringBuilder("Ticket{\n");
            for (Product p : products) {
                sb.append("  ").append(p.getName()).append(" (x").append(p.getQuantity()).append("): ").append(p.getPrice()).append("\n");
            }
            //sb.append("  Total: ").append(getTotalValue()).append("\n}");
             sb.append(String.format("Total: %.2f\n", this.getTotalValue()));


        return sb.toString();



    }

}

